import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class P06AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList().forEach(Address::printGeneralInformation);
        em.getTransaction().commit();
        em.close();
    }
}
