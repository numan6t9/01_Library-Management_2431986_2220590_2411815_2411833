package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MemberPayFinesViewController {

    @javafx.fxml.FXML
    private TextField memberNameTF;
    @javafx.fxml.FXML
    private TextField fineAmountTF;
    @javafx.fxml.FXML
    private TextField booktitleTF;
    @javafx.fxml.FXML
    private TextField cardmobileNumberTF;
    @javafx.fxml.FXML
    private TextField fineIdTF;
    @javafx.fxml.FXML
    private TextField memberIdTF;
    @javafx.fxml.FXML
    private TextField fineamountTF;
    @javafx.fxml.FXML
    private TextField transectionIdTF;
    @javafx.fxml.FXML
    private RadioButton mobileBankingRB;
    @javafx.fxml.FXML
    private RadioButton creditdabitCardRB;
    @javafx.fxml.FXML
    private TextField duedateTF;
    @javafx.fxml.FXML
    private TextField dayslateTF;
    @javafx.fxml.FXML
    private RadioButton cashRB;
    @javafx.fxml.FXML
    private AnchorPane memberPayFinesMainPane;

    @javafx.fxml.FXML
    public void printReceiptOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewFineOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void payFineOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void closeOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmPaymentOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardview.fxml"));
        Node node = fxmlLoader.load();
        memberPayFinesMainPane.getChildren().setAll(node);


    }
}
