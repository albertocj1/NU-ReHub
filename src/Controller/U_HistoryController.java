package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.HistoryStack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class U_HistoryController implements Initializable{

    HistoryStack history_stack = new HistoryStack();

    @FXML
    Button discover, explore, favorite, home, profile, logout;


    @FXML
    Text rTitle1, rTitle2, rTitle3, rTitle4, rTitle5, rTitle6, rTitle7, rTitle8, rTitle9;

    @FXML
    Text rAuthor1, rAuthor2, rAuthor3, rAuthor4, rAuthor5, rAuthor6, rAuthor7, rAuthor8, rAuthor9;

    @FXML
    Text rYear1, rYear2, rYear3, rYear4, rYear5, rYear6, rYear7, rYear8, rYear9;

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9;

    Object[][] separatedArray = HistoryStack.separateStackElements(history_stack.getHistoryStack());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData(separatedArray);

    }

    public void setData(Object[][] separatedArray){

        for (int i = 1; i <= 9; i++) {
            getCorrespondingPane(i).setVisible(i <= separatedArray.length);
        }

        if(separatedArray.length != 0){
        for (int i = 0; i < Math.min(separatedArray.length, 9); i++) {
            Text title = getCorrespondingTitle(i + 1);
            if (title != null) {
                title.setText(String.valueOf(separatedArray[i][0]));
            }

            Text author = getCorrespondingAuthor(i + 1);
            if (author != null) {
                author.setText(String.valueOf(separatedArray[i][1]));
            }

            Text year = getCorrespondingYear(i + 1);
            if (year != null) {
                year.setText(String.valueOf(separatedArray[i][2]));
            }

        }
    }
        else{
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane4.setVisible(false);
            pane5.setVisible(false);
            pane6.setVisible(false);
            pane7.setVisible(false);
            pane8.setVisible(false);
            pane9.setVisible(false);
        }
    }

    private Text getCorrespondingTitle(int index) {
        switch (index) {
            case 1:
                return rTitle1;
            case 2:
                return rTitle2;
            case 3:
                return rTitle3;
            case 4:
                return rTitle4;
            case 5:
                return rTitle5;
            case 6:
                return rTitle6;
            case 7:
                return rTitle7;
            case 8:
                return rTitle8;
            case 9:
                return rTitle9;
            default:
                return null;
        }
    }
    private Text getCorrespondingAuthor(int index) {
        switch (index) {
            case 1:
                return rAuthor1;
            case 2:
                return rAuthor2;
            case 3:
                return rAuthor3;
            case 4:
                return rAuthor4;
            case 5:
                return rAuthor5;
            case 6:
                return rAuthor6;
            case 7:
                return rAuthor7;
            case 8:
                return rAuthor8;
            case 9:
                return rAuthor9;
            default:
                return null;
        }
    }
    
    private Text getCorrespondingYear(int index) {
        switch (index) {
            case 1:
                return rYear1;
            case 2:
                return rYear2;
            case 3:
                return rYear3;
            case 4:
                return rYear4;
            case 5:
                return rYear5;
            case 6:
                return rYear6;
            case 7:
                return rYear7;
            case 8:
                return rYear8;
            case 9:
                return rYear9;
            default:
                return null;
        }
    }

    private Pane getCorrespondingPane(int index) {
        switch (index) {
            case 1:
                return pane1;
            case 2:
                return pane2;
            case 3:
                return pane3;
            case 4:
                return pane4;
            case 5:
                return pane5;
            case 6:
                return pane6;
            case 7:
                return pane7;
            case 8:
                return pane8;
            case 9:
                return pane9;
            default:
                return null;
        }
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

        U_FavoritesController controller = loader.getController();
        controller.initialize();
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

}
