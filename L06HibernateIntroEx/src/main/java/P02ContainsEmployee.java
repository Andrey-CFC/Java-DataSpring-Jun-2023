import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class P02ContainsEmployee {
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();
        em.getTransaction().begin();

            String isEmployeePresented = em.createQuery("from Employee where concat_ws(' ',first_name, last_name) = :fullName", Employee.class)
                    .setParameter("fullName", fullName)
                    .getResultList().isEmpty() ? "No" : "Yes";
            em.getTransaction().commit();
            System.out.println(isEmployeePresented);
        em.close();
    }
}
