package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.function.ObjIntConsumer;

public class BudgetManagementViewController
{
    @javafx.fxml.FXML
    private TextField staffPayroll;
    @javafx.fxml.FXML
    private TextField libraryMaintencance;
    @javafx.fxml.FXML
    private Label showTotalExpenses;
    @javafx.fxml.FXML
    private ComboBox chooseBudgetComboBox;
    @javafx.fxml.FXML
    private DatePicker fromBudgetPeriod;
    @javafx.fxml.FXML
    private Label showRemainingButton;
    @javafx.fxml.FXML
    private TextField digitalResources;
    @javafx.fxml.FXML
    private DatePicker toBudgetPeriod;
    @javafx.fxml.FXML
    private Label showAvailableBudget;
    @javafx.fxml.FXML
    private TextField bookAcquisition;
    @javafx.fxml.FXML
    private TextField miscellaneousExpenses;
    @javafx.fxml.FXML
    private AnchorPane budgetManagementMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateAllocationReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateExpensesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateBudgetButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateRemainingBudgetButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showAvailableBudgetButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        budgetManagementMainPane.getChildren().setAll(node);

    }
}