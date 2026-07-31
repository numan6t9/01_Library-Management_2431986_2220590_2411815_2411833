package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AccountantDashboardViewController
{

    @javafx.fxml.FXML
    private AnchorPane accountantMainPane;

    //initialize
    @javafx.fxml.FXML
    public void initialize() {


    }


// buttons




    @javafx.fxml.FXML
    public void FinancialStatementButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/FinancialStatementView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void SupplierPaymentsButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/SupplierPaymentsView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void MembershipFeesButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/MembershipFeeView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);
    }


    @javafx.fxml.FXML
    public void LogoutButtonForAccountant(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/LoginView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);



    }

    @javafx.fxml.FXML
    public void BudgetManagementButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/BudgetManagementView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void PayrollManagementButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/PayrollManagementView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void FineCollectionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/FineCollectionView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void AnnualBudgetReportButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AnnualBudgetReportView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);
    }

    @FXML
    public void membershipRenewalButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/MembershipRenewalFeeView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);
    }
}
