package NewNav;

import Enums.Language;

public class HomePage extends Page {
    private UserSession session;

    public HomePage() {
        this.session = UserSession.getInstance();
    }

    @Override
    public void display() {
        if (Page.language == Language.EN) {
            System.out.println("\n=== Home Page ===");
            System.out.println("Welcome, " + session.getCurrentUser().getFirstName() + "!");
            System.out.println("1. Go to Profile");
            System.out.println("2. Go to Settings");
            System.out.println("3. Notifications");
            System.out.println("4. Personal Information");
            System.out.println("-2. Logout");
            System.out.println("-3. Exit");
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Главная страница ===");
            System.out.println("Добро пожаловать, " + session.getCurrentUser().getFirstName() + "!");
            System.out.println("1. Профиль");
            System.out.println("2. Настройки");
            System.out.println("3. Уведомления");
            System.out.println("4. Личная Информация");
            System.out.println("-2. Выйти из аккаунта");
            System.out.println("-3. Выход");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Басты бет ===");
            System.out.println("Қош келдіңіз, " + session.getCurrentUser().getFirstName() + "!");
            System.out.println("1. Профильге өту");
            System.out.println("2. Баптауларға өту");
            System.out.println("3. Хабарландырулар");
            System.out.println("4. Жеке ақпарат");
            System.out.println("-2. Аккаунттан шығу");
            System.out.println("-3. Шығу");
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
            case 3: 
                new NotificationPage().start();
                break;
            case 4: 
                new PersonalInfoPage().start();
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
