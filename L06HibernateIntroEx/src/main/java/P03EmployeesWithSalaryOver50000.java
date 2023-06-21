import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class P03EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("from Employee where salary > 50000", Employee.class).getResultList().forEach(employee -> System.out.println(employee.getFirstName()));

        em.getTransaction().commit();
        em.close();
    }
}
