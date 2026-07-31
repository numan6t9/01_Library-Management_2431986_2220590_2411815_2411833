package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MembershipFeeViewController
{
    @javafx.fxml.FXML
    private ComboBox selectPaymentMethodComboBox;
    @javafx.fxml.FXML
    private TableView membershipFeeTableVIew;
    @javafx.fxml.FXML
    private TableColumn applicationIdTableView;
    @javafx.fxml.FXML
    private TableColumn membershipTypeTableView;
    @javafx.fxml.FXML
    private TableColumn applicantNameTableView;
    @javafx.fxml.FXML
    private DatePicker paymentDate;
    @javafx.fxml.FXML
    private TextField enterApplicantIdToSeeAmount;
    @javafx.fxml.FXML
    private Label showTotalPayableAmount;
    @javafx.fxml.FXML
    private AnchorPane memerbshipFeeMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void selectApplicantButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateMembershipIDandPaymentReceipt(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void payNowButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        memerbshipFeeMainPane.getChildren().setAll(node);
    }
}