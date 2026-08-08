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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProcessBookReturnsViewController implements Initializable {

    @FXML
    private TableView<IssuedBook> tblBooks;
    @FXML
    private TableColumn<IssuedBook, String> bookIDTC;
    @FXML
    private TableColumn<IssuedBook, String> titleTC;
    @FXML
    private TableColumn<IssuedBook, LocalDate> issueDateTC;
    @FXML
    private TableColumn<IssuedBook, LocalDate> dueDateTC;
    @FXML
    private TableColumn<IssuedBook, String> statusTC;

    @FXML
    private TextField memberIDTF;
    @FXML
    private TextField bookIDTF;
    @FXML
    private TextField titleTF;
    @FXML
    private TextField issueDateTF;
    @FXML
    private TextField dueDateTF;
    @FXML
    private TextField fineTF;
    @FXML
    private DatePicker returnDateDP;
    @FXML
    private RadioButton goodRB;
    @FXML
    private RadioButton damagedRB;
    @FXML
    private RadioButton lostRB;
    @FXML
    private Label lblStatus;
    @FXML
    private Button btnSearch;
    @FXML
    private AnchorPane processBookReturnMainPane;

    private ToggleGroup conditionGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // কলাম সেটআপ
        bookIDTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        issueDateTC.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        dueDateTC.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // রেডিও বাটন গ্রুপ
        conditionGroup = new ToggleGroup();
        goodRB.setToggleGroup(conditionGroup);
        damagedRB.setToggleGroup(conditionGroup);
        lostRB.setToggleGroup(conditionGroup);
        goodRB.setSelected(true);

        // টেবিল সিলেকশন লিসেনার
        tblBooks.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        bookIDTF.setText(newVal.getBookId());
                        titleTF.setText(newVal.getTitle());
                        issueDateTF.setText(newVal.getIssueDate().toString());
                        dueDateTF.setText(newVal.getDueDate().toString());
                    }
                });
    }

    // Event-3: Search issued books by Member ID
    @FXML
    public void searchIssuedBooks(ActionEvent actionEvent) {
        String memberId = memberIDTF.getText().trim();

        if (memberId.isEmpty()) {
            lblStatus.setStyle("-fx-text-fill: red;");
            lblStatus.setText("Please enter Member ID.");
            return;
        }

        List<IssuedBook> allIssued = readIssuedBooks();
        ObservableList<IssuedBook> filtered = FXCollections.observableArrayList();

        for (IssuedBook ib : allIssued) {
            if (ib.getMemberId().equalsIgnoreCase(memberId)
                    && ib.getStatus().equalsIgnoreCase("Issued")) {
                filtered.add(ib);
            }
        }

        tblBooks.setItems(filtered);

        if (filtered.isEmpty()) {
            lblStatus.setStyle("-fx-text-fill: red;");
            lblStatus.setText("No issued books found for this member.");
        } else {
            lblStatus.setStyle("-fx-text-fill: green;");
            lblStatus.setText(filtered.size() + " issued book(s) found.");
        }
    }

    // Event-5: Calculate Fine
    @FXML
    public void calculateFineOnActionButton(ActionEvent actionEvent) {
        LocalDate returnDate = returnDateDP.getValue();

        if (returnDate == null) {
            lblStatus.setStyle("-fx-text-fill: red;");
            lblStatus.setText("Please select return date.");
            return;
        }

        if (dueDateTF.getText().isEmpty()) {
            lblStatus.setStyle("-fx-text-fill: red;");
            lblStatus.setText("Please select a book first.");
            return;
        }

        LocalDate dueDate = LocalDate.parse(dueDateTF.getText());
        double fine = 0.0;

        // Overdue fine calculation
        if (returnDate.isAfter(dueDate)) {
            long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
            fine = overdueDays * 1.0; // $1 per day
        }

        // Book condition fine
        if (damagedRB.isSelected()) {
            fine += 25.0; // Damaged book extra fine
        } else if (lostRB.isSelected()) {
            fine += 50.0; // Lost book extra fine
        }

        fineTF.setText(String.format("%.2f", fine));
        lblStatus.setStyle("-fx-text-fill: green;");
        lblStatus.setText("Fine calculated: $" + String.format("%.2f", fine));
    }

    // Event-6 & Event-7: Return Book and Save
    @FXML
    public void returnBookOnActionButton(ActionEvent actionEvent) {
        IssuedBook selected = tblBooks.getSelectionModel().getSelectedItem();

        if (selected == null) {
            lblStatus.setStyle("-fx-text-fill: red;");
            lblStatus.setText("Please select a book to return.");
            return;
        }

        if (returnDateDP.getValue() == null) {
            lblStatus.setStyle("-fx-text-fill: red;");
            lblStatus.setText("Please select return date.");
            return;
        }

        // ১. IssuedBooks.bin আপডেট করা
        List<IssuedBook> allIssued = readIssuedBooks();
        for (IssuedBook ib : allIssued) {
            if (ib.getBookId().equals(selected.getBookId())
                    && ib.getMemberId().equals(selected.getMemberId())) {

                if (lostRB.isSelected()) {
                    ib.setStatus("Lost");
                } else if (damagedRB.isSelected()) {
                    ib.setStatus("Returned-Damaged");
                } else {
                    ib.setStatus("Returned");
                }
            }
        }
        saveIssuedBooks(allIssued);

        // ২. Book.bin এ status আপডেট করা
        List<Book> allBooks = readBooksFromFile();
        for (Book b : allBooks) {
            if (b.getBookId().equals(selected.getBookId())) {
                if (lostRB.isSelected()) {
                    b.setStatus("Lost");
                } else if (damagedRB.isSelected()) {
                    b.setStatus("Damaged");
                } else {
                    b.setStatus("Available");
                }
            }
        }
        saveBooksToFile(allBooks);

        // ৩. টেবিল রিফ্রেশ
        searchIssuedBooks(actionEvent);

        lblStatus.setStyle("-fx-text-fill: green;");
        lblStatus.setText("Book returned successfully! Fine: $" + fineTF.getText());
    }

    // Clear Button
    @FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
        bookIDTF.clear();
        titleTF.clear();
        issueDateTF.clear();
        dueDateTF.clear();
        fineTF.clear();
        returnDateDP.setValue(null);
        goodRB.setSelected(true);
        lblStatus.setText("");
        tblBooks.getSelectionModel().clearSelection();
    }

    // Back Button
    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        processBookReturnMainPane.getChildren().setAll(node);
    }

    // ========== File Read/Write Methods ==========

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
}