package main.webapp.Backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    public static ResultSet executeSelect(String sql) throws SQLException {
        ResultSet result = null;
        Connection connection = Connector.getInstantConnection();

        Statement statement = connection.createStatement();

        result = statement.executeQuery(sql);

        return result;
    }

    public static int execute(String sql) throws SQLException {
        int result = 0;
        Connection connection = Connector.getInstantConnection();

        Statement statement = connection.createStatement();

        result = statement.executeUpdate(sql);

        return result;
    }
}
