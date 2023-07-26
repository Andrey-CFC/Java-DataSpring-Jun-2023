package bg.softuni.ModelMapper;

import bg.softuni.ModelMapper.entities.Address;
import bg.softuni.ModelMapper.entities.Employee;
import bg.softuni.ModelMapper.entities.dtos.AddressDTO;
import bg.softuni.ModelMapper.entities.dtos.CreateEmployeeDTO;
import bg.softuni.ModelMapper.services.AddressService;
import bg.softuni.ModelMapper.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class AppRunner implements CommandLineRunner {

    private final AddressService addressService;
    private final EmployeeService employeeService;
    private final Scanner scanner;

    @Autowired
    public AppRunner(AddressService addressService, EmployeeService employeeService, Scanner scanner) {
        this.addressService = addressService;
        this.employeeService = employeeService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
//        createAddress(scanner);
//        createEmployee(scanner);
        printAllEmployees();
    }

    private void printAllEmployees() {
        this.employeeService.findAll().forEach(System.out::println);
    }

    private void createEmployee() {
        String firstName = scanner.nextLine();
        BigDecimal salary = new BigDecimal(scanner.nextLine());
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
//        Long addressId = Long.parseLong(scanner.nextLine());
        String country = scanner.nextLine();
        String city = scanner.nextLine();
        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, address);
        Employee employee = this.employeeService.create(employeeDTO);
        System.out.println(employee);

    }

    private void createAddress() {
        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDTO data = new AddressDTO(country, city);
        Address address = addressService.create(data);
        System.out.println(address);
    }
}
