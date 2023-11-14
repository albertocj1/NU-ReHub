package Controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.swing.Action;

import Model.Node;
import Model.ResearchStorage;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
// import javafx.scene.Node as NodeFX;

public class A_InternshipController {

    static ArrayList<String> dumpCourse = new ArrayList<>();
    static ArrayList<String> dumpType = new ArrayList<>();
    static ArrayList<String> dumpYear = new ArrayList<>();
    static ArrayList<String> dumpSearch = new ArrayList<>();

    static String[] listDoi = ResearchStorage.giveKeys();
    static int maxPage;
    static int currentPage = 1;

    static String selectedType;

    @FXML
    TextField rTitleTF1, rAuthorTF1, rYearTF1, rCourseTF1, rDOITF1;

    @FXML
    Label typeText;

    @FXML
    Label warninglabel11, warninglabel21, warninglabel31, warninglabel41, warninglabel51;

    @FXML
    Button editSubmitButton, editDiscardButton;

    @FXML
    Pane deletePane;

    @FXML
    Button editButton1, editButton2, editButton3, editButton4, editButton5, editButton6, editButton7, editButton8;

    @FXML
    Button deleteButton1, deleteButton2, deleteButton3, deleteButton4, deleteButton5, deleteButton6, deleteButton7,
            deleteButton8;

    @FXML
    Pane editPaperPane;

    @FXML
    Pane paneTool1, paneTool2, paneTool3, paneTool4, paneTool5, paneTool6, paneTool7, paneTool8;

    @FXML
    Button buttonDiscard, saveButton;

    // @FXML
    // Button sampleS;

    @FXML
    Label warninglabel1, warninglabel2, warninglabel3, warninglabel4, warninglabel5;

    @FXML
    Text addPaperText;

    @FXML
    Text successText;

    @FXML
    TextField rTitleTF,rAuthorTF, rYearTF, rCourseTF, rDOITF;

    @FXML
    Pane addPaperPane;

    @FXML
    Button addPaperButton;

    @FXML
    Rectangle rectangleAdd, recAddHeader;

    @FXML
    Text resTitleDe, resAuthorDe, resYearPubDe, resCourseDe, resDOIDe;

    @FXML
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8;

    @FXML
    ImageView p1, p2, p3, p4, p5, p6, p7, p8;

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
    Text rName1, rAuthor1, rCourse1, rPublished1;

    @FXML
    Text rName2, rAuthor2, rCourse2, rPublished2;

    @FXML
    Text rName3, rAuthor3, rCourse3, rPublished3;

    @FXML
    Text rName4, rAuthor4, rCourse4, rPublished4;

    @FXML
    Text rName5, rAuthor5, rCourse5, rPublished5;

    @FXML
    Text rName6, rAuthor6, rCourse6, rPublished6;

    @FXML
    Text rName7, rAuthor7, rCourse7, rPublished7;

    @FXML
    Text rName8, rAuthor8, rCourse8, rPublished8;

    A_HomeController a_HomeController;

    static String pane1Doi;
    static String pane2Doi;
    static String pane3Doi;
    static String pane4Doi;
    static String pane5Doi;
    static String pane6Doi;
    static String pane7Doi;
    static String pane8Doi;
    static String inLineForDeleteDoi;
    static String inLineForEditDoi;

    public void initialize() {
        maxPage =1;
        listDoi = ResearchStorage.giveKeys();
        typeText.setText(selectedType);
        listDoi = filterType(selectedType);
        loadPage(processArray(listDoi), 0);
    
        }

    public void loadPage(Map<Integer, String[]> inputData, int currentPageSet) {
        maxPage = inputData.size();
        changePicFade(p1, false);
        changePicFade(p2, false);
        changePicFade(p3, false);
        changePicFade(p4, false);
        changePicFade(p5, false);
        changePicFade(p6, false);
        changePicFade(p7, false);
        changePicFade(p8, false);
        paneTool1.setOpacity(0);
        paneTool2.setOpacity(0);
        paneTool3.setOpacity(0);
        paneTool4.setOpacity(0);
        paneTool5.setOpacity(0);
        paneTool6.setOpacity(0);
        paneTool7.setOpacity(0);
        paneTool8.setOpacity(0);
        loadData(inputData.get(currentPage)); 
              
    }

    // @FXML
    // public void sampleShift(ActionEvent event) throws IOException {
    //     Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/A_Home - Copy.fxml"));
    //     Parent root = loader.load();
    //     // RegisterController = loader.getController();

    //     Scene scene = new Scene(root);
    //         stage.setScene(scene);
    //         stage.show();
    // }

    



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
        for (int i = 0; i < inputArray.length; i += 8) {
            String[] currentSet = new String[8];
            for (int j = i; j < i + 8 && j < inputArray.length; j++) {
                currentSet[j - i] = inputArray[j];
            }
            // Add the set to the resultMap with the occurrence as the key
            resultMap.put(++occurrence, currentSet);
        }

        return resultMap;
    }

    public void loadData(String[] setData) {
        
        try {
            Node currentNode = ResearchStorage.getNode(setData[0]);
            changePicFade(p1, false);
            fadeText(rName1, currentNode.getResearchTitle());
            fadeText(rAuthor1, currentNode.getResearchAuthor());
            fadeText(rCourse1, currentNode.getResearchCourse());
            fadeText(rPublished1, currentNode.getYearPublished());
            pane1Doi = currentNode.getResearchDOI();
        } catch (Exception e) {
            // changePicFade(p3, true);
            rName1.setText(" ");
            rAuthor1.setText(" ");
            rCourse1.setText(" ");
            rPublished1.setText(" ");
            pane1Doi = null;
        }

        try {
            Node currentNode2 = ResearchStorage.getNode(setData[1]);
            changePicFade(p2, false);
            fadeText(rName2, currentNode2.getResearchTitle());
            fadeText(rAuthor2, currentNode2.getResearchAuthor());
            fadeText(rCourse2, currentNode2.getResearchCourse());
            fadeText(rPublished2, currentNode2.getYearPublished());
            pane2Doi = currentNode2.getResearchDOI();
        } catch (Exception e) {
            // changePicFade(p3, true);
            rName2.setText(" ");
            rAuthor2.setText(" ");
            rCourse2.setText(" ");
            rPublished2.setText(" ");
            pane2Doi = null;
        }

        try {
            Node currentNode3 = ResearchStorage.getNode(setData[2]);
            changePicFade(p3, false);
            fadeText(rName3, currentNode3.getResearchTitle());
            fadeText(rAuthor3, currentNode3.getResearchAuthor());
            fadeText(rCourse3, currentNode3.getResearchCourse());
            fadeText(rPublished3, currentNode3.getYearPublished());
            pane3Doi = currentNode3.getResearchDOI();
        } catch (Exception e) {
            // changePicFade(p3, true);
            rName3.setText(" ");
            rAuthor3.setText(" ");
            rCourse3.setText(" ");
            rPublished3.setText(" ");
            pane3Doi = null;
        }

        try {
            Node currentNode4 = ResearchStorage.getNode(setData[3]);
            changePicFade(p4, false);
            fadeText(rName4, currentNode4.getResearchTitle());
            fadeText(rAuthor4, currentNode4.getResearchAuthor());
            fadeText(rCourse4, currentNode4.getResearchCourse());
            fadeText(rPublished4, currentNode4.getYearPublished());
            pane4Doi = currentNode4.getResearchDOI();
        } catch (Exception e) {
            // changePicFade(p3, true);
            rName4.setText(" ");
            rAuthor4.setText(" ");
            rCourse4.setText(" ");
            rPublished4.setText(" ");
            pane4Doi = null;
        }

        try {
            Node currentNode5 = ResearchStorage.getNode(setData[4]);
            changePicFade(p5, false);
            fadeText(rName5, currentNode5.getResearchTitle());
            fadeText(rAuthor5, currentNode5.getResearchAuthor());
            fadeText(rCourse5, currentNode5.getResearchCourse());
            fadeText(rPublished5, currentNode5.getYearPublished());
            pane5Doi = currentNode5.getResearchDOI();
        } catch (Exception e) {
            // changePicFade(p3, true);
            rName5.setText(" ");
            rAuthor5.setText(" ");
            rCourse5.setText(" ");
            rPublished5.setText(" ");
            pane5Doi = null;
        }

        try {
            Node currentNode6 = ResearchStorage.getNode(setData[5]);
            changePicFade(p6, false);
            fadeText(rName6, currentNode6.getResearchTitle());
            fadeText(rAuthor6, currentNode6.getResearchAuthor());
            fadeText(rCourse6, currentNode6.getResearchCourse());
            fadeText(rPublished6, currentNode6.getYearPublished());
            pane6Doi = currentNode6.getResearchDOI();
        } catch (Exception e) {
            // changePicFade(p3, true);
            rName6.setText(" ");
            rAuthor6.setText(" ");
            rCourse6.setText(" ");
            rPublished6.setText(" ");
            pane6Doi = null;
        }

        try {
            Node currentNode7 = ResearchStorage.getNode(setData[6]);
            changePicFade(p7, false);
            fadeText(rName7, currentNode7.getResearchTitle());
            fadeText(rAuthor7, currentNode7.getResearchAuthor());
            fadeText(rCourse7, currentNode7.getResearchCourse());
            fadeText(rPublished7, currentNode7.getYearPublished());
            pane7Doi = currentNode7.getResearchDOI();
        } catch (Exception e) {
            // changePicFade(p3, true);
            rName7.setText(" ");
            rAuthor7.setText(" ");
            rCourse7.setText(" ");
            rPublished7.setText(" ");
            pane7Doi = null;
        }

        try {
            Node currentNode8 = ResearchStorage.getNode(setData[7]);
            changePicFade(p8, false);
            fadeText(rName8, currentNode8.getResearchTitle());
            fadeText(rAuthor8, currentNode8.getResearchAuthor());
            fadeText(rCourse8, currentNode8.getResearchCourse());
            fadeText(rPublished8, currentNode8.getYearPublished());
            pane8Doi = currentNode8.getResearchDOI();
        } catch (Exception e) {
            // changePicFade(p3, true);
            rName8.setText(" ");
            rAuthor8.setText(" ");
            rCourse8.setText(" ");
            rPublished8.setText(" ");
            pane8Doi = null;
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

    
    public void addPaperAction() {
        movePaneLeft();
        fadeRectangle(rectangleAdd, 0.5, 1, 0.5);
        addPaperButton.setDisable(true);
        moveRectangle(recAddHeader, 0.5, -170);
        moveText(addPaperText, 0.5, -170);
        System.out.println("Button add paper pressed");
    }

    // Method to apply fade effect to a rectangle
    private void fadeRectangle(Rectangle rectangle, double durationInSeconds, double fromValue, double toValue) {
        // Create a FadeTransition with specified duration
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(durationInSeconds), rectangle);

        // Set the starting and ending opacity values
        fadeTransition.setFromValue(fromValue);
        fadeTransition.setToValue(toValue);

        // Set the cycle count (how many times the animation should repeat)
        fadeTransition.setCycleCount(1);

        // Play the animation
        fadeTransition.play();
    }

    public static void moveRectangle(Rectangle rectangle, double durationSeconds, double distance) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(durationSeconds), rectangle);
        transition.setToX(rectangle.getTranslateX() + distance); // Adjust the value as needed
        transition.play();
    }

    public static void moveText(Text text, double durationSeconds, double distance) {
        if (text == null) {
            System.out.println("Error: Text is null.");
            return;
        }

        TranslateTransition transition = new TranslateTransition(Duration.seconds(durationSeconds), text);
        transition.setToX(text.getTranslateX() + distance); // Adjust the value as needed
        transition.play();
    }

    @FXML
    public void exitAddPaper(MouseEvent event) {
        movePaneRight();
        addPaperButton.setDisable(false);
        fadeRectangle(rectangleAdd, 0.5, 0.5, 1);
        moveRectangle(recAddHeader, 0.5, 170);
        moveText(addPaperText, 0.5, 170);
        System.out.println("Button exit add paper pressed");
    }

    private void movePaneRight() {
        movePane(addPaperPane, 0.5, 400);
        System.out.println("move pane successfully");

    }

    private void movePaneLeft() {
        movePane(addPaperPane, 0.5, -400);
        System.out.println("move pane successfully");
    }

    public static void movePane(Pane pane, double durationSeconds, int distance) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(durationSeconds), pane);
        transition.setToX(pane.getTranslateX() + distance); // Adjust the value as needed
        transition.play();
    }

    public void discardAction() {
        movePaneRight();
        addPaperButton.setDisable(false);
        fadeRectangle(rectangleAdd, 0.5, 0.5, 1);
        moveRectangle(recAddHeader, 0.5, 170);
        moveText(addPaperText, 0.5, 170);
        rTitleTF.setText("");
        rAuthorTF.setText("");
        rYearTF.setText("");
        rCourseTF.setText("");
        rDOITF.setText("");
        System.out.println("Button discard add paper pressed");        
    }

    
    // return new ImageView(imagePoster);
    // private String starring3 = "/castImage/DaveBautista.png";
    // FILE UPLOAD
    @FXML
    public void onFileChooseButtonClicked(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            configureFileChooser(fileChooser);

            File selectedFile = fileChooser.showOpenDialog(new Stage());
            if (selectedFile != null) {
            
                System.out.println("Selected File: " + selectedFile.getName());
                System.out.println("File Path: " + selectedFile.getAbsolutePath());
            }
        }
    private void configureFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("Choose a File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
    }

// ADD PAPER VALIDATION

    public void saveMethod(ActionEvent event) throws IOException {
        if (addPaperValidation()) {
            ResearchStorage.addNode(rTitleTF.getText(), rAuthorTF.getText(), rYearTF.getText(), rDOITF.getText(), rCourseTF.getText(), selectedType, listDoi);
            System.out.println("goods all validation pressed");
            rTitleTF.setText("");
            rAuthorTF.setText("");
            rYearTF.setText("");
            rCourseTF.setText("");
            rDOITF.setText("");
            listDoi = ResearchStorage.giveKeys();
            filterType(selectedType);
            loadPage(processArray(listDoi), 0);
        } 

    }

    

    public static void fadeInAndOut(Text text) {
        // Create a FadeTransition for the fade-in effect
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), text);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        // Create a FadeTransition for the fade-out effect
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), text);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        // Combine the fade-in and fade-out transitions
        fadeIn.setOnFinished(event -> fadeOut.play());

        // Start the fade-in animation
        fadeIn.play();
    }



    public boolean addPaperValidation() {
        

        boolean validationsPassed = true;

        try {
            String researchTitle = rTitleTF.getText();
            System.out.println("pasko na tlga");
            if (!(validateResearchTitle(researchTitle))) {
                System.out.println("pumasok qaqo");
                warninglabel1.setText("Research title cannot be empty");
                warninglabel1.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel1.setVisible(false);
                System.out.println("Research title validation passed");
            }
        } catch (Exception e) {
            warninglabel1.setText("Research title cannot be empty");
            warninglabel1.setVisible(true);
            validationsPassed = false;
        }

        try {
            String researchAuthor = rAuthorTF.getText();
            if (!(validateAuthors(researchAuthor))) {
                warninglabel2.setText("Enter author names as 'First Name|Last Name");
                warninglabel2.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel2.setVisible(false);
            }
        } catch (Exception e) {
            warninglabel2.setText("Enter author names as 'First Name|Last Name");
            warninglabel2.setVisible(true);
            validationsPassed = false;
        }

        try {
            String researchYearPublished = rYearTF.getText();
            if (!(validateYearPublished(researchYearPublished))) {
                warninglabel3.setText("Year should be 2023, 2022, 2021, or 2020");
                warninglabel3.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel3.setVisible(false);
            }
        } catch (Exception e) {
            warninglabel3.setText("Year should be 2023, 2022, 2021, or 2020");
            warninglabel3.setVisible(true);
            validationsPassed = false;
        }

        try {
            String researchCourse = rCourseTF.getText();
            if (!(validateCourseProgram(researchCourse))) {
                warninglabel4.setText("Course should be BSCS-ML, BSCS-DF, BSIT-MWA, or BSIT-MAA");
                warninglabel4.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel4.setVisible(false);
            }
        } catch (Exception e) {
            warninglabel4.setText("Course should be BSCS-ML, BSCS-DF, BSIT-MWA, or BSIT-MAA");
            warninglabel4.setVisible(true);
            validationsPassed = false;
        }

        try {
            String researchDoi = rDOITF.getText();
            if (!(validateResearchDOI(researchDoi))) {
                warninglabel5.setText("Follow the pattern '10.5678/xxxxxx' x can be alphanumeric");
                warninglabel5.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel5.setVisible(false);
            }
        } catch (Exception e) {
            warninglabel5.setText("Follow the pattern '10.5678/xxxxxx' x can be alphanumeric");
            warninglabel5.setVisible(true);
            validationsPassed = false;
        }

        if (validationsPassed) {
            System.out.println("All validations passed");
            return true;
        } else {
            System.out.println("Some validations failed");
            return false;
        }
    }


    
    public boolean validateResearchTitle(String researchTitle) {
        return !(researchTitle == null || researchTitle.isEmpty());
    }
    
    public boolean validateAuthors(String researchAuthor) {
        return researchAuthor.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$");
    }
    
    public boolean validateYearPublished(String researchYearPublished) {
        return researchYearPublished.matches("2023|2022|2021|2020");
    }
    
    public boolean validateCourseProgram(String researchCourse) {
        return researchCourse.matches("BSCS-ML|BSCS-DF|BSIT-MWA|BSIT-MAA");
    }
    
    public boolean validateResearchDOI(String researchDOI) {
        return researchDOI.matches("10\\.5678/[a-zA-Z0-9]+");
    }

    private static final Duration FADE_DURATION = Duration.seconds(0.5); // Fade duration in milliseconds

    private void fadePane(Pane pane, boolean show) {
        if (show) {
            // Set the pane to visible and fade it in
            pane.setVisible(true);
            FadeTransition fadeIn = new FadeTransition(FADE_DURATION, pane);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        } else {
            // Fade out the pane
            FadeTransition fadeOut = new FadeTransition(FADE_DURATION, pane);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> pane.setVisible(false));
            fadeOut.play();
        }
    }

    public void showPaneTool1() {
        fadePane(paneTool1, true);
        System.out.println(pane1Doi);
    }

    public void hidePaneTool1() {
        fadePane(paneTool1, false);
    }

    public void showPaneTool2() {
        fadePane(paneTool2, true);
        System.out.println(pane2Doi);
    }

    public void hidePaneTool2() {
        fadePane(paneTool2, false);
    }

    public void showPaneTool3() {
        fadePane(paneTool3, true);
        System.out.println(pane3Doi);
    }

    public void hidePaneTool3() {
        fadePane(paneTool3, false);
    }

    public void showPaneTool4() {
        fadePane(paneTool4, true);
        System.out.println(pane4Doi);
    }

    public void hidePaneTool4() {
        fadePane(paneTool4, false);
    }

    public void showPaneTool5() {
        fadePane(paneTool5, true);
        System.out.println(pane5Doi);
    }

    public void hidePaneTool5() {
        fadePane(paneTool5, false);
    }

    public void showPaneTool6() {
        fadePane(paneTool6, true);
        System.out.println(pane6Doi);
    }

    public void hidePaneTool6() {
        fadePane(paneTool6, false);
    }

    public void showPaneTool7() {
        fadePane(paneTool7, true);
        System.out.println(pane7Doi);
    }

    public void hidePaneTool7() {
        fadePane(paneTool7, false);
    }

    public void showPaneTool8() {
        fadePane(paneTool8, true);
        System.out.println(pane8Doi);

    }

    public void hidePaneTool8() {
        fadePane(paneTool8, false);
    }
    
    public void deleteButton(String doiString) {
        System.out.println("delete button pressed");
    }

    public void editButtonClicked() {
        movePaneV(editPaperPane, -600);
        System.out.println("edit button pressed");
        editButton1.setDisable(true);
        editButton2.setDisable(true);
        editButton3.setDisable(true);
        editButton4.setDisable(true);
        editButton5.setDisable(true);
        editButton6.setDisable(true);
        editButton7.setDisable(true);
        editButton8.setDisable(true);
        editPaperPane.setDisable(false);

    }

    public void editExited() {
        movePaneV(editPaperPane, 600);
        System.out.println("edit button pressed");
        editButton1.setDisable(false);
        editButton2.setDisable(false);
        editButton3.setDisable(false);
        editButton4.setDisable(false);
        editButton5.setDisable(false);
        editButton6.setDisable(false);
        editButton7.setDisable(false);
        editButton8.setDisable(false);
        editPaperPane.setDisable(true);
    }


    private static final Duration DURATIONV = Duration.seconds(1.0);
    public static void movePaneV(Pane pane, double distance) {
        TranslateTransition transition = new TranslateTransition(DURATIONV, pane);

        // Set the starting Y coordinate (assuming the current Y position)
        transition.setFromY(pane.getTranslateY());

        // Set the ending Y coordinate by adding the specified distance
        transition.setToY(pane.getTranslateY() + distance);

        // Play the animation
        transition.play();
    }

    public void deleteButtonClicked() {
        movePane(deletePane, 0.5, 400);
        System.out.println("delete button pressed");
        deleteButton1.setDisable(true);
        deleteButton2.setDisable(true);
        deleteButton3.setDisable(true);
        deleteButton4.setDisable(true);
        deleteButton5.setDisable(true);
        deleteButton6.setDisable(true);
        deleteButton7.setDisable(true);
        deleteButton8.setDisable(true);
    }

    public void deleteButtonExited() {
        movePane(deletePane, 0.5, -400);
        System.out.println("delete button pressed");
        deleteButton1.setDisable(false);
        deleteButton2.setDisable(false);
        deleteButton3.setDisable(false);
        deleteButton4.setDisable(false);
        deleteButton5.setDisable(false);
        deleteButton6.setDisable(false);
        deleteButton7.setDisable(false);
        deleteButton8.setDisable(false);
    }

    public void deleteButtton1Clicked() {
        deleteButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane1Doi);
        inLineForDeleteDoi = pane1Doi;
        resTitleDe.setText(currentNode.getResearchTitle());
        resAuthorDe.setText(currentNode.getResearchAuthor());
        resCourseDe.setText(currentNode.getResearchCourse());
        resYearPubDe.setText(currentNode.getYearPublished());
        resDOIDe.setText(currentNode.getResearchDOI());
    } 

    public void deleteButtton2Clicked() {
        deleteButtonClicked();
        inLineForDeleteDoi = pane2Doi;
        Node currentNode = ResearchStorage.getNode(pane2Doi);
        resTitleDe.setText(currentNode.getResearchTitle());
        resAuthorDe.setText(currentNode.getResearchAuthor());
        resCourseDe.setText(currentNode.getResearchCourse());
        resYearPubDe.setText(currentNode.getYearPublished());
        resDOIDe.setText(currentNode.getResearchDOI());
    }

    public void deleteButtton3Clicked() {
        deleteButtonClicked();
        inLineForDeleteDoi = pane3Doi;
        Node currentNode = ResearchStorage.getNode(pane3Doi);
        resTitleDe.setText(currentNode.getResearchTitle());
        resAuthorDe.setText(currentNode.getResearchAuthor());
        resCourseDe.setText(currentNode.getResearchCourse());
        resYearPubDe.setText(currentNode.getYearPublished());
        resDOIDe.setText(currentNode.getResearchDOI());
    }

    public void deleteButtton4Clicked() {
        deleteButtonClicked();
        inLineForDeleteDoi = pane4Doi;
        Node currentNode = ResearchStorage.getNode(pane4Doi);
        resTitleDe.setText(currentNode.getResearchTitle());
        resAuthorDe.setText(currentNode.getResearchAuthor());
        resCourseDe.setText(currentNode.getResearchCourse());
        resYearPubDe.setText(currentNode.getYearPublished());
        resDOIDe.setText(currentNode.getResearchDOI());
    }

    public void deleteButtton5Clicked() {
        deleteButtonClicked();
        inLineForDeleteDoi = pane5Doi;
        Node currentNode = ResearchStorage.getNode(pane5Doi);
        resTitleDe.setText(currentNode.getResearchTitle());
        resAuthorDe.setText(currentNode.getResearchAuthor());
        resCourseDe.setText(currentNode.getResearchCourse());
        resYearPubDe.setText(currentNode.getYearPublished());
        resDOIDe.setText(currentNode.getResearchDOI());
    }

    public void deleteButtton6Clicked() {
        deleteButtonClicked();
        inLineForDeleteDoi = pane6Doi;
        Node currentNode = ResearchStorage.getNode(pane6Doi);
        resTitleDe.setText(currentNode.getResearchTitle());
        resAuthorDe.setText(currentNode.getResearchAuthor());
        resCourseDe.setText(currentNode.getResearchCourse());
        resYearPubDe.setText(currentNode.getYearPublished());
        resDOIDe.setText(currentNode.getResearchDOI());
    }

    public void deleteButtton7Clicked() {
        deleteButtonClicked();
        inLineForDeleteDoi = pane7Doi;
        Node currentNode = ResearchStorage.getNode(pane7Doi);
        resTitleDe.setText(currentNode.getResearchTitle());
        resAuthorDe.setText(currentNode.getResearchAuthor());
        resCourseDe.setText(currentNode.getResearchCourse());
        resYearPubDe.setText(currentNode.getYearPublished());
        resDOIDe.setText(currentNode.getResearchDOI());
    }

    public void deleteButtton8Clicked() {
        deleteButtonClicked();
        inLineForDeleteDoi = pane8Doi;
        Node currentNode = ResearchStorage.getNode(pane8Doi);
        resTitleDe.setText(currentNode.getResearchTitle());
        resAuthorDe.setText(currentNode.getResearchAuthor());
        resCourseDe.setText(currentNode.getResearchCourse());
        resYearPubDe.setText(currentNode.getYearPublished());
        resDOIDe.setText(currentNode.getResearchDOI());
    }

    public void deleteButtonSubmit() {
        System.out.println("pasok");
        Node currentNodeDelete = ResearchStorage.getNode(inLineForDeleteDoi);
        ResearchStorage.deleteNode(currentNodeDelete);
        deleteButtonExited();
        listDoi = ResearchStorage.giveKeys();
        loadPage(processArray(listDoi), 0);
    }

    public void editButtonClicked1 () {
        editButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane1Doi);
        inLineForEditDoi = pane1Doi;
        rTitleTF1.setPromptText(currentNode.getResearchTitle());
        rAuthorTF1.setPromptText(currentNode.getResearchAuthor());
        rCourseTF1.setPromptText(currentNode.getResearchCourse());
        rYearTF1.setPromptText(currentNode.getYearPublished());
        rDOITF1.setPromptText(currentNode.getResearchDOI());
    }

    public void editButtonClicked2 () {
        editButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane2Doi);
        inLineForEditDoi = pane2Doi;
        rTitleTF1.setPromptText(currentNode.getResearchTitle());
        rAuthorTF1.setPromptText(currentNode.getResearchAuthor());
        rCourseTF1.setPromptText(currentNode.getResearchCourse());
        rYearTF1.setPromptText(currentNode.getYearPublished());
        rDOITF1.setPromptText(currentNode.getResearchDOI());
    }

    public void editButtonClicked3 () {
        editButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane3Doi);
        inLineForEditDoi = pane3Doi;
        rTitleTF1.setPromptText(currentNode.getResearchTitle());
        rAuthorTF1.setPromptText(currentNode.getResearchAuthor());
        rCourseTF1.setPromptText(currentNode.getResearchCourse());
        rYearTF1.setPromptText(currentNode.getYearPublished());
        rDOITF1.setPromptText(currentNode.getResearchDOI());
    }

    public void editButtonClicked4 () {
        editButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane4Doi);
        inLineForEditDoi = pane4Doi;
        rTitleTF1.setPromptText(currentNode.getResearchTitle());
        rAuthorTF1.setPromptText(currentNode.getResearchAuthor());
        rCourseTF1.setPromptText(currentNode.getResearchCourse());
        rYearTF1.setPromptText(currentNode.getYearPublished());
        rDOITF1.setPromptText(currentNode.getResearchDOI());
    }

    public void editButtonClicked5 () {
        editButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane5Doi);
        inLineForEditDoi = pane5Doi;
        rTitleTF1.setPromptText(currentNode.getResearchTitle());
        rAuthorTF1.setPromptText(currentNode.getResearchAuthor());
        rCourseTF1.setPromptText(currentNode.getResearchCourse());
        rYearTF1.setPromptText(currentNode.getYearPublished());
        rDOITF1.setPromptText(currentNode.getResearchDOI());
    }

    public void editButtonClicked6 () {
        editButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane6Doi);
        inLineForEditDoi = pane6Doi;
        rTitleTF1.setPromptText(currentNode.getResearchTitle());
        rAuthorTF1.setPromptText(currentNode.getResearchAuthor());
        rCourseTF1.setPromptText(currentNode.getResearchCourse());
        rYearTF1.setPromptText(currentNode.getYearPublished());
        rDOITF1.setPromptText(currentNode.getResearchDOI());
    }

    public void editButtonClicked7 () {
        editButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane7Doi);
        inLineForEditDoi = pane7Doi;
        rTitleTF1.setPromptText(currentNode.getResearchTitle());
        rAuthorTF1.setPromptText(currentNode.getResearchAuthor());
        rCourseTF1.setPromptText(currentNode.getResearchCourse());
        rYearTF1.setPromptText(currentNode.getYearPublished());
        rDOITF1.setPromptText(currentNode.getResearchDOI());
    }

    public void editButtonClicked8 () {
        editButtonClicked();
        Node currentNode = ResearchStorage.getNode(pane8Doi);
        inLineForEditDoi = pane8Doi;
        rTitleTF1.setPromptText(currentNode.getResearchTitle());
        rAuthorTF1.setPromptText(currentNode.getResearchAuthor());
        rCourseTF1.setPromptText(currentNode.getResearchCourse());
        rYearTF1.setPromptText(currentNode.getYearPublished());
        rDOITF1.setPromptText(currentNode.getResearchDOI());
    }

    public void editDiscard() {
        editExited();
        rTitleTF1.setText("");
        rAuthorTF1.setText("");
        rCourseTF1.setText("");
        rYearTF1.setText("");
        rDOITF1.setText("");
    }

    public void editSubmit() {
        if (editPaperValidation()) {
            ResearchStorage.addNode(rTitleTF1.getText(), rAuthorTF1.getText(), rYearTF1.getText(), rDOITF1.getText(), rCourseTF1.getText(), selectedType, listDoi);
            System.out.println("goods all validation pressed");
            rTitleTF1.setText("");
            rAuthorTF1.setText("");
            rYearTF1.setText("");
            rCourseTF1.setText("");
            rDOITF1.setText("");
            ResearchStorage.deleteNode(ResearchStorage.getNode(inLineForEditDoi));
            listDoi = ResearchStorage.giveKeys();
            filterType(selectedType);
            loadPage(processArray(listDoi), 0);
        } 
    }

    public boolean editPaperValidation() {
        

        boolean validationsPassed = true;

        try {
            String researchTitle = rTitleTF1.getText();
            System.out.println("pasko na tlga");
            if (!(validateResearchTitle(researchTitle))) {
                System.out.println("pumasok qaqo");
                warninglabel11.setText("Research title cannot be empty");
                warninglabel11.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel11.setVisible(false);
                System.out.println("Research title validation passed");
            }
        } catch (Exception e) {
            warninglabel11.setText("Research title cannot be empty");
            warninglabel11.setVisible(true);
            validationsPassed = false;
        }

        try {
            String researchAuthor = rAuthorTF1.getText();
            if (!(validateAuthors(researchAuthor))) {
                warninglabel21.setText("Enter author names as 'First Name|Last Name");
                warninglabel21.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel21.setVisible(false);
            }
        } catch (Exception e) {
            warninglabel21.setText("Enter author names as 'First Name|Last Name");
            warninglabel21.setVisible(true);
            validationsPassed = false;
        }

        try {
            String researchYearPublished = rYearTF1.getText();
            if (!(validateYearPublished(researchYearPublished))) {
                warninglabel31.setText("Year should be 2023, 2022, 2021, or 2020");
                warninglabel31.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel3.setVisible(false);
            }
        } catch (Exception e) {
            warninglabel31.setText("Year should be 2023, 2022, 2021, or 2020");
            warninglabel31.setVisible(true);
            validationsPassed = false;
        }

        try {
            String researchCourse = rCourseTF1.getText();
            if (!(validateCourseProgram(researchCourse))) {
                warninglabel41.setText("Course should be BSCS-ML, BSCS-DF, BSIT-MWA, or BSIT-MAA");
                warninglabel41.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel41.setVisible(false);
            }
        } catch (Exception e) {
            warninglabel41.setText("Course should be BSCS-ML, BSCS-DF, BSIT-MWA, or BSIT-MAA");
            warninglabel41.setVisible(true);
            validationsPassed = false;
        }

        try {
            String researchDoi = rDOITF1.getText();
            if (!(validateResearchDOI(researchDoi))) {
                warninglabel51.setText("Follow the pattern '10.5678/xxxxxx' x can be alphanumeric");
                warninglabel51.setVisible(true);
                validationsPassed = false;
            } else {
                warninglabel51.setVisible(false);
            }
        } catch (Exception e) {
            warninglabel51.setText("Follow the pattern '10.5678/xxxxxx' x can be alphanumeric");
            warninglabel51.setVisible(true);
            validationsPassed = false;
        }

        if (validationsPassed) {
            System.out.println("All validations passed");
            return true;
        } else {
            System.out.println("Some validations failed");
            return false;
        }
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void profile(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/A_Profile.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void home(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/A_Home - copy.fxml"));
        Parent root = loader.load();
        a_HomeController = loader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        // // Sample ArrayList of Strings
        // ArrayList<String> arrayList = new ArrayList<>();
        // arrayList.add("Apple");
        // arrayList.add("Banana");
        // arrayList.add("Orange");

        // // Initial String array
        // String[] stringArray = {"Grapes", "Cherry", "Lemon"};

        // // Call the method to append ArrayList elements to the String array

        // // Print the updated String array
        // System.out.println("Updated String array: " + Arrays.toString(stringArray));
    }

    
}
