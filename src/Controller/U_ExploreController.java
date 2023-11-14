package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.Action;

import Model.DataSample;
import Model.HistoryStack;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

public class U_ExploreController {
    
    @FXML
    ImageView  nuimage, logoutimage, profileimage, homeimage, discoverimage, exploreimage, favoriteimage, historyimage,
    dataImage1, dataImage2, dataImage3, dataImage4, stitle, syearA, syearD;
    @FXML
    Label dataTitle1, dataAuthor1, dataYear1, dataType1;
    @FXML
    Label dataTitle2, dataAuthor2, dataYear2, dataType2;
    @FXML
    Label dataTitle3, dataAuthor3, dataYear3, dataType3;
    @FXML
    Label dataTitle4, dataAuthor4, dataYear4, dataType4;
    @FXML
    Label dataCourse1, dataCourse2, dataCourse3, dataCourse4, genreLabel;
    @FXML
    Button previous, next, sortTitle, sortYearA, sortYearD, genreButton;
    @FXML
    Pane pane1, pane2, pane3, pane4;
    @FXML
    ChoiceBox<String> choicebox;

    private int currentDataIndex = 0;
    private List<Object[]> filteredData;
    
    Comparator<Object[]> yearAscComparator = Comparator.comparingInt(entry -> Integer.parseInt((String) entry[5]));

    
    Comparator<Object[]> yearDescComparator = (entry1, entry2) -> {
        int year1 = Integer.parseInt((String) entry1[5]);
        int year2 = Integer.parseInt((String) entry2[5]);
        return Integer.compare(year2, year1);
    };

    
    // Sort by year ascending
    public void sortByYearAscending() {
        sortAndDisplay(yearAscComparator);

        stitle.setVisible(false);
        syearA.setVisible(true);
        syearD.setVisible(false);
    }

    // Sort by year descending
    public void sortByYearDescending() {
        sortAndDisplay(yearDescComparator);

        stitle.setVisible(false);
        syearA.setVisible(false);
        syearD.setVisible(true);
    }
    private void sortAndDisplay(Comparator<Object[]> comparator) {
        filteredData.sort(comparator);
        currentDataIndex = 0; // Reset the index when data is sorted
        updateLabelsWithCurrentData();
    }

    //Quick Sort 
    private int partition(Object[][] arr, int low, int high) {
        String pivot = (String) arr[high][1]; // Select the pivot as the last element
        System.out.println("Pivot: " + pivot);
        int i = (low - 1);
    
        for (int j = low; j < high; j++) {
            if (((String) arr[j][1]).compareTo(pivot) < 0) { // Compare the titles
                i++;

                System.out.println("Swapping elements at i = " + i + " and j = " + j);
    
                Object[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        System.out.println("Array after partition:");
        printArray(arr);

        Object[] temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
    
        return i + 1;
    }

    @FXML
    public void genreButtonClicked() {
        if (choicebox.isVisible()) {
            choicebox.setVisible(false);
        } else {
            choicebox.setVisible(true);
        }
    }
    
    private Object[][] quickSort(Object[][] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            System.out.println("Pivot element: " + arr[pi][1]);
    
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }

    private void printArray(Object[][] arr) {
    for (Object[] row : arr) {
        System.out.println(Arrays.toString(row));
    }
}

    @FXML
    public void sortByTitleAZ(ActionEvent event) {
        Object[][] sortedData = quickSort(filteredData.toArray(new Object[0][]), 0, filteredData.size() - 1);
        currentDataIndex = 0; // Reset the index when data is sorted
        updateLabelsWithSortedData(sortedData);

        stitle.setVisible(true);
        syearA.setVisible(false);
        syearD.setVisible(false);
    }

    private void updateLabelsWithSortedData(Object[][] sortedData) {
        filteredData = Arrays.asList(sortedData); // Update the filteredData with the sorted data
        currentDataIndex = 0; // Reset the index when data is sorted
        updateLabelsWithCurrentData(); // Call the method to update labels with the current index
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
        setImageFromFilePath(homeimage, "src/Images/home(1).png");
        setImageFromFilePath(discoverimage, "src/Images/hand.png");
        setImageFromFilePath(exploreimage, "src/Images/folder(1).png");
        setImageFromFilePath(favoriteimage, "src/Images/saved.png");
        setImageFromFilePath(historyimage, "src/Images/history.png");
    }
    
    public void initialize() {
        setAllImageViews();
        choicebox.getItems().addAll("Data Science", "Machine Learning", "Cybersecurity", "Web Development", "Game Development");
        choicebox.setValue("Data Science");
        choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setFilteredDataByGenre(newValue);
                currentDataIndex = 0;
                updateLabelsWithCurrentData();
                genreLabel.setText(newValue); // Update the label based on selection
                choicebox.setVisible(false); // Hide the choicebox after selection
            }
        }); 
        setFilteredDataByGenre("Data Science");
        genreLabel.setText("Data Science");
        choicebox.setVisible(false); 
        updateLabelsWithCurrentData();

}

    private void setFilteredDataByGenre(String desiredGenre) {
        DataSample dataSample = new DataSample();
        Object[][] data = dataSample.getDataSample();
        filteredData = filterDataByGenre(desiredGenre, data);
        currentDataIndex = 0; // Reset the index when data is filtered
        updateLabelsWithCurrentData();
    }
    private void updateLabelsWithCurrentData() {
        clearLabelsAndImages();
    
        int numberOfNodesToDisplay = Math.min(currentDataIndex + 4, filteredData.size()) - currentDataIndex;

          // Apply fade-out transition to all panes
        FadeTransition fadeOut1 = new FadeTransition(Duration.millis(500), pane1);
        fadeOut1.setFromValue(1.0);
        fadeOut1.setToValue(0.0);
        fadeOut1.play();

        FadeTransition fadeOut2 = new FadeTransition(Duration.millis(500), pane2);
        fadeOut2.setFromValue(1.0);
        fadeOut2.setToValue(0.0);
        fadeOut2.play();

        FadeTransition fadeOut3 = new FadeTransition(Duration.millis(500), pane3);
        fadeOut3.setFromValue(1.0);
        fadeOut3.setToValue(0.0);
        fadeOut3.play();

        FadeTransition fadeOut4 = new FadeTransition(Duration.millis(500), pane4);
        fadeOut4.setFromValue(1.0);
        fadeOut4.setToValue(0.0);
        fadeOut4.play();

        // Set up the action to perform after the fade-out completes
        fadeOut1.setOnFinished(event -> {
        for (int i = 0; i < numberOfNodesToDisplay; i++) {
            // Existing code to set labels and images
        }
    
        for (int i = 0; i < numberOfNodesToDisplay; i++) {
            Object[] entry = filteredData.get(currentDataIndex + i);
            Label titleLabel = null;
            Label authorLabel = null;
            Label yearLabel = null;
            Label typeLabel = null;
            Label courseLabel = null;
            ImageView image = null;
            Pane pane = null;
    
            // Assign labels, image, and pane based on the index i
            if (i == 0) {
                titleLabel = dataTitle1;
                authorLabel = dataAuthor1;
                yearLabel = dataYear1;
                typeLabel = dataType1;
                courseLabel = dataCourse1;
                image = dataImage1;
                pane = pane1;
            } else if (i == 1) {
                titleLabel = dataTitle2;
                authorLabel = dataAuthor2;
                yearLabel = dataYear2;
                typeLabel = dataType2;
                courseLabel = dataCourse2;
                image = dataImage2;
                pane = pane2;
            } else if (i == 2) {
                titleLabel = dataTitle3;
                authorLabel = dataAuthor3;
                yearLabel = dataYear3;
                typeLabel = dataType3;
                courseLabel = dataCourse3;
                image = dataImage3;
                pane = pane3;
            } else if (i == 3) {
                titleLabel = dataTitle4;
                authorLabel = dataAuthor4;
                yearLabel = dataYear4;
                typeLabel = dataType4;
                courseLabel = dataCourse4;
                image = dataImage4;
                pane = pane4;
            }
    
            // Set label texts and image
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
                    if (genres.length == 1) {
                        typeLabel.setText(genres[0]);
                    } else if (genres.length == 2) {
                        typeLabel.setText(genres[0] + ", " + genres[1]);
                    }
                }
            }
            if (courseLabel != null) {
                courseLabel.setText((String) entry[9]);
            }
            if (image != null) {
                String imagePath = (String) entry[15];
                Image entryImage = new Image("file:" + imagePath);
                image.setImage(entryImage);
            }
            if (pane != null) {
                pane.setVisible(true); // Make the pane visible for this node
            }
        }
    
        // Hide the panes that don't have labels or images
        for (int i = numberOfNodesToDisplay; i < 4; i++) {
            Pane pane = null;
            if (i == 0) {
                pane = pane1;
            } else if (i == 1) {
                pane = pane2;
            } else if (i == 2) {
                pane = pane3;
            } else if (i == 3) {
                pane = pane4;
            }
            if (pane != null) {
                pane.setVisible(false); // Make the pane invisible for the remaining nodes
            }
        }

        // Apply fade-in effect to all panes
        FadeTransition fadeIn1 = new FadeTransition(Duration.millis(500), pane1);
        fadeIn1.setFromValue(0.0);
        fadeIn1.setToValue(1.0);
        fadeIn1.play();

        FadeTransition fadeIn2 = new FadeTransition(Duration.millis(500), pane2);
        fadeIn2.setFromValue(0.0);
        fadeIn2.setToValue(1.0);
        fadeIn2.play();

        FadeTransition fadeIn3 = new FadeTransition(Duration.millis(500), pane3);
        fadeIn3.setFromValue(0.0);
        fadeIn3.setToValue(1.0);
        fadeIn3.play();

        FadeTransition fadeIn4 = new FadeTransition(Duration.millis(500), pane4);
        fadeIn4.setFromValue(0.0);
        fadeIn4.setToValue(1.0);
        fadeIn4.play();
    });
    }
    
    private List<Object[]> filterDataByGenre(String desiredGenre, Object[][] data) {
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
    public void previousClicked() {
        if (currentDataIndex >= 4) {
            currentDataIndex -= 4;
            updateLabelsWithCurrentData();
        }
    }
    @FXML
    public void nextClicked() {
        if (currentDataIndex + 4 < filteredData.size()) {
            currentDataIndex += 4;
            updateLabelsWithCurrentData();
        }
    }
    private void clearLabelsAndImages() {
        // Clear all labels
        dataTitle1.setText(null);
        dataAuthor1.setText(null);
        dataYear1.setText(null);
        dataType1.setText(null);
        dataCourse1.setText(null);
    
        dataTitle2.setText(null);
        dataAuthor2.setText(null);
        dataYear2.setText(null);
        dataType2.setText(null);
        dataCourse2.setText(null);
    
        dataTitle3.setText(null);
        dataAuthor3.setText(null);
        dataYear3.setText(null);
        dataType3.setText(null);
        dataCourse3.setText(null);
    
        dataTitle4.setText(null);
        dataAuthor4.setText(null);
        dataYear4.setText(null);
        dataType4.setText(null);
        dataCourse4.setText(null);

        // Clear all images
        dataImage1.setImage(null);
        dataImage2.setImage(null);
        dataImage3.setImage(null);
        dataImage4.setImage(null);
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
        public void home(ActionEvent event) throws IOException {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Home.fxml"));
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

        HistoryStack history_stack = new HistoryStack();

        String historyItem;
        
        @FXML
        public void gotoPDF1(ActionEvent event) throws IOException{
            
            historyItem = dataTitle1.getText() + "*" + dataAuthor1.getText() + "*" + dataYear1.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }

        @FXML
        public void gotoPDF2(ActionEvent event) throws IOException{
            
            historyItem = dataTitle2.getText() + "*" + dataAuthor2.getText() + "*" + dataYear2.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }

        @FXML
        public void gotoPDF3(ActionEvent event) throws IOException{
            
            historyItem = dataTitle3.getText() + "*" + dataAuthor3.getText() + "*" + dataYear3.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }

        @FXML
        public void gotoPDF4(ActionEvent event) throws IOException{
            
            historyItem = dataTitle4.getText() + "*" + dataAuthor4.getText() + "*" + dataYear4.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
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

}