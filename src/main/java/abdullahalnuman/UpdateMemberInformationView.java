package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UpdateMemberInformationView
{
    @javafx.fxml.FXML
    private Label showMemberId;
    @javafx.fxml.FXML
    private TextField enterMemberId;
    @javafx.fxml.FXML
    private Label showMemberName;
    @javafx.fxml.FXML
    private TextField updateEmail;
    @javafx.fxml.FXML
    private TextField enterMemberName;
    @javafx.fxml.FXML
    private TextField updateAddress;
    @javafx.fxml.FXML
    private Label showEmailAddress;
    @javafx.fxml.FXML
    private Label showAddress;
    @javafx.fxml.FXML
    private TextField updateName;
    @javafx.fxml.FXML
    private AnchorPane memberInformationMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateMemberAndInformationAndSaveButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchMemberButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        memberInformationMainPane.getChildren().setAll(node);
    }
}