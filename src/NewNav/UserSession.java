package NewNav;

import Users.*;

public class UserSession {
    private static User currentUser;
    private static UserSession instance;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public void logout() {
        currentUser = null;
    }
    
    public String userType() {
    	if(currentUser instanceof Teacher) {
    		return "Teacher";
    	} else if (currentUser instanceof Student) {
    		return "Student";
    	} else if (currentUser instanceof Admin) {
    		return "Admin";
    	} else if (currentUser instanceof Manager) {
    		return "Manager";
    	} else {
    		return "Guest";
    	}
    }
}