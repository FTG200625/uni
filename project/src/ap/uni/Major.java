package ap.uni;

import java.util.ArrayList;

public class Major {
    //public static int ID = 0;
    public int id;
    public static ArrayList<Major> majorList = new ArrayList<>();
    public String name;
    public final int capacity ;
    public int numberOfStudent ;

    //methods...
    public Major (String newName, int newCapacity){

        //++ID;
        //id = ID;
        id = majorList.size() + 1;
        name = newName;
        capacity = newCapacity;
        numberOfStudent = 0;
        majorList.add(this);
    }

    public static Major findById (int id){

        for (Major major: majorList){
            if(major.id == id)
                return major;
        }
        return null;
    }

    public void addStudent (){
        if (numberOfStudent < capacity)
            ++numberOfStudent;
        else
            System.out.print("The major has reached its maximum capacity.");

    }
}
