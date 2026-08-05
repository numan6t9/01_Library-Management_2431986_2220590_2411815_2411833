package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AnnualBudgetReportViewController
{
    @javafx.fxml.FXML
    private AnchorPane annualBudgetMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        annualBudgetMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void retrieveFinancialRecords(ActionEvent actionEvent) {
    }
}