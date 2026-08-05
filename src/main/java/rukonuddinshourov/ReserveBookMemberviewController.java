package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ReserveBookMemberviewController {
    @javafx.fxml.FXML
    private TableView tblBooks;
    @javafx.fxml.FXML
    private Label lblMessage;
    @javafx.fxml.FXML
    private Button btnSearch;
    @javafx.fxml.FXML
    private DatePicker ReservationDate;
    @javafx.fxml.FXML
    private GridPane reserveDateDP;
    @javafx.fxml.FXML
    private TableColumn booIdTC;
    @javafx.fxml.FXML
    private TextField BookIDTF;
    @javafx.fxml.FXML
    private TextField TitleTF;
    @javafx.fxml.FXML
    private TextField AvailabilityTF;
    @javafx.fxml.FXML
    private TextField memberIDTC;
    @javafx.fxml.FXML
    private TableColumn StatusTC;
    @javafx.fxml.FXML
    private TableColumn TitlebookTC;
    @javafx.fxml.FXML
    private TextField searchbookTF;
    @javafx.fxml.FXML
    private TableColumn AuthorTC;
    @javafx.fxml.FXML
    private AnchorPane reserveBookMainPane;

    @javafx.fxml.FXML
    public void reserveBookOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        reserveBookMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void searchBook(ActionEvent actionEvent) {
    }
}
