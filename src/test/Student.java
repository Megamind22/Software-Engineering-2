package test;

import Database.StudentSQl;

public class Student {

    private String name;
    private int id;
    private String courseId = null;

    public Student() {
    }/*Constrctor*/

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }/*Constrctor*/


    public Student(String name, int id, String courseId) {
        this.name = name;
        this.id = id;
        this.courseId = courseId;
    }/*End_Of_Constrctor*/


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }


    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {

        return this.id;
    }

    public String showGrade(String courseID) {
        return StudentSQl.showAllStudentGrade(this.id , courseID);
    }/*End_Of_showGrade*/

    public void makeSurvey(String courseName, String thinkOPinion) {
        StudentSQl.makeSurvey(this.id, courseName, thinkOPinion);
        System.out.println("Done");
    }/*End_Of_showGrade*/

    public String showAllCourses() {

        return StudentSQl.showAllCourses(this.id);
    }/*End_Of_showGrade*/

  

}/*End_Of_Student*/
