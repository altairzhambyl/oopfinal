package Users ;

import Research.*;

public class Master extends Student
{
	private static final long serialVersionUID = 1L;
	private String internshipCompany;
	
	public Master() {
        setInternshipBehavior(new DefaultInternshipper()); // Masters always apply for internships
        setResearcher(new DefaultResearcher());		// Masters always  Researchers
    }
	
	
	
	
	public String getInternshipCompany() {
		return this.internshipCompany;	
	}
	
	
	public void setInternshipCompany(String internshipCompany) {
		this.internshipCompany = internshipCompany;
	}
	
	
	public Master(String internshipCompany) {
		super();
		this.internshipCompany = internshipCompany;
	}
	
}

