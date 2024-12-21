package Pages;

import java.util.*;

import Enums.Language;

class AboutPage extends Page {
  public AboutPage(){
	  
  }
  
  public void display() {
    this.header();
    this.content();
    this.footer();
  }
  
  public void footer() {
      switch (Page.language) {
          case KZ:
              System.out.println("0: Басты бетке кету");
              break;
          case EN:
              System.out.println("0: go to Home page");
              break;
          default: // RU
              System.out.println("0: Вернуться на главную");
              break;
      }
  }

  public void header() {
      switch (Page.language) {
          case KZ:
              System.out.println("Біз туралы бет");
              break;
          case EN:
              System.out.println("About us");
              break;
          default: // RU
              System.out.println("О нас");
              break;
      }
  }

  public void content() {
      switch (Page.language) {
          case KZ:
              System.out.println("Salem!");
              break;
          case EN:
              System.out.println("Hello!");
              break;
          default: // RU
              System.out.println("Privet!");
              break;
      }
  }

	@Override
	public Page inputToPage(int i) {
		switch(i) {
		case 0:
			return new HomePage();
		default:
			return new AboutPage();
		}
	}

}