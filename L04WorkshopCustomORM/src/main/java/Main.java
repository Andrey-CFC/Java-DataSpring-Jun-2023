import entities.Account;
import entities.User;
import orm.EntityManager;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException {
        final EntityManager<User> userEntityManager = new EntityManager<>();
        final EntityManager<Account> accountEntityManager = new EntityManager<>();
        userEntityManager.doAlter(User.class);
        System.out.println();

    }
}
