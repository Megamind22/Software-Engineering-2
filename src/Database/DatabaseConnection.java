package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String username = null;
    private static String password = null;
    private static Connection connection;
    protected static Statement statement;

    public DatabaseConnection() {

    }/*End_Of_DatabaseConnection*/

    public DatabaseConnection(String dataBaseUser, String password) {
        this.username = dataBaseUser;
        this.password = password;
    }/*End_Of_DatabaseConnection*/

    protected static Boolean testConnection() {

        try {
            DatabaseConnection.connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }/*End_Of_testConnection*/

    protected static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }/*End_Of_testConnection*/

}/*End_Of_DatabaseConnection*/
