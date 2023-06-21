import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class P09IncreaseSalaries {
    private static final List<String> DEPARTMENTS_NAMES_TO_INCREASE_SALARIES = List.of("Engineering", "Tool Design", "Marketing", "Information Services");

    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("FROM Employee WHERE department.name in (:deps)", Employee.class)
                .setParameter("deps", DEPARTMENTS_NAMES_TO_INCREASE_SALARIES)
                .getResultList();
        employees.forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));
        em.flush();
        em.getTransaction().commit();
        em.close();
        employees.forEach(employee -> System.out.printf("%s %s (%s)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary()));
    }
}
