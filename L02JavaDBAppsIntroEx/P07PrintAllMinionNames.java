package L02JavaDBAppsIntroEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class P07PrintAllMinionNames {
    private static final String GET_ALL_MINIONS = "select name from minions;";
    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getMySQLConnection();

        PreparedStatement statement = connection.prepareStatement(GET_ALL_MINIONS);
        ResultSet resultSet = statement.executeQuery();
        List<String> minions = new ArrayList<>();

        while (resultSet.next()) {
            minions.add(resultSet.getString(1));
        }
        int first = 0;
        int last = minions.size()-1;
        for (int i = 0; i < minions.size(); i++) {
            System.out.println(i % 2 == 0
                    ? minions.get(first++)
                    : minions.get(last--)
            );
        }
    }
}
