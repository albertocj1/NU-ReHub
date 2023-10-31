import java.util.Scanner;

public class LogIn {
    class User {
        String username;
        String password;
        User next;
    
        public User(String username, String password) {
            this.username = username;
            this.password = password;
            this.next = null;
        }
    }

    class UserLinkedList {
        User head;

        public void addUser(String username, String password) {
            User newUser = new User(username, password);
            newUser.next = head;
            head = newUser;
        }

        public boolean validateUser(String username, String password) {
            User current = head;
            while (current != null) {
                if (current.username.equals(username) && current.password.equals(password)){
                    return true; // if user exists
                }
                current = current.next;
            }
            return false; // if user does not exist.
        }

        public void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        // Check if username is already taken
        User current = head;
             while (current != null) {
                if (current.username.equals(username)) {
                    System.out.println("Username already exists. Please choose a different username.");
                        return;
                }

                 current = current.next;
             }
    
        }

    }
    
}
