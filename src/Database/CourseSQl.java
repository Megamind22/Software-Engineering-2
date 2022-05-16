package Database;

import java.sql.*;
import java.util.*;
import test.CourseComponent;

public  class CourseSQl {

    public static void addCourse(CourseComponent course) {
        DatabaseConnection.testConnection();
        String query = Query.addCourse(course);
        System.out.println(query);
        try {
            ResultSet CourseDetials = DatabaseConnection.statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
    }/*End_Of_addCourse*/

    public static void deleteCourse(String courseID) {
        DatabaseConnection.testConnection();
        String query = Query.deleteCourse(courseID);
        try {
            ResultSet deleteCourse = DatabaseConnection.statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
    }/*End_Of_deleteCourse*/

    public static ArrayList<String> nearToStartCourse() {
        ArrayList<String> output = new ArrayList<>();
        DatabaseConnection.testConnection();
        String query = Query.nearToStartCourses();
        try {
            ResultSet StartCourse = DatabaseConnection.statement.executeQuery(query);
            output = readStartCourses(StartCourse);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return output;
    }/*End_Of_nearToStartCourse*/

    private static ArrayList<String> readStartCourses(ResultSet result) {
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

    public static ArrayList<String> nearToEnDCoures() {
        ArrayList<String> output = new ArrayList<>();
        DatabaseConnection.testConnection();
        String query = Query.nearToEnDCoures();
        try {
            ResultSet EnDCoures = DatabaseConnection.statement.executeQuery(query);
            output = readCoursesEndDate(EnDCoures);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return output;
    }/*End_Of_nearToEnDCoures*/

    private static ArrayList<String> readCoursesEndDate(ResultSet result) {
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

    public static ArrayList<String> CourseIDQuery() {//؟؟
        ArrayList<String> output = new ArrayList<>();
        DatabaseConnection.testConnection();
        String Query = "select cr_id  from COURSEDETAIL";
        try {
            ResultSet id_StartCourse = DatabaseConnection.statement.executeQuery(Query);
            output = readIdForStartCourseFromDataBase(id_StartCourse);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return output;
    }/*End_Of_*/

    private static ArrayList<String> readIdForStartCourseFromDataBase(ResultSet result) {
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

    public static String showStartCourseDetails(String COURSEID) {
        DatabaseConnection.testConnection();
        String query = Query.getStartCourseDetails(COURSEID);
        try {
            ResultSet Course_Details = DatabaseConnection.statement.executeQuery(query);
            return PrintCourse_Details(Course_Details);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return "Error SQl Syntax";
    }/*End_Of_showStartCourseDetails*/

    private static String PrintCourse_Details(ResultSet result) {
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

}/*End_Of_CourseSQl*/
