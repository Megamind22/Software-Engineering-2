package test;

import Database.AdminSQl;
import java.io.*;

public class Admin extends AdminSQl  {

    public Admin() {

    }

    public void addStudentWithInitialCourses(Student student, String courseId) {
        addStudentData(student);
        addCoursesToStudent(student.getId(), courseId);
    }/*End_Of_addStudent*/


    public void addInstructorWithInitialCourse(Instructor instructor, String courseId) {
        addInstructor(instructor,courseId);
        addCoursesToInstructor(instructor.getId(), courseId);

    }/*End_Of_addInstructor*/

    public void deleteStudent(int StudentId) {
        deleteStudent(StudentId);
    }/*End_Of_deleteStudent*/

    public void updateStudent(String ID, String NewName)  {

    updateStudent(ID , NewName);
    }/*End_Of_updateStudent*/
    
     public void updateInstructor(String ID, String NewName)  {

      updateInstructor(ID , NewName);
    }/*End_Of_updateStudent*/



    public void deleteInstructort(int instructorId) {
        deleteInstructor(instructorId);
    }/*End_Of_deleteInstructort*/

    public String shwoAllInstractor() {
        return shwoAllInstractors();
    }/*End_Of_shwoAllInstractor*/

    public String shwoAllStudent() {

        return shwoAllStudents();
    }/*End_Of_shwoAllStudent*/


}/*End_Of_Admin*/
