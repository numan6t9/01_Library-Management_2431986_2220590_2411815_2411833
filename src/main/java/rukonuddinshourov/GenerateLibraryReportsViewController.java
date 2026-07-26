package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class GenerateLibraryReportsViewController {
    @javafx.fxml.FXML
    private TableColumn date;
    @javafx.fxml.FXML
    private DatePicker toDate;
    @javafx.fxml.FXML
    private TextField totalRecord;
    @javafx.fxml.FXML
    private ComboBox reportType;
    @javafx.fxml.FXML
    private DatePicker fromDate;
    @javafx.fxml.FXML
    private DatePicker generatedDate;
    @javafx.fxml.FXML
    private TableColumn borrowedDate;
    @javafx.fxml.FXML
    private TableColumn categoryBooks;
    @javafx.fxml.FXML
    private ComboBox category;
    @javafx.fxml.FXML
    private TableColumn returned;
    @javafx.fxml.FXML
    private TableColumn memberId;
    @javafx.fxml.FXML
    private TableColumn bookTitle;
    @javafx.fxml.FXML
    private TextField status;

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportPdfButton(ActionEvent actionEvent) {
    }
}
