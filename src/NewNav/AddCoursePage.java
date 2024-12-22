package NewNav;

import Enums.Language;

public class AddCoursePage extends Page {
    private UserSession session;

    public AddCoursePage() {
        this.session = UserSession.getInstance();
    }

    @Override
    public void display() {
        if (Page.language == Language.EN) {
            System.out.println("\n=== Add Course Page ===");
            System.out.println("Write the data in the following order:");
            System.out.println("1. Course code");
            System.out.println("2. Course name");
            System.out.println("3. Course description");
            System.out.println("4. Credits in ECTS");
            System.out.println("5. Credits in KZ");
            System.out.println("6. Course year");
            System.out.println("7. Course type: 1.Major, 2.Minor, 3.Elective");
            
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Add Course Page ===");
            System.out.println("Write the data in the following order:");
            System.out.println("1. Course code");
            System.out.println("2. Course name");
            System.out.println("3. Course description");
            System.out.println("4. Credits in ECTS");
            System.out.println("5. Credits in KZ");
            System.out.println("6. Course year");
            System.out.println("7. Course type: 1.Major, 2.Minor, 3.Elective");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Add Course Page ===");
            System.out.println("Write the data in the following order:");
            System.out.println("1. Course code");
            System.out.println("2. Course name");
            System.out.println("3. Course description");
            System.out.println("4. Credits in ECTS");
            System.out.println("5. Credits in KZ");
            System.out.println("6. Course year");
            System.out.println("7. Course type: 1.Major, 2.Minor, 3.Elective");
        }
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
            case -2:
                session.logout();
                new AuthPage().start();
                break;
            case -3:
                if (Page.language == Language.EN) {
                    System.out.println("Goodbye!");
                } else if (Page.language == Language.RU) {
                    System.out.println("До свидания!");
                } else if (Page.language == Language.KZ) {
                    System.out.println("Сау болыңыз!");
                }
                scanner.close();
                System.exit(0);
                break;
            default:
                if (Page.language == Language.EN) {
                    System.out.println("Invalid choice! Please try again.");
                } else if (Page.language == Language.RU) {
                    System.out.println("Неверный выбор! Пожалуйста, попробуйте снова.");
                } else if (Page.language == Language.KZ) {
                    System.out.println("Қате таңдау! Қайтадан көріңізші.");
                }
                navigate();
        }
    }

    @Override
    public void start() {
            display();
            navigate();
        
    }
}