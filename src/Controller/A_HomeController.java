package Controller;

import java.io.IOException;

import javax.swing.Action;

import Model.ResearchStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node; 

public class A_HomeController {

    static String selectedTypeChoosen = "";

    @FXML
    Button btAddPDF;
    
    @FXML
    Pane pane1, pane2, pane3, pane4, pane5;

    @FXML
    Button btInternship, btCapstone, btThesis;

    @FXML
    ImageView nuimage, profileimage, homeimage, logoutimage, internshipimage, capstoneimage, thesisimage;

    public void initialize() {
        
        setAllImageViews();
    }

    public static void main(String[] args) {
        
    }

    public void clickInternshipPane(ActionEvent event) throws IOException{
        System.out.println("Internship Pane Clicked");
        selectedTypeChoosen = "Internship";
        shiftToAdmin(event);
    }

    public void clickThesisPane(ActionEvent event) throws IOException{
        System.out.println("Thesis Pane Clicked");
        selectedTypeChoosen = "Thesis";
        shiftToAdmin(event);
    }

    public void clickCapstonePane(ActionEvent event) throws IOException{
        System.out.println("Capstone Pane Clicked");
        selectedTypeChoosen = "Capstone";
        shiftToAdmin(event);
    }

    @FXML
    public void shiftToAdmin(ActionEvent event) throws IOException {
        A_InternshipController.selectedType = selectedTypeChoosen;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/A_Internship.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
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
        setImageFromFilePath(homeimage, "src/Images/home (1).png");
        setImageFromFilePath(internshipimage, "src/Images/logout.png");
        setImageFromFilePath(capstoneimage, "src/Images/user.png");
        setImageFromFilePath(thesisimage, "src/Images/home(1).png");
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
    public void logout(ActionEvent event) throws IOException {
    
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}