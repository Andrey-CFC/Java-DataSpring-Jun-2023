package L02JavaDBAppsIntroEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class P08IncreaseMinionsAge {
    private static final String UPDATE_MINIONS_AGE_BY_ID = "UPDATE minions SET age=age+1, name=LOWER(name)  WHERE id=?;";
    private static final String GET_ALL_MINIONS = "SELECT * FROM minions;";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getMySQLConnection();
        final Scanner scanner = new Scanner(System.in);

        final int[] minionsIds = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        PreparedStatement statement = connection.prepareStatement(UPDATE_MINIONS_AGE_BY_ID);
        for (int i = 0; i < minionsIds.length; i++) {
            statement.setInt(1, minionsIds[i]);
            statement.execute();
        }
        PreparedStatement statement1 = connection.prepareStatement(GET_ALL_MINIONS);
        ResultSet resultSet = statement1.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + " " + resultSet.getInt(3));
        }
    }
}
