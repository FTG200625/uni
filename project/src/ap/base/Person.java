package ap.base;

import java.util.ArrayList;

public class Person {
    public static int ID;
    public int id;
    public static ArrayList<Person> personList = new ArrayList<>();
    public String name;
    public String nationalID;

    //methods...
    public Person (String newName, String newNationalID){

        ++ID;
        id = ID;
        name = newName;
        nationalID = newNationalID;
        personList.add(this);

    }
    public static Person findBy (int id){

        for (Person person: personList){
            if (person.id == id)
                return person;
        }
        return null;
    }
}
