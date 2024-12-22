package NewNav;

import Enums.Language;

public class ProfilePage extends Page {
    @Override
    public void display() {
        if (Page.language == Language.EN) {
            System.out.println("\n=== Profile Page ===");
            System.out.println();
            System.out.println("1. Change password");
            System.out.println("-1. Go to Home");
            System.out.println("-2. Exit");
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Страница Профиля ===");
            System.out.println("1. Изменить пароль");
            System.out.println("-1. Вернуться на главную");
            System.out.println("-2. Выход");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Профиль беті ===");
            System.out.println("1. Құпиясөзді өзгерту");
            System.out.println("-1. Басты бетке оралу");
            System.out.println("-2. Шығу");
        }
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();

        switch(choice) {
            case 1:
                new AuthPage().changePassword();
                break;
            case -1:
                new HomePage().start();
                break;
            case -2:
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
        }
    }

    public void start() {
            display();
            navigate();
        
    }
}
