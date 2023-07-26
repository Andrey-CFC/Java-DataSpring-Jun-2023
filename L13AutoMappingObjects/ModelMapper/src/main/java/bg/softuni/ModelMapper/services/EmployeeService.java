package bg.softuni.ModelMapper.services;

import bg.softuni.ModelMapper.entities.Employee;
import bg.softuni.ModelMapper.entities.dtos.CreateEmployeeDTO;
import bg.softuni.ModelMapper.entities.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    Employee create(CreateEmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();
}
