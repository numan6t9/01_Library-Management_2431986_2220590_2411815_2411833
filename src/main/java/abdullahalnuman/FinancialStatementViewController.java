package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FinancialStatementViewController
{
    @javafx.fxml.FXML
    private DatePicker fiscalPeriodFrom;
    @javafx.fxml.FXML
    private TableView financialStatementTableView;
    @javafx.fxml.FXML
    private Label showTotalIncome;
    @javafx.fxml.FXML
    private TableColumn membershipFeeTableView;
    @javafx.fxml.FXML
    private TableColumn libraryExpensesTableView;
    @javafx.fxml.FXML
    private Label showTotalExpenditure;
    @javafx.fxml.FXML
    private AnchorPane financialStatementMainPane;
    @javafx.fxml.FXML
    private DatePicker fiscalPeriodTo;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadFinancialRecordsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateTotalIncomeAndExpenditureButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        financialStatementMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void generateFinancialStatementAndExportReportButton(ActionEvent actionEvent) {
    }
}