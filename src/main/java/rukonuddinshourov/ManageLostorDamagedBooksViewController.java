package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class ManageLostorDamagedBooksViewController {

    @javafx.fxml.FXML
    private TableColumn fineTC;
    @javafx.fxml.FXML
    private TextField BookTitleTF;
    @javafx.fxml.FXML
    private TableColumn bookIDTC;
    @javafx.fxml.FXML
    private TextField BookIDTF;
    @javafx.fxml.FXML
    private TextArea RemarksTA;
    @javafx.fxml.FXML
    private TableColumn conditionTC;
    @javafx.fxml.FXML
    private ComboBox bookconditionCB;
    @javafx.fxml.FXML
    private TableColumn memberIdTC;
    @javafx.fxml.FXML
    private DatePicker ReportDateDP;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TextField AuthorTF;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TextField fineperDayTF;
    @javafx.fxml.FXML
    private DatePicker IssueDateDP;
    @javafx.fxml.FXML
    private TextField MemberIDTF;
    @javafx.fxml.FXML
    private AnchorPane lostordamagedBooksMainPane;

    @Deprecated
    public void ClearRecords(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void UpdateLostorDamageBooksButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchDamageorLostBook(ActionEvent actionEvent) {
    }

    @Deprecated
    public void SaveRecords(ActionEvent actionEvent) {
    }

    @Deprecated
    public void CalculateFineButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ClearRecordOnACtionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SaveRecordOnActionBitton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void CalculateFineOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        lostordamagedBooksMainPane.getChildren().setAll(node);


    }
}
