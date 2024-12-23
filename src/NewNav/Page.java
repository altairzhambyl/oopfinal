package NewNav;

import java.util.Scanner;

import Enums.Language;

import java.util.InputMismatchException;

public abstract class Page {
    protected static Scanner scanner = new Scanner(System.in);

    public static Language language = Language.RU;
    public abstract void display();
    public abstract void navigate();
    
    public abstract void start();
    
    protected int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }
    protected String getUserInput() {
        
            return scanner.nextLine();
    }
}