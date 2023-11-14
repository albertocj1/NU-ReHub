package Model;

import java.util.HashMap;

public class UserRepository {
    private static UserRepository instance;
    private HashMap<String, User> userMap;

    private UserRepository() {
        userMap = new HashMap<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user) {
        userMap.put(user.getidNumber(), user);
        userMap.put(user.getEmail(), user);
    }

    public User getUserByIdNumber(String idNumber) {
        return userMap.get(idNumber);
    }

    public User getUserByEmail(String email) {
        return userMap.get(email);
    }

    public boolean userExists(String idNumber) {
        return userMap.containsKey(idNumber);
    }

    public boolean userEmailExists(String email) {
        return userMap.containsKey(email);
    }

    public HashMap<String, User> getUserMap() {
        return userMap;
    }
}
