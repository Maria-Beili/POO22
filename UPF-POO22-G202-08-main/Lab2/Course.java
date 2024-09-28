import java.util.LinkedList;

public class Course {
    //Atributs
    private String name;
    LinkedList<Enrollment> enrollmentList;
    LinkedList<Assignment> assignmentList;
    LinkedList<Lecture> lectureList;

    //Constructor
    public Course(String n){
        name = n;
        enrollmentList = new LinkedList<Enrollment>();
        assignmentList = new LinkedList<Assignment>();
        lectureList = new LinkedList<Lecture>();
    }

    //Mètodes 
    public void addEnrollment(Enrollment e){
        enrollmentList.add(e);
    }
    
    public void addAssignment(Assignment a){
        assignmentList.add(a);
    }

    public void addLecture(Lecture l){
        lectureList.add(l);
    }

    public String toString() {
        return name; 
    }
    
}

