package NewNav;

public class SettingsPage extends Page {
    @Override
    public void display() {
        System.out.println("\n=== Settings Page ===");
        System.out.println("1. Change Theme");
        System.out.println("2. Change Language");
        System.out.println("3. Go to Home");
        System.out.println("4. Exit");
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();
        
        switch(choice) {
            case 1:
                System.out.println("Changing theme...");
                break;
            case 2:
                System.out.println("Changing language...");
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