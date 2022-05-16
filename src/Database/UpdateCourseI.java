package Database;

public interface UpdateCourseI {

    public void UpdateRoomQuery(String CourseID, String NewRoom);

    public void UpdatebranchQuery(String CourseID, String NewBranch);

    public void UpdateCoursePriceQuery(String CourseID, String NewCoursePrice);

    public void UpdateStartDateQuery(String CourseID, String NewStartDate);

    public void UpdateDaysOfCourseQuery(String CourseID, String NewDaysOfCourse);

    public void UpdateEndDateQuery(String CourseID, String NewEndDate);

}
