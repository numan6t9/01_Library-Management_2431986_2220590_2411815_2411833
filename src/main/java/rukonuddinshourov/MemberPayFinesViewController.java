package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import nonuser.PaymentFileHelper;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MemberPayFinesViewController implements Initializable {


    @FXML private TextField memberNameTF;
    @FXML private TextField memberIdTF;


    @FXML private TextField fineIdTF;
    @FXML private TextField booktitleTF;
    @FXML private TextField duedateTF;
    @FXML private TextField dayslateTF;
    @FXML private TextField fineamountTF;


    @FXML private TextField cardmobileNumberTF;
    @FXML private TextField transectionIdTF;
    @FXML private TextField fineAmountTF;


    @FXML private RadioButton creditdabitCardRB;
    @FXML private RadioButton mobileBankingRB;
    @FXML private RadioButton cashRB;

    @FXML private AnchorPane memberPayFinesMainPane;

    private ToggleGroup paymentGroup;


    private boolean fineLoaded = false;
    private boolean payFineClicked = false;
    private boolean isPaid = false;
    private String fineStatus = "Unpaid";
    private double fineAmount = 0;
    private int daysLate = 0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        paymentGroup = new ToggleGroup();
        creditdabitCardRB.setToggleGroup(paymentGroup);
        mobileBankingRB.setToggleGroup(paymentGroup);
        cashRB.setToggleGroup(paymentGroup);

        memberNameTF.setEditable(false);
        fineIdTF.setEditable(false);
        booktitleTF.setEditable(false);
        duedateTF.setEditable(false);
        dayslateTF.setEditable(false);
        fineamountTF.setEditable(false);
        fineAmountTF.setEditable(false);
        transectionIdTF.setEditable(false);

        setPaymentSectionDisabled(true);
    }


    @FXML
    public void viewFineOnActionButton(ActionEvent actionEvent) {

        String memberId = memberIdTF.getText().trim();

        if (memberId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please enter Member ID!");
            return;
        }

        if (!memberId.matches("[A-Za-z0-9]{3,10}")) {
            showAlert(Alert.AlertType.ERROR, "Invalid Member ID format!");
            return;
        }


        String fineId = "F-1001";
        LocalDate dueDate = LocalDate.now().minusDays(24);
        daysLate = (int) ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        fineAmount = daysLate * 5.0;

        memberNameTF.setText("Rukon Uddin Shourov");
        fineIdTF.setText(fineId);
        booktitleTF.setText("Java Programming");
        duedateTF.setText(dueDate.toString());
        dayslateTF.setText(String.valueOf(daysLate));
        fineamountTF.setText(String.valueOf(fineAmount));


        if (PaymentFileHelper.isFinePaid(fineId)) {

            fineStatus = "Paid";
            isPaid = true;
            fineLoaded = true;
            setPaymentSectionDisabled(true);

            FinePayment last = PaymentFileHelper.getLastPayment(memberId);

            if (last != null) {
                transectionIdTF.setText(last.getTransactionId());
                fineAmountTF.setText(String.valueOf(last.getAmount()));
            }

            showAlert(Alert.AlertType.INFORMATION,
                    "This fine is ALREADY PAID.\n\n" +
                            "Transaction ID : " + transectionIdTF.getText());
            return;
        }

        fineStatus = "Unpaid";
        fineLoaded = true;
        payFineClicked = false;
        isPaid = false;

        showAlert(Alert.AlertType.INFORMATION,
                "Fine Details Loaded\n\n" +
                        "Fine ID     : " + fineId + "\n" +
                        "Days Late   : " + daysLate + "\n" +
                        "Fine Amount : " + fineAmount + " TK\n" +
                        "Status      : " + fineStatus);
    }


    @FXML
    public void payFineOnActionButton(ActionEvent actionEvent) {

        if (!fineLoaded) {
            showAlert(Alert.AlertType.WARNING, "Click 'View Fine' first!");
            return;
        }

        if (isPaid) {
            showAlert(Alert.AlertType.INFORMATION, "This fine is already PAID.");
            return;
        }

        fineAmountTF.setText(String.valueOf(fineAmount));
        setPaymentSectionDisabled(false);
        payFineClicked = true;

        showAlert(Alert.AlertType.INFORMATION,
                "Choose payment method and enter payment information.");
    }


    private boolean validatePayment() {

        if (!payFineClicked) {
            showAlert(Alert.AlertType.WARNING, "Click 'Pay Fine' first!");
            return false;
        }

        RadioButton selected = (RadioButton) paymentGroup.getSelectedToggle();

        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Select a payment method!");
            return false;
        }

        String method = selected.getText();

        if (!method.equalsIgnoreCase("Cash")) {

            String number = cardmobileNumberTF.getText().trim();

            if (number.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Enter Card / Mobile Number!");
                return false;
            }

            if (!number.matches("\\d+")) {
                showAlert(Alert.AlertType.ERROR, "Digits only!");
                return false;
            }

            if (method.equalsIgnoreCase("Mobile Banking") && number.length() != 11) {
                showAlert(Alert.AlertType.ERROR, "Mobile number must be 11 digits!");
                return false;
            }

            if (method.equalsIgnoreCase("Credit/Debit Card") && number.length() != 16) {
                showAlert(Alert.AlertType.ERROR, "Card number must be 16 digits!");
                return false;
            }
        }

        if (fineAmount <= 0) {
            showAlert(Alert.AlertType.ERROR, "Invalid fine amount!");
            return false;
        }

        return true;
    }


    @FXML
    public void confirmPaymentOnActionButton(ActionEvent actionEvent) {

        if (isPaid) {
            showAlert(Alert.AlertType.INFORMATION, "Payment already completed.");
            return;
        }

        if (!validatePayment()) return;

        RadioButton selected = (RadioButton) paymentGroup.getSelectedToggle();
        String method = selected.getText();

        String txnId = "TXN" + (100000 + new Random().nextInt(900000));
        transectionIdTF.setText(txnId);

        fineStatus = "Paid";
        isPaid = true;

        String time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a"));


        FinePayment payment = new FinePayment(
                memberIdTF.getText(),
                memberNameTF.getText(),
                fineIdTF.getText(),
                booktitleTF.getText(),
                duedateTF.getText(),
                daysLate,
                fineAmount,
                method,
                txnId,
                fineStatus,
                time
        );

        PaymentFileHelper.savePayment(payment);

        setPaymentSectionDisabled(true);

        showAlert(Alert.AlertType.INFORMATION,
                "✅ PAYMENT SUCCESSFUL & SAVED\n\n" +
                        "Member ID      : " + memberIdTF.getText() + "\n" +
                        "Fine ID        : " + fineIdTF.getText() + "\n" +
                        "Payment Method : " + method + "\n" +
                        "Amount Paid    : " + fineAmount + " TK\n" +
                        "Transaction ID : " + txnId + "\n" +
                        "Status         : " + fineStatus);
    }


    @FXML
    public void printReceiptOnActionButton(ActionEvent actionEvent) {

        String memberId = memberIdTF.getText().trim();

        if (memberId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Enter Member ID first!");
            return;
        }

        ArrayList<FinePayment> history =
                PaymentFileHelper.getMemberPayments(memberId);

        if (history.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "No payment history found!");
            return;
        }

        FinePayment last = history.get(history.size() - 1);

        StringBuilder sb = new StringBuilder();

        sb.append("========== PAYMENT RECEIPT ==========\n\n");
        sb.append("Member Name    : ").append(last.getMemberName()).append("\n");
        sb.append("Member ID      : ").append(last.getMemberId()).append("\n");
        sb.append("-------------------------------------\n");
        sb.append("Fine ID        : ").append(last.getFineId()).append("\n");
        sb.append("Book Title     : ").append(last.getBookTitle()).append("\n");
        sb.append("Due Date       : ").append(last.getDueDate()).append("\n");
        sb.append("Days Late      : ").append(last.getDaysLate()).append("\n");
        sb.append("-------------------------------------\n");
        sb.append("Payment Method : ").append(last.getPaymentMethod()).append("\n");
        sb.append("Transaction ID : ").append(last.getTransactionId()).append("\n");
        sb.append("Amount Paid    : ").append(last.getAmount()).append(" TK\n");
        sb.append("Status         : ").append(last.getStatus()).append("\n");
        sb.append("Date & Time    : ").append(last.getDateTime()).append("\n");
        sb.append("=====================================\n\n");

        sb.append(">>> PAYMENT HISTORY (").append(history.size()).append(" records)\n\n");

        double total = 0;
        for (FinePayment p : history) {
            sb.append("• ").append(p.getDateTime())
                    .append(" | ").append(p.getFineId())
                    .append(" | ").append(p.getAmount()).append(" TK")
                    .append(" | ").append(p.getPaymentMethod())
                    .append(" | ").append(p.getTransactionId())
                    .append("\n");
            total += p.getAmount();
        }

        sb.append("\n-------------------------------------\n");
        sb.append("TOTAL PAID : ").append(total).append(" TK\n");
        sb.append("=====================================");

        TextArea area = new TextArea(sb.toString());
        area.setEditable(false);
        area.setPrefSize(480, 480);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Receipt");
        alert.setHeaderText("Library Fine Payment Receipt");
        alert.getDialogPane().setContent(area);
        alert.showAndWait();
    }


    @FXML
    public void closeOnActionButton(ActionEvent actionEvent) {

        memberNameTF.clear();
        memberIdTF.clear();
        fineIdTF.clear();
        booktitleTF.clear();
        duedateTF.clear();
        dayslateTF.clear();
        fineamountTF.clear();
        fineAmountTF.clear();
        cardmobileNumberTF.clear();
        transectionIdTF.clear();

        paymentGroup.selectToggle(null);

        fineLoaded = false;
        payFineClicked = false;
        isPaid = false;
        fineStatus = "Unpaid";
        fineAmount = 0;
        daysLate = 0;

        setPaymentSectionDisabled(true);

        showAlert(Alert.AlertType.INFORMATION, "All fields cleared.");
    }


    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardview.fxml"));

        Node node = fxmlLoader.load();
        memberPayFinesMainPane.getChildren().setAll(node);
    }


    private void setPaymentSectionDisabled(boolean disable) {
        creditdabitCardRB.setDisable(disable);
        mobileBankingRB.setDisable(disable);
        cashRB.setDisable(disable);
        cardmobileNumberTF.setDisable(disable);
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}