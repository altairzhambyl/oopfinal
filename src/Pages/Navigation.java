package Pages;
import java.util.*;

import Enums.Language;

public final class Navigation {
    private Page currentPage;
    private Page homePage = new HomePage();
    private Page aboutPage = new AboutPage();
    
    public Navigation() {
    	this.currentPage = this.homePage;
    	this.startNavigation();
    }
    public void startNavigation() {
    	Scanner sc = new Scanner(System.in);
    	int i = 0;
    	while (i != -2) {
    		currentPage.display();
    		i = sc.nextInt();
      
	    	if (i == -1) {
	    		this.changeLanugage();
	    		return ;
	    	}
	    	currentPage = currentPage.inputToPage(i);
    	}
    	sc.close();
    }
    
    public void changeLanugage() {
      System.out.println("Choos the language");
      System.out.println("1. Русский");
      System.out.println("2. Қазақша");
      System.out.println("3. English");
      Scanner sc = new Scanner(System.in);
      int i = sc.nextInt();
      if(i == 1) {
        Page.language = Language.RU;
      } else if (i==2) {
        Page.language = Language.KZ;
      } else if (i==3) {
        Page.language = Language.EN;
      } else {
        System.out.println("Error");
      }
      this.startNavigation();
    }
}