package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GenerateLibraryReportsViewController {

    @javafx.fxml.FXML
    private TableColumn bookTitleTC;
    @javafx.fxml.FXML
    private TableColumn returnedTC;
    @javafx.fxml.FXML
    private DatePicker toDateDP;
    @javafx.fxml.FXML
    private TableColumn categoryBooksTC;
    @javafx.fxml.FXML
    private TableColumn dateTC;
    @javafx.fxml.FXML
    private TableColumn memberIdTC;
    @javafx.fxml.FXML
    private AnchorPane generateLibraryReportsMainPanel;
    @javafx.fxml.FXML
    private TextField totalRecordTF;
    @javafx.fxml.FXML
    private DatePicker fromDateDP;
    @javafx.fxml.FXML
    private DatePicker generateDP;
    @javafx.fxml.FXML
    private ComboBox categoryCB;
    @javafx.fxml.FXML
    private ComboBox reportTypeCB;
    @javafx.fxml.FXML
    private TextField statusTF;
    @javafx.fxml.FXML
    private TableColumn borrowedDateTC;

    @Deprecated
    public void clearButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void generateButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void exportPdfButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportPdfButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/LibrarianDashboardView.fxml"));
        Node node = fxmlLoader.load();

        generateLibraryReportsMainPanel.getChildren().setAll(node);


    }
}
