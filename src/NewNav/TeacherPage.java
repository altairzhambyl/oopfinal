package NewNav;

public class TeacherPage extends Page {
    @Override
    public void display() {
        System.out.println("\n=== Teacher Page ===");
        System.out.println("1. View Courses");
        System.out.println("2. Manage Courses");
        System.out.println("3. View Students info");
        System.out.println("4. Put Marks");
        System.out.println("5. Send Message");
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();
        
        switch(choice) {
            case 1:
                System.out.println("Viewing courses...");
                break;
            case 2:
                System.out.println("Managing courses...");
                break;
            case 3:
                new HomePage().start();
                break;
            case 4:
                System.out.println("Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                navigate();
        }
    }

    public void start() {
        while(true) {
            display();
            navigate();
        }
    }
}