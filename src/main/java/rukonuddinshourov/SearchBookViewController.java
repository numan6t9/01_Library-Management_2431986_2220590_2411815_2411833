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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchBookViewController implements Initializable {

    @FXML
    private AnchorPane searchBookMainPane;
    @FXML
    private Label searchbookLB;

    // TableView must be typed with <Book>
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> bookidTC;
    @FXML
    private TableColumn<Book, String> titleTC;
    @FXML
    private TableColumn<Book, String> authorTC;
    @FXML
    private TableColumn<Book, String> publisherTC;
    @FXML
    private TableColumn<Book, String> availablityTC;

    // Dummy Database for testing
    private ObservableList<Book> masterData = FXCollections.observableArrayList();
    @FXML
    private TextField bookNameTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 1. Setup Table Columns (match with Book class variable names)
        bookidTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTC.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherTC.setCellValueFactory(new PropertyValueFactory<>("N/A"));
        availablityTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // 2. Load some sample data
        masterData.add(new Book("B001", "Jva Basics", "Herbert Schildt",  "Available"));
        masterData.add(new Book("B002", "Effective Java", "Joshua Bloch",  "Reserved"));
        masterData.add(new Book("B003", "Clean Code", "Robert Martin",  "Available"));

        // Show all books by default
        bookTable.setItems(masterData);
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent)throws IOException {

            String keyword = bookNameTF.getText().trim().toLowerCase();

            ObservableList<Book> filteredList = FXCollections.observableArrayList();
            java.io.File file = new java.io.File("Book.bin");

            if (!file.exists()) {
                System.out.println("Book.bin file not found!");
                return;
            }

            try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(file))) {
                while (true) {
                    try {
                        Object obj = ois.readObject();
                        if (obj instanceof Book) {
                            Book b = (Book) obj;

                            if (keyword.isEmpty() || b.getAuthor().toLowerCase().contains(keyword)) {
                                filteredList.add(b);
                            }
                        }
                    } catch (java.io.EOFException e) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            bookTable.setItems(filteredList);
        }
    @FXML
    public void clearButtonOnAction(ActionEvent actionEvent) {
        bookNameTF.clear();
        bookTable.setItems(masterData);
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        searchBookMainPane.getChildren().setAll(node);
    }
}