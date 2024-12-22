package NewNav;

import Enums.Language;

public class ManageCoursePage extends Page {
    private UserSession session;

    public ManageCoursePage() {
        this.session = UserSession.getInstance();
    }

    @Override
    public void display() {
        if (Page.language == Language.EN) {
            System.out.println("\n=== Manage Courses===");
            System.out.println("Let's manage courses for, " + session.getCurrentUser().getFirstName() + "!");
            System.out.println("1. Add course");
            System.out.println("2. Remove course");
            System.out.println("3. Change course details");
            System.out.println("4. Go back");
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Управление дисциплинами ===");
            System.out.println("Начните редактировать дисциплины, " + session.getCurrentUser().getFirstName() + "!");
            System.out.println("1. Добавить новую дисциплину");
            System.out.println("2. Удалить дисциплину");
            System.out.println("3. Изменить данные о дисциплине");
            System.out.println("4. Вернуться");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Басты бет ===");
            System.out.println("Қош келдіңіз, " + session.getCurrentUser().getFirstName() + "!");
            System.out.println("1. Профильге өту");
            System.out.println("2. Баптауларға өту");
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