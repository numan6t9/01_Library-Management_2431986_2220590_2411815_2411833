package rukonuddinshourov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nonuser.OverdueRecord;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class ManageOverdueBooksandFinesViewController implements Initializable {

    @FXML private TextField enterMemberIdTF;
    @FXML private TextField finePerDayTF;
    @FXML private TextField overdueDaysTF;
    @FXML private TextField paymentStatusTF;
    @FXML private TextField enterPaymentInformationTF;

    @FXML private Label finetoPayLB;
    @FXML private TableView<OverdueRecord> fineCollectionTableView;
    @FXML private TableColumn<OverdueRecord, String> borrowedBookTC;
    @FXML private TableColumn<OverdueRecord, String> bookReturnDateTC;
    @FXML private TableColumn<OverdueRecord, String> bookReturnTC;

    @FXML private AnchorPane manageoverDueandFineMainPane;

    private ObservableList<OverdueRecord> overdueList = FXCollections.observableArrayList();
    private double totalFine = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        borrowedBookTC.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        bookReturnDateTC.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        bookReturnTC.setCellValueFactory(new PropertyValueFactory<>("issueDate"));

        fineCollectionTableView.setItems(overdueList);


        finePerDayTF.setText("10");
    }


    @FXML
    public void searchMemberOnActionButton(ActionEvent actionEvent) {

        String memberId = enterMemberIdTF.getText().trim();

        if (memberId.isEmpty()) {
            showAlert("Please enter Member ID!");
            return;
        }

        overdueList.clear();
        totalFine = 0;

        overdueList.add(new OverdueRecord("Java Programming", LocalDate.now().minusDays(15), LocalDate.now().minusDays(25)));
        overdueList.add(new OverdueRecord("Database System", LocalDate.now().minusDays(8), LocalDate.now().minusDays(20)));
        overdueList.add(new OverdueRecord("Operating System", LocalDate.now().minusDays(12), LocalDate.now().minusDays(30)));

        paymentStatusTF.clear();
        enterPaymentInformationTF.clear();
        finetoPayLB.setText("Fine to pay");

        showAlert("Overdue records found for Member: " + memberId);
    }


    @FXML
    public void calculateFineOnActionButton(ActionEvent actionEvent) {

        if (overdueList.isEmpty()) {
            showAlert("No overdue books found! Search first.");
            return;
        }

        double finePerDay = 10.0;
        try {
            finePerDay = Double.parseDouble(finePerDayTF.getText());
        } catch (Exception e) {
            finePerDayTF.setText("10");
        }

        long totalDays = 0;
        totalFine = 0;

        for (OverdueRecord record : overdueList) {
            long days = ChronoUnit.DAYS.between(record.getDueDate(), LocalDate.now());
            if (days > 0) {
                totalDays += days;
                totalFine += days * finePerDay;
            }
        }

        overdueDaysTF.setText(String.valueOf(totalDays));
        finetoPayLB.setText(totalFine + " TK");

        showAlert("Fine Calculated Successfully!");
    }

    @FXML
    public void payFineNowButton(ActionEvent actionEvent) {

        if (totalFine <= 0) {
            showAlert("Please calculate fine first!");
            return;
        }

        if (enterPaymentInformationTF.getText().trim().isEmpty()) {
            showAlert("Please enter payment information (Transaction ID / Reference)!");
            return;
        }

        paymentStatusTF.setText("PAID ✅");
        finetoPayLB.setText("Paid: " + totalFine + " TK");

        showAlert("Payment Successful!\nAmount: " + totalFine + " TK");
    }

    @FXML
    public void generateFineReceiptOnActionButton(ActionEvent actionEvent) {

        if (totalFine == 0) {
            showAlert("No payment record found!");
            return;
        }

        String receipt = """
                ========== OVERDUE FINE RECEIPT ==========
                
                Member ID          : %s
                Total Overdue Days : %s
                Fine Per Day       : %s TK
                Total Fine         : %s TK
                Payment Status     : %s
                Payment Info       : %s
                Date               : %s
                =========================================
                Thank You!
                """.formatted(
                enterMemberIdTF.getText(),
                overdueDaysTF.getText(),
                finePerDayTF.getText(),
                totalFine,
                paymentStatusTF.getText(),
                enterPaymentInformationTF.getText(),
                LocalDate.now()
        );

        TextArea textArea = new TextArea(receipt);
        textArea.setEditable(false);
        textArea.setPrefSize(400, 350);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fine Receipt");
        alert.setHeaderText("Overdue Fine Receipt");
        alert.getDialogPane().setContent(textArea);
        alert.showAndWait();
    }


    @FXML
    public void notificationSendToMemberOnActionButton(ActionEvent actionEvent) {
        if (overdueList.isEmpty()) {
            showAlert("No member selected!");
            return;
        }
        showAlert("Notification sent to member successfully!");
    }


    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = loader.load();
        manageoverDueandFineMainPane.getChildren().setAll(node);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}