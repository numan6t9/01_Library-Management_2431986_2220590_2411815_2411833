package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BookDetailsViewController {
    @javafx.fxml.FXML
    private TextField isbn;
    @javafx.fxml.FXML
    private TextField PublisherTF;
    @javafx.fxml.FXML
    private TableColumn bookIdTC;
    @javafx.fxml.FXML
    private TableColumn availablityTC;
    @javafx.fxml.FXML
    private TextField bookNameTF;
    @javafx.fxml.FXML
    private TableColumn bookcategoryTC;
    @javafx.fxml.FXML
    private TextField availablityTF;
    @javafx.fxml.FXML
    private TableColumn authorTC;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TextField authorTF;
    @javafx.fxml.FXML
    private Label bookDetailslabel;
    @javafx.fxml.FXML
    private TextField bookTitleTF;
    @javafx.fxml.FXML
    private ComboBox categoryCB;
    @javafx.fxml.FXML
    private AnchorPane bookDetailsMainPane;

    @javafx.fxml.FXML
    public void searchInTheListButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bookListTable(Event event) {
    }

    @javafx.fxml.FXML
    public void borrowButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();

        bookDetailsMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
    }
}
