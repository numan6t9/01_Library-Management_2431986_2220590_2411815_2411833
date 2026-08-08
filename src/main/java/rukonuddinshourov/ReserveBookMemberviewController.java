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


        booIdTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        TitlebookTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        AuthorTC.setCellValueFactory(new PropertyValueFactory<>("author"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        bookList.addAll(
                new Book("B101","1111","Java Programming","James Gosling","Science",5,"Available"),
                new Book("B102","2222","Database System","Elmasri","Science",3,"Reserved"),
                new Book("B103","3333","Operating System","Silberschatz","Science",4,"Available"),
                new Book("B104","4444","Clean Code","Robert Martin","Science",6,"Available"),
                new Book("B105","5555","Java Basics","Herbert Schildt","Science",8,"Available"),
                new Book("B106","6666","Effective Java","Joshua Bloch","Science",2,"Reserved"),
                new Book("B107","7777","Database Systems","Elmasri","Science",4,"Available"),
                new Book("B108","8888","Operating Systems","Silberschatz","Science",9,"Available"),
                new Book("B109","9999","Artificial Intelligence","Russell Norvig","Science",3,"Unavailable"),
                new Book("B110","1010","Discrete Mathematics","Rosen","Math",15,"Available"),
                new Book("B111","1112","Data Structures","Mark Allen","Science",11,"Available"),
                new Book("B112","1113","Computer Networks","Andrew Tanenbaum","Science",5,"Available"),
                new Book("B113","1114","Software Engineering","Ian Sommerville","Science",6,"Available"),
                new Book("B114","1115","Linear Algebra","Gilbert Strang","Math",10,"Available"),
                new Book("B115","1116","Modern History","William Jones","History",8,"Unavailable"),
                new Book("B116","1117","C Programming","Dennis Ritchie","Science",9,"Available"),
                new Book("B117","1118","Python Programming","Guido Rossum","Science",14,"Available"),
                new Book("B118","1119","Digital Logic Design","Morris Mano","Science",7,"Available"),
                new Book("B119","1120","Statistics Basics","Robert Johnson","Math",13,"Available"),
                new Book("B120","1121","Machine Learning","Tom Mitchell","Science",4,"Unavailable")
        );

        tblBooks.setItems(bookList);

        tblBooks.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                BookIDTF.setText(newVal.getBookId());
                TitleTF.setText(newVal.getTitle());
                AvailabilityTF.setText(newVal.getStatus());
            }
        });
    }

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


        if (!selectedBook.getStatus().equalsIgnoreCase("Available")) {
            lblMessage.setText("Book is not available.");
            return;
        }


        if (memberId.startsWith("0")) {
            lblMessage.setText("Member not eligible.");
            return;
        }

        selectedBook.setStatus("Reserved");
        tblBooks.refresh();

        lblMessage.setText("Reservation successful on " + date);
    }


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


    @FXML
    public void backButtonOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));

        Node node = loader.load();
        reserveBookMainPane.getChildren().setAll(node);
    }
}