package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BorrowingHistoryViewController {

    @javafx.fxml.FXML
    private TableColumn dueDateTC;
    @javafx.fxml.FXML
    private TableColumn returnDateTC;
    @javafx.fxml.FXML
    private TableColumn bookIdTC;
    @javafx.fxml.FXML
    private TableColumn bookTitleTC;
    @javafx.fxml.FXML
    private Label borrowingHistoryLB;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TextField bookSearchTF;
    @javafx.fxml.FXML
    private ComboBox statusTF;
    @javafx.fxml.FXML
    private TableColumn borrowTC;
    @javafx.fxml.FXML
    private AnchorPane borrowingHistoryMainPane;

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void printOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void closeOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        borrowingHistoryMainPane.getChildren().setAll(node);

    }
}
