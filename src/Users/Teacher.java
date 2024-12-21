package Users ;

import java.io.Serializable;
import java.util.Set;
import java.util.Vector;

import Courses.Course;
import Enums.Urgency;

public class Teacher extends Employee implements Serializable
{
	public Vector<Course> courses;
	

	
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	public void sendComplaint(String complaint, Urgency urgency) {
		// TODO implement me	
	}
	
	
	public Set<Student> viewStudents() {
		// TODO implement me
		return null;	
	}
	
	
	
	public void giveHomework() {
		// TODO implement me	
	}
	
	
	
	public Vector<Course> getCourses() {
		return this.courses;	
	}

	
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	
	
	
	public Teacher(Vector<Course> courses) {
		super();
		setCourses(courses);
	}
	public Teacher() {
		super();
	}
	public Teacher(String first, String last, String email) {
		super(first, last, email);
	}
	
}
