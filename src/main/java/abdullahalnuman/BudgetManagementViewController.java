package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
}