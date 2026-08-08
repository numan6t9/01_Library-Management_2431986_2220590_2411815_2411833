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

public class UpdateLibraryCatalogViewController implements Initializable {

    @FXML private TextField bookIdTF;
    @FXML private TextField ISBNTF;
    @FXML private TextField TitleTF;
    @FXML private TextField AuthorTF;
    @FXML private TextField QuantityTF;
    @FXML private TextField shelfLocationTF;

    @FXML private ComboBox<String> StatusCB;
    @FXML private ComboBox<String> categoryCB;

    @FXML private TableView<Book> bookTableView;

    @FXML private TableColumn<Book,String> bookIdTC;
    @FXML private TableColumn<Book,String> isbnTC;
    @FXML private TableColumn<Book,String> titleTC;
    @FXML private TableColumn<Book,String> authorTC;
    @FXML private TableColumn<Book,String> categoryTC;
    @FXML private TableColumn<Book,Integer> quantityTC;
    @FXML private TableColumn<Book,String> statusTC;

    @FXML private AnchorPane libraryCatalogMainPane;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        StatusCB.setItems(FXCollections.observableArrayList(
                "Available", "Unavailable"
        ));

        categoryCB.setItems(FXCollections.observableArrayList(
                "Science", "Math", "History", "Novel"
        ));

        bookIdTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        isbnTC.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTC.setCellValueFactory(new PropertyValueFactory<>("author"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        bookList.addAll(
                new Book("B101","1111","Java","Herbert","Science",10,"Available"),
                new Book("B102","2222","Math Algebra","Smith","Math",5,"Available"),
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

        bookTableView.setItems(bookList);

        bookTableView.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldV, newV) -> {
                    if(newV != null){
                        bookIdTF.setText(newV.getBookId());
                        ISBNTF.setText(newV.getIsbn());
                        TitleTF.setText(newV.getTitle());
                        AuthorTF.setText(newV.getAuthor());
                        categoryCB.setValue(newV.getCategory());
                        QuantityTF.setText(String.valueOf(newV.getQuantity()));
                        StatusCB.setValue(newV.getStatus());
                    }
                });
    }


    @FXML
    public void SearchbuttonOnAction(ActionEvent actionEvent) {

        String id = bookIdTF.getText().trim();

        for(Book b : bookList){
            if(b.getBookId().equalsIgnoreCase(id)){
                bookTableView.getSelectionModel().select(b);
                return;
            }
        }

        showAlert("Book not found!");
    }

    @FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {

        Book selected = bookTableView.getSelectionModel().getSelectedItem();

        if(selected == null){
            showAlert("Select a book to update!");
            return;
        }

        if(TitleTF.getText().isEmpty() ||
                AuthorTF.getText().isEmpty() ||
                QuantityTF.getText().isEmpty()){
            showAlert("Fill all fields!");
            return;
        }

        selected.setTitle(TitleTF.getText());
        selected.setAuthor(AuthorTF.getText());
        selected.setCategory(categoryCB.getValue());
        selected.setQuantity(Integer.parseInt(QuantityTF.getText()));
        selected.setStatus(StatusCB.getValue());

        bookTableView.refresh();

        showAlert("Book updated successfully!");
    }

    @FXML
    public void removeButtononAction(ActionEvent actionEvent) {

        Book selected = bookTableView.getSelectionModel().getSelectedItem();

        if(selected == null){
            showAlert("Select a book to remove!");
            return;
        }

        bookList.remove(selected);
        showAlert("Book removed!");
    }


    @FXML
    public void confirmOnActionbutton(ActionEvent actionEvent) {
        showAlert("Catalog update confirmed!");
    }

    @FXML
    public void refreshButtonOAction(ActionEvent actionEvent) {

        bookIdTF.clear();
        ISBNTF.clear();
        TitleTF.clear();
        AuthorTF.clear();
        QuantityTF.clear();
        shelfLocationTF.clear();
        categoryCB.setValue(null);
        StatusCB.setValue(null);

        bookTableView.refresh();
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));

        Node node = loader.load();
        libraryCatalogMainPane.getChildren().setAll(node);
    }

    private void showAlert(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}