package NewNav;

import Enums.Language;
import Users.User;
import Database.DB;

public class PersonalInfoPage extends Page {
    @Override
    public void display() {
        User currentUser = UserSession.getInstance().getCurrentUser();
        if (currentUser == null) {
            System.out.println("No user logged in.");
            return;
        }
        if (Page.language == Language.EN) {
            System.out.println("\n=== About User ===");
            System.out.println("Full Name: " + currentUser.getFirstName() + " " + currentUser.getLastName());
            System.out.println("Login: " + currentUser.getEmail());
            System.out.println("Phone Number: " + currentUser.getPhoneNumber());
            System.out.println("\n-1. Go to Home");
            System.out.println("-2. Exit");
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Личная информация ===");
            System.out.println("ФИО: " + currentUser.getFirstName() + " " + currentUser.getLastName());
            System.out.println("Логин: " + currentUser.getEmail());
            System.out.println("Номер телефона: " + currentUser.getPhoneNumber());
            System.out.println("\n-1. Вернуться на главную");
            System.out.println("-2. Выход");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Қолданушы туралы ===");
            System.out.println("Толық аты: " + currentUser.getFirstName() + " " + currentUser.getLastName());
            System.out.println("Логин: " + currentUser.getEmail());
            System.out.println("Телефон нөмірі: " + currentUser.getPhoneNumber());
            System.out.println("\n-1. Басты бетке оралу");
            System.out.println("-2. Шығу");
        }
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();
        switch (choice) {
            case -1:
                new HomePage().start();
                break;
            case -2:
                System.out.println("Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                navigate();
        }
    }

    public void start() {
        display();
        navigate();
    }
}
