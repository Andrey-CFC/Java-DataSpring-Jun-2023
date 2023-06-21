package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
    private static Connection connection;
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String DBNAME = "custom_orm_workshop";

    public static void createConnection() throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "R00ney!0");

        connection = DriverManager.getConnection(CONNECTION_URL +DBNAME, properties);

    }
    public static Connection getConnection() throws SQLException {
                createConnection();
        return connection;
    }
}
