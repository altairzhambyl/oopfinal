package Users ;

import java.io.Serializable;
import java.util.Vector;


public abstract class Employee extends User
{
	
	
	private Vector<Student> studentList;
	

	public Vector<Student> getStudentList() {
		return this.studentList;
	}
	
	
	public void setStudentList(Vector<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	
	public Employee() {
		super();		
	}
	public Employee(String userFirstName,String userLastName, String email) {
		super(userFirstName, userLastName, email);
	}
	public Employee(String userFirstName,String userLastName, String email, Vector<Student> studentList) {
		super(userFirstName, userLastName, email);
		this.studentList = studentList;
	}
	
}

