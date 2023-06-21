import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class P12RemoveTowns {
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        Town town = em.createQuery("SELECT t FROM Town t WHERE t.name=:townName", Town.class)
                .setParameter("townName", townName)
                .getSingleResult();
        List<Employee> employees =  em.createQuery("SELECT e FROM Employee AS e WHERE e.address.town.name = '" + townName + "'", Employee.class).getResultList();

        em.getTransaction().begin();
        for (Employee employee : employees) {
            employee.setAddress(null);
            em.persist(employee);
        }
        List<Address> addresses = em.createQuery("SELECT a FROM Address a WHERE a.town.id=:townId", Address.class)
                .setParameter("townId", town.getId())
                .getResultList();

        addresses.forEach(em::remove);
        em.remove(town);
        em.getTransaction().commit();
        em.close();
        System.out.printf("%d address in %s deleted", addresses.size(), townName);
    }
}
