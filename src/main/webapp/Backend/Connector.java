package main.webapp.Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connector {
    private static Connection connection = getConnection();

    public static Connection getInstantConnection(){
        return connection;
    }
    private static Connection getConnection(){
        ResourceBundle resource = ResourceBundle.getBundle("main.webapp.Backend.database");

        String url = resource.getString("db.url");
        String table = resource.getString("db.name");
        String login = resource.getString("db.login");
        String pass = resource.getString("db.password");

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(
                    url + table + "?serverTimezone=UTC",
                    login,
                    pass
            );
        } catch (SQLException e) {
            System.out.println("Connection error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
