package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageOverdueBooksandFinesViewController
{
    @javafx.fxml.FXML
    private TextField enterPaymentInformation;
    @javafx.fxml.FXML
    private TextField enterMemberId;
    @javafx.fxml.FXML
    private TableColumn bookReturnDateTableView1;
    @javafx.fxml.FXML
    private TableColumn bookReturnDateTableView;
    @javafx.fxml.FXML
    private Label showTotalFine;
    @javafx.fxml.FXML
    private TextField overdueDays;
    @javafx.fxml.FXML
    private TableColumn borrowedBookTableView;
    @javafx.fxml.FXML
    private TableView fineCollectionTableView;
    @javafx.fxml.FXML
    private TextField finePerDay;
    @javafx.fxml.FXML
    private TextField paymentStatus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void payFineNowButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void notificationSendToMember(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchMemberButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateFineButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateFineReceiptButton(ActionEvent actionEvent) {
    }
}