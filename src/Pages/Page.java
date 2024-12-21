package Pages;

import Enums.Language;

public abstract class Page {
    public abstract void display();
    public abstract Page inputToPage(int i);
    public static Language language = Language.RU;
    public Language getLanguage() {
    	return Page.language;
    }
    public void setLanguage(Language lan) {
    	Page.language = lan;
    }
}