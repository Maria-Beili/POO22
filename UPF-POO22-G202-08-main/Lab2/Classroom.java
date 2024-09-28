import java.util.LinkedList;

public class Classroom {
    
    //Atributs
    private String code;
    private LinkedList<Lecture> lectureList;

    // Constructor
    public Classroom(String c){
        code = c;
        lectureList = new LinkedList<Lecture>();
    }

    //Mètodes
    public void addLecture(Lecture l){
        lectureList.add(l);
    }

    public String toString() {
        String myNum = "" + code;
        return myNum; 
    }

    public LinkedList<String> getCourses(){
        int length = lectureList.size();
        LinkedList<Course> courses = new LinkedList<Course>();
        for (int i=0; i<length; i++) {
            Course course = lectureList.get(i).getCourse();
            if (!courses.contains(course)) {
                courses.add(course);
            }
        }
        return Utility.toString(courses);
    }

    
    

}
