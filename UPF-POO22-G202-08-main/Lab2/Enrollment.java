public class Enrollment {
    //Atributs
    private String seminarGroup;
    private Student student;
    private Course course;

    //Constructor
    public Enrollment(String sg){
        seminarGroup = sg;
    }

    //Mètodes
    public void addStudent(Student s){
        student = s;
    }

    public void addCourse(Course c){
        course = c;
    }

    public Course getCourse(){
        return course;
    }

}
