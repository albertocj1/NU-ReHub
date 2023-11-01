import java.util.HashMap;
import java.util.Scanner;

public class Register {
    public HashMap <String, String> users;

    public Register(){
        users = new HashMap<>();
    }

    public void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
    
        if (!users.containsKey(username)) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
    
            users.put(username, password);
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Username already exists. Please choose another username.");
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
        registrationSystem.registerUser(scanner);

        boolean loggedIn = false;


    while(!loggedIn){
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (registrationSystem.validateUser(username, password)) {
            System.out.println("Login successful!");
            loggedIn = true;
        } else {
            System.out.println("Invalid credentials!");

        }
    }

        scanner.close();
    }

    public static void main(String[] args) {
        RegistrationSystem();
    }
}
