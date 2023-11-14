package Controller;

import java.io.IOException;

import Model.User;
import Model.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RegisterController {

    public static String namepass, emailpass, idpass, passpass;

    @FXML
    Button gobackloginbtn;

    @FXML
    Label warninglabel1, warninglabel2,  warninglabel3, warninglabel4; 

    @FXML
    ImageView nuimage, bgimage, noteimage;
    
    @FXML
    TextField nameTF, idTF, emailTF;

    @FXML
    PasswordField passwordPF;

    @FXML
    LoginController LoginController = null;

    @FXML
    public void setImageFromFilePath(ImageView imageView, String imagePath) {
        try {
            Image image = new Image("file:" + imagePath);

            imageView.setImage(image);
        } catch (IllegalArgumentException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    public void setAllImageViews() {
        setImageFromFilePath(nuimage, "src/Images/nu white logo.png");
        setImageFromFilePath(bgimage, "src/Images/background.jpg");
        setImageFromFilePath(noteimage, "src/Images/info.png");
    }

    public void initialize() {
        setAllImageViews();
    }

    public void register(ActionEvent event) throws IOException {
        String name = nameTF.getText();
        String IdNumber = idTF.getText();
        String email = emailTF.getText();
        String password = passwordPF.getText();

    boolean validationsPassed = true;

        if (!isValidName(name)) {
            warninglabel1.setText("Name should not be empty");
            warninglabel1.setVisible(true);
            validationsPassed = false;
        } else {
            warninglabel1.setVisible(false);
        }
        
        if (!isValidIDNumber(IdNumber)) {
            warninglabel2.setText("Number should contain exactly 10 digits.");
            warninglabel2.setVisible(true);
            validationsPassed = false;
        } else {
            warninglabel2.setVisible(false);
        }
        
        if (!isValidEmail(email)) {
            warninglabel3.setText("Email should end with '@national-u.edu.ph'");
            warninglabel3.setVisible(true);
            validationsPassed = false;
        } else {
            warninglabel3.setVisible(false);
        }
        
        if (!isValidPassword(password)) {
            warninglabel4.setText("Password should contain one number and special character.");
            warninglabel4.setVisible(true);
            validationsPassed = false;
        } else {
            warninglabel4.setVisible(false);
        }

        // Check for duplicate email
        UserRepository userRepository = UserRepository.getInstance();

        if (userRepository.userExists(IdNumber)) {
            warninglabel2.setText("ID number already in use");
            warninglabel2.setVisible(true);
            validationsPassed = false;
        }

        if (userRepository.userEmailExists(email)) {
            warninglabel3.setText("Email already in use");
            warninglabel3.setVisible(true);
            validationsPassed = false;
        }
        

        if (validationsPassed) {

            User newUser = new User(email, IdNumber, name, password);
            userRepository.addUser(newUser);

            System.out.println("User Added:");
            System.out.println("Name: " + newUser.getName());
            System.out.println("ID Number: " + newUser.getidNumber());
            System.out.println("Email: " + newUser.getEmail());

            namepass = name;
            emailpass = email;
            idpass = IdNumber;
            passpass = password;


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
            Parent root = loader.load();
            LoginController = loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
    }

    public boolean isValidName(String name) {
        return !name.trim().isEmpty();
    }

    public boolean isValidIDNumber(String IdNumber) {
        return IdNumber.matches("\\d{10}");
    }

    public boolean isValidEmail(String email) {
        return email.endsWith("@national-u.edu.ph");
    }

    public boolean isValidPassword(String password) {
        return password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*");
    }
}
