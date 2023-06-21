package L02JavaDBAppsIntroEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class P02GetVillainsNames {
    private static final String SELECT_ALL_VILLAINS_MINIONS_COUNT_WITH_MORE_THAN_15_MINIONS = "select v.name, count(mv.minion_id) as count_of_minions " +
            "from villains as v " +
            "join minions_villains as mv on v.id = mv.villain_id " +
            "group by v.id " +
            "having count_of_minions > ? " +
            "order by count_of_minions desc;";
    private static final String PRINT_FORMAT = "%s %d%n";
    private static final String COLUMN_LABEL_COUNT_OF_MINIONS = "count_of_minions";
    private static final String COLUMN_LABEL_NAME = "name";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getMySQLConnection();

        final PreparedStatement statement = connection.prepareStatement(SELECT_ALL_VILLAINS_MINIONS_COUNT_WITH_MORE_THAN_15_MINIONS);
        statement.setInt(1, 15);
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            print(resultSet);
        }
        connection.close();
    }

    private static void print(ResultSet resultSet) throws SQLException {
        final String name = resultSet.getString(COLUMN_LABEL_NAME);
        final int count_of_minions = resultSet.getInt(COLUMN_LABEL_COUNT_OF_MINIONS);
        System.out.printf(PRINT_FORMAT, name, count_of_minions);
    }

}
