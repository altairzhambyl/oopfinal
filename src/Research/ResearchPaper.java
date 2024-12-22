package Research;

import java.io.Serializable;
import java.util.Date;

public class ResearchPaper implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
    private String authors;
    private Date publicationDate;
    private int citations;

    public ResearchPaper(String title, String authors, Date publicationDate, int citations) {
        if (title == null || authors == null || publicationDate == null) {
            throw new IllegalArgumentException("Invalid research paper details");
        }
        this.title = title;
        this.authors = authors;
        this.publicationDate = publicationDate;
        this.citations = citations;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public int getCitations() {
        return citations;
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", publicationDate=" + publicationDate +
                ", citations=" + citations +
                '}';
    }
}
