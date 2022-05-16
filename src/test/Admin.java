package test;

import Database.AdminSQl;
import java.io.*;

public class Admin  {

    public Admin() {

    }

    public void addStudentWithInitialCourses(Student student, String courseId) {
        AdminSQl.addStudentData(student);
        AdminSQl.addCoursesToStudent(student.getId(), courseId);
    }/*End_Of_addStudent*/


    public void addInstructorWithInitialCourse(Instructor instructor, String courseId) {
        AdminSQl.addInstructor(instructor,courseId);
        AdminSQl.addCoursesToInstructor(instructor.getId(), courseId);

    }/*End_Of_addInstructor*/

    public void deleteStudent(int StudentId) {
        AdminSQl.deleteStudent(StudentId);
    }/*End_Of_deleteStudent*/

    public void updateStudent(String ID, String NewName)  {

    AdminSQl.updateStudent(ID , NewName);
    }/*End_Of_updateStudent*/
    
     public void updateInstructor(String ID, String NewName)  {

    AdminSQl.updateInstructor(ID , NewName);
    }/*End_Of_updateStudent*/



    public void deleteInstructort(int instructorId) {
        AdminSQl.deleteInstructor(instructorId);
    }/*End_Of_deleteInstructort*/

    public String shwoAllInstractor() {
        return AdminSQl.shwoAllInstractors();
    }/*End_Of_shwoAllInstractor*/

    public String shwoAllStudent() {

        return AdminSQl.shwoAllStudents();
    }/*End_Of_shwoAllStudent*/


}/*End_Of_Admin*/
