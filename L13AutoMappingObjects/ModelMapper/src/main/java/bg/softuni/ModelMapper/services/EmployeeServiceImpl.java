package bg.softuni.ModelMapper.services;

import bg.softuni.ModelMapper.entities.Address;
import bg.softuni.ModelMapper.entities.Employee;
import bg.softuni.ModelMapper.entities.dtos.CreateEmployeeDTO;
import bg.softuni.ModelMapper.entities.dtos.EmployeeDTO;
import bg.softuni.ModelMapper.repositories.AddressRepository;
import bg.softuni.ModelMapper.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private AddressRepository addressRepository;
    private EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeServiceImpl(AddressRepository addressRepository, EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Employee create(CreateEmployeeDTO employeeDTO) {

        Employee employee = mapper.map(employeeDTO, Employee.class);

        Optional<Address> address = this.addressRepository.findByCountryAndCity(
                employeeDTO.getAddress().getCountry(),
                employeeDTO.getAddress().getAddressCity()
        );
        address.ifPresent(employee::setAddress);
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {

        return this.employeeRepository.findAll()
                .stream()
                .map(e->mapper.map(e,EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
