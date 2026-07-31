package cse213finalproject._1_librarymanagement_2431986_2220590_2411815_2411833;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginViewController
{
    @javafx.fxml.FXML
    private TextField enterUserId;
    @javafx.fxml.FXML
    private PasswordField enterPassword;
    @javafx.fxml.FXML
    private TextField enterUserName;
    @javafx.fxml.FXML
    private AnchorPane loginMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        loginMainPane.getChildren().setAll(node);





        
    }
}