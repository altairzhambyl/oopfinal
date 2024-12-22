package Research;

import java.util.Vector;

public class DefaultResearcher implements Researcher{
	private Researcher author;
    private Vector<Research> researchProjects;

    public DefaultResearcher() {
        this.researchProjects = new Vector<>();
    }

    @Override
    public Researcher getResearchAuthor() {
        return this.author;
    }

    @Override
    public Vector<Research> getResearchProjects() {
        return this.researchProjects;
    }

    @Override
    public void publishResearch() {
        if (researchProjects.isEmpty()) {
            System.out.println("No research projects to publish.");
        } else {
            System.out.println("Publishing research...");
            for (Research project : researchProjects) {
                System.out.println("Publishing: " + project.getTopic());
            }
        }
    }

    @Override
    public void setResearchAuthor(Researcher author) {
        this.author = author;
    }

    public void addResearchProject(Research project) {
        researchProjects.add(project);
    }
	
}
