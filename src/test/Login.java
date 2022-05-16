package test;

import Database.*;
import java.sql.*;

public class Login extends DatabaseConnection {

    public static String testlogin(String userName, int password) {

        DatabaseConnection.testConnection();
        String QueryStatement = "select user_type from users where userName='" + userName + "'and password=" + password + "";
        ResultSet typeOfUser;
        try {
            typeOfUser = DatabaseConnection.statement.executeQuery(QueryStatement);
            typeOfUser.next();
            return typeOfUser.getString("user_type");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        DatabaseConnection.closeConnection();

        return "Error";
    }
}/*End_Of_DatabaseConnection*/
