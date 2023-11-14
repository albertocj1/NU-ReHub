package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;


import Model.ResearchStorage;
import Model.User;
import Model.Node;
import Model.UserRepository;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class U_FavoritesController {


    
    @FXML
    Text title1, title2, title3, title4, title5, title6, title7, title8;

    @FXML
    Text author1, author2, author3, author4, author5, author6, author7, author8;

    @FXML
    Text date1, date2, date3, date4, date5, date6, date7, date8;

    @FXML
    Text genre1, genre2, genre3, genre4, genre5, genre6, genre7, genre8;

    @FXML
    ImageView pic1, pic2, pic3, pic4, pic5, pic6, pic7, pic8;

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8;

    @FXML
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @FXML
        ImageView  nuimage, logoutimage, profileimage, homeimage, discoverimage, exploreimage, favoriteimage, historyimage, bookmarkimage, tagimage, 
        rImage1, rImage2, rImage3, dataImage1, dataImage2, dataImage3, tag, bookmark, imageRead;
    
        static UserRepository userRepo = UserRepository.getInstance();

        static String userEmail = LoginController.getLoggedInUserEmail();
        static User user = userRepo.getUserByEmail(userEmail);
        static String[] listDoi = ResearchStorage.giveKeys();
        static LinkedList<String> favorites = user.getFavorites();
        
        static String[] array = favorites.toArray(new String[0]);
        
    
    
         public void initialize() {
           loadData(array);
        
            }
        
    
        public void loadData(String[] setData) {
            
            try {
                pane1.setVisible(true);
                Node currentNode = ResearchStorage.getNode(setData[0]);
                changePicFade(pic1, false);
                fadeText(title1, currentNode.getResearchTitle());
                fadeText(author1, currentNode.getResearchAuthor());
                fadeText(genre1, currentNode.getResearchGenresString());
                fadeText(date1, currentNode.getYearPublished());
            } catch (Exception e) {
                pane1.setVisible(false);
                title1.setText(" ");
                author1.setText(" ");
                genre1.setText(" ");
                date1.setText("");
            }
    
            try {
                pane2.setVisible(true);
                Node currentNode2 = ResearchStorage.getNode(setData[1]);
                changePicFade(pic2, false);
                fadeText(title2, currentNode2.getResearchTitle());
                fadeText(author2, currentNode2.getResearchAuthor());
                fadeText(genre2, currentNode2.getResearchGenresString());
                fadeText(date2, currentNode2.getYearPublished());
    
            } catch (Exception e) {
                pane2.setVisible(false);
                title2.setText(" ");
                author2.setText(" ");
                genre2.setText(" ");
                date2.setText(" ");
            }
    
            try {
                pane3.setVisible(true);
                Node currentNode3 = ResearchStorage.getNode(setData[2]);
                changePicFade(pic3, false);
                fadeText(title3, currentNode3.getResearchTitle());
                fadeText(author3, currentNode3.getResearchAuthor());
                fadeText(genre3, currentNode3.getResearchGenresString());
                fadeText(date3, currentNode3.getYearPublished());
        
            } catch (Exception e) {
                pane3.setVisible(false);
                title3.setText("");
                author3.setText(" ");
                genre3.setText(" ");
                date3.setText(" ");
             
            }
    
            try {
                pane4.setVisible(true);
                Node currentNode4 = ResearchStorage.getNode(setData[3]);
                changePicFade(pic4, false);
                fadeText(title4, currentNode4.getResearchTitle());
                fadeText(author4, currentNode4.getResearchAuthor());
                fadeText(genre4, currentNode4.getResearchGenresString());
                fadeText(date4, currentNode4.getYearPublished());
               
            } catch (Exception e) {
                pane4.setVisible(false);
                title4.setText(" ");
                author4.setText(" ");
                genre4.setText(" ");
                date4.setText(" ");

            }
    
            try {
                pane5.setVisible(true);
                Node currentNode5 = ResearchStorage.getNode(setData[4]);
                changePicFade(pic5, false);
                fadeText(title5, currentNode5.getResearchTitle());
                fadeText(author5, currentNode5.getResearchAuthor());
                fadeText(genre5, currentNode5.getResearchGenresString());
                fadeText(date5, currentNode5.getYearPublished());
                
            } catch (Exception e) {
                pane5.setVisible(false);
                title5.setText(" ");
                author5.setText(" ");
                genre5.setText(" ");
                date5.setText(" ");
            }
    
            try {
                pane6.setVisible(true);
                Node currentNode6 = ResearchStorage.getNode(setData[5]);
                changePicFade(pic6, false);
                fadeText(title6, currentNode6.getResearchTitle());
                fadeText(author6, currentNode6.getResearchAuthor());
                fadeText(genre6, currentNode6.getResearchGenresString());
                fadeText(date6, currentNode6.getYearPublished());
            } catch (Exception e) {
                pane6.setVisible(false);
                title6.setText(" ");
                author6.setText(" ");
                genre6.setText(" ");
                date6.setText(" ");
            }
    
            try {
                pane7.setVisible(true);
                Node currentNode7 = ResearchStorage.getNode(setData[6]);
                changePicFade(pic7, false);
                fadeText(title7, currentNode7.getResearchTitle());
                fadeText(author7, currentNode7.getResearchAuthor());
                fadeText(genre7, currentNode7.getResearchGenresString());
                fadeText(date7, currentNode7.getYearPublished());

            } catch (Exception e) {
                pane7.setVisible(false);
                title7.setText(" ");
                author7.setText(" ");
                genre7.setText(" ");
                date7.setText(" ");
            }
    
            try {
                pane8.setVisible(true);
                Node currentNode8 = ResearchStorage.getNode(setData[7]);
                changePicFade(pic8, false);
                fadeText(title8, currentNode8.getResearchTitle());
                fadeText(author8, currentNode8.getResearchAuthor());
                fadeText(genre8, currentNode8.getResearchGenresString());
                fadeText(date8, currentNode8.getYearPublished());
                
            } catch (Exception e) {
                pane8.setVisible(false);
                title8.setText(" ");
                author8.setText(" ");
                genre8.setText(" ");
                date8.setText(" ");
        
            }
        }
        private void changePicFade(ImageView given, Boolean isNull) {
            if (isNull) {
                given.setImage(null);
            } else {
                ImageView newImage = new ImageView("/Images/ML,Intern,2020.png");
                fadeImageView(given, newImage);
            }
        }
        private void fadeImageView(ImageView imageView, ImageView newImage) {
            if (newImage.getImage() == null) {
                imageView.setImage(null);
                return; // If new image is null, don't perform fade transitions
            }
        
            FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(500), imageView);
            fadeOutTransition.setFromValue(1.0);
            fadeOutTransition.setToValue(0.0);
            
            fadeOutTransition.setOnFinished(event -> {
                imageView.setImage(newImage.getImage());
                FadeTransition fadeInTransition = new FadeTransition(Duration.millis(500), imageView);
                fadeInTransition.setFromValue(0.0);
                fadeInTransition.setToValue(1.0);
                fadeInTransition.play();
            });
        
            fadeOutTransition.play();
        }
        private void fadeText(Text textNode, String newText) {
            FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(500), textNode);
            fadeOutTransition.setFromValue(1.0);
            fadeOutTransition.setToValue(0.0);
            
            fadeOutTransition.setOnFinished(event -> {
                textNode.setText(newText);
                FadeTransition fadeInTransition = new FadeTransition(Duration.millis(500), textNode);
                fadeInTransition.setFromValue(0.0);
                fadeInTransition.setToValue(1.0);
                fadeInTransition.play();
            });
        
            fadeOutTransition.play();
        }
       

        @FXML
        public void read(ActionEvent event) throws IOException {
           

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void gotoHome(ActionEvent event) throws IOException {
            
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Home.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
             
        }

        @FXML
        public void explore(ActionEvent event) throws IOException {
         

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Explore.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void gotoDiscover(ActionEvent event) throws IOException {
            

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Discover.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

        }
         @FXML
        public void gotoProfile(ActionEvent event) throws IOException {
            
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Profile.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void about(ActionEvent event) throws IOException {
          

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_About.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        public void contact(ActionEvent event) throws IOException {
        

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Contact.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        public void gotoHistory(ActionEvent event) throws IOException {
        

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_History.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        public void Logout(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

    }