package Users ;

import java.util.Vector;

import Enums.Speciality;
import Research.*;

public class Bachelor extends Student
{
	
	
	private static final long serialVersionUID = 1L;
	private int creditsEarned;
	
	public void becomeResearcher() {
		setResearcher(new DefaultResearcher());
	}
	
	public void switchSpeciality(Speciality newSpeciality) {
		this.setSpeciality(newSpeciality);
	}
	
	public void enableInternshipApplication() {
        setInternshipBehavior(new DefaultInternshipper()); // Bachelor's can choose to apply
    }
	
	
	public int getCreditsEarned() {
		return this.creditsEarned;	
	}
	

	
	public void setCreditsEarned(int creditsEarned) {
		this.creditsEarned = creditsEarned;
	}
	

	@Override
	public void sendRequestToManager() {
		// TODO Auto-generated method stub
		
	}
	
	public Bachelor(int creditsEarned) {
		super();
		this.creditsEarned = creditsEarned;
	}
	public Bachelor(String userFirstName, String userLastName, String email, int yearOfStudy, int credits) {
		super(userFirstName, userLastName, email, yearOfStudy);
		this.creditsEarned = credits;
	}



}

