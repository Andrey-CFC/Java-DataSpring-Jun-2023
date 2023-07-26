package bg.softuni.ModelMapper;

import bg.softuni.ModelMapper.entities.Address;
import bg.softuni.ModelMapper.entities.Employee;
import bg.softuni.ModelMapper.entities.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
public class ConsoleRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ModelMapper mapper = new ModelMapper();
//        PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<Employee, EmployeeDTO>() {
//            @Override
//            protected void configure() {
//                map().setCity(source.getAddress().getAddressCity());
//            }
//        };
//        mapper.addMappings(propertyMap);
//        mapper.validate();

        TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);
        typeMap.addMappings(mapping -> mapping.map(source -> source.getAddress().getCity(), EmployeeDTO::setCity));
        typeMap.validate();
        Address address = new Address("Bulgaria", "Sofia");
        Employee employee = new Employee("Sylvie", BigDecimal.TEN, address);

        EmployeeDTO employeeDTO = typeMap.map(employee);

        System.out.println(employeeDTO);
    }
}
