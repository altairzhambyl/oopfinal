package NewNav;

import Enums.Language;

public class LanguagePage extends Page{
	@Override
    public void display() {
        if (Page.language == Language.EN) {
            System.out.println("\n=== Language Page ===");
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Страница Языков ===");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Тілдер беті ===");
        }
            
        System.out.println("1. English");
        System.out.println("3. Руский");
        System.out.println("3. Қазақ тілі");
        System.out.println("\n-1.Return home");
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();
        
        switch(choice) {
            case 1:
                System.out.println("Language changed");
                Page.language = Language.EN;
                break;
            case 2:
                System.out.println("Язык изменён");
                Page.language = Language.RU;
                break;
            case 3:
                System.out.println("Тілі ауыстырылды");
                Page.language = Language.KZ;
                break;
            case -1:
                new HomePage().start();
                break;
            case -2:
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
