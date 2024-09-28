//import java.util.LinkedList;

public class TestUniversity {
    
    public static void main(String[] args) {
        University university = new University();
        
        System.out.println("\nStudents:" + university.getStudents() + "\n");
        System.out.println("Classrooms:" + university.getClassrooms() + "\n");
        System.out.println("Courses:" + university.getCourses() + "\n");
        System.out.println("Teachers:"+ university.getTeachers() + "\n");
        System.out.println("Courses of Albus Dumbledore:"+ university.TeachersOfCourse("Albus Dumbledore") + "\n");
        System.out.println("Courses of Hermione Granger:"+ university.CoursesOfStudent("Hermione Granger") + "\n");
        System.out.println("Courses of classroom 10.101:"+ university.CoursesofClassroom("10.101") + "\n");
    }
}
