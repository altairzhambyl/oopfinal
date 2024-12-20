package OfficeRegistrar;
import java.util.*;

public class CourseBase {
	private static ArrayList<Course> courses = new ArrayList<>();
	
    public static void addCourse(Course course) {
        courses.add(course);
    }

    public static ArrayList<Course> getCourses() {
        return courses;	
    }   
}