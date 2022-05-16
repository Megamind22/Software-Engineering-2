package Database;

import java.sql.*;

public abstract class InstructorSQl {

    public static void addStudentGrade(int studentId, String grade, int instructorId) {
        DatabaseConnection.testConnection();

        String query = Query.addStudentGrade(studentId, grade, instructorId);
        try {
            DatabaseConnection.statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Syntax Sql error");
        }
        DatabaseConnection.closeConnection();
    }/*End_Of_addStudentGrade*/

    public static String puplishStudentGrade(int InstructorId) {
        DatabaseConnection.testConnection();

        String query = Query.getStudentsGrades(InstructorId);
        try {
            ResultSet dataGrade = DatabaseConnection.statement.executeQuery(query);
            return readData(dataGrade);//readData ? 
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return "Error SqlSyntax ";
    }/*End_Of_puplishStudentGrade*/


    private static String readData(ResultSet result) {

        String tempGrade = "";
        try {
            while (result.next()) {
                String studentId = result.getString("id");
                String studentName = result.getString("name");
                String studentGrade = result.getString("grade");
                tempGrade = tempGrade + studentId + "\t" + studentName + "\t" + studentGrade + "\n";

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tempGrade;
    }/*End_Of_readDataFromDataBase*/


}/*End_Of_InstructorSQl*/
