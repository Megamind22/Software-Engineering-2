package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private  String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private  String username = "mohamed";
    private  String password = "123";
    private  Connection connection;
    protected  Statement statement;

    public DatabaseConnection() {

    }/*End_Of_DatabaseConnection*/

    public DatabaseConnection(String dataBaseUser, String password) {
        this.username = dataBaseUser;
        this.password = password;
    }/*End_Of_DatabaseConnection*/

    protected  Boolean testConnection() {

        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }/*End_Of_testConnection*/

    protected  void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }/*End_Of_testConnection*/

}/*End_Of_DatabaseConnection*/
