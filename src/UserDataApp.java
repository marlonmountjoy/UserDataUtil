import java.util.*;

public class UserDataApp {

    public static void main(String[] args) {
        
        List<User> users = DataLoader.loadUsers("cleaned_users.csv"); 
        
        Scanner scanner = new Scanner(System.in);

        
        int searchPattern = 1; 

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Sort by Username");
            System.out.println("2. Search by Username");
            System.out.println("3. Sort by Email");
            System.out.println("4. Search by Email");
            System.out.println("5. Sort by Last Name");
            System.out.println("6. Search by Last Name");
            System.out.println("7. Check Name in Password");
            System.out.println("8. Choose Search Pattern");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
          
            String userInput = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(userInput);  
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;  
            }

            switch (choice) {
                case 1:
                    long startTime = System.nanoTime(); 
                    List<User> sortedUsers = UserUtils.sortByUsername(users);
                    long endTime = System.nanoTime();  
                    sortedUsers.forEach(System.out::println);
                    System.out.println("Time taken to sort by username: " + (endTime - startTime) + " nanoseconds");
                    break;
                case 2:
                    System.out.print("Enter username to search: ");
                    String usernameQuery = scanner.nextLine();
                    startTime = System.nanoTime();  
                    List<User> foundUsersByUsername = performSearch(users, usernameQuery, searchPattern);
                    endTime = System.nanoTime();  
                    if (foundUsersByUsername.isEmpty()) {
                        System.out.println("No users found with that username.");
                    } else {
                        foundUsersByUsername.forEach(System.out::println);
                    }
                    System.out.println("Time taken to search by username: " + (endTime - startTime) + " nanoseconds");
                    break;
                case 3:
                    System.out.print("Sort email in ascending order? (true/false): ");
                    boolean emailAscending = scanner.nextBoolean();
                    scanner.nextLine();
                    startTime = System.nanoTime();  
                    List<User> sortedByEmailUsers = UserUtils.sortByEmail(users, emailAscending);
                    endTime = System.nanoTime();  
                    sortedByEmailUsers.forEach(System.out::println);
                    System.out.println("Time taken to sort by email: " + (endTime - startTime) + " nanoseconds");
                    break;
                case 4:
                    System.out.print("Enter email to search: ");
                    String emailQuery = scanner.nextLine();
                    startTime = System.nanoTime();  
                    List<User> foundUsersByEmail = performSearch(users, emailQuery, searchPattern);
                    endTime = System.nanoTime();  
                    foundUsersByEmail.forEach(System.out::println);
                    System.out.println("Time taken to search by email: " + (endTime - startTime) + " nanoseconds");
                    break;
                case 5:
                    System.out.print("Sort last name in ascending order? (true/false): ");
                    boolean ascending = scanner.nextBoolean();
                    scanner.nextLine();  
                    startTime = System.nanoTime();  
                    List<User> sortedByLastNameUsers = UserUtils.sortByLastName(users, ascending);
                    endTime = System.nanoTime(); 
                    sortedByLastNameUsers.forEach(System.out::println);
                    System.out.println("Time taken to sort by last name: " + (endTime - startTime) + " nanoseconds");
                    break;
                case 6:
                    System.out.println("Checking if names appear in passwords...");
                    startTime = System.nanoTime(); 
                    List<User> usersWithNameInPassword = UserUtils.checkNameInPassword(users);  
                    endTime = System.nanoTime();  
                    if (usersWithNameInPassword.isEmpty()) {
                        System.out.println("No users found with their name in the password.");
                    } else {
                        System.out.println("Users with their name in the password:");
                        usersWithNameInPassword.forEach(System.out::println);
                    }
                    System.out.println("Time taken to check names in passwords: " + (endTime - startTime) + " nanoseconds");
                    break;
                case 8:
                    System.out.println("\nChoose Search Pattern:");
                    System.out.println("1. Linear Search");
                    System.out.println("2. Binary Search");
                    System.out.print("Enter your choice: ");
                    searchPattern = scanner.nextInt();
                    scanner.nextLine(); 
                    if (searchPattern != 1 && searchPattern != 2) {
                        System.out.println("Invalid choice. Defaulting to Linear Search.");
                        searchPattern = 1;
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static List<User> performSearch(List<User> users, String query, int searchPattern) {
        List<User> result = new ArrayList<>();
        if (searchPattern == 1) {
            result = UserUtils.searchByUsernameLinear(users, query);
        } else if (searchPattern == 2) {
            result = UserUtils.searchByUsernameBinary(users, query);
        }
        return result;
    }
}
