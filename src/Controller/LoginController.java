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
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController {

    @FXML
    Button loginbtn, registerbtn;

    @FXML
    Label warninglabel;

    @FXML
    TextField emailTF;

    @FXML
    PasswordField passwordPF;

    @FXML
    RegisterController RegisterController = null;

    @FXML
    U_HomeController U_HomeController = null;

    @FXML
    A_HomeController A_HomeController = null;

    private static String loggedInUserEmail;  

    public static String getLoggedInUserEmail() {
        return loggedInUserEmail;
    }


    public void Register(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Register.fxml"));
        Parent root = loader.load();
        RegisterController = loader.getController();

        Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }

    public void Login(ActionEvent event) throws IOException {


        String input = emailTF.getText(); 
        String password = passwordPF.getText();

        UserRepository userRepository = UserRepository.getInstance();

        User user = null;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Admin login
        if ("admin@national-u.edu.ph".equals(input) && "admin123!".equals(password)) {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/A_Home - Copy.fxml"));
            Parent root = loader.load();
            A_HomeController = loader.getController();

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/View/CSS/home_hover.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("/View/CSS/home_hover2.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("/View/CSS/home_hover3.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
        }

        else {
            if (input.contains("@")) {
                user = userRepository.getUserByEmail(input);
            } else {
                user = userRepository.getUserByIdNumber(input);
            }
            
            if (user != null && user.getPassword().equals(password)) {
                loggedInUserEmail = user.getEmail();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Home.fxml"));
                Parent root = loader.load();
                U_HomeController = loader.getController();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            } else {
                warninglabel.setText("Invalid credentials.");
                warninglabel.setVisible(true);
                return;
            }
        }  
    }
}