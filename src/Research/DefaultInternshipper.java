package Research;

public class DefaultInternshipper implements CanApplyForInternship{
	private boolean hasApplied = false;
    private String internshipCompany;

    @Override
    public boolean applyForInternship() {
        if (!hasApplied) {
            System.out.println("Applying for internship...");
            hasApplied = true;
            internshipCompany = "TechCorp Inc."; // Example company
            return true;
        } else {
            System.out.println("Already applied for an internship.");
            return false;
        }
    }

    @Override
    public String getInternshipCompany() {
        return internshipCompany != null ? internshipCompany : "No internship company assigned yet.";
    }
}	
