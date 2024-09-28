import java.util.LinkedList;

public class Student {
    //Atributs
    private String name;
    private int nia;
    private LinkedList<Enrollment> enrollmentList;

    //Constructor
    public Student(String n, int num){
        name = n;
        nia = num;
        enrollmentList = new LinkedList<Enrollment>();
    }

    public void addEnrollment(Enrollment e){
        enrollmentList.add(e);
    }

    public String toString() {
        return name;
    }

    public LinkedList<String> getCourses(){
        int length = enrollmentList.size();
        LinkedList<Course> courses = new LinkedList<Course>();
        for (int i=0; i<length; i++) {
            Course course = enrollmentList.get(i).getCourse();
            courses.add(course);
        }
        return Utility.toString(courses);
    }

}

