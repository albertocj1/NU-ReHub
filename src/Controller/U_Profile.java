package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class U_Profile {
    
    @FXML
    Label nameLabel, emailLabel, idLabel, passLabel;

    @FXML
    ImageView nuimage, logoutimage, profileimage, studentimage;

    public void initialize(){
        String name = RegisterController.namepass;
        String email = RegisterController.emailpass;
        String idnum = RegisterController.idpass;
        String password = RegisterController.passpass;

        nameLabel.setText(name);
        emailLabel.setText(email);
        idLabel.setText(idnum);
        passLabel.setText(password);

        setAllImageViews();    
    }

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
            setImageFromFilePath(nuimage, "src/Images/nu_logo.png");
            setImageFromFilePath(logoutimage, "src/Images/logout.png");
            setImageFromFilePath(profileimage, "src/Images/user.png");
            setImageFromFilePath(studentimage, "src/Images/user(2).png");
        }

    @FXML
        public void logout(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

    @FXML
        public void home(ActionEvent event) throws IOException {
    
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Home.fxml"));
            Parent root = loader.load();
    
            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
}
