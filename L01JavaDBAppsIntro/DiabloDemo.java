package L01JavaDBAppsIntro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DiabloDemo {
    private static final String SELECT_USER_GAMES_COUNT_BY_USERNAME = "SELECT u.user_name,u.first_name,u.last_name,count(distinct ug.game_id) as count FROM  users as u JOIN `users_games` as ug ON u.id=ug.user_id WHERE user_name=? group by ug.user_id;";
    public static void main(String[] args) throws SQLException {
        Connection connection = getMySQLConnection();

        String username = readUsername();

        PreparedStatement statement = connection.prepareStatement(SELECT_USER_GAMES_COUNT_BY_USERNAME);
        statement.setString(1,username);
        ResultSet result = statement.executeQuery();
        if (result.next()){
            System.out.println("User: " + result.getString("user_name"));
            System.out.printf("%s %s has played %d games%n", result.getString("first_name"), result.getString("last_name"), result.getInt("count"));
        } else{
            System.out.println("No such user exists");
        }
    }

    private static String readUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        return username;
    }

    private static Connection getMySQLConnection() throws SQLException {
        Properties userPass = new Properties();
        userPass.setProperty("user","root");
        userPass.setProperty("password","R00ney!0");

        Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo",userPass);
        return connection;
    }
}
