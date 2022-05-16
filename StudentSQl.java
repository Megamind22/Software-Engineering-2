package Database;

import java.sql.*;

public abstract class StudentSQl extends DatabaseConnection  {

    public  String showAllStudentGrade(int studentId,String courseID) {
        testConnection();
        String query = Query.getStudentGrade(studentId,courseID);
        try {
            ResultSet dataGrade = statement.executeQuery(query);
            return readGradeFromDataBase(dataGrade);

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return "swqs";
    }/*End_Of_showAllStudentGrade*/

    private  String readGradeFromDataBase(ResultSet result) {

        try {
            result.next();
            String studentGrade = result.getString("grade");
            return studentGrade;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "Error SQLEXception";
    }/*End_Of_readGradeFromDataBase*/


    public  String showAllCourses(int studentId) {
        testConnection();
        String query = Query.getCoursesName(studentId);
        try {
            ResultSet courseName = statement.executeQuery(query);
            return readNameFromCourse(courseName);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return "Error SQlException";
    }/*End_Of_showAllCourses*/


    private  String readNameFromCourse(ResultSet result) {
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

    public  void makeSurvey(int StudentId, String courseName, String UrOpinion) {

        testConnection();

        String query = Query.insertIntoSurvey(StudentId, courseName, UrOpinion);
        try {

            statement.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Syntax Sql error");
        }
        closeConnection();
    }/*End_Of_makeSurvey*/


}/*End_Of_StudentSQl*/
