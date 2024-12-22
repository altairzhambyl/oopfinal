package Research;

import java.util.Vector;

public  interface Researcher 
{
    
	
	public Researcher getResearchAuthor() ;
	
	
	public Vector<Research> getResearchProjects() ;
	
	
	public void publishResearch() ;
	
	
	public void setResearchAuthor(Researcher author) ;
	
	
}

