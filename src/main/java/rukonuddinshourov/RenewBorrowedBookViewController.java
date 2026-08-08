package rukonuddinshourov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import nonuser.IssuedBook;

import java.io.IOException;
import java.time.LocalDate;

public class RenewBorrowedBookViewController {

    @FXML private TableColumn<IssuedBook, String> bookIdBorrow;
    @FXML private TableColumn<IssuedBook, String> Title;
    @FXML private TableColumn<IssuedBook, String> BorrowDate;
    @FXML private TableColumn<IssuedBook, String> DueDatebook;
    @FXML private TableColumn<IssuedBook, String> Status;

    @FXML private TableView<IssuedBook> tblBorrowedBooks;

    @FXML private TextField BookID;
    @FXML private TextField bookTitle;
    @FXML private TextField DueDate;
    @FXML private DatePicker NewDueDate;

    @FXML private Button btnRenew;
    @FXML private Button btnBack;
    @FXML private Button btnLogout;
    @FXML private Label renewborrowedbooks;
    @FXML private BorderPane renewBorrowedBooksMainPane;

    private ObservableList<IssuedBook> borrowedBooksList =
            FXCollections.observableArrayList();

    private IssuedBook selectedBook = null;

    // ================= Initialize =================
    @FXML
    public void initialize() {

        BookID.setEditable(false);
        bookTitle.setEditable(false);
        DueDate.setEditable(false);

        // Table Column Setup
        bookIdBorrow.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        Title.setCellValueFactory(new PropertyValueFactory<>("title"));
        BorrowDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        DueDatebook.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        Status.setCellValueFactory(new PropertyValueFactory<>("status"));

        // ✅ Demo Data (IssuedBook constructor match)
        borrowedBooksList.addAll(
                new IssuedBook("B101", "Java", "M001",
                        LocalDate.of(2026, 8, 1),
                        LocalDate.of(2026, 8, 10),
                        "Borrowed"),

                new IssuedBook("B102", "Database", "M002",
                        LocalDate.of(2026, 8, 2),
                        LocalDate.of(2026, 8, 12),
                        "Borrowed"),

                new IssuedBook("B103", "Math", "M003",
                        LocalDate.of(2026, 7, 25),
                        LocalDate.of(2026, 8, 5),
                        "Overdue"),

                new IssuedBook("B104", "Clean Code", "M004",
                        LocalDate.of(2026, 8, 5),
                        LocalDate.of(2026, 8, 15),
                        "Borrowed")
        );

        tblBorrowedBooks.setItems(borrowedBooksList);

        // ✅ Row Select → Auto Fill
        tblBorrowedBooks.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        selectedBook = newVal;
                        BookID.setText(newVal.getBookId());
                        bookTitle.setText(newVal.getTitle());
                        DueDate.setText(newVal.getDueDate().toString());
                        NewDueDate.setValue(null);
                    }
                });
    }

    // ================= Renew Button =================
    @FXML
    public void renewBookOnActionButton(ActionEvent actionEvent) {

        if (selectedBook == null) {
            showAlert("Please select a book from the table!");
            return;
        }

        if (selectedBook.getStatus().equalsIgnoreCase("Returned")) {
            showAlert("Cannot renew returned book!");
            return;
        }

        if (selectedBook.getStatus().equalsIgnoreCase("Overdue")) {
            showAlert("Cannot renew overdue book! Pay fine first.");
            return;
        }

        if (NewDueDate.getValue() == null) {
            showAlert("Please select a New Due Date!");
            return;
        }

        if (NewDueDate.getValue().isBefore(selectedBook.getDueDate())) {
            showAlert("New Due Date must be after Current Due Date!");
            return;
        }

        LocalDate maxDate = selectedBook.getDueDate().plusDays(14);
        if (NewDueDate.getValue().isAfter(maxDate)) {
            showAlert("Maximum renewal is 14 days only!");
            return;
        }

        // ✅ Renew
        selectedBook.getDueDate();
        tblBorrowedBooks.refresh();
        DueDate.setText(selectedBook.getDueDate().toString());

        showAlert("Book renewed successfully!\nNew Due Date: "
                + selectedBook.getDueDate());
    }

    // ================= Clear Button =================
    @FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
        BookID.clear();
        bookTitle.clear();
        DueDate.clear();
        NewDueDate.setValue(null);
        selectedBook = null;
        tblBorrowedBooks.getSelectionModel().clearSelection();
    }

    // ================= Back Button =================
    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        renewBorrowedBooksMainPane.getChildren().setAll(node);
    }

    // ================= Logout Button =================
    @FXML
    public void logoutOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/LoginView.fxml"));
        Node node = fxmlLoader.load();
        renewBorrowedBooksMainPane.getChildren().setAll(node);
    }

    // ✅ Helper Method
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}