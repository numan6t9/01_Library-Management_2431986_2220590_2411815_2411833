package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DeactivateMemberAccountViewController {

    @javafx.fxml.FXML
    private TextField memberNameTF;
    @javafx.fxml.FXML
    private TextArea warningTA;
    @javafx.fxml.FXML
    private RadioButton noRB;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private TextField memberIdTF;
    @javafx.fxml.FXML
    private RadioButton yesRB;
    @javafx.fxml.FXML
    private Label deactivatelabell;
    @javafx.fxml.FXML
    private AnchorPane deactivateAccountMainPane;

    @javafx.fxml.FXML
    public void deleteAccountOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();

        deactivateAccountMainPane.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void deactivateAccountOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmOnActionButton(ActionEvent actionEvent) {
    }
}
