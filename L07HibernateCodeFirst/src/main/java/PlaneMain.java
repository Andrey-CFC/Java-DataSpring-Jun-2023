import entities.composition.Company;
import entities.composition.Plane;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PlaneMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("relations");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Company company = new Company("New Company");
        Plane plane1 = new Plane("STZAir", 250);
        Plane plane2 = new Plane("TsardomAir", 280);

        List<Plane> fleet = new ArrayList<>();
        fleet.add(plane1);
        fleet.add(plane2);

        company.setPlanes(fleet);

        em.persist(company);
//        List<Plane> planes = found.getPlanes();
//        System.out.println(planes.size());

        em.getTransaction().commit();
        em.close();
    }
}
