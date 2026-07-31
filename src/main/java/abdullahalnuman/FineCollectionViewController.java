package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.Fine;

import java.io.IOException;
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
    private AnchorPane fineCollectionMainPane;

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

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        fineCollectionMainPane.getChildren().setAll(node);
    }
}