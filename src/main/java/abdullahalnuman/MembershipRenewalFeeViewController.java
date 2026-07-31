package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MembershipRenewalFeeViewController
{
    @javafx.fxml.FXML
    private TextField enterMemberIdToSelect;
    @javafx.fxml.FXML
    private TableColumn expiredDateTableView;
    @javafx.fxml.FXML
    private TableColumn memberNameTableView;
    @javafx.fxml.FXML
    private TextField enterpaymentInformation;
    @javafx.fxml.FXML
    private TableColumn memberIdTableView;
    @javafx.fxml.FXML
    private TextField renewalFee;
    @javafx.fxml.FXML
    private TextField lateRenewalFine;
    @javafx.fxml.FXML
    private CheckBox expiredMemberCheckbox;
    @javafx.fxml.FXML
    private Label showTotalRenewalFees;
    @javafx.fxml.FXML
    private TableView renewalFeeTableView;
    @javafx.fxml.FXML
    private AnchorPane renewalFeeMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateMemberStatusAndGenerateRenewalReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void PayNowBButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateRenewalFeeButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void selectMemberButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadAllMemberButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        renewalFeeMainPane.getChildren().setAll(node);
    }
}