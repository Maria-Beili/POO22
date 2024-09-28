import java.util.LinkedList;

public class Teacher {
    //Atributs 
    private String name;
    private LinkedList<Assignment> assignmentsList;

    //Constructor 
    public Teacher(String n) {
        name = n;
        assignmentsList = new LinkedList<Assignment>();
    }

    //Mètodes
    public void addAssignment(Assignment a) {
        assignmentsList.add(a);
    }

    public String toString() {
        return name; 
    }

    public LinkedList<String> getCourses(){
        int length = assignmentsList.size();
        LinkedList<Course> courses = new LinkedList<Course>();
        for (int i=0; i<length; i++) {
            Course course = assignmentsList.get(i).getCourse();
            courses.add(course);
        }
        return Utility.toString(courses);
    }
    
}
