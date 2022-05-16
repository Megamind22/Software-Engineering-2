package Database;

import java.sql.*;

public abstract class StudentSQl {

    public static String showAllStudentGrade(int studentId,String courseID) {
        DatabaseConnection.testConnection();
        String query = Query.getStudentGrade(studentId,courseID);
        try {
            ResultSet dataGrade = DatabaseConnection.statement.executeQuery(query);
            return readGradeFromDataBase(dataGrade);

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return "swqs";
    }/*End_Of_showAllStudentGrade*/

    private static String readGradeFromDataBase(ResultSet result) {

        try {
            result.next();
            String studentGrade = result.getString("grade");
            return studentGrade;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "Error SQLEXception";
    }/*End_Of_readGradeFromDataBase*/


    public static String showAllCourses(int studentId) {
        DatabaseConnection.testConnection();
        String query = Query.getCoursesName(studentId);
        try {
            ResultSet courseName = DatabaseConnection.statement.executeQuery(query);
            return readNameFromCourse(courseName);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return "Error SQlException";
    }/*End_Of_showAllCourses*/


    private static String readNameFromCourse(ResultSet result) {
        String tempCourses = "";
        try {
            while (result.next()) {
                String courseName = result.getString("name");
                tempCourses = tempCourses + courseName + "\n";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tempCourses;
    }/*End_Of_readNameFromCourse*/

    public static void makeSurvey(int StudentId, String courseName, String UrOpinion) {

        DatabaseConnection.testConnection();

        String query = Query.insertIntoSurvey(StudentId, courseName, UrOpinion);
        try {

            DatabaseConnection.statement.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Syntax Sql error");
        }
        DatabaseConnection.closeConnection();
    }/*End_Of_makeSurvey*/


}/*End_Of_StudentSQl*/
