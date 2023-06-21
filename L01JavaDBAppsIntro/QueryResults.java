package L01JavaDBAppsIntro;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class QueryResults {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "R00ney!0");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        System.out.println("Enter User ID");
        String userId = sc.nextLine();

        PreparedStatement stmt =
                connection.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
        stmt.setString(1,userId);
        System.out.println(stmt);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
        connection.close();
    }
}
