package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class U_Contact {

    @FXML
    ImageView  nuimage, logoutimage, profileimage, homeimage, discoverimage, exploreimage, favoriteimage, historyimage, renzimage, ellaimage, rodneyimage, danyssaimage, cjimage, markimage;
    
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
            setImageFromFilePath(homeimage, "src/Images/home(1).png");
            setImageFromFilePath(discoverimage, "src/Images/hand.png");
            setImageFromFilePath(exploreimage, "src/Images/folder (1).png");
            setImageFromFilePath(favoriteimage, "src/Images/saved.png");
            setImageFromFilePath(historyimage, "src/Images/history.png");
            setImageFromFilePath(renzimage, "src/Images/3renz.png");
            setImageFromFilePath(ellaimage, "src/Images/4cailing.png");
            setImageFromFilePath(rodneyimage, "src/Images/1rodney.png");
            setImageFromFilePath(danyssaimage, "src/Images/2danyssa.png");
            setImageFromFilePath(markimage, "src/Images/5mark.png");
            setImageFromFilePath(cjimage, "src/Images/6cj.png");
        }
    
        public void initialize (){
            setAllImageViews();
        }

        @FXML
        public void home(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Home.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void discover(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Discover.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void explore(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Explore.fxml"));
            Parent root = loader.load();
    
            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void favorite(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Favorites.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void history(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_History.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void profile(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Profile.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
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
        public void about(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_About.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
}
