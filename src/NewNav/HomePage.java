package NewNav;

public class HomePage extends Page {
    private UserSession session;

    public HomePage() {
        this.session = UserSession.getInstance();
    }

    @Override
    public void display() {
        System.out.println("\n=== Home Page ===");
        System.out.println("Welcome, " + session.getCurrentUser().getUsername() + "!");
        System.out.println("1. Go to Profile");
        System.out.println("2. Go to Settings");
        System.out.println("3. Logout");
        System.out.println("4. Exit");
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();
        
        switch(choice) {
            case 1:
                new ProfilePage().start();
                break;
            case 2:
                new SettingsPage().start();
                break;
            case 3:
                session.logout();
                new AuthPage().start();
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

    @Override
    public void start() {
        while(session.isLoggedIn()) {
            display();
            navigate();
        }
    }
}