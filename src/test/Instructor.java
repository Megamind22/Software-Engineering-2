package test;

import Database.InstructorSQl;

public class Instructor extends InstructorSQl {

    private String Name;
    private int id;
    private String courseId;

    public Instructor() {

    }/*End_Of_Connstrctor*/

    public Instructor(String name, int id) {
        this.Name = name;
        this.id = id;
    }
    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {

        this.Name = name;
    }

    public String getName() {

        return this.Name;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {

        return this.id;
    }

    public void addGrade(int StudentId, String grade) {

        addStudentGrade(StudentId, grade, this.id);

    }/*End_Of_addGrade*/

    public String puplishGrades() {
        return puplishStudentGrade(this.id);

    }/*End_Of_puplishGrades*/

}/*End_Of_Instructor*/
