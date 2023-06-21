import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class P10FindEmployeesByFirstName {
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();
        em.getTransaction().begin();
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();

        List<Employee> employees = em.createQuery("SELECT e FROM Employee  e WHERE e.firstName LIKE :firstNamePattern", Employee.class)
                .setParameter("firstNamePattern", pattern + "%")
                .getResultList();

        employees.forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary()));
        em.getTransaction().commit();
        em.close();
    }
}
