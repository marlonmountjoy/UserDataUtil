import java.util.*;

public class UserUtils {

    public static List<User> sortByUsername(List<User> users) {
        users.sort(Comparator.comparing(User::getUsername));  
        return users;
    }

   
    public static List<User> sortByLastName(List<User> users, boolean ascending) {
        if (ascending) {
            users.sort(Comparator.comparing(User::getLastName));  
        } else {
            users.sort(Comparator.comparing(User::getLastName).reversed());  
        }
        return users;
    }

   
    public static List<User> sortByEmail(List<User> users, boolean ascending) {
        if (ascending) {
            users.sort(Comparator.comparing(User::getEmail));  
        } else {
            users.sort(Comparator.comparing(User::getEmail).reversed());  
        }
        return users;
    }

   
    public static List<User> searchByUsernameLinear(List<User> users, String query) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getUsername().contains(query)) {
                result.add(user);
            }
        }
        return result;
    }

    
    public static List<User> searchByUsernameBinary(List<User> users, String query) {
        
        Collections.sort(users, Comparator.comparing(User::getUsername));  

        int left = 0, right = users.size() - 1;
        List<User> result = new ArrayList<>();

        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            User midUser = users.get(mid);

            if (midUser.getUsername().equals(query)) {
                result.add(midUser); 
                break;
            } else if (midUser.getUsername().compareTo(query) < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return result;
    }

    
    public static List<User> checkNameInPassword(List<User> users) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getPassword().toLowerCase().contains(user.getFirstName().toLowerCase()) || 
                user.getPassword().toLowerCase().contains(user.getLastName().toLowerCase())) {
                result.add(user);
            }
        }
        return result;
    }
}
