package L02JavaDBAppsIntroEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P03GetMinionsNames {
    private static final String GET_MINIONS_NAME_AND_AGE_BY_VILLAIN_ID = "select m.name, m.age " +
            "from minions as m " +
            "join minions_villains as mv on m.id = mv.minion_id " +
            "where mv.villain_id = ?;";
    private static final String GET_VILLAIN_NAME_BY_ID = "select name from villains " +
            "where id = ?;";
    private static final String PRINT_VILLAIN = "Villain: %s%n";
    private static final String PRINT_NO_VILLAIN_FOUND_FORMAT = "No villain with ID %d exists in the database.%n";
    private static final String PRINT_MINION_FORMAT = "%d. %s %d%n";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getMySQLConnection();
        final int villainID = new Scanner(System.in).nextInt();

        final PreparedStatement statementForMinions = connection.prepareStatement(GET_MINIONS_NAME_AND_AGE_BY_VILLAIN_ID);
        statementForMinions.setInt(1, villainID);


        final PreparedStatement statementForVillains = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        statementForVillains.setInt(1, villainID);
        final ResultSet resultSetForVillain = statementForVillains.executeQuery();
        if (!resultSetForVillain.next()) {
            System.out.printf(PRINT_NO_VILLAIN_FOUND_FORMAT, villainID);
            connection.close();
            return;
        }
        final ResultSet resultSetForMinions = statementForMinions.executeQuery();
        print(resultSetForVillain, resultSetForMinions);

        connection.close();
    }

    private static void print(ResultSet villains, ResultSet minions) throws SQLException {
        final String villainName = villains.getString(COLUMN_LABEL_NAME);
        System.out.printf(PRINT_VILLAIN, villainName);
        for (int i = 1; minions.next(); i++) {
            final String minionName = minions.getString(COLUMN_LABEL_NAME);
            final int minionAge = minions.getInt(COLUMN_LABEL_AGE);
            System.out.printf(PRINT_MINION_FORMAT, i, minionName, minionAge);
        }
    }
}
