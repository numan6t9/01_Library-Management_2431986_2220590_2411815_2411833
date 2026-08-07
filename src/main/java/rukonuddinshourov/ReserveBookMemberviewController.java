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
import javafx.scene.layout.GridPane;
import nonuser.Book;

//import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReserveBookMemberviewController implements Initializable {

    @FXML
    private TableView<Book> tblBooks;

    @FXML
    private TableColumn<Book, String> booIdTC;

    @FXML
    private TableColumn<Book, String> TitlebookTC;

    @FXML
    private TableColumn<Book, String> AuthorTC;

    @FXML
    private TableColumn<Book, String> StatusTC;

    @FXML
    private TextField BookIDTF;

    @FXML
    private TextField TitleTF;

    @FXML
    private TextField AvailabilityTF;

    @FXML
    private TextField searchbookTF;

    @FXML
    private TextField memberIDTC;

    @FXML
    private DatePicker ReservationDate;

    @FXML
    private Label lblMessage;

    @FXML
    private AnchorPane reserveBookMainPane;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();
    @FXML
    private Button btnSearch;
    @FXML
    private GridPane reserveDateDP;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // ✅ Connect table columns with Book class
        booIdTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        TitlebookTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        AuthorTC.setCellValueFactory(new PropertyValueFactory<>("author"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // ✅ Sample Data
        bookList.addAll(
                new Book("B101", "Java Programming", "James Gosling", "Available"),
                new Book("B102", "Database System", "Elmasri", "Reserved"),
                new Book("B103", "Operating System", "Silberschatz", "Available")
        );

        tblBooks.setItems(bookList);

        // ✅ When selecting a row, fill text fields
        tblBooks.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                BookIDTF.setText(newVal.getBookId());
                TitleTF.setText(newVal.getTitle());
                AvailabilityTF.setText(newVal.getStatus());
            }
        });
    }

    // ✅ Search Book
    @FXML
    public void searchBook(ActionEvent event) {

        String keyword = searchbookTF.getText().toLowerCase();

        ObservableList<Book> filteredList = FXCollections.observableArrayList();

        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(keyword)
                    || book.getBookId().toLowerCase().contains(keyword)) {
                filteredList.add(book);
            }
        }

        tblBooks.setItems(filteredList);

        if (filteredList.isEmpty()) {
            lblMessage.setText("No book found.");
        } else {
            lblMessage.setText("Search completed.");
        }
    }

    // ✅ Reserve Book
    @FXML
    public void reserveBookOnActionButton(ActionEvent event) {

        Book selectedBook = tblBooks.getSelectionModel().getSelectedItem();
        LocalDate date = ReservationDate.getValue();
        String memberId = memberIDTC.getText();

        if (selectedBook == null) {
            lblMessage.setText("Please select a book.");
            return;
        }

        if (memberId == null || memberId.isEmpty()) {
            lblMessage.setText("Member ID required.");
            return;
        }

        if (date == null) {
            lblMessage.setText("Select reservation date.");
            return;
        }

        // ✅ Check availability
        if (!selectedBook.getStatus().equalsIgnoreCase("Available")) {
            lblMessage.setText("Book is not available.");
            return;
        }

        // ✅ Simple eligibility check
        if (memberId.startsWith("0")) {
            lblMessage.setText("Member not eligible.");
            return;
        }

        // ✅ Reserve
        selectedBook.setStatus("Reserved");
        tblBooks.refresh();

        lblMessage.setText("Reservation successful on " + date);
    }

    // ✅ Clear Button
    @FXML
    public void clearButtonOnAction(ActionEvent event) {

        BookIDTF.clear();
        TitleTF.clear();
        AvailabilityTF.clear();
        searchbookTF.clear();
        ReservationDate.setValue(null);
        lblMessage.setText("");

        tblBooks.setItems(bookList);
    }

    // ✅ Back Button
    @FXML
    public void backButtonOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));

        Node node = loader.load();
        reserveBookMainPane.getChildren().setAll(node);
    }
}