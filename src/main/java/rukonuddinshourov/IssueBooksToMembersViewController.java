package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


public class IssueBooksToMembersViewController {
    @javafx.fxml.FXML
    private Button confirmBookIssue;
    @javafx.fxml.FXML
    private TextField memberNameTF;
    @javafx.fxml.FXML
    private TextField searchBookTF;
    @javafx.fxml.FXML
    private TableColumn memberNameTC;
    @javafx.fxml.FXML
    private TableColumn bookNameTC;
    @javafx.fxml.FXML
    private TableColumn availablityTC;
    @javafx.fxml.FXML
    private TextField memberIdTF;
    @javafx.fxml.FXML
    private DatePicker issueDateDP;
    @javafx.fxml.FXML
    private TableColumn memberIdTC;
    @javafx.fxml.FXML
    private TableColumn issuedateTC;
    @javafx.fxml.FXML
    private TextField isbnTitleTF;
    @javafx.fxml.FXML
    private AnchorPane issueBookspanelMainPane;
    @javafx.fxml.FXML
    private Label issueBookslabel;



    @javafx.fxml.FXML
    public void SearchBookAvaiablity(ActionEvent actionEvent) {
    }

    @Deprecated
    public void UpdateToIssue(ActionEvent actionEvent) {
    }

    @Deprecated
    public void ConfirmIssueBook(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void UpdateToIssuedButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ConfirmButtonAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        issueBookspanelMainPane.getChildren().setAll(node);

    }
}
