package Controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Action;

import Model.HistoryStack;
import Model.Node;
import Model.ResearchStorage;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class U_DiscoverController {

    static ArrayList<String> dumpCourse = new ArrayList<>();
    static ArrayList<String> dumpType = new ArrayList<>();
    static ArrayList<String> dumpYear = new ArrayList<>();
    static ArrayList<String> dumpSearch = new ArrayList<>();

    static String[] listDoi = ResearchStorage.giveKeys();
    static int maxPage;
    static int currentPage = 1;

    @FXML
    ImageView  nuimage, logoutimage, profileimage, homeimage, discoverimage, filterimage, exploreimage, favoriteimage, historyimage;

    @FXML
    ImageView p1, p2, p3, p4;

    @FXML
    ImageView searchPic;

    @FXML
    TextField searchTextField;

    @FXML
    Button searchButton;

    @FXML
    CheckBox cbInternship, cbCapstone, cbThesis;

    @FXML
    CheckBox cbBSCSML, cbBSCSDF, cbBSITMWA, cbBSITMAA;

    @FXML
    CheckBox cb2023, cb2022, cb2021, cb2020;

    @FXML
    Button prevButton, nextButton;

    @FXML
    Text rName1, rAuthor1, rCourse1, rPublished1, rType1;

    @FXML
    Text rName2, rAuthor2, rCourse2, rPublished2, rType2;

    @FXML
    Text rName3, rAuthor3, rCourse3, rPublished3, rType3;

    @FXML
    Text rName4, rAuthor4, rCourse4, rPublished4, rType4;

    @FXML
    Pane pane1, pane2, pane3, pane4;


    public void initialize() {
        listDoi = ResearchStorage.giveKeys();
        loadPage(processArray(listDoi), currentPage);
        setAllImageViews();
    }

    public void loadPage(Map<Integer, String[]> inputData, int currentPageSet) {
        maxPage = inputData.size();
        
        changePicFade(p1, false);
        changePicFade(p2, false);
        changePicFade(p3, false);
        changePicFade(p4, false);
        loadData(inputData.get(currentPage)); 
              
    }

    public void nextPage() {
        System.out.println("Next Page");
        System.out.println("current page: " + currentPage);
        if (currentPage < maxPage) {
            currentPage += 1;
            loadPage(processArray(listDoi), currentPage);
        }
    }

    public void prevPage() {
        System.out.println("Previous Page");
        System.out.println("current page: " + currentPage);
        if (currentPage > 1) {
            currentPage -= 1;
            loadPage(processArray(listDoi), currentPage);
        }
    }

    public static Map<Integer, String[]> processArray(String[] inputArray) {
        Map<Integer, String[]> resultMap = new HashMap<>();
        int occurrence = 0;

        // Iterate through the input array and create sets of 4 elements
        for (int i = 0; i < inputArray.length; i += 4) {
            String[] currentSet = new String[4];
            for (int j = i; j < i + 4 && j < inputArray.length; j++) {
                currentSet[j - i] = inputArray[j];
            }
            // Add the set to the resultMap with the occurrence as the key
            resultMap.put(++occurrence, currentSet);
        }

        return resultMap;
    }

    public void loadData(String[] setData) {
        
        try {
            pane1.setVisible(true);
            Node currentNode = ResearchStorage.getNode(setData[0]);
            changePicFade(p1, false);
            fadeText(rName1, currentNode.getResearchTitle());
            fadeText(rAuthor1, currentNode.getResearchAuthor());
            fadeText(rCourse1, currentNode.getResearchCourse());
            fadeText(rPublished1, currentNode.getYearPublished());
            fadeText(rType1, currentNode.getTypeDoc());
        } catch (Exception e) {
            pane1.setVisible(false);
            rName1.setText(" ");
            rAuthor1.setText(" ");
            rCourse1.setText(" ");
            rPublished1.setText(" ");
            rType1.setText(" ");
        }

        try {
            pane2.setVisible(true);
            Node currentNode2 = ResearchStorage.getNode(setData[1]);
            changePicFade(p2, false);
            fadeText(rName2, currentNode2.getResearchTitle());
            fadeText(rAuthor2, currentNode2.getResearchAuthor());
            fadeText(rCourse2, currentNode2.getResearchCourse());
            fadeText(rPublished2, currentNode2.getYearPublished());
            fadeText(rType2, currentNode2.getTypeDoc());
        } catch (Exception e) {
            pane2.setVisible(false);
            rName2.setText(" ");
            rAuthor2.setText(" ");
            rCourse2.setText(" ");
            rPublished2.setText(" ");
            rType2.setText(" ");
        }

        try {
            pane3.setVisible(true);
            Node currentNode3 = ResearchStorage.getNode(setData[2]);
            changePicFade(p3, false);
            fadeText(rName3, currentNode3.getResearchTitle());
            fadeText(rAuthor3, currentNode3.getResearchAuthor());
            fadeText(rCourse3, currentNode3.getResearchCourse());
            fadeText(rPublished3, currentNode3.getYearPublished());
            fadeText(rType3, currentNode3.getTypeDoc());
        } catch (Exception e) {
            pane3.setVisible(false);
            rName3.setText(" ");
            rAuthor3.setText(" ");
            rCourse3.setText(" ");
            rPublished3.setText(" ");
            rType3.setText(" ");
        }

        try {
            pane4.setVisible(true);
            Node currentNode4 = ResearchStorage.getNode(setData[3]);
            changePicFade(p4, false);
            fadeText(rName4, currentNode4.getResearchTitle());
            fadeText(rAuthor4, currentNode4.getResearchAuthor());
            fadeText(rCourse4, currentNode4.getResearchCourse());
            fadeText(rPublished4, currentNode4.getYearPublished());
            fadeText(rType4, currentNode4.getTypeDoc());
        } catch (Exception e) {
            pane4.setVisible(false);
            rName4.setText(" ");
            rAuthor4.setText(" ");
            rCourse4.setText(" ");
            rPublished4.setText(" ");
            rType4.setText(" ");
        }
    }

    public void updateDoiListCourseFilter(String courseFilter) {
        listDoi = filterCourse(courseFilter);
        currentPage = 1;
        loadPage(processArray(listDoi), currentPage);
    }

    public void updateDoiListTypeFilter(String typeFilter) {
        System.out.println(Arrays.toString(listDoi));
        System.out.println("----------------");
        listDoi = filterType(typeFilter);
        System.out.println(Arrays.toString(listDoi));
        currentPage = 1;
        loadPage(processArray(listDoi), currentPage);
        
    }

    public void updateDoiListYearFilter(String yearFilter) {
        listDoi = filterYear(yearFilter);
        currentPage = 1;
        loadPage(processArray(listDoi), currentPage);
        
    }

    public String[] filterCourse(String courseFilter) {
        List<String> filteredList = new ArrayList<>();

        for (String doi : listDoi) {
            Node currentNode = ResearchStorage.getNode(doi);
            if (currentNode.getResearchCourse().equals(courseFilter)) {
                filteredList.add(doi);
            } else {
                dumpCollector("course", doi);
            }
        }

        return filteredList.toArray(new String[0]);
    }

    public String[] filterType(String typeFilter) {
        List<String> filteredList = new ArrayList<>();

        for (String doi : listDoi) {
            Node currentNode = ResearchStorage.getNode(doi);
            if (currentNode.getTypeDoc().equals(typeFilter)) {
                filteredList.add(doi);
            } else {
                dumpCollector("type", doi);
            }
        }

        return filteredList.toArray(new String[0]);
    }

    public String[] filterYear(String yearFilter) {
        List<String> filteredList = new ArrayList<>();

        for (String doi : listDoi) {
            Node currentNode = ResearchStorage.getNode(doi);
            if (currentNode.getYearPublished().equals(yearFilter)) {
                filteredList.add(doi);
            } else {
                dumpCollector("year", doi);
            }

        }

        return filteredList.toArray(new String[0]);
    }

    public String[] filterSearch(String inputWord) {
        List<String> filteredList = new ArrayList<>();

        for (String doi : listDoi) {
            Node currentNode = ResearchStorage.getNode(doi);
            if (currentNode.getResearchTitle().toLowerCase().contains(inputWord.toLowerCase())) {
                filteredList.add(doi);
            } else {
                dumpCollector("search", doi);
            }
        }
        return filteredList.toArray(new String[0]);
    }

    public void resetFilter() {
        listDoi = ResearchStorage.giveKeys();
        currentPage = 1;
        loadPage(processArray(listDoi), currentPage);
    }

    public void submitSearch() {
        dumpRecover("search");
        dumpSearch.clear();
        String inputWord = searchTextField.getText();
        listDoi = filterSearch(inputWord);
        currentPage = 1;
        loadPage(processArray(listDoi), currentPage);
        System.out.println("Input in search:"+inputWord);
    }

    @FXML
    public void ToggleGroupButtonType(ActionEvent event) {
        CheckBox selectedCheckBox = (CheckBox) event.getSource();

        if (selectedCheckBox == cbInternship && cbInternship.isSelected()) {
            cbCapstone.setSelected(false);
            cbThesis.setSelected(false);
            dumpRecover("type");
            dumpType.clear();
            updateDoiListTypeFilter("Internship");
        } else if (selectedCheckBox == cbCapstone && cbCapstone.isSelected()) {
            cbInternship.setSelected(false);
            cbThesis.setSelected(false);
            dumpRecover("type");
            dumpType.clear();
            updateDoiListTypeFilter("Capstone");
        } else if (selectedCheckBox == cbThesis && cbThesis.isSelected()) {
            cbInternship.setSelected(false);
            cbCapstone.setSelected(false);
            dumpRecover("type");
            dumpType.clear();
            updateDoiListTypeFilter("Thesis");
        } else {
            System.out.println("None");
            currentPage = 1;
            dumpRecover("type");
            dumpType.clear();
            loadPage(processArray(listDoi), currentPage);
        }

        // Your logic for handling selected checkbox here
        if (cbInternship.isSelected()) {
            System.out.println("Internship");
        } else if (cbCapstone.isSelected()) {
            System.out.println("Capstone");
        } else if (cbThesis.isSelected()) {
            System.out.println("Thesis");
        }
    }

    @FXML
    public void ToggleGroupButtonCourse(ActionEvent event) {
        CheckBox selectedCheckBox = (CheckBox) event.getSource();

        if (selectedCheckBox == cbBSCSML && cbBSCSML.isSelected()) {
            cbBSCSDF.setSelected(false);
            cbBSITMAA.setSelected(false);
            cbBSITMWA.setSelected(false);
            dumpRecover("course");
            dumpCourse.clear();
            updateDoiListCourseFilter("BSCS-ML");
        } else if (selectedCheckBox == cbBSCSDF && cbBSCSDF.isSelected()) {
            cbBSCSML.setSelected(false);
            cbBSITMAA.setSelected(false);
            cbBSITMWA.setSelected(false);
            dumpRecover("course");
            dumpCourse.clear();
            updateDoiListCourseFilter("BSCS-DF");
        } else if (selectedCheckBox == cbBSITMAA && cbBSITMAA.isSelected()) {
            cbBSCSDF.setSelected(false);
            cbBSCSML.setSelected(false);
            cbBSITMWA.setSelected(false);
            dumpRecover("course");
            dumpCourse.clear();
            updateDoiListCourseFilter("BSIT-MAA");
        } else if (selectedCheckBox == cbBSITMWA && cbBSITMWA.isSelected()) {
            cbBSCSDF.setSelected(false);
            cbBSCSML.setSelected(false);
            cbBSITMAA.setSelected(false);
            dumpRecover("course");
            dumpCourse.clear();
            updateDoiListCourseFilter("BSIT-MWA");
        }
          else {
            System.out.println("None");
            currentPage = 1;
            dumpRecover("course");
            dumpCourse.clear();
            loadPage(processArray(listDoi), currentPage);
        }

        // Your logic for handling selected checkbox here
        if (cbBSCSML.isSelected()) {
            System.out.println("BSCS-ML");
        } else if (cbBSCSDF.isSelected()) {
            System.out.println("BSCS-DF");
        } else if (cbBSITMAA.isSelected()) {
            System.out.println("BSIT-MAA");
        } else if (cbBSITMWA.isSelected()) {
            System.out.println("BSIT-MWA");
        }
    }
    
    @FXML
    public void ToggleGroupButtonYear(ActionEvent event) {
        CheckBox selectedCheckBox = (CheckBox) event.getSource();

        if (selectedCheckBox == cb2020 && cb2020.isSelected()) {
            cb2023.setSelected(false);
            cb2022.setSelected(false);
            cb2021.setSelected(false);
            dumpRecover("year");
            dumpYear.clear();
            updateDoiListYearFilter("2020");
        } else if (selectedCheckBox == cb2021 && cb2021.isSelected()) {
            cb2023.setSelected(false);
            cb2022.setSelected(false);
            cb2020.setSelected(false);
            dumpRecover("year");
            dumpYear.clear();
            updateDoiListYearFilter("2021");
        } else if (selectedCheckBox == cb2022 && cb2022.isSelected()) {
            cb2023.setSelected(false);
            cb2021.setSelected(false);
            cb2020.setSelected(false);
            dumpRecover("year");
            dumpYear.clear();
            updateDoiListYearFilter("2022");
        } else if (selectedCheckBox == cb2023 && cb2023.isSelected()) {
            cb2022.setSelected(false);
            cb2021.setSelected(false);
            cb2020.setSelected(false);
            dumpRecover("year");
            dumpYear.clear();
            updateDoiListYearFilter("2023");
        }
          else {
            System.out.println("None");
            currentPage = 1;
            dumpRecover("year");
            dumpYear.clear();
            loadPage(processArray(listDoi), currentPage);
        }

        // Your logic for handling selected checkbox here
        if (cb2020.isSelected()) {
            System.out.println("2020");
        } else if (cb2021.isSelected()) {
            System.out.println("2021");
        } else if (cb2022.isSelected()) {
            System.out.println("2022");
        } else if (cb2023.isSelected()) {
            System.out.println("2023");
        }
    }

    public static void dumpCollector(String kind, String doi) {
        if (kind == "type") {
            dumpType.add(doi);
        } else if (kind == "course") {
            dumpCourse.add(doi);
        } else if (kind == "year") {
            dumpYear.add(doi);
        } else if (kind == "search") {
            dumpSearch.add(doi);
        }
    }

    public static void dumpRecover(String kind) {
        if (kind == "type") {
            appendArrayListToArray(dumpType, listDoi);
        } else if (kind == "course") {
            appendArrayListToArray(dumpCourse, listDoi);
            
        } else if (kind == "year") {
            appendArrayListToArray(dumpYear, listDoi);
        } else if (kind == "search") {
            appendArrayListToArray(dumpSearch, listDoi);
        }
    }

    public static void appendArrayListToArray(ArrayList<String> arrayListGiven, String[] stringArray) {
        // Create a new array with a size that accommodates the ArrayList elements
        for (String doi : stringArray) {
            arrayListGiven.add(doi);
        }

        Collections.shuffle(arrayListGiven);
        String[] stringArrayOutput = arrayListGiven.toArray(new String[arrayListGiven.size()]);

        // Print the elements of the String array
        listDoi = stringArrayOutput;

        // Use System.arraycopy to append ArrayList elements to the new arr
    }

    public static void setImageElements(ImageView imageView, String path) {
        imageView.setImage(new Image(path));
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

    private void changePicFade(ImageView given, Boolean isNull) {
        if (isNull) {
            given.setImage(null);
        } else {
            ImageView newImage = new ImageView("/Images/ML,Intern,2020.png");
            fadeImageView(given, newImage);
        }
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
            setImageFromFilePath(discoverimage, "src/Images/tap.png");
            setImageFromFilePath(exploreimage, "src/Images/folder (1).png");
            setImageFromFilePath(favoriteimage, "src/Images/saved.png");
            setImageFromFilePath(historyimage, "src/Images/history.png");
            setImageFromFilePath(filterimage, "src/Images/filter(1).png");
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
    public void favorite(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Favorites.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    public void history(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_History.fxml"));
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

    @FXML
    public void profile(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Profile.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Login.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

        HistoryStack history_stack = new HistoryStack();

        String historyItem;

        @FXML
        public void gotoPDF1(ActionEvent event) throws IOException{
            if(rName1.getText() != " "){
            historyItem = rName1.getText() + "*" + rAuthor1.getText() + "*" + rPublished1.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }

        }

        @FXML
        public void gotoPDF2(ActionEvent event) throws IOException{
            if(rName2.getText() != " "){
            historyItem = rName2.getText() + "*" + rAuthor2.getText() + "*" + rPublished2.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }

        }

        @FXML
        public void gotoPDF3(ActionEvent event) throws IOException{

            if(rName3.getText() != " "){
            historyItem = rName3.getText() + "*" + rAuthor3.getText() + "*" + rPublished3.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }

        }

        @FXML
        public void gotoPDF4(ActionEvent event) throws IOException{
            if(rName4.getText() != " "){
            historyItem = rName4.getText() + "*" + rAuthor4.getText() + "*" + rPublished4.getText();

            addtoHistory(historyItem);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PDFView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            }
            
        }

        public void addtoHistory(String history_item){

            history_stack.pushToStack(history_item);
    
            System.out.println("History Update: " + history_item);
            System.out.println("History Current Stack: " + history_stack.getHistoryStack());
        }
}