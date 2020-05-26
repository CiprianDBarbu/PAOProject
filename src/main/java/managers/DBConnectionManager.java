package managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    public Connection createConnection() {
        try {
            String url = "jdbc:mysql://127.0.0.1/mydb";
            String username = "root";
            String password = "";

            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static DBConnectionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final static class SingletonHolder {
        private static final DBConnectionManager INSTANCE =
                new DBConnectionManager();
    }

}
