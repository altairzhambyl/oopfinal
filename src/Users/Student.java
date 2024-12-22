package Users ;

import java.time.LocalDate;

import Database.DB;
import Enums.School;
import Enums.Speciality;
import Research.*;

public class Student extends User {	

	
	
	private final int yearOfStudy;
	
	private School school;
	
	private Speciality speciality;
	
	private float gpa;
	
	private Researcher researcher;

	private CanApplyForInternship internshipBehavior;

    public void setInternshipBehavior(CanApplyForInternship internshipBehavior) {
        this.internshipBehavior = internshipBehavior;
    }

    public void applyForInternship() {
    	//check if student is 4th course and can apply to internship
        if (internshipBehavior != null && LocalDate.now().getYear()-yearOfStudy > 3) {
            internshipBehavior.applyForInternship();
        } else {
            System.out.println("This student is not applying for internships.");
        }
    }

    public void showInternshipCompany() {
        if (internshipBehavior != null) {
            System.out.println("Internship company: " + internshipBehavior.getInternshipCompany());
        } else {
            System.out.println("No internship behavior assigned.");
        }
    }	
	
    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public void performResearch() {
        if (researcher != null) {
            researcher.publishResearch();
        } else {
            System.out.println("This student is not conducting research.");
        }
    }
    
	public void viewSchedule() {
		// TODO implement me	
	}
	
	
	public void sendRequestToManager() {
		// TODO implement me
	}
	
	
	
	public void getExpelled() {
		User.userCount--;
		try {
		DB.loadFromFile();
		} catch (Exception e) {
			System.out.print("Couldn't expel this student sry");
		}
		DB db = DB.getInstance();
		db.removeUser(this);
	}
	
	/*
	public attendance viewAttendance() {
		// TODO implement this shit later
		return null;	
	} 
	*/
	
	
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
	
	
	
	
	public School getSchool() {
		return this.school;	
	}
	
	
	
	public void setSchool(School school) {
		this.school = school;
	}
	
	public void setGPA(float gpa) {
		this.gpa = gpa;
	}
	public float getGPA() {
		return this.gpa;
	}
	
	public Speciality getSpeciality() {
		return this.speciality;	
	}
	
	
	
	public void setSpeciality(Speciality spec) {
		this.speciality = spec;
	}
	
	
	
	public Student(Integer yearOfStudy, School school, Speciality speciality) {
		super();
		this.yearOfStudy = yearOfStudy;
		this.school = school;
		this.speciality = speciality;
	}
	public Student(String userFirstName, String userLastName, String email, int yearOfStudy) {
		super(userFirstName, userLastName, email);
		this.yearOfStudy = yearOfStudy;
	}
	public Student() {
		super();
		this.yearOfStudy = LocalDate.now().getYear();
	}
	public Student(	String userFirstName, String userLastName, String email) {
		super(userFirstName,userLastName, email);
		this.yearOfStudy = 2024;
	}
	
}
