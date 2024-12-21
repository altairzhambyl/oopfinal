package Pages;
import java.util.*;

import Enums.Language;

public class HomePage extends Page{
	  public HomePage(){
		  
	  }
	  
	  
	  public void display() {
	    this.header();
	    this.content();
	  }
	  
	  public void header() {
	        switch (Page.language) {
	      default:
	        System.out.println("Главная страница");
	        return;
	      case KZ:
	        System.out.println("Басты бет");
	        break;
	      case EN:
	        System.out.println("Home page");
	        break;
	        }
	  }
	  public void content() {
	        switch (Page.language) {
	      default:
	        System.out.println("-1. Сменить язык");
	        System.out.println("1. О нас");
	        return;
	      case KZ:
	        System.out.println("-1. Басқа тілді таңдау");
	        System.out.println("1. Біз туралы бет");
	        break;
	      case EN:
	        System.out.println("-1. Change language");
	        System.out.println("1. About page");
	        break;
	        }
	  }


	@Override
	public Page inputToPage(int i) {
		switch(i) {
		case 1:
			return new AboutPage();
		case -1:
			return null;
		default:
			return new HomePage();
		}
	}

}