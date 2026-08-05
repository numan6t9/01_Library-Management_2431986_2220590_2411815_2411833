package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MemberpersonalprofileupdateViewController {

    @javafx.fxml.FXML
    private ComboBox genderCB;
    @javafx.fxml.FXML
    private TextField lastNameTF;
    @javafx.fxml.FXML
    private TextField emailIdTF;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthDP;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private TextField adressTF;
    @javafx.fxml.FXML
    private PasswordField passswordPF;
    @javafx.fxml.FXML
    private PasswordField confirmPasswordPF;
    @javafx.fxml.FXML
    private TextField firstNameTF;
    @javafx.fxml.FXML
    private TextField memberIdTF;
    @javafx.fxml.FXML
    private AnchorPane memberprofileUpdateMainPane;

    @javafx.fxml.FXML
    public void cancelButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void confirmButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void savechangeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        memberprofileUpdateMainPane.getChildren().setAll(node);

    }
}
