package rukonuddinshourov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GenerateLibraryReportsViewController implements Initializable {

    @FXML private TableColumn<Report, String> memberIdTC;
    @FXML private TableColumn<Report, String> bookTitleTC;
    @FXML private TableColumn<Report, String> categoryBooksTC;
    @FXML private TableColumn<Report, String> borrowedDateTC;
    @FXML private TableColumn<Report, String> returnedTC;
    @FXML private TableColumn<Report, String> dateTC;

    @FXML private ComboBox<String> categoryCB;
    @FXML private ComboBox<String> reportTypeCB;
    @FXML private DatePicker fromDateDP;
    @FXML private DatePicker toDateDP;
    @FXML private DatePicker generateDP;

    @FXML private TextField totalRecordTF;
    @FXML private TextField statusTF;

    @FXML private AnchorPane libraryReportMainPane;

    private ObservableList<Report> reportList = FXCollections.observableArrayList();
    @FXML
    private TableView reportTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Fill ComboBoxes
        reportTypeCB.setItems(FXCollections.observableArrayList(
                "Circulation", "Membership", "Inventory"
        ));

        categoryCB.setItems(FXCollections.observableArrayList(
                "Science", "Math", "History", "Novel"
        ));

        // Set Table Columns
        memberIdTC.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        bookTitleTC.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        categoryBooksTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        borrowedDateTC.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
        returnedTC.setCellValueFactory(new PropertyValueFactory<>("returned"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        generateDP.setValue(LocalDate.now());
    }

    @FXML
    public void generateButtonOnAction(ActionEvent actionEvent) {

        if (fromDateDP.getValue() == null || toDateDP.getValue() == null) {
            statusTF.setText("Select date range!");
            return;
        }

        reportList.clear();

        reportList.add(new Report("M101", "Java Book", "Science",
                LocalDate.of(2026, 8, 1), "Yes", LocalDate.of(2026, 8, 5)));

        reportList.add(new Report("M102", "Math Algebra", "Math",
                LocalDate.of(2026, 8, 2), "No", LocalDate.of(2026, 8, 8)));

        reportTableView.setItems(reportList);

        totalRecordTF.setText(String.valueOf(reportList.size()));
        statusTF.setText("Report Generated");
        generateDP.setValue(LocalDate.now());
    }

    @FXML
    public void clearButtonOnAction(ActionEvent actionEvent) {
        reportTableView.getItems().clear();
        totalRecordTF.clear();
        statusTF.clear();
        fromDateDP.setValue(null);
        toDateDP.setValue(null);
    }

    @FXML
    public void exportPdfButtonOnAction(ActionEvent actionEvent) {
        statusTF.setText("PDF Exported Successfully (Demo)");
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        libraryReportMainPane.getChildren().setAll(node);
    }
}