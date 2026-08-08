package rukonuddinshourov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BorrowingHistoryViewController {

    @FXML private TableView<BorrowHistory> borrowHistoryTableView;

    @FXML private TableColumn<BorrowHistory,String> bookIdTC;
    @FXML private TableColumn<BorrowHistory,String> bookTitleTC;
    @FXML private TableColumn<BorrowHistory,String> borrowTC;
    @FXML private TableColumn<BorrowHistory,String> dueDateTC;
    @FXML private TableColumn<BorrowHistory,String> returnDateTC;
    @FXML private TableColumn<BorrowHistory,String> statusTC;

    @FXML private TextField bookSearchTF;
    @FXML private ComboBox<String> statusCB;
    @FXML private AnchorPane borrowingHistoryMainPane;

    private ObservableList<BorrowHistory> historyList =
            FXCollections.observableArrayList();
    @FXML
    private Label borrowingHistoryLB;

    @FXML
    public void initialize() {

        statusCB.setItems(FXCollections.observableArrayList(
                "Borrowed", "Returned", "Overdue"
        ));

        bookIdTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookTitleTC.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        borrowTC.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        dueDateTC.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        returnDateTC.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Demo Data
        historyList.addAll(
                new BorrowHistory("B101","Java","01-08-2026","10-08-2026","08-08-2026","Returned"),
                new BorrowHistory("B102","Database","02-08-2026","12-08-2026","", "Borrowed"),
                new BorrowHistory("B103","Math","25-07-2026","05-08-2026","", "Overdue")
        );

        borrowHistoryTableView.setItems(historyList);
    }

    @FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        bookSearchTF.clear();
        statusCB.setValue(null);
        borrowHistoryTableView.setItems(historyList);
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        borrowingHistoryMainPane.getChildren().setAll(node);
    }

    @FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @FXML
    public void printOnActionButton(ActionEvent actionEvent) {
    }
}