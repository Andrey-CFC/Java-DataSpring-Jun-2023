import entities.Employee;

import javax.persistence.EntityManager;


public class P04EmployeesFromDepartment {
    private static final String PRINT_FORMAT = "%s %s from %s - $%s";
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();
        em.createQuery("FROM Employee where department.name = :dName ORDER BY salary, id", Employee.class)
                .setParameter("dName","Research and Development")
                .getResultList()
                .forEach(Employee::printFullNameDepNameAndSalary);
    }
}
