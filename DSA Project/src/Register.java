import java.util.HashMap;
import java.util.Scanner;

public class Register {
    public HashMap <String, String> users;

    public Register(){
        users = new HashMap<>();
    }

    public void registerUser(Scanner scanner) {
        String username = "";
        String password = "";
    
        while (username.isEmpty() || password.isEmpty()) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
    
            if (username.isEmpty()) {
                System.out.println("Username cannot be empty. Please try again.");
            } else if (users.containsKey(username)) {
                System.out.println("Username already exists. Please choose another username.");
                return;
            } else {
                System.out.print("Enter password: ");
                password = scanner.nextLine();
    
                if (password.isEmpty()) {
                    System.out.println("Password cannot be empty. Please try again.");
                } else if (password.length() < 6) {
                    System.out.println("Password must be at least 6 characters long. Please try again.");
                }
            }
        }
    
        users.put(username, password);
        System.out.println("User registered successfully!");
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered yet.");
        } else {
            System.out.println("Registered Users:");
            for (String username : users.keySet()) {
                String password = users.get(username);
                System.out.println("Username: " + username + ", Password: " + password);
            }
        }
    }

    public boolean validateUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true; 
        }
        return false; 
    }
    
    public static void RegistrationSystem() {
        Register registrationSystem = new Register();
        Scanner scanner = new Scanner(System.in);

        

        boolean loggedIn = false;


        while (!loggedIn) {
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registrationSystem.registerUser(scanner);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    if (registrationSystem.validateUser(email, password)) {
                        System.out.println("Login successful!");
                        loggedIn = true;
                        registrationSystem.showUsers();
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        RegistrationSystem();
    }
}
