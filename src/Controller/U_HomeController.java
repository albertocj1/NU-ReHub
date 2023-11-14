    package Controller;

    import java.io.IOException;
    import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

    import Model.DataSample;
import Model.HistoryStack;
import Model.User;
import Model.UserRepository;
import javafx.animation.FadeTransition;
    import javafx.animation.TranslateTransition;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.Pane;
    import javafx.scene.shape.Rectangle;
    import javafx.stage.Stage;
    import javafx.util.Duration;

    public class U_HomeController {

        @FXML
        Button discover, explore, favorite, history, profile, logout, search, explore1, about, contact, read1, read2, read3, read4, read5, read6, dsbtn, mlbtn, cyberbtn, webbtn, gamebtn, ekis, favbtn;

        @FXML
        ImageView  nuimage, logoutimage, profileimage, homeimage, discoverimage, exploreimage, favoriteimage, historyimage, bookmarkimage, tagimage, 
        rImage1, rImage2, rImage3, dataImage1, dataImage2, dataImage3, tag, bookmark, imageRead;

        @FXML
        Label rTitle1, rAuthor1, rYear1, rType1, rDoi1;

        @FXML
        Label rTitle2, rAuthor2, rYear2, rType2, rDoi2; 

        @FXML
        Label rTitle3, rAuthor3, rYear3, rType3, rDoi3;

        @FXML
        Label dataTitle1, dataAuthor1, dataYear1, dataType1, dataDoi1;

        @FXML
        Label dataTitle2, dataAuthor2, dataYear2, dataType2, dataDoi2;

        @FXML
        Label dataTitle3, dataAuthor3, dataYear3, dataType3, dataDoi3;

        @FXML
        Label titleRead, authorRead, yearRead, doiRead;
        @FXML
        Rectangle rectangle;

        @FXML
        Pane paneRead;

        String userEmail = LoginController.getLoggedInUserEmail();
    
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
            setImageFromFilePath(homeimage, "src/Images/home (1).png");
            setImageFromFilePath(discoverimage, "src/Images/hand.png");
            setImageFromFilePath(exploreimage, "src/Images/folder (1).png");
            setImageFromFilePath(favoriteimage, "src/Images/saved.png");
            setImageFromFilePath(historyimage, "src/Images/history.png");
            setImageFromFilePath(bookmarkimage, "src/Images/saved(1).png");
            setImageFromFilePath(tagimage, "src/Images/tag (1).png");
        }

        public void initialize() {
            
            setAllImageViews(); 
            setLabelData();
            setLabelDataByGenre("Data Science");
        }

        // Filter data by desired genre - Data Science
        @FXML
        public void dsbtnClicked(ActionEvent event) {
            String desiredGenre = "Data Science";
            rectangle.setVisible(false);
            setLabelDataByGenre(desiredGenre);
        }

        @FXML
        public void mlbtnClicked(ActionEvent event) {
            String desiredGenre = "Machine Learning";
            rectangle.setVisible(false);
            setLabelDataByGenre(desiredGenre);
        }

        @FXML
        public void cyberbtnClicked(ActionEvent event) {
            String desiredGenre = "Cybersecurity";
            rectangle.setVisible(false);
            setLabelDataByGenre(desiredGenre);
        }

        @FXML
        public void webbtnClicked(ActionEvent event) {
            String desiredGenre = "Web Development";

            rectangle.setVisible(true);
            setLabelDataByGenre(desiredGenre);
            
        }

        @FXML
        public void gamebtnClicked(ActionEvent event) {
            String desiredGenre = "Game Development";
            rectangle.setVisible(false);
            setLabelDataByGenre(desiredGenre);
        }

        public void setLabelDataByGenre(String desiredGenre) {
            DataSample dataSample = new DataSample(); // Create an instance of DataSample
            Object[][] data = dataSample.getDataSample();
        
            // Filter data by the desired genre
            List<Object[]> filteredData = filterDataByGenre(desiredGenre, data);
        
            clearLabelsAndImages();
        
            // Check if there is filtered data available
            if (!filteredData.isEmpty()) {
                // Assuming you want to display the first three filtered entries
                for (int i = 0; i < Math.min(3, filteredData.size()); i++) {
                    Object[] entry = filteredData.get(i);
        
                    Label titleLabel = null;
                    Label authorLabel = null;
                    Label yearLabel = null;
                    Label typeLabel = null;
                    Label doiLabel = null; // Add a label for DOI
                    ImageView image = null;
        
                    // Assign labels and image based on the index i
                    if (i == 0) {
                        titleLabel = dataTitle1;
                        authorLabel = dataAuthor1;
                        yearLabel = dataYear1;
                        typeLabel = dataType1;
                        doiLabel = dataDoi1; // Add this line for DOI
                        image = dataImage1;
                    } else if (i == 1) {
                        titleLabel = dataTitle2;
                        authorLabel = dataAuthor2;
                        yearLabel = dataYear2;
                        typeLabel = dataType2;
                        doiLabel = dataDoi2; // Add this line for DOI
                        doiLabel = dataDoi2;
                        image = dataImage2;
                    } else if (i == 2) {
                        titleLabel = dataTitle3;
                        authorLabel = dataAuthor3;
                        yearLabel = dataYear3;
                        typeLabel = dataType3;
                        doiLabel = dataDoi3; // Add this line for DOI
                        image = dataImage3;
                    }
        
                    // Set label texts, DOI, and image
                    if (titleLabel != null) {
                        titleLabel.setText((String) entry[1]);
                    }
                    if (authorLabel != null) {
                        authorLabel.setText((String) entry[3]);
                    }
                    if (yearLabel != null) {
                        yearLabel.setText((String) entry[5]);
                    }
                    if (typeLabel != null) {
                        String[] genres = (String[]) entry[13];
                        if (genres.length > 0) {
                            typeLabel.setText(genres[0]);
                        }
                    }
                    if (doiLabel != null) {
                        doiLabel.setText((String) entry[7]); // Assuming the DOI is at index 6
                    }
                    if (image != null) {
                        String imagePath = (String) entry[15]; // Assuming the image path is at index 15
                        Image entryImage = new Image("file:" + imagePath);
                        image.setImage(entryImage);
                    }
                }
            }
        }

        private void clearLabelsAndImages() {
            // Clear all labels
            dataTitle1.setText(null);
            dataAuthor1.setText(null);
            dataYear1.setText(null);
            dataType1.setText(null);
        
            dataTitle2.setText(null);
            dataAuthor2.setText(null);
            dataYear2.setText(null);
            dataType2.setText(null);
        
            dataTitle3.setText(null);
            dataAuthor3.setText(null);
            dataYear3.setText(null);
            dataType3.setText(null);
        
            // Clear all images
            dataImage1.setImage(null);
            dataImage2.setImage(null);
            dataImage3.setImage(null);
        }

        public List<Object[]> filterDataByGenre(String desiredGenre, Object[][] data) {
            List<Object[]> filteredData = new ArrayList<>();

            for (Object[] entry : data) {
                String[] genres = (String[]) entry[13];
                for (String genre : genres) {
                    if (genre.equals(desiredGenre)) {
                        filteredData.add(entry);
                        break; 
                    }
                }
            }

            return filteredData;
        }

        @FXML
        public void setLabelData() {
            DataSample dataSample = new DataSample(); // Create an instance of DataSample
            Object[][] data = dataSample.getDataSample();
            
            // Check if there is data available for both labels
            if (data.length >= 3) {
    
                //research1
                rTitle1.setText((String) data[0][1]);
                rAuthor1.setText((String) data[0][3]);
                rYear1.setText((String) data[0][5]);
                rDoi1.setText((String) data[0][7]);
                
                String[] genres = (String[]) data[0][13];
                if (genres.length > 0) {
                    rType1.setText(genres[0]);
                }
    
                String imagePath = (String) data[0][15];
                Image image = new Image("file:" + imagePath);
                rImage1.setImage(image);
    
                //research2
                rTitle2.setText((String) data[1][1]);
                rAuthor2.setText((String) data[1][3]);
                rYear2.setText((String) data[1][5]);
                rDoi2.setText((String) data[1][7]);
                
                String[] genres2 = (String[]) data[1][13];
                if (genres2.length > 0) {
                    rType2.setText(genres2[0]);
                }
    
                String imagePath2 = (String) data[1][15];
                Image image2 = new Image("file:" + imagePath2);
                rImage2.setImage(image2);
    
                //research3
                rTitle3.setText((String) data[2][1]);
                rAuthor3.setText((String) data[2][3]);
                rYear3.setText((String) data[2][5]);
                rDoi3.setText((String) data[2][7]);
                
                String[] genres3 = (String[]) data[2][13];
                if (genres3.length > 0) {
                    rType3.setText(genres3[0]);
                }
    
                String imagePath3 = (String) data[2][15];
                Image image3 = new Image("file:" + imagePath3);
                rImage3.setImage(image3);
            }
        }

        @FXML
        public void readClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if (clickedButton == read1 || clickedButton == read2 || clickedButton == read3
                || clickedButton == read4 || clickedButton == read5 || clickedButton == read6) {
            setReadLabels(clickedButton);
            paneRead.setVisible(true);
            fadeAndSlideInPaneReadFromRight();
             }
        }

        private void setReadLabels(Button readButton) {
            switch (readButton.getId()) {
                case "read1":
                    setReadLabels(rTitle1.getText(), rAuthor1.getText(), rYear1.getText(), rImage1.getImage(), rDoi1.getText());
                    break;
                case "read2":
                    setReadLabels(rTitle2.getText(), rAuthor2.getText(), rYear2.getText(), rImage2.getImage(), rDoi2.getText());
                    break;
                case "read3":
                    setReadLabels(rTitle3.getText(), rAuthor3.getText(), rYear3.getText(), rImage3.getImage(), rDoi3.getText());
                    break;
                case "read4":
                    setReadLabels(dataTitle1.getText(), dataAuthor1.getText(), dataYear1.getText(), dataImage1.getImage(), dataDoi1.getText());
                    break;
                case "read5":
                    setReadLabels(dataTitle2.getText(), dataAuthor2.getText(), dataYear2.getText(), dataImage2.getImage(), dataDoi2.getText());
                    break;
                case "read6":
                    setReadLabels(dataTitle3.getText(), dataAuthor3.getText(), dataYear3.getText(), dataImage3.getImage(), dataDoi3.getText());
                    break;
            }
        }
    

            private void setReadLabels(String title, String author, String year, Image image, String doi) {
            titleRead.setText(title);
            authorRead.setText(author);
            yearRead.setText(year);
            imageRead.setImage(image);
            doiRead.setText(doi);
        }



        HistoryStack history_stack = new HistoryStack();

        String historyItem;

        @FXML
        public void contread(ActionEvent event) throws IOException{
            historyItem = titleRead.getText() + "*" + authorRead.getText() + "*" + yearRead.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

        } 

        public void addtoHistory(String history_item){

            history_stack.pushToStack(history_item);
    
            System.out.println("History Update: " + history_item);
            System.out.println("History Current Stack: " + history_stack.getHistoryStack());
        }


        private void fadeAndSlideInPaneReadFromRight() {
            
            paneRead.setOpacity(0);
            paneRead.setTranslateX(paneRead.getWidth());

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), paneRead);
            fadeTransition.setToValue(1); 

            TranslateTransition slideIn = new TranslateTransition(Duration.seconds(0.5), paneRead);
            slideIn.setToX(0); 
            
            fadeTransition.play();
            slideIn.play();
        }

        private void fadeAndSlideOutPaneToRight() {
            
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), paneRead);
            fadeTransition.setToValue(0); 

            TranslateTransition slideOut = new TranslateTransition(Duration.seconds(0.5), paneRead);
            slideOut.setToX(paneRead.getWidth());

            fadeTransition.setOnFinished(e -> paneRead.setVisible(false));
            slideOut.setOnFinished(e -> paneRead.setVisible(false));

            fadeTransition.play();
            slideOut.play();
        }
        @FXML   
        public void ekis(ActionEvent event) throws IOException{
            fadeAndSlideOutPaneToRight();
        }


        //Navigation Buttons Below

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

        @FXML
        public void contact(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Contact.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
         public void addtoFav(ActionEvent event) throws IOException {
            UserRepository User1 = UserRepository.getInstance();
            Button clickedButton = (Button) event.getSource();
      
            if (clickedButton == favbtn) {
                String doi = doiRead.getText();
                if (doi != null && !doi.isEmpty()) {
                    User user = User1.getUserByEmail(userEmail);
        
                    if (user != null) {
                        // Check if the DOI already exists in the favorites
                        if (user.getFavorites().contains(doi)) {
                            System.out.println("DOI already exists in the favorites list: " + doi);
                            return; // Exit the method to avoid duplicates
                        }
        
                        // Check if the maximum limit of 8 favorites is reached
                        if (user.getFavorites().size() >= 8) {
                            System.out.println("Maximum limit of 8 favorites reached. Cannot add more.");
                            return; // Exit the method to enforce the limit
                        }
        
                        user.addFavorite(doi);
                
                        System.out.println("DOI added to the favorites list: " + doi);
                    } else {
                        System.out.println("User not found for email: " + userEmail);
                    }
                }
            }
            displayFavDois();
        }

         public void displayFavDois() {
        // Assuming you have an instance of UserRepository
        UserRepository userRepo = UserRepository.getInstance();
        // Assuming you have a user email variable userEmail
        User user = userRepo.getUserByEmail(userEmail);

        if (user != null) {
            LinkedList<String> favorites = user.getFavorites();

            System.out.println("Favorites for user " + user.getEmail() + ":");
            for (String favorite : favorites) {
                System.out.println(favorite);
            }
        } else {
            System.out.println("User not found for email: " + userEmail);
        }
    }
    }   
