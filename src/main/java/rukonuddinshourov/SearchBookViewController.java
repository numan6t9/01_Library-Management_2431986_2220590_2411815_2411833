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


    private ObservableList<Book> masterData = FXCollections.observableArrayList();
    @FXML
    private TextField bookNameTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookidTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTC.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherTC.setCellValueFactory(new PropertyValueFactory<>("N/A"));
        availablityTC.setCellValueFactory(new PropertyValueFactory<>("status"));

masterData.addAll(
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