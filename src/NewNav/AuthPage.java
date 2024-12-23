package NewNav;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Database.DB;
import Enums.*;
import Users.*;

public class AuthPage extends Page {
    private Map<String, User> users;
    private UserSession session;

    public AuthPage(){
        users = new HashMap<>();
        session = UserSession.getInstance();
        
        if(new File("data").isFile()) {
        	try {
        	DB.loadFromFile(); }
        	catch (Exception e) {
        		//cry TODO handle exception
        	}
        }
        DB db = DB.getInstance();
        for (User u : db.getUsers()) {
            users.put(u.getEmail(), u);
        }
    }

    @Override
    public void display() {
        if (Page.language == Language.EN) {
            System.out.println("\n=== Authentication Page ===");
            System.out.println("1. Login");
            System.out.println("2. Forgor password *skull emoji*");
            System.out.println("-2. Exit");
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Страница Аутенфикации ===");
            System.out.println("1. Логин");
            System.out.println("2. Забыл пароль *skull emoji*");
            System.out.println("-2. Выход");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Аутенфикация беті ===");
            System.out.println("1. Логин");
            System.out.println("2. Құпия сөзімді ұмытып қалдым *skull emoji*");
            System.out.println("-2. Шығу");
        }
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();
        scanner.nextLine(); // Clear the buffer

        switch(choice) {
            case 1:
                login();
                break;
            case 2:
                changePassword();
                break;
            case -2:
                if (Page.language == Language.EN) {
                    System.out.println("Goodbye!");
                } else if (Page.language == Language.RU) {
                    System.out.println("До свидания!");
                } else if (Page.language == Language.KZ) {
                    System.out.println("Қош болыңыз!");
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
                    System.out.println("Қате таңдау! Қайталап көріңіз.");
                }
                navigate();
        }
    }

    private void login() {
        if (Page.language == Language.EN) {
            System.out.print("Enter email: ");
        } else if (Page.language == Language.RU) {
            System.out.print("Введите email: ");
        } else if (Page.language == Language.KZ) {
            System.out.print("Электрондық поштаны енгізіңіз: ");
        }
        String username = scanner.nextLine();

        if (Page.language == Language.EN) {
            System.out.print("Enter password: ");
        } else if (Page.language == Language.RU) {
            System.out.print("Введите пароль: ");
        } else if (Page.language == Language.KZ) {
            System.out.print("Құпия сөзді енгізіңіз: ");
        }
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null) {
            session.setCurrentUser(user);
            if (user.logIn(password)) {
            	if(user instanceof Teacher) {
            		new TeacherPage().start();
            	} else if (user instanceof Student) {
            		new StudentPage().start();
            	} else if (user instanceof Admin) {
            		new AdminPage().start();
            	} else if (user instanceof Manager) {
            		new ManagerPage().start();
            	} else {
            		new HomePage().start();
            	}          	
            } else {
            	navigate();
            }
        } else {
            if (Page.language == Language.EN) {
                System.out.println("Invalid username or password!");
            } else if (Page.language == Language.RU) {
                System.out.println("Неверное имя пользователя или пароль!");
            } else if (Page.language == Language.KZ) {
                System.out.println("Қате пайдаланушы аты немесе құпия сөз!");
            }
            navigate();
        }
    }

    public void changePassword() {
        if (Page.language == Language.EN) {
            System.out.println("\n===Change Password Page===\n");
            System.out.print("Enter email: ");
        } else if (Page.language == Language.RU) {
            System.out.println("\n===Страница Измены Пароля===\n");
            System.out.print("Введите email: ");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n===Құпия Сөз Өзгерту Беті===\n");
            System.out.print("Электрондық поштаны енгізіңіз: ");
        }
        String username = scanner.nextLine();

        User user = users.get(username);
        if (user != null) {
            if (Page.language == Language.EN) {
                System.out.print("Enter new password: ");
            } else if (Page.language == Language.RU) {
                System.out.print("Введите новый пароль: ");
            } else if (Page.language == Language.KZ) {
                System.out.print("Жаңа құпия сөзді енгізіңіз: ");
            }
            String password = scanner.nextLine();
            user.changePassword(password);
        }
        start();
    }

    public void start() {
            display();
            navigate();
    }
}