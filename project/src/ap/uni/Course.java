package ap.uni;

import java.util.ArrayList;

public class Course {
    public static int ID;
    public int id;
    public static ArrayList<Course> courseList = new ArrayList<>();
    public String title = "";
    public int units;

    //methods...
    public Course (String newTitle, int NewUnits){
        ++ID;
        id = ID;
        title = newTitle;
        units = NewUnits;
        courseList.add(this);
    }

    public static Course findByID (int id){

        for (Course course : courseList){
            if (course.id == id)
                return course;
        }
        return null;
    }
}
