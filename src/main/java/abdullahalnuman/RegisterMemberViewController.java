package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class RegisterMemberViewController
{
    @javafx.fxml.FXML
    private TextField enterMemberAge;
    @javafx.fxml.FXML
    private RadioButton genderFemaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton genderMaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton othersGenderradioButton;
    @javafx.fxml.FXML
    private TextField enterAddress;
    @javafx.fxml.FXML
    private TextField enterMemberName;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthOfTheMember;
    @javafx.fxml.FXML
    private Label showMembershipId;
    @javafx.fxml.FXML
    private TextField enterEmailAddress;
    @javafx.fxml.FXML
    private AnchorPane registerMemberMainPane;

    @javafx.fxml.FXML
    public void initialize() {


    }

    @javafx.fxml.FXML
    public void registerNewMemberAndGenerateIdButton(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        registerMemberMainPane.getChildren().setAll(node);
    }
}