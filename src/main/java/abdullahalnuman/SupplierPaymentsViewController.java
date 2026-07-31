package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.Payment;

import java.io.IOException;

public class SupplierPaymentsViewController
{
    @javafx.fxml.FXML
    private TableColumn<Payment,String> invoiceIdTableView;
    @javafx.fxml.FXML
    private TextField enterInvoiceNumber;
    @javafx.fxml.FXML
    private TextField selectInvoiceFromListForProccedPayment;
    @javafx.fxml.FXML
    private TableColumn<Payment,String> supplierIdTableView;
    @javafx.fxml.FXML
    private TextField enterSupplierId;
    @javafx.fxml.FXML
    private TableView <Payment>TableView;
    @javafx.fxml.FXML
    private AnchorPane supplierPaymentsMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void paySupplierButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchUnpaidSupplierAndLoadTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/AccountantDashboardView.fxml"));
        Node node = fxmlLoader.load();
        supplierPaymentsMainPane.getChildren().setAll(node);


    }
}

