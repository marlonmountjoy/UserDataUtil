import java.io.*;
import java.util.*;

public class DataLoader {

    public static List<User> loadUsers(String filePath) {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");  
                User user = new User(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
