package ap.uni;

import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;


public class Student {
    //public static int ID;
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int enteranceYear;
    public int majorID;
    public String studentID;

    public Student (int newPersonID, int newEnteranceYear, int newMajorID){
        //++ID;
        //id = ID;
        id = studentList.size() + 1;
        personID = newPersonID;
        enteranceYear = newEnteranceYear;
        majorID = newMajorID;
        Major major = Major.findById(newMajorID);
        if (major == null) {
            System.out.println("Major with ID not found!");
        }
        major.addStudent();
        setStudentCode();
        studentList.add(this);
    }

    //methods...
    public static Student findById (int id){

        for (Student student : studentList){
            if (student.id == id)
                return student;
        }
        return null;
    }

    public void setStudentCode (){
        int year = this.enteranceYear % 1000;
        int majorCode = this.majorID, numOfStudent = this.id;

        String major = "";
        String num = "";

        if(majorCode <= 9)
             major = "0" + majorCode;
        else
             major = String.valueOf(majorCode);
        if (numOfStudent <= 9)
            num = "0" + numOfStudent;
        else
            num = String.valueOf(numOfStudent);

        String temp = "";
        temp = year + major + num ;
        this.studentID = temp;
    }
}
