package Database;

import java.sql.*;

public abstract class InstructorSQl extends DatabaseConnection {

    public  void addStudentGrade(int studentId, String grade, int instructorId) {
        testConnection();

        String query = Query.addStudentGrade(studentId, grade, instructorId);
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Syntax Sql error");
        }
        closeConnection();
    }/*End_Of_addStudentGrade*/

    public  String puplishStudentGrade(int InstructorId) {
        testConnection();

        String query = Query.getStudentsGrades(InstructorId);
        try {
            ResultSet dataGrade = statement.executeQuery(query);
            return readData(dataGrade);//readData ? 
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return "Error SqlSyntax ";
    }/*End_Of_puplishStudentGrade*/


    private  String readData(ResultSet result) {

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
