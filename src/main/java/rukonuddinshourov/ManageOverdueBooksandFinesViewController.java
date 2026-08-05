package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ManageOverdueBooksandFinesViewController
{
    @javafx.fxml.FXML
    private TableView fineCollectionTableView;
    @javafx.fxml.FXML
    private TextField finePerDayTF;
    @javafx.fxml.FXML
    private TextField paymentStatusTF;
    @javafx.fxml.FXML
    private TableColumn bookReturnTC;
    @javafx.fxml.FXML
    private Label finetoPayLB;
    @javafx.fxml.FXML
    private TableColumn bookReturnDateTC;
    @javafx.fxml.FXML
    private TextField enterMemberIdTF;
    @javafx.fxml.FXML
    private TableColumn borrowedBookTC;
    @javafx.fxml.FXML
    private TextField overdueDaysTF;
    @javafx.fxml.FXML
    private TextField enterPaymentInformationTF;
    @javafx.fxml.FXML
    private AnchorPane manageoverDueandFineMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void payFineNowButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void notificationSendToMember(ActionEvent actionEvent) {
    }

    @Deprecated
    public void searchMemberButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void calculateFineButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void generateFineReceiptButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchMemberOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateFineReceiptOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateFineOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void notificationSendToMemberOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        manageoverDueandFineMainPane.getChildren().setAll(node);

    }
}