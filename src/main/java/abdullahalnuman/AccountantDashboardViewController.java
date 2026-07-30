package abdullahalnuman;

import javafx.event.ActionEvent;
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
    public void FinancialReportsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void FinancialStatementButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SupplierPaymentsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void MembershipFeesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AuditReportsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LogoutButtonForAccountant(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/LoginView.fxml"));
        Node node = fxmlLoader.load();
        accountantMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void BudgetManagementButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void PayrollManagementButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void FineCollectionButton(ActionEvent actionEvent) {
    }
}
