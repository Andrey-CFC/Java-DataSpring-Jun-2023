import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student("TeoNew");
        em.persist(student);
        student.setName("TeoUpdated");
        em.persist(student);

        em.getTransaction().commit();
    }
}
