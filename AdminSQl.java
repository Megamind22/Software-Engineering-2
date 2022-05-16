package Database;

import test.Instructor;
import test.Student;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminSQl extends DatabaseConnection {

    public  void addStudentData(Student student) {
        testConnection();
        String query = Query.addStudent(student) ;
        try {
            statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        closeConnection();
    }/*End_Of_addStudent*/


    public  void addCoursesToStudent(int StudentId, String courseId) {
        testConnection();

        String[] sepratedCourseIds = courseId.split(" ");
        addCoursesToStudenEXectued(StudentId, sepratedCourseIds);
        closeConnection();
    }/*addCoursesToStudent*/
    private  void addCoursesToStudenEXectued(int StudentId, String[] sepratedCourseIds) {

        for (int j = 0; j < sepratedCourseIds.length; j++) {
            String Query = "insert into st_cor values(" + StudentId + ",'" + sepratedCourseIds[j] + "','')";
            System.out.println(Query);
            try {
                statement.executeQuery(Query);
            } catch (SQLException ex) {
                System.exit(0);
            }
        }/*End_for*/
    }/*End_Of_addCoursesToStudenEXectued*/


    public  void addInstructor(Instructor instructor,String courseId) {
        testConnection();
        String q = Query.addInstructor(instructor,courseId);
        try {
            statement.executeQuery(q);
        } catch (SQLException ex) {
        }
        closeConnection();
    }/*End_Of_addInstructor*/


    public  void addCoursesToInstructor(int InstructorId, String courseId) {
        testConnection();
        String[] sepratedCourseIds = courseId.split(" ");
        addCoursesToInstructorEXectued(InstructorId, sepratedCourseIds);
        closeConnection();
    }/*End_Of_addCoursesToInstructor*/

    private  void addCoursesToInstructorEXectued(int InstructorId, String[] sepratedCourseIds) {
        for (int j = 0; j < sepratedCourseIds.length - 1; j++) {
            String query = "insert into is_cr values(" + InstructorId + ",'" + sepratedCourseIds[j] + "')";//??
            try {
                statement.executeQuery(query);
            } catch (SQLException ex) {
                System.exit(0);
            }
        }/*End_for*/
    }/*End_Of_addCoursesToInstructorEXectued*/


    public  void deleteStudent(int StudentId) {

        testConnection();
        String q = Query.deleteStudent(StudentId);
        try {
            statement.executeQuery(q);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        closeConnection();
    }/*End_Of_deleteStudent*/

    public  void deleteInstructor(int InstructorId) {
        testConnection();
         String query=Query.deleteInstructor(InstructorId);
        try {
            statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        closeConnection();
    }/*End_Of_deleteInstructor*/


    public  void updateStudent(String ID, String NewName)  {
        testConnection();
        String query = Query.UpdateStudent(ID, NewName);
       try {
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                System.exit(0);
            }
         closeConnection();
    }/*updateStudent*/
    
    
    public  void updateInstructor(String ID, String NewName)  {
        testConnection();
        String query = Query.UpdateInstructor(ID, NewName);
       try {
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                System.exit(0);
            }
         closeConnection();
    }/*updateStudent*/



    public  String shwoAllInstractors() {
        testConnection();
        String query = Query.getAllInstractors();
        try {
            ResultSet InstructorName = statement.executeQuery(query);
            return readInstructorsFromDataBase(InstructorName);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return "Error SQlSynrax";
    }/*End_Of_shwoAllInstractor*/
    private  String readInstructorsFromDataBase(ResultSet result) {
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

    public  String shwoAllStudents() {
        testConnection();
        String query = Query.getAllStudents();
        try {
            ResultSet StudentName = statement.executeQuery(query);
            return readStudentsFromDataBase(StudentName);

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return "Error SQlEXception";
    }/*End_Of_shwoAllStudent*/

    private  String readStudentsFromDataBase(ResultSet result) {
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
