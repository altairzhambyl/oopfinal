package NewNav;

import Enums.Language;

public class SettingsPage extends Page {
    @Override
    public void display() {
        if (Page.language == Language.EN) {
            System.out.println("\n=== Settings Page ===");
            System.out.println("1. Change Language");
            System.out.println("\n-1. Go to Home");
            System.out.println("-2. Exit");
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Страница Настроек ===");
            System.out.println("1. Изменить язык");
            System.out.println("\n-1. Вернуться на главную");
            System.out.println("-2. Выход");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Баптаулар беті ===");
            System.out.println("1. Тілді өзгерту");
            System.out.println("\n-1. Басты бетке оралу");
            System.out.println("-2. Шығу");
        }
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();

        switch(choice) {
            case 1:
                if (Page.language == Language.EN) {
                    System.out.println("Changing language...");
                } else if (Page.language == Language.RU) {
                    System.out.println("Изменение языка...");
                } else if (Page.language == Language.KZ) {
                    System.out.println("Тілді өзгерту...");
                }
                new LanguagePage().start();
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