package ap.uni;

import java.util.ArrayList;

public class PresentedCourse {

    public static int ID;
    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds = new ArrayList<>();

    //methods...
    public PresentedCourse (int newCourseID, int newProfessorID, int maxCapacity){

        ID++;
        id = ID;
        courseID = newCourseID;
        professorID = newProfessorID;
        capacity = maxCapacity;
        studentIds = new ArrayList<>(maxCapacity);
        presentedCourseList.add(this);

    }

    public static PresentedCourse findByID (int id){

        for (PresentedCourse presentedCourse : presentedCourseList){
            if (presentedCourse.id == id)
                return presentedCourse;
        }
        return null;
    }

    public void addStudent (int studentID){

        if (studentIds.size() < capacity)
            studentIds.add(studentID);
        else
            System.out.print("The course has reached its maximum capacity.");
    }
}
