package L02JavaDBAppsIntroEx;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P09IncreaseAgeByStoredProcedure {
    private static final String STORED_PROCEDURE_CALL = "CALL usp_get_older(?) ";
    private static final String GET_MINIONS_BY_ID = "SELECT name,age FROM minions WHERE id=?;";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getMySQLConnection();
        final int id = new Scanner(System.in).nextInt();
        CallableStatement callableStatement = connection.prepareCall(STORED_PROCEDURE_CALL);
        callableStatement.setInt(1, id);
        callableStatement.execute();
        PreparedStatement statement = connection.prepareStatement(GET_MINIONS_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
        }
    }
}
