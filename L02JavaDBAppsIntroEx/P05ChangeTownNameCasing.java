package L02JavaDBAppsIntroEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class P05ChangeTownNameCasing {
    private static final String GET_COUNTRY_BY_NAME = "SELECT name FROM towns WHERE country=?;";
    private static final String UPDATE_TOWNS_NAME_BY_COUNTRY = "Update towns SET name=UPPER(name) WHERE country=?;";
    private static final String PRINT_MESSAGE = "%d town names were affected.%n";
    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getMySQLConnection();
        final String country = new Scanner(System.in).nextLine();

        PreparedStatement statement = connection.prepareStatement(UPDATE_TOWNS_NAME_BY_COUNTRY);
        statement.setString(1, country);
        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            System.out.println("No town names were affected.");
            return;
        }
        System.out.printf(PRINT_MESSAGE, affectedRows);
        statement = connection.prepareStatement(GET_COUNTRY_BY_NAME);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();
        String[] result = new String[affectedRows];
        int i = 0;
        while (resultSet.next()) {
            result[i++] = resultSet.getString(1);
        }
        System.out.println(Arrays.toString(result));
    }
}
