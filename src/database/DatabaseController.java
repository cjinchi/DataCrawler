package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {
    private Connection connection;

    public DatabaseController(String user, String password, String database) {
        try {
            connection = DriverManager.getConnection(String.format(
                    "jdbc:mysql://localhost/%s?user=%s&password=%s&serverTimezone=GMT", database, user, password));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return connection != null;
    }
}
