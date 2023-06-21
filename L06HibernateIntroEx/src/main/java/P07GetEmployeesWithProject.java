import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class P07GetEmployeesWithProject {
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        em.getTransaction().begin();

        em.createQuery("FROM Employee WHERE id = :employeeId", Employee.class)
                .setParameter("employeeId",scanner.nextInt())
                .getSingleResult()
                .printFullNameWithProjectNames();
        em.getTransaction().commit();
        em.close();
    }
}
