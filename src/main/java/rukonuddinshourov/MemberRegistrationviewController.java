package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MemberRegistrationviewController {

    @javafx.fxml.FXML
    private TextArea addressTA;
    @javafx.fxml.FXML
    private TextField fullNameTF;
    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private PasswordField PasswordPF;
    @javafx.fxml.FXML
    private TextField userNameTF;
    @javafx.fxml.FXML
    private TextField librarianNameTF;
    @javafx.fxml.FXML
    private RadioButton femaleRB;
    @javafx.fxml.FXML
    private RadioButton otherRB;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private RadioButton maleRB;
    @javafx.fxml.FXML
    private DatePicker birthDateDP;
    @javafx.fxml.FXML
    private TextField librarianIdTF;
    @javafx.fxml.FXML
    private PasswordField ConfirmPasswordPF;
    @javafx.fxml.FXML
    private BorderPane memberRegistrasionMainPane;

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        memberRegistrasionMainPane.getChildren().setAll(node);

    }


    @javafx.fxml.FXML
    public void registerOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearOnActionbutton(ActionEvent actionEvent) {
    }
}
