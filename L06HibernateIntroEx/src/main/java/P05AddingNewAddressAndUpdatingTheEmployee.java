import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.Scanner;
import java.util.Set;


public class P05AddingNewAddressAndUpdatingTheEmployee {
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();
        em.getTransaction().begin();
        Town townForNewAddress = em.createQuery("FROM Town WHERE id = 7", Town.class)
                .getSingleResult();
        Set<Employee> employees = Set.copyOf(em.createQuery("FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList());

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        newAddress.setTown(townForNewAddress);
        em.persist(newAddress);
        employees.forEach(e -> e.setAddress(newAddress));
        em.flush();
        em.getTransaction().commit();
        em.close();
        scanner.close();

    }
}
