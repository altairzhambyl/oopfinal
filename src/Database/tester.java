package Database;


import OfficeRegistrar.Course;
import Users.Teacher;


public class tester {

    public static void main(String[] args) {
        try {
            Teacher t = new Teacher("Second", "Last", "567@kbtu.kz");
            Course course = new Course("yescode", "ads", "no desc");
            
            DataBase db = DataBase.getInstance();
            db.addUser(t);
            db.addCourse(course);
            
            // Display courses and users
            System.out.println("Courses in the database:");
            db.getCourses().forEach(System.out::println);
            System.out.println("Users in the database:");
            db.getUsers().forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error in Main: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
