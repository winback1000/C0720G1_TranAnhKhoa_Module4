package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    String jdbcURL = "jdbc:mysql://localhost:3306/dictionary?useSSL=false";
    String jdbcUsername = "root";
    String jdbcPassword = "Chewingum1";

    protected java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    protected void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
