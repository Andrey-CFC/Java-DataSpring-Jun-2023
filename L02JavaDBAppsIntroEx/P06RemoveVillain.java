package L02JavaDBAppsIntroEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P06RemoveVillain {
    private static final String GET_VILLAIN_NAME_BY_ID = "select name from villains where id = ?;";
    private static final String GET_COUNT_MINIONS_BY_VILLAIN_ID = "select count(*) as m_count from minions_villains where villain_id = ?;";
    private static final String DELETE_MINIONS_VILLAINS_BY_VILLAIN_ID = "delete from minions_villains where villain_id = ?;";
    private static final String DELETE_VILLAIN_BY_ID = "delete from villains where id = ?;";
    private static final String PRINT_RELEASED_MINIONS_COUNT_FORMAT = "%d minions released";
    private static final String PRINT_VILLAINS_DELETE_FORMAT = "%s was deleted%n";
    private static final String PRINT_NO_SUCH_VILLAIN_FORMAT = "No such villain was found";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getMySQLConnection();
        final int villainId = new Scanner(System.in).nextInt();
        final PreparedStatement getVillainStatement = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        getVillainStatement.setInt(1, villainId);
        final ResultSet villainResultSet = getVillainStatement.executeQuery();
        if (!villainResultSet.next()) {
            System.out.println(PRINT_NO_SUCH_VILLAIN_FORMAT);
            connection.close();
            return;
        }
        final String villainName = villainResultSet.getString(1);

        final PreparedStatement minionsCountSet = connection.prepareStatement(GET_COUNT_MINIONS_BY_VILLAIN_ID);
        minionsCountSet.setInt(1, villainId);
        final ResultSet minionsCountResultSet = minionsCountSet.executeQuery();
        minionsCountResultSet.next();
        int countOfMinionsReleased = minionsCountResultSet.getInt(1);

        connection.setAutoCommit(false);
        try (PreparedStatement releaseMinionsStatement = connection.prepareStatement(DELETE_MINIONS_VILLAINS_BY_VILLAIN_ID);
             PreparedStatement deleteVillainsStatement = connection.prepareStatement(DELETE_VILLAIN_BY_ID);){
            releaseMinionsStatement.setInt(1, villainId);
            releaseMinionsStatement.executeUpdate();

            deleteVillainsStatement.setInt(1, villainId);
            deleteVillainsStatement.executeUpdate();

            connection.commit();
            System.out.printf(PRINT_VILLAINS_DELETE_FORMAT,villainName);
            System.out.printf(PRINT_RELEASED_MINIONS_COUNT_FORMAT, countOfMinionsReleased);
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
            connection.rollback();
        }

    }


}
