package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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
    private AnchorPane payrollMainPane;

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

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        payrollMainPane.getChildren().setAll(node);

    }
}