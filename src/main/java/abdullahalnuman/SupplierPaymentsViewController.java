package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import nonuser.Payment;

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
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void paySupplierButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchUnpaidSupplierAndLoadTable(ActionEvent actionEvent) {
    }
}

