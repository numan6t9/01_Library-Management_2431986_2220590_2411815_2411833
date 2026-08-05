package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ProcessBookReturnsViewController {
    @javafx.fxml.FXML
    private TableView tblBooks;
    @javafx.fxml.FXML
    private Button btnSearch;
    @javafx.fxml.FXML
    private Label lblStatus;
    @javafx.fxml.FXML
    private TextField bookIDTF;
    @javafx.fxml.FXML
    private TableColumn dueDateTC;
    @javafx.fxml.FXML
    private TextField dueDateTF;
    @javafx.fxml.FXML
    private DatePicker returnDateDP;
    @javafx.fxml.FXML
    private TableColumn bookIDTC;
    @javafx.fxml.FXML
    private TextField fineTF;
    @javafx.fxml.FXML
    private TextField issueDateTF;
    @javafx.fxml.FXML
    private TableColumn issueDateTC;
    @javafx.fxml.FXML
    private RadioButton lostRB;
    @javafx.fxml.FXML
    private TextField memberIDTF;
    @javafx.fxml.FXML
    private RadioButton damagedRB;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TextField titleTF;
    @javafx.fxml.FXML
    private RadioButton goodRB;
    @javafx.fxml.FXML
    private AnchorPane processBookReturnMainPane;

    @javafx.fxml.FXML
    public void searchIssuedBooks(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        processBookReturnMainPane.getChildren().setAll(node);


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
