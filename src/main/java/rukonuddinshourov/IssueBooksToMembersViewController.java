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
import nonuser.Book;
import nonuser.IssuedBook;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class IssueBooksToMembersViewController implements Initializable {

    @FXML
    private Button confirmBookIssue;
    @FXML
    private TextField memberNameTF;
    @FXML
    private TextField searchBookTF;
    @FXML
    private TextField memberIdTF;
    @FXML
    private DatePicker issueDateDP;
    @FXML
    private TextField isbnTitleTF;
    @FXML
    private AnchorPane issueBookspanelMainPane;
    @FXML
    private Label issueBookslabel;

    @FXML
    private TableView<IssuedBook> issedTableTV;
    @FXML
    private TableColumn<IssuedBook, String> bookNameTC;
    @FXML
    private TableColumn<IssuedBook, String> memberIdTC;
    @FXML
    private TableColumn<IssuedBook, String> memberNameTC;
    @FXML
    private TableColumn<IssuedBook, LocalDate> issuedateTC;
    @FXML
    private TableColumn<IssuedBook, String> availablityTC;

    private Book foundBook = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookNameTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        memberIdTC.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        memberNameTC.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        issuedateTC.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        availablityTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadIssuedBooks();
    }

    private void loadIssuedBooks() {
        List<IssuedBook> list = readIssuedBooks();
        ObservableList<IssuedBook>obsList = FXCollections.observableArrayList(list);
//        ObservableList<IssuedBook> obsList = FXCollections.observableArrayList(list);
        issedTableTV.setItems(obsList);
    }

    @FXML
    public void SearchBookAvaiablity(ActionEvent actionEvent) {
        String keyword = searchBookTF.getText().trim().toLowerCase();

        if (keyword.isEmpty()) {
            showMessage("Please enter book title to search.", true);
            return;
        }

        List<Book> allBooks = readBooksFromFile();
        foundBook = null;

        for (Book b : allBooks) {
            if (b.getTitle().toLowerCase().contains(keyword)
                    || b.getBookId().toLowerCase().contains(keyword)) {

                if (b.getStatus().equalsIgnoreCase("Available")) {
                    foundBook = b;
                    isbnTitleTF.setText(b.getTitle());
                    showMessage("Book found: " + b.getTitle() + " - Available", false);
                } else {
                    showMessage("Book found but not available. Status: " + b.getStatus(), true);
                }
                return;
            }
        }

        showMessage("Book not found.", true);
    }

    @FXML
    public void UpdateToIssuedButtonOnAction(ActionEvent actionEvent) {
        if (foundBook == null) {
            showMessage("Please search and find a book first.", true);
            return;
        }

        String memberId = memberIdTF.getText().trim();
        String memberName = memberNameTF.getText().trim();
        LocalDate issueDate = issueDateDP.getValue();

        if (memberId.isEmpty() || memberName.isEmpty()) {
            showMessage("Please enter Member ID and Name.", true);
            return;
        }

        if (issueDate == null) {
            showMessage("Please select issue date.", true);
            return;
        }

        LocalDate dueDate = issueDate.plusDays(14);

        List<Book> allBooks = readBooksFromFile();
        for (Book b : allBooks) {
            if (b.getBookId().equals(foundBook.getBookId())) {
                b.setStatus("Issued");
            }
        }
        saveBooksToFile(allBooks);

        List<IssuedBook> issuedList = readIssuedBooks();
        IssuedBook newIssue = new IssuedBook(
                foundBook.getBookId(),
                foundBook.getTitle(),
                memberId,
                issueDate,
                dueDate,
                "Issued"
        );
        issuedList.add(newIssue);
        saveIssuedBooks(issuedList);

        loadIssuedBooks();

        showMessage("Book '" + foundBook.getTitle() + "' issued to " + memberName
                + ". Due: " + dueDate, false);

        foundBook = null;
    }

    @FXML
    public void ConfirmButtonAction(ActionEvent actionEvent) {
        memberIdTF.clear();
        memberNameTF.clear();
        searchBookTF.clear();
        isbnTitleTF.clear();
        issueDateDP.setValue(null);
        foundBook = null;

        loadIssuedBooks();
        showMessage("Issue confirmed and fields cleared.", false);
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        issueBookspanelMainPane.getChildren().setAll(node);
    }

    private void showMessage(String msg, boolean isError) {
        if (isError) {
            issueBookslabel.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        } else {
            issueBookslabel.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        }
        issueBookslabel.setText(msg);
    }

    @SuppressWarnings("unchecked")
    private List<Book> readBooksFromFile() {
        List<Book> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Book.bin"))) {
            list = (List<Book>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error reading Book.bin: " + e.getMessage());
        }
        return list;
    }

    private void saveBooksToFile(List<Book> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Book.bin"))) {
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error saving Book.bin: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<IssuedBook> readIssuedBooks() {
        List<IssuedBook> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IssuedBooks.bin"))) {
            list = (List<IssuedBook>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error reading IssuedBooks.bin: " + e.getMessage());
        }
        return list;
    }

    private void saveIssuedBooks(List<IssuedBook> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IssuedBooks.bin"))) {
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error saving IssuedBooks.bin: " + e.getMessage());
        }
    }
}