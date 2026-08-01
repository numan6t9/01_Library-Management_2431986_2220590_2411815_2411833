package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SearchBookViewController {

    @javafx.fxml.FXML
    private TableColumn authorTC;
    @javafx.fxml.FXML
    private AnchorPane searchBookMainPAnel;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TableColumn bookidTC;
    @javafx.fxml.FXML
    private TableColumn availablityTC;
    @javafx.fxml.FXML
    private Label searchbookLB;
    @javafx.fxml.FXML
    private TextField authorNameTF;
    @javafx.fxml.FXML
    private TableColumn publisherTC;

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        searchBookMainPAnel.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void clearOnActionButton(ActionEvent actionEvent) {
    }
}
