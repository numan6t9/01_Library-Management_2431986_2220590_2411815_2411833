package cse213finalproject._1_librarymanagement_2431986_2220590_2411815_2411833;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginViewController
{
    @javafx.fxml.FXML
    private ComboBox <String>userTypeComboBox;
    @javafx.fxml.FXML
    private TextField enterUserId;
    @javafx.fxml.FXML
    private AnchorPane loginMainPane;
    @javafx.fxml.FXML
    private PasswordField enterPassword;
    @javafx.fxml.FXML
    private TextField enterUserName;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Accountant","Receptionist","Librarian","Member");

    }

    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) throws IOException {

        if (userTypeComboBox.getValue().equals("Accountant")){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("abdullahalnuman/AccountantDashboardView.fxml"));
            Node node = fxmlLoader.load();
            loginMainPane.getChildren().setAll(node);
        }
        if (userTypeComboBox.getValue().equals("Receptionist")){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("abdullahalnuman/ReceptionistDashboardView.fxml"));
            Node node = fxmlLoader.load();
            loginMainPane.getChildren().setAll(node);

        }
        if (userTypeComboBox.getValue().equals("Member")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rukonuddinshourov/memberDashboardView.fxml"));
            Node node = fxmlLoader.load();
            loginMainPane.getChildren().setAll(node);


        }
        if (userTypeComboBox.getValue().equals("Librarian")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rukonuddinshourov/LibrarianDashboardView.fxml"));
            Node node = fxmlLoader.load();
            loginMainPane.getChildren().setAll(node);

        }

    }
}