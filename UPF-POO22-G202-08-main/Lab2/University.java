import java.util.LinkedList;

public class University {
    
    //Atributs
    private LinkedList<Student> studentList;
    private LinkedList<Teacher> teacherList;
    private LinkedList<Classroom> classroomList;
    private LinkedList<Course> courseList;

    //Constructor
    public University() {
        studentList = new LinkedList<Student>();
        teacherList = new LinkedList<Teacher>();
        classroomList = new LinkedList<Classroom>();
        courseList = new LinkedList<Course>();

        String name;
        int nia;

        LinkedList<String[]> students = Utility.readXML("student");
        for (String[] array: students) {
            name = array[0];
            nia = Integer.parseInt(array[1]);
            Student student = new Student(name, nia);
            studentList.add(student);
        }

        LinkedList<String[]> teachers = Utility.readXML("teacher");
        for (String[] array: teachers) {
            name = array[0];
            Teacher teacher = new Teacher(name);
            teacherList.add(teacher);
        }

        LinkedList<String[]> courses = Utility.readXML("course");
        for (String[] array: courses) {
            name = array[0];
            Course course = new Course(name);
            courseList.add(course);
        }   
        
        LinkedList<String[]> classrooms = Utility.readXML("classroom");
        for (String[] array: classrooms) {
            Classroom classroom = new Classroom(array[0]);
            classroomList.add(classroom);
        }  
        
        LinkedList<String[]> lectures = Utility.readXML("lecture");
        for (String[] array: lectures) {
            Classroom classroom = Utility.getObject(array[0], classroomList);
            Course course = Utility.getObject(array[1], courseList);
            Lecture lecture = new Lecture(array[4], Integer.parseInt(array[2]), Integer.parseInt(array[3]));

            lecture.addClassroom(classroom);
            lecture.addCourse(course);
            classroom.addLecture(lecture);
            course.addLecture(lecture);
        } 

        LinkedList<String[]> enrollments = Utility.readXML("enrollment");
        for (String[] array: enrollments) {
            Student student = Utility.getObject(array[0], studentList);
            Course course = Utility.getObject(array[1], courseList);
            Enrollment enrollment = new Enrollment(array[2]);

            enrollment.addStudent(student);
            enrollment.addCourse(course);
            student.addEnrollment(enrollment);
            course.addEnrollment(enrollment);
        } 

        LinkedList<String[]> assignments = Utility.readXML("assignment");
        for (String[] array: assignments) {
            Teacher teacher = Utility.getObject(array[0], teacherList);
            Course course = Utility.getObject(array[1], courseList);
            LinkedList<String> groupList = new LinkedList<String>();
            for (int i=2; i< array.length; i++) {
                groupList.add(array[i]);
            }
            Assignment assignment = new Assignment(groupList);
            
            assignment.addTeacher(teacher);
            assignment.addCourse(course);
            course.addAssignment(assignment);
            teacher.addAssignment(assignment);
        } 
    }

    //Mètodes
    public LinkedList<String> getStudents() {
        return Utility.toString(studentList);
    }

    public LinkedList<String> getTeachers() {
        return Utility.toString(teacherList);
    }

    public LinkedList<String> getCourses() {
        return Utility.toString(courseList);
    }

    public LinkedList<String> getClassrooms() {
        return Utility.toString(classroomList);
    }


    //Queries
    public LinkedList<String> CoursesOfStudent(String student) {
        return Utility.getObject(student, studentList).getCourses();
    }
    

    public LinkedList<String> TeachersOfCourse(String teacher){
        return Utility.getObject(teacher, teacherList).getCourses();
    }

    public LinkedList<String> CoursesofClassroom(String classroom){
        return Utility.getObject(classroom, classroomList).getCourses();
    }

}
