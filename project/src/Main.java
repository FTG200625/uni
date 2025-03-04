import ap.base.Person;
import ap.uni.*;

public class Main {
    public static void main(String[] args) {
        //majors...
        Major major1 = new Major("computerScience", 20);
        Major major2 = new Major("math", 15);

        //persons...
        Person yasamin = new Person("Yasamin Alibabaie", "0000000000");
        Person sara = new Person("Sara shamsi", "1111111111");
        Person yekta = new Person("Yekta ghafori", "2222222222");
        Person mrNjafi = new Person("mr.Najafi", "3333333333");
        Person mrGhatee = new Person("mr.Ghatee", "4444444444");

        //students...
        Student yasaminStu = new Student(yasamin.id, 1403, major1.id);
        Student saraStu = new Student(sara.id, 1402, major1.id);
        Student yektaStu = new Student(yekta.id, 1400, major2.id);

        //professors...
        Professor najafiPro = new Professor(mrNjafi.id, major2.id);
        Professor ghateePro = new Professor(mrGhatee.id, major1.id);

        //courses...
        Course course1 =  new Course("math1", 3);
        Course course2 =  new Course("math2", 3);
        Course course3 =  new Course("AP", 4);

        //presentedCourses...
        PresentedCourse presentedCourse1 = new PresentedCourse(course1.id, najafiPro.id, 10);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.id, najafiPro.id, 10);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.id, ghateePro.id, 20);

        //taking classes...
        presentedCourse1.addStudent(yasaminStu.id);
        presentedCourse1.addStudent(saraStu.id);

        presentedCourse2.addStudent(yasaminStu.id);
        presentedCourse2.addStudent(saraStu.id);
        presentedCourse2.addStudent(yektaStu.id);

        presentedCourse3.addStudent(yektaStu.id);

        //transcript...
        Transcript transcriptYasamin = new Transcript(yasaminStu.id);
        transcriptYasamin.setGrade(presentedCourse1.id, 18.40);
        transcriptYasamin.setGrade(presentedCourse2.id, 17.5);

        Transcript transcriptSara = new Transcript(saraStu.id);
        transcriptSara.setGrade(presentedCourse1.id, 18);
        transcriptSara.setGrade(presentedCourse2.id, 19.80);

        Transcript transcriptYekta = new Transcript(yektaStu.id);
        transcriptYekta.setGrade(presentedCourse2.id, 20);
        transcriptYekta.setGrade(presentedCourse3.id, 18.5);

        //print...
        System.out.println("name: "+yasamin.name+"***code: "+yasaminStu.studentID);
        System.out.println("name: "+sara.name+"***code: "+saraStu.studentID);
        System.out.println("name: "+yekta.name+"***code: "+yektaStu.studentID);

        System.out.println("name: "+mrNjafi.name+"***id: "+najafiPro.id);
        System.out.println("name: "+mrGhatee.name+"***id: "+ghateePro.id);

        System.out.println("yasamin's transcript: ");
        transcriptYasamin.printTranscript();
        System.out.println("GPA: "+ transcriptYasamin.getGPA());

        System.out.println("sara's transcript: ");
        transcriptSara.printTranscript();
        System.out.println("GPA: "+transcriptSara.getGPA());

        System.out.println("yekta's transcript: ");
        transcriptYekta.printTranscript();
        System.out.println("GPA: "+transcriptYekta.getGPA());

    }
}