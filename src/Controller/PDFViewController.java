package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PDFViewController implements Initializable {

    @FXML
    WebView webView;

    private WebEngine engine;
    private WebHistory history;
    private String homePage;
    private double webZoom;

    @FXML
    Button home;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        engine = webView.getEngine();
        homePage = "https://drive.google.com/file/d/1Y3CIM3mM_LfuPcOc1K7a4bX804cSYedL/view?usp=sharing";
        //textField.setText(homePage);
        //webZoom = 1;
        loadPage();
    }

    public void loadPage() {

        //engine.load("http://www.google.com%22/);
        engine.load(homePage);
    }

    @FXML
    public void gotoHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/U_Home.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
    
