package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import nonuser.Fine;

import java.time.LocalDate;

public class FineCollectionViewController
{
    @javafx.fxml.FXML
    private TextField enterPaymentInformation;
    @javafx.fxml.FXML
    private TextField enterMemberId;
    @javafx.fxml.FXML
    private TableColumn<Fine, LocalDate> bookReturnDateTableView;
    @javafx.fxml.FXML
    private Label showTotalFine;
    @javafx.fxml.FXML
    private TextField overdueDays;
    @javafx.fxml.FXML
    private TableColumn <Fine,String>borrowedBookTableView;
    @javafx.fxml.FXML
    private TableView <Fine>fineCollectionTableView;
    @javafx.fxml.FXML
    private TextField finePerDay;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void payFineNowButton(ActionEvent actionEvent) {
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