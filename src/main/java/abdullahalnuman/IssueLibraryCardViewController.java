package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class IssueLibraryCardViewController
{
    @javafx.fxml.FXML
    private TextField enterMemberId;
    @javafx.fxml.FXML
    private Label showMemberStatus;
    @javafx.fxml.FXML
    private TextField enterMemberName;
    @javafx.fxml.FXML
    private AnchorPane libraryCardsMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void GenerateLibraryCardsAndExport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchMemberButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        libraryCardsMainPane.getChildren().setAll(node);
    }
}