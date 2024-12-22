package Comparators; 
 
import java.util.Comparator;

import Users.User; 
 
public class UserNamesComparator implements Comparator<User> { 
		@Override 
    	public int compare(User u1, User u2) { 
        int lastNameComparison = u1.getLastName().compareTo(u2.getLastName()); 
        if (lastNameComparison != 0) { 
            return lastNameComparison;  
        } 
        return u1.getFirstName().compareTo(u2.getFirstName()); 
    } 
}