package Database;

import java.sql.*;
import java.util.*;
import test.CourseComponent;

public  class CourseSQl extends DatabaseConnection implements UpdateCourseI{

    public  void addCourse(CourseComponent course) {
        testConnection();
        String query = Query.addCourse(course);
        System.out.println(query);
        try {
            ResultSet CourseDetials = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
    }/*End_Of_addCourse*/

    public  void deleteCourse(String courseID) {
        testConnection();
        String query = Query.deleteCourse(courseID);
        try {
            ResultSet deleteCourse = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
    }/*End_Of_deleteCourse*/

    public  ArrayList<String> nearToStartCourse() {
        ArrayList<String> output = new ArrayList<>();
        testConnection();
        String query = Query.nearToStartCourses();
        try {
            ResultSet StartCourse = statement.executeQuery(query);
            output = readStartCourses(StartCourse);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return output;
    }/*End_Of_nearToStartCourse*/

    private  ArrayList<String> readStartCourses(ResultSet result) {
        ArrayList<String> output = new ArrayList<>();
        try {
            while (result.next()) {
                String StartCourse = result.getString("START_DATE");
                output.add(StartCourse);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return output;
    }/*End_Of_readStartCourses*/

    public  ArrayList<String> nearToEnDCoures() {
        ArrayList<String> output = new ArrayList<>();
        testConnection();
        String query = Query.nearToEnDCoures();
        try {
            ResultSet EnDCoures = statement.executeQuery(query);
            output = readCoursesEndDate(EnDCoures);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return output;
    }/*End_Of_nearToEnDCoures*/

    private  ArrayList<String> readCoursesEndDate(ResultSet result) {
        ArrayList<String> output = new ArrayList<>();
        try {
            while (result.next()) {
                String EnDCoures = result.getString("END_DATE");
                output.add(EnDCoures);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return output;
    }/*End_Of_readCoursesEndDate*/

    public  ArrayList<String> CourseIDQuery() {//؟؟
        ArrayList<String> output = new ArrayList<>();
        testConnection();
        String Query = "select cr_id  from COURSEDETAIL";
        try {
            ResultSet id_StartCourse = statement.executeQuery(Query);
            output = readIdForStartCourseFromDataBase(id_StartCourse);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return output;
    }/*End_Of_*/

    private  ArrayList<String> readIdForStartCourseFromDataBase(ResultSet result) {
        ArrayList<String> output = new ArrayList<>();
        try {
            while (result.next()) {
                String id_StartCourse = result.getString("cr_id");
                output.add(id_StartCourse);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return output;
    }/*End_Of_readIdForStartCourseFromDataBase*/

    public  String showStartCourseDetails(String COURSEID) {
        testConnection();
        String query = Query.getStartCourseDetails(COURSEID);
        try {
            ResultSet Course_Details = statement.executeQuery(query);
            return PrintCourse_Details(Course_Details);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
        return "Error SQl Syntax";
    }/*End_Of_showStartCourseDetails*/

    private  String PrintCourse_Details(ResultSet result) {
        String tempCourseDetail = "";
        try {
            while (result.next()) {
                String ROOM = result.getString("ROOM");
                String BRANCH = result.getString("BRANCH");
                String PRICE = result.getString("PRICE");
                String START_DATE = result.getString("START_DATE");
                String DAYS_OF_COURSE = result.getString("DAYSOF_COURSE");
                String END_DATE = result.getString("END_DATE");
                String CR_ID = result.getString("CR_ID");

                tempCourseDetail = tempCourseDetail + "CR_ID :" + CR_ID + " ROOM :" + ROOM + " BRANCH :" + BRANCH + " PRICE :" + PRICE + "\n"
                        + " nearToStartCourse :" + START_DATE + " DAYSOF_COURSE : " + DAYS_OF_COURSE + " END_DATE :" + END_DATE + "\n";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tempCourseDetail;
    }/*End_Of_PrintCourse_Details*/
    
    @Override
    public  void UpdateRoomQuery(String CourseID, String NewRoom) {
        testConnection();
        String query = Query.UpdateRoom(CourseID, NewRoom);
        executeQuery(query);
    }/*End_Of_UpdateRoom*/

    @Override
    public  void UpdatebranchQuery(String CourseID, String NewBranch) {
        testConnection();
        String query =Query.Updatebranch(CourseID, NewBranch) ;
        executeQuery(query);

    }/*End_Of_Updatebranch*/

    @Override
    public  void UpdateCoursePriceQuery(String CourseID, String NewCoursePrice){
        testConnection();
        String query = Query.UpdateCoursePrice(CourseID, NewCoursePrice);
        executeQuery(query);
    }/*End_Of_*/

    @Override
    public  void UpdateStartDateQuery(String CourseID, String NewStartDate) {
        testConnection();
        String query = Query.UpdateStartDate(CourseID, NewStartDate);
        executeQuery(query);
    }/*End_Of_UpdateStartDate*/

    @Override
    public  void UpdateDaysOfCourseQuery(String CourseID, String NewDaysOfCourse) {
        testConnection();
        String query =Query.UpdateDaysOfCourse(CourseID, NewDaysOfCourse);
        executeQuery(query);
    }/*End_Of_UpdateDaysOfCourse*/

    @Override
    public  void UpdateEndDateQuery(String CourseID, String NewEndDate) {
        testConnection();
        String query = Query.UpdateEndDate(CourseID, NewEndDate);
        executeQuery(query);
    }/*End_Of_UpdateEndDate*/

    private  void executeQuery(String Query) {
        try {
            statement.executeUpdate(Query);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnection();
        }
    }/*End_Of_executeQuery*/


}/*End_Of_CourseSQl*/
