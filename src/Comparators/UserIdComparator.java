package Comparators;
import java.util.Comparator;

import Users.User; 
 
public class UserIdComparator implements Comparator<User> { 
 @Override 
    public int compare(User u1, User u2) { 
        return u1.getUserId().compareTo(u2.getUserId()); 
    } 
}