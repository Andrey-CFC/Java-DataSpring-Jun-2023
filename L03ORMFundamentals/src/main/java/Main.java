import entities.Courses;
import entities.User;
import orm.EntityManager;
import orm.config.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root","R00ney!0","soft_uni");
        Connection connection = MyConnector.getConnection();
        EntityManager<User> userEntityManager = new EntityManager<>(connection);
        boolean persistResult = userEntityManager.persist(new User("u","p",12, LocalDate.now()));
        User first = userEntityManager.findFirst(User.class);

        System.out.println(first);

//        EntityManager<Courses> coursesEntityManager = new EntityManager<>(connection);
//        coursesEntityManager.persist(new Courses("Math",12));

    }
}
