package ap.uni;

import ap.base.Person;
import java.util.HashMap;

public class Transcript {

    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();// key is id of course and value is student's grade.

    //methods...
    public Transcript(int newStudentID) {
        studentID = newStudentID;
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse presentedCourse = PresentedCourse.findByID(presentedCourseID);

        if (presentedCourse.studentIds.contains(studentID))
            transcript.put(presentedCourseID, grade);
        else
            System.out.println("student has not taken this course!");

    }

    public void printTranscript() {
        Student student = Student.findById(studentID);
        Person person = Person.findBy(student.personID);
        int courseid = 0;

        if (student == null) {
            System.out.println("student not found!");
            return;
        }

        if (person == null) {
            System.out.println("information not found!");
            return;
        }

        System.out.println("name : " + person.name);
        System.out.println("studentID : " + student.studentID);

        /*for (int i = 1 ; i <= PresentedCourse.ID ; ++i){
                PresentedCourse presentedCourse = PresentedCourse.findByID(i);
                for (int j = 0 ; j < presentedCourse.studentIds.get(j) ; ++j){
                    if (presentedCourse.studentIds.get(j) == studentID){
                        courseid = presentedCourse.courseID;
                        Course course = Course.findByID(courseid);

                        System.out.println("course title : "+course.title);
                        System.out.println("grade : "+transcript.get(courseid));
                    }
                }
        }*/
        transcript.forEach((courseID, grade) -> {
            PresentedCourse presentedCourse = PresentedCourse.findByID(courseID);
            if (presentedCourse != null) {
                Course course = Course.findByID(presentedCourse.courseID);
                if (course != null) {
                    System.out.println(course.title + ": " + grade);
                }
            }
        });

    }

    //need to be done...
    public double getGPA() {
        double[] totalGradePoints = {0};
        int[] totalUnits = {0};

        if (transcript == null || transcript.isEmpty()) {
            return 0.0;
        }
        transcript.forEach((courseID, grade) -> {
            PresentedCourse presentedCourse = PresentedCourse.findByID(courseID);
            if (presentedCourse != null) {
                Course course = Course.findByID(presentedCourse.courseID);
                if (course != null) {
                    totalGradePoints[0] = totalGradePoints[0] + (grade * course.units);
                    totalUnits[0] = totalUnits[0] + course.units;
                }
            }

        });
        if (totalUnits[0] == 0) {
            return 0.0;
        }
        return totalGradePoints[0] / totalUnits[0];
    }
}
