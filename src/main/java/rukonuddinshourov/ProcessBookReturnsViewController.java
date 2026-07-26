package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ProcessBookReturnsViewController {
    @javafx.fxml.FXML
    private TableView tblBooks;
    @javafx.fxml.FXML
    private TableColumn colIssueDate;
    @javafx.fxml.FXML
    private RadioButton rbGood;
    @javafx.fxml.FXML
    private Button btnSearch;
    @javafx.fxml.FXML
    private RadioButton rbLost;
    @javafx.fxml.FXML
    private TextField txtBookID;
    @javafx.fxml.FXML
    private RadioButton rbDamaged;
    @javafx.fxml.FXML
    private Label lblStatus;
    @javafx.fxml.FXML
    private TableColumn colBookID;
    @javafx.fxml.FXML
    private TextField txtDueDate;
    @javafx.fxml.FXML
    private TableColumn colDueDate;
    @javafx.fxml.FXML
    private TextField txtFine;
    @javafx.fxml.FXML
    private DatePicker dpReturnDate;
    @javafx.fxml.FXML
    private TableColumn colTitle;
    @javafx.fxml.FXML
    private TextField memberID;
    @javafx.fxml.FXML
    private TableColumn colStatus;
    @javafx.fxml.FXML
    private TextField txtTitle;
    @javafx.fxml.FXML
    private TextField txtIssueDate;

    @javafx.fxml.FXML
    public void searchIssuedBooks(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateFineOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void returnBookOnActionButton(ActionEvent actionEvent) {
    }
}
