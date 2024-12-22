package Users ;

import java.util.Vector;

import Enums.Mark;
import Research.DefaultResearcher;
import Research.Research;
import Research.Researcher;

public class PhD extends Student
{
	
	public Teacher superviser;
	
	
	public Vector<Research> researchProjects;
	
	public Researcher researchAuthor;
	
	
	public PhD() {
        setResearcher(new DefaultResearcher()); // PhD students are always researchers
    }
	
	
	
	
	public Mark viewResearchMark() {
		// TODO implement me
		return Mark.A;	
	}
	
	
	
	public Teacher getSuperviser() {
		return this.superviser;
	}
	
	
	
	public void setSuperviser(Teacher superviser) {
		this.superviser = superviser;
	}
	
	
	
	
	public PhD(Teacher superviser, Vector<Research> researchProjects) {
		super();
		this.superviser = superviser;
		this.researchProjects = researchProjects;
	}
	


	

	@Override
	public void sendRequestToManager() {
		// TODO Auto-generated method stub
		
	}}

