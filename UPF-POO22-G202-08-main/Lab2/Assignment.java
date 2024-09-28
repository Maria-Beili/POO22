import java.util.LinkedList;

public class Assignment {
    //Atributs
    private Teacher teacher;
    private Course course;
    private LinkedList<String> groups;

    //Constructor
    public Assignment(LinkedList<String> g){
        groups = g;
    }

    //Mètodes
    public void addTeacher(Teacher t){
        teacher = t;
    }

    public void addCourse(Course c){
        course = c;
    }

    public Course getCourse(){
        return course;
    }

    public Teacher getTeacher(){
        return teacher;
    }

}
