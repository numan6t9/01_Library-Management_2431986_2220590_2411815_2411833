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

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class BookDetailsViewController implements Initializable {

    @FXML private TextField isbn;
    @FXML private TextField PublisherTF;
    @FXML private TextField bookNameTF; // Search Input
    @FXML private TextField availablityTF;
    @FXML private TextField authorTF;
    @FXML private TextField bookTitleTF;
    @FXML private ComboBox<String> categoryCB;
    @FXML private AnchorPane bookDetailsMainPane;

    @FXML private TableView<Book> bookDetailsTable;
    @FXML private TableColumn<Book, String> bookIdTC;
    @FXML private TableColumn<Book, String> titleTC;
    @FXML private TableColumn<Book, String> authorTC;
    @FXML private TableColumn<Book, String> bookcategoryTC;
    @FXML private TableColumn<Book, String> availablityTC;
    @FXML
    public void bookListTable(javafx.event.Event event) {
    }

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Setup Table Columns
        bookIdTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTC.setCellValueFactory(new PropertyValueFactory<>("author"));
        availablityTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        bookcategoryTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        categoryCB.setItems(FXCollections.observableArrayList("Fiction", "Science", "History", "Technology"));


        loadBooksFromFile("");
    }

    private void loadBooksFromFile(String searchFilter) {
        bookList.clear();
        File file = new File("Book.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Book b = (Book) ois.readObject();
                    if (searchFilter.isEmpty() || b.getTitle().toLowerCase().contains(searchFilter.toLowerCase())) {
                        bookList.add(b);
                    }
                } catch (EOFException e) { break; }
            }
        } catch (Exception e) { e.printStackTrace(); }

        bookDetailsTable.setItems(bookList);
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        loadBooksFromFile(bookNameTF.getText().trim());
    }

    @FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        Book selected = bookDetailsTable.getSelectionModel().getSelectedItem();

        if (selected != null) {
            bookTitleTF.setText(selected.getTitle());
            authorTF.setText(selected.getAuthor());
            availablityTF.setText(selected.getStatus());


            PublisherTF.setText("Library Press");
            isbn.setText("ISBN-" + selected.getBookId());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please select a book from the table first!");
            alert.show();
        }
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        bookDetailsMainPane.getChildren().setAll(node);
    }


    @FXML public void searchInTheListButtonOnAction(ActionEvent actionEvent) { searchButtonOnAction(actionEvent); }
    @FXML public void borrowButtonOnAction(ActionEvent actionEvent) { }
}