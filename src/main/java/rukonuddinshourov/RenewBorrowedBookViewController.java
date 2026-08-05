package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class RenewBorrowedBookViewController {
    @javafx.fxml.FXML
    private TableColumn Status;
    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private Button btnLogout;
    @javafx.fxml.FXML
    private TableColumn DueDatebook;
    @javafx.fxml.FXML
    private DatePicker NewDueDate;
    @javafx.fxml.FXML
    private TableColumn Title;
    @javafx.fxml.FXML
    private TableColumn bookIdBorrow;
    @javafx.fxml.FXML
    private Label renewborrowedbooks;
    @javafx.fxml.FXML
    private TableView tblBorrowedBooks;
    @javafx.fxml.FXML
    private TextField BookID;
    @javafx.fxml.FXML
    private TextField DueDate;
    @javafx.fxml.FXML
    private TableColumn BorrowDate;
    @javafx.fxml.FXML
    private TextField bookTitle;
    @javafx.fxml.FXML
    private Button btnRenew;
    @javafx.fxml.FXML
    private BorderPane renewBorrowedBooksMainPane;

    @javafx.fxml.FXML
    public void logoutOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        renewBorrowedBooksMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void renewBookOnActionButton(ActionEvent actionEvent) {
    }
}
