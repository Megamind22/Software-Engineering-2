package Database;

import test.Instructor;
import test.Student;
import test.CourseComponent;

public abstract class Query {

    public static String getAllInstructorsNames() {
        return "select name from instructor";
    }/*End_Of_InstructorName*/

    public static String addStudent(Student student) {
        String Query = "Begin" //Add CorseId DB
                + "\n" + "insert into Student values("
                + student.getId()
                + ",'"
                + student.getName()
                + "');"
                + "\n"
                + "insert into users values('STD','"
                + student.getName()
                + "',"
                + student.getId()
                + ");"
                + "\n"
                + "End;";

        return Query;
    }/*End_Of_studentDataQuery*/

    public static String addInstructor(Instructor instructor , String courseId) {
        String Query = "Begin" + "\n" + "insert into instructor values(" + instructor.getId() + ",'" + instructor.getName() + "');"
                + "\n" + "insert into users values('TA','" + instructor.getName() + "'," + instructor.getId() + ");" + "\n"+ 
                "insert into is_cr values(" + instructor.getId() + ",'" + courseId + "');"+ "\n"+"End;";
        return Query;

    }

    /*End_Of_addInstructorQuery*/

    public static String deleteStudent(int StudentId) {
        return "Begin"
                + "\n"
                + "delete from Student where id="
                + StudentId
                + ";"
                + "\n"
                + "delete from users where password="
                + StudentId
                + ";"
                + "\n"
                + "End;";

    }/*End_Of_deleteStudent*/

    public static String deleteInstructor(int InstructorId) {
        return "Begin"
                + "\n"
                + "delete from INSTRUCTOR where id='"
                + InstructorId + "';"
                + "\n"
                + "delete from users where password='"
                + InstructorId + "';"
                + "\n" + "End;";
        
    }/*End_Of_deleteInstructor*/
    
    public static String getAllInstractors() {
        return "select name from instructor ";
    }/*End_Of_shwoAllInstractorQuery*/

    public static String getAllStudents() {
        return "select name from student ";
    }/*End_Of_shwoAllStudentQuery*/

    public static String addCourse(CourseComponent course) {
        return "Begin "
                + "\n"
                + "INSERT INTO course VALUES ("
                + course.getCourseId()
                + " ,'" + course.getCourseName()
                + "' );"
                + "\n" + "INSERT INTO coursedetail VALUES ("
                + course.getCourseId()
                + " , '"
                + course.getRoom()
                + "'  , "
                + "'" + course.getBranch()
                + "' ,'"
                + course.getCoursePrice()
                + "',  '"
                + course.getStartCourse()
                + "' ,'"
                + course.getDaysCourse()
                + "' ,  '"
                + course.getEndCourse()
                + "'  );"
                + "\n"
                + "End;";
    }/*End_Of_addCourseQuery*/

    public static String deleteCourse(String courseID) {
        return "delete  from course WHERE id =" + courseID + "  ";
    }/*End_Of_deleteCourseQuery*/


    public static String nearToStartCourses() {
        return "select START_DATE  from COURSEDETAIL";
    }/*End_Of_nearToStartCourseQuery*/

    public static String nearToEnDCoures() {
        return "select END_DATE  from COURSEDETAIL";
    }/*End_Of_nearToEnDCoures*/

    public static String getStudentsGrades(int InstructorId) {
        return "select Student.id,Student.name,grade from st_cor join Student on Student.id=st_id where cr_id in"
                + "(select cr_id from is_cr where is_id=" + InstructorId + ")";
    }/*End_Of_puplishGradeQuery*/

    public static String addStudentGrade(int studentId, String grade, int instructorId) {
        return "update st_cor set grade=" + grade + " where st_id=" + studentId + " and st_cor.cr_id in"
                + " (select cr_id from is_cr where is_id=" + instructorId + ")";
    }/*addStudentGradeQuery*/

    public static String getStudentGrade(int studentId,String courseID){
        return "select st_cor.grade from course join st_cor on st_cor.cr_id =course.id where course.ID='"+courseID+"'"
                        +"and st_id="+studentId+"";
    }/*End_Of_seeStudentGradeQuery*/


    public static String insertIntoSurvey(int StudentId, String courseName, String UrOpinion) {
        return "insert into survey values(" + StudentId + ",'" + courseName + "','" + UrOpinion + "')";
    }

    public static String UpdateRoom(String CourseID, String NewRoom) {
        return "UPDATE COURSEDETAIL set room ='" + NewRoom + "' WHERE cr_id ='" + CourseID + "'  ";
    }/*UpdateRoom*/

    public static String Updatebranch(String CourseID, String NewBranch) {
        return "UPDATE COURSEDETAIL set Branch ='" + NewBranch + "' WHERE cr_id ='" + CourseID + "'  ";
    }/*End_Of_Updatebranch*/

    public static String UpdateCoursePrice(String CourseID, String NewCoursePrice) {
        return "UPDATE COURSEDETAIL set PRICE ='" + NewCoursePrice + "' WHERE cr_id ='" + CourseID + "'  ";
    }/*End_Of_UpdateCoursePrice*/

    public static String UpdateStartDate(String CourseID, String NewStartDate) {
        return "UPDATE COURSEDETAIL set START_DATE ='" + NewStartDate + "' WHERE cr_id ='" + CourseID + "'  ";
    }/*End_Of_UpdateStartDate*/


    public static String UpdateDaysOfCourse(String CourseID, String NewDaysOfCourse) {
        return "UPDATE COURSEDETAIL set DAYSOF_COURSE ='" + NewDaysOfCourse + "' WHERE cr_id ='" + CourseID + "'  ";
    }/*End_Of_UpdateDaysOfCourse*/


    public static String UpdateEndDate(String CourseID, String NewEndDate) {
        DatabaseConnection.testConnection();
        return "UPDATE COURSEDETAIL set END_DATE ='" + NewEndDate + "' WHERE cr_id ='" + CourseID + "'  ";
    }/*End_Of_UpdateEndDate*/

    public static String getCoursesName(int studentId) {
        return "select course.name from course join st_cor on st_cor.cr_id =course.id where  st_id=" + studentId + "";
    }/*End_Of_getCoursesName*/

    public static String getStartCourseDetails(String COURSEID) {
        return "select *  from COURSEDETAIL where cr_id =" + COURSEID + "  ";
    }/*End_Of_getStartCourseDetails*/


    
    
 public static String UpdateStudent(String ID, String NewName) {
        return "Begin "
                + "\n"+
                "UPDATE STUDENT set Name ='" +NewName  + "' WHERE ID ='" + ID + "' ;"+
                "UPDATE USERS set USERNAME ='" +NewName  + "' WHERE PASSWORD ='" + ID + "'  ;" 
                + "End;";
}/*UpdateStudent*/

    public static String UpdateInstructor(String ID, String NewName) {
        return "Begin "
                + "\n"+
                "UPDATE INSTRUCTOR set name ='" +NewName  + "' WHERE ID ='" + ID + "' ;"+
                "UPDATE USERS set USERNAME ='" +NewName  + "' WHERE PASSWORD ='" + ID + "'  ;" 
                + "End;";
}/*UpdateStudent*/
 
    
}/*End_Of_Query*/


