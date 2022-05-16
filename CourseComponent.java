package test;

public class CourseComponent {

    private String courseName;
    private int courseID;
    private String room;
    private String branch;
    private String coursePrice;
    private String startDate;
    private String daysOfCourse;
    private String endDate;

    public CourseComponent() {

    }

    public CourseComponent(String courseName, int courseID, String room, String branch, String coursePrice, String startDate, String daysOfCourse, String endDate) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.room = room;
        this.branch = branch;
        this.coursePrice = coursePrice;
        this.startDate = startDate;
        this.daysOfCourse = daysOfCourse;
        this.endDate = endDate;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {

        return courseName;
    }

    public void setCourseId(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseId() {
        return courseID;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {

        return room;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {

        return branch;
    }

    public void setCoursePrice(String coursePrice) {

        this.coursePrice = coursePrice;
    }

    public String getCoursePrice() {

        return coursePrice;
    }

    public void setStartCourse(String startDate) {
        this.startDate = startDate;
    }

    public String getStartCourse() {
        return startDate;
    }

    public void setDaysCourse(String daysOfCourse) {

        this.daysOfCourse = daysOfCourse;
    }

    public String getDaysCourse() {
        return daysOfCourse;
    }

    public void setEndCourse(String endDate) {

        this.endDate = endDate;
    }

    public String getEndCourse() {
        return endDate;
    }

}/*End_Of_CourseComponent*/
