public class Lecture {
    //Atributs
    private String group;
    private int timeSlot;
    private int type;
    private Classroom classroom;
    private Course course;

    //Constructor
    public Lecture(String g, int s, int t){
        group = g;
        timeSlot = s;
        type = t;
    }

    //Mètodes
    public void addClassroom(Classroom c){
        classroom = c;
    }

    public void addCourse(Course c){
        course = c;
    }

    public Course getCourse(){
        return course;
    }

    public int getType(){
        return type;
    }


}
