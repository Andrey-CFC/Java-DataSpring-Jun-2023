package bg.softuni.ModelMapper.entities.dtos;

import bg.softuni.ModelMapper.entities.Employee;

import java.math.BigDecimal;

public class EmployeeDTO {
    private String firstName;
    private BigDecimal salary;
    private String city;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee) {
        this.firstName = employee.getFirstName();
        this.salary = employee.getSalary();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }
}
