package ap.uni;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

public class Professor {
    public static int ID;
    public int id;
    public static ArrayList<Professor> professorList = new ArrayList<>();
    public int personID;
    public int majorID;

    //methods...
    public Professor (int newPersonID, int newMajorID){
        ID++;
        id = ID;
        personID = newPersonID;
        majorID = newMajorID;
        professorList.add(this);
    }

    public static Professor findByID (int id){

        for (Professor professor : professorList){
            if (professor.id == id)
                return professor;
        }
        return null;
    }
}
