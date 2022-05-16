package Database;

import test.Instructor;
import test.Student;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminSQl {

    public static void addStudentData(Student student) {
        DatabaseConnection.testConnection();
        String query = Query.addStudent(student);
        try {
            DatabaseConnection.statement.executeQuery(query);
        } catch (SQLException ex) {
        }
        DatabaseConnection.closeConnection();
    }/*End_Of_addStudent*/


    public static void addCoursesToStudent(int StudentId, String courseId) {
        DatabaseConnection.testConnection();

        String[] sepratedCourseIds = courseId.split(" ");
        addCoursesToStudenEXectued(StudentId, sepratedCourseIds);
        DatabaseConnection.closeConnection();
    }/*addCoursesToStudent*/
    private static void addCoursesToStudenEXectued(int StudentId, String[] sepratedCourseIds) {

        for (int j = 0; j < sepratedCourseIds.length; j++) {
            String Query = "insert into st_cor values(" + StudentId + ",'" + sepratedCourseIds[j] + "','')";
            System.out.println(Query);
            try {
                DatabaseConnection.statement.executeQuery(Query);
            } catch (SQLException ex) {
                System.exit(0);
            }
        }/*End_for*/
    }/*End_Of_addCoursesToStudenEXectued*/


    public static void addInstructor(Instructor instructor,String courseId) {
        DatabaseConnection.testConnection();
        String q = Query.addInstructor(instructor,courseId);
        try {
            DatabaseConnection.statement.executeQuery(q);
        } catch (SQLException ex) {
        }
        DatabaseConnection.closeConnection();
    }/*End_Of_addInstructor*/


    public static void addCoursesToInstructor(int InstructorId, String courseId) {
        DatabaseConnection.testConnection();
        String[] sepratedCourseIds = courseId.split(" ");
        addCoursesToInstructorEXectued(InstructorId, sepratedCourseIds);
        DatabaseConnection.closeConnection();
    }/*End_Of_addCoursesToInstructor*/

    private static void addCoursesToInstructorEXectued(int InstructorId, String[] sepratedCourseIds) {
        for (int j = 0; j < sepratedCourseIds.length - 1; j++) {
            String query = "insert into is_cr values(" + InstructorId + ",'" + sepratedCourseIds[j] + "')";//??
            try {
                DatabaseConnection.statement.executeQuery(query);
            } catch (SQLException ex) {
                System.exit(0);
            }
        }/*End_for*/
    }/*End_Of_addCoursesToInstructorEXectued*/


    public static void deleteStudent(int StudentId) {

        DatabaseConnection.testConnection();
        String q = Query.deleteStudent(StudentId);
        try {
            DatabaseConnection.statement.executeQuery(q);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        DatabaseConnection.closeConnection();
    }/*End_Of_deleteStudent*/

    public static void deleteInstructor(int InstructorId) {
        System.out.println("11");
        DatabaseConnection.testConnection();
        System.out.println("22");
         String query=Query.deleteInstructor(InstructorId);
         System.out.println("33");
        try {
            DatabaseConnection.statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        DatabaseConnection.closeConnection();
    }/*End_Of_deleteInstructor*/


    public static void updateStudent(String ID, String NewName)  {
        DatabaseConnection.testConnection();
        String query = Query.UpdateStudent(ID, NewName);
       try {
                DatabaseConnection.statement.executeUpdate(query);
            } catch (SQLException ex) {
                System.exit(0);
            }
         DatabaseConnection.closeConnection();
    }/*updateStudent*/
    
    
    public static void updateInstructor(String ID, String NewName)  {
        DatabaseConnection.testConnection();
        String query = Query.UpdateInstructor(ID, NewName);
       try {
                DatabaseConnection.statement.executeUpdate(query);
            } catch (SQLException ex) {
                System.exit(0);
            }
         DatabaseConnection.closeConnection();
    }/*updateStudent*/



    public static String shwoAllInstractors() {
        DatabaseConnection.testConnection();
        String query = Query.getAllInstractors();
        try {
            ResultSet InstructorName = DatabaseConnection.statement.executeQuery(query);
            return readInstructorsFromDataBase(InstructorName);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return "Error SQlSynrax";
    }/*End_Of_shwoAllInstractor*/
    private static String readInstructorsFromDataBase(ResultSet result) {
        String tempInstructor = "";
        try {
            while (result.next()) {
                String Instructors = result.getString("name");
                tempInstructor = tempInstructor + Instructors + "\n";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tempInstructor;
    }

    public static String shwoAllStudents() {
        DatabaseConnection.testConnection();
        String query = Query.getAllStudents();
        try {
            ResultSet StudentName = DatabaseConnection.statement.executeQuery(query);
            return readStudentsFromDataBase(StudentName);

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return "Error SQlEXception";
    }/*End_Of_shwoAllStudent*/

    private static String readStudentsFromDataBase(ResultSet result) {
        String tempStudentData = "";
        try {
            while (result.next()) {
                String Students = result.getString("name");
                tempStudentData = tempStudentData + Students + "\n";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tempStudentData;
    }

}/*End_Of_AdminSQl*/
