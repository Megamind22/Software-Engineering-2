package Database;

import java.sql.*;

public abstract class UpdateCourseSQL  {

    
    public static void UpdateRoom(String CourseID, String NewRoom) {
        DatabaseConnection.testConnection();
        String query = Query.UpdateRoom(CourseID, NewRoom);
        executeQuery(query);
    }/*End_Of_UpdateRoom*/

    public static void Updatebranch(String CourseID, String NewBranch) {
        DatabaseConnection.testConnection();
        String query =Query.Updatebranch(CourseID, NewBranch) ;
        executeQuery(query);

    }/*End_Of_Updatebranch*/

    public static void UpdateCoursePrice(String CourseID, String NewCoursePrice){
        DatabaseConnection.testConnection();
        String query = Query.UpdateCoursePrice(CourseID, NewCoursePrice);
        executeQuery(query);
    }/*End_Of_*/

    public static void UpdateStartDate(String CourseID, String NewStartDate) {
        DatabaseConnection.testConnection();
        String query = Query.UpdateStartDate(CourseID, NewStartDate);
        executeQuery(query);
    }/*End_Of_UpdateStartDate*/

    public static void UpdateDaysOfCourse(String CourseID, String NewDaysOfCourse) {
        DatabaseConnection.testConnection();
        String query =Query.UpdateDaysOfCourse(CourseID, NewDaysOfCourse);
        executeQuery(query);
    }/*End_Of_UpdateDaysOfCourse*/

    public static void UpdateEndDate(String CourseID, String NewEndDate) {
        DatabaseConnection.testConnection();
        String query = Query.UpdateEndDate(CourseID, NewEndDate);
        executeQuery(query);
    }/*End_Of_UpdateEndDate*/

    private static void executeQuery(String Query) {
        try {
            DatabaseConnection.statement.executeUpdate(Query);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
    }/*End_Of_executeQuery*/

}/*End_Of_*/
