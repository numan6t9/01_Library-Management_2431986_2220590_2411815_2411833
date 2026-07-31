package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManageBookReservationViewController
{
    @javafx.fxml.FXML
    private Label showReservationApproved;
    @javafx.fxml.FXML
    private TextField enterMemberId;
    @javafx.fxml.FXML
    private TextField enterBookName;
    @javafx.fxml.FXML
    private TextField enterMemberName;
    @javafx.fxml.FXML
    private CheckBox notEligibleCheckBox;
    @javafx.fxml.FXML
    private CheckBox eligibleCheckBox;
    @javafx.fxml.FXML
    private AnchorPane bookReservationMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void approveReservationButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchMemberButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        bookReservationMainPane.getChildren().setAll(node);
    }
}