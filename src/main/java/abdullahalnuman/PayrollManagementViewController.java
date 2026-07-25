package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PayrollManagementViewController
{
    @javafx.fxml.FXML
    private TextField selectEmployeeId;
    @javafx.fxml.FXML
    private DatePicker toPayrollPeriod;
    @javafx.fxml.FXML
    private DatePicker fromPayrollPeriod;
    @javafx.fxml.FXML
    private TextField bonusAmount;
    @javafx.fxml.FXML
    private Label showNetSalary;
    @javafx.fxml.FXML
    private Label showStatus;
    @javafx.fxml.FXML
    private TextField overtimeSalary;
    @javafx.fxml.FXML
    private TextField grossSalary;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void paySalaryAndGenerateReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateNetSalaryAndShow(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ShowMembersPayrollStatusButton(ActionEvent actionEvent) {
    }
}