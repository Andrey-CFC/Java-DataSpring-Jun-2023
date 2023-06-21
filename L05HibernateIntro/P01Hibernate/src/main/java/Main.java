import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Student sylvie = new Student("Sylvie");
//        Student andrey = new Student("Andrey");
//        session.save(sylvie);
//        session.save(andrey);

        List<Student> students =
                session.createQuery("FROM Student " ,
                        Student.class).list();
        for (Student student : students) {
            System.out.println(student.getName());
        }
        session.getTransaction().commit();
        session.close();

    }
}
