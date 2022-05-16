package test;

import Database.CourseSQl;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CoursesModule {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    private ArrayList<CourseComponent> courses = new ArrayList<>();

    public CoursesModule() {

    }/*End_Of_Constractor*/

    public void addCourse(CourseComponent course) {
        CourseSQl.addCourse(course);
    }/*End_OF_addCourse*/

    public void deleteCourse(String courseID) {

        CourseSQl.deleteCourse(courseID);
    }/*End_OF_deleteCourse*/

    private static ArrayList<String> readCoursesStartdata() {
        ArrayList<String> Startdatas = new ArrayList<>(); //DatesOf start
        Startdatas = CourseSQl.nearToStartCourse();
        return Startdatas;
    }/*End_OF_ShowCoursesStartdata*/

    private static ArrayList<String> readCoursesEndDatas() {
        ArrayList<String> endtdatas = new ArrayList<>(); //DatesOf start
        endtdatas = CourseSQl.nearToEnDCoures();
        return endtdatas;
    }/*End_OF_readCoursesEndDatas*/

    private static ArrayList<String> readcoursesId() {
        ArrayList<String> coursesIds = new ArrayList<>();
        coursesIds = CourseSQl.CourseIDQuery();
        return coursesIds;
    }/*End_Of_readcoursesId*/


    private static String readNearestStartCourseId(ArrayList<String> coursesStartDatas, ArrayList<String> coursesIds) throws ParseException {
        String NearestStartCoursID = null;
        int numOf_CoursesStartDatas = coursesStartDatas.size() - 1;
        for (int date = 0; date <= numOf_CoursesStartDatas; date++) {
            String date1_string = coursesStartDatas.get(date);// CourseDate
            Date date1_df = dateFormat.parse(date1_string); //Covert TO Date
            for (int j = 0; j <= coursesStartDatas.size() - 1; j++) {
                String date2_string = coursesStartDatas.get(j);//CourseDateNum2
                Date date2_df = dateFormat.parse(date2_string);
                if (date1_df.compareTo(date2_df) > 0) {//True If d > d2 +
                    NearestStartCoursID = coursesIds.get(j);
                }/*End_if*/
            }/*End_for*/
        }/*End_for*/
        return NearestStartCoursID;
    }/*End_OF_read_NearestStartCourseId*/


    private static String readNearestEndCourseId(ArrayList<String> coursesEndDatas, ArrayList<String> coursesIds) throws ParseException {
        String NearestEndCoursID = null;
        int numOf_CoursesEndDatas = coursesEndDatas.size() - 1;
        for (int date = 0; date <= numOf_CoursesEndDatas; date++) {
            String date1_string = coursesEndDatas.get(date);
            Date date1_df = dateFormat.parse(date1_string);
            for (int j = 0; j <= coursesEndDatas.size() - 1; j++) {
                String date2_string = coursesEndDatas.get(j);
                Date date2_df = dateFormat.parse(date2_string);
                if (date1_df.compareTo(date2_df) < 0) {
                    NearestEndCoursID = coursesIds.get(j);
                }/*End_if*/
            }/*End_for*/
        }/*End_for*/
        return NearestEndCoursID;

    }/*End_OF_read_NearestEndCourseId*/


    public String ShowNearestStartCourseDetails() throws ParseException {//readDetailsOfNearToStartCourses
        ArrayList<String> Startdatas = readCoursesStartdata();
        ArrayList<String> coursesIds = readcoursesId();
        String NearestStartCoursID = readNearestStartCourseId(Startdatas, coursesIds);

        return CourseSQl.showStartCourseDetails(NearestStartCoursID);
    }/*End_OF_show_NearestStartCourseDetails*/


    public String ShowNearestEndCoursDetails() throws ParseException {

        ArrayList<String> coursesEnDdatas = readCoursesEndDatas();
        ArrayList<String> coursesIds = readcoursesId();
        String NearestEndCoursID = readNearestEndCourseId(coursesEnDdatas, coursesIds);
        return CourseSQl.showStartCourseDetails(NearestEndCoursID);
    }/*End_OF_ShowNearestEndCoursDetails*/

}/*End_OF_Show_NearestEndCoursDetails*/
