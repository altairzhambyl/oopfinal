package Research;

import Users.User;
import java.io.Serializable;
import java.util.*;

public class Research implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String topic;
    private List<User> participants;
    private List<ResearchPaper> papers;
    private Date startDate;

    public Research(String topic, Date startDate) {
        if (topic == null || topic.isEmpty()) {
            throw new IllegalArgumentException("Topic cannot be null or empty");
        }
        this.topic = topic;
        this.startDate = startDate;
        this.participants = new ArrayList<>();
        this.papers = new ArrayList<>();
    }

    // Getters and Setters
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        if (topic == null || topic.isEmpty()) {
            throw new IllegalArgumentException("Topic cannot be null or empty");
        }
        this.topic = topic;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<User> getParticipants() {
        return new ArrayList<>(participants); // Returning a copy for encapsulation
    }

    public List<ResearchPaper> getPapers() {
        return new ArrayList<>(papers); // Returning a copy for encapsulation
    }

    // Methods
    public void addParticipant(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        participants.add(user);
    }

    public void addPaper(ResearchPaper paper) {
        if (paper == null) {
            throw new IllegalArgumentException("Research paper cannot be null");
        }
        papers.add(paper);
    }

    public void printParticipants() {
        System.out.println("Participants in Research: " + topic);
        for (User user : participants) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }

    public void printPapers() {
        System.out.println("Research Papers in Research: " + topic);
        for (ResearchPaper paper : papers) {
            System.out.println(paper.getTitle());
        }
    }
}
