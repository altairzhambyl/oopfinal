package Pages;

import java.util.*;
import Users.*;

import Enums.Language;

public class AuthPage extends Page {
	TestUserBase UserBase;
	public AuthPage(){
		this.UserBase = TestUserBase.getInstance();
	}
  
	public void display() {
		this.header();
    	this.content();
    	this.footer();
	}
  
	public void footer() {
		switch (Page.language) {
          case KZ:
              System.out.println("null");
              break;
          case EN:
              System.out.println("null");
              break;
          default: // RU
              System.out.println("Auth1");
              break;
		}
	}

	public void header() {
		switch (Page.language) {
			case KZ:
				System.out.println("null");
				break;
			case EN:
				System.out.println("null");
				break;
			default: // RU
				System.out.println("Login");
				break;
		}
	}

	public void content() {
		switch (Page.language) {
		case KZ:
			System.out.println("null");
			break;
		case EN:
			System.out.println("null");
			break;
		default: // RU
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your login");
            String log = sc.nextLine();
            if (log==null || log.trim().isEmpty()) {
            	inputToPage(1);
            }
            if(UserBase.checkLogin(log)) {
            	System.out.println("Good");
            	inputToPage(2);
            } else {
            	System.out.println("Bad, try again");
            	inputToPage(1);
            }
            break;
		}
	}

	@Override
	public Page inputToPage(int i) {
		switch(i) {
		case 0:
			return new HomePage();
		case 1:
			return new AuthPage();
		default:
			return new AboutPage();
		}
	}

}