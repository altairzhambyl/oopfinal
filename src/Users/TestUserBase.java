package Users;
import java.util.*;

public class TestUserBase {
    private static TestUserBase instance;
    private ArrayList<User> users;

    private TestUserBase() {
        users = new ArrayList<>();
    }

    public static TestUserBase getInstance() {
        if (instance == null) {
            instance = new TestUserBase();
        }
        return instance;
    }

    public boolean checkLogin(String username) {
        for(User u : users) {
        	if(u.getEmail().equals(username)) {
        		return true;
        	}
        }
        this.printUsers();
        return false;
    }
    
    public void addUser(User u) {
    	users.add(u);
    }
    
    public void removeUser(User u) {
    	users.remove(u);
    }
    
    public void printUsers() {
    	for(User u : users) {
    		System.out.println(u.toString());
    	}
    }
    
    public ArrayList<User> getUserBase(){
    	return users;
    }
}
