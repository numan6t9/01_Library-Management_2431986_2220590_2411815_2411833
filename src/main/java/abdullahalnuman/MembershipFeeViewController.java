package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
}