package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class BorrowingHistoryViewController {
    @javafx.fxml.FXML
    private TableColumn returnDate;
    @javafx.fxml.FXML
    private TextField bookSearch;
    @javafx.fxml.FXML
    private TableColumn dueDate;
    @javafx.fxml.FXML
    private TableColumn statusCheck;
    @javafx.fxml.FXML
    private TableColumn borrow;
    @javafx.fxml.FXML
    private ComboBox status;
    @javafx.fxml.FXML
    private TableColumn bookId;
    @javafx.fxml.FXML
    private TableColumn bookTitle;

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void printOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void closeOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }
}
