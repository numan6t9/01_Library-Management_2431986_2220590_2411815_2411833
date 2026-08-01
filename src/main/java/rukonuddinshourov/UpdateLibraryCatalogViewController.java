package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UpdateLibraryCatalogViewController {

    @javafx.fxml.FXML
    private TextField bookIdTF;
    @javafx.fxml.FXML
    private TableColumn bookIdTC;
    @javafx.fxml.FXML
    private ComboBox StatusCB;
    @javafx.fxml.FXML
    private TextField TitleTF;
    @javafx.fxml.FXML
    private TextField ISBNTF;
    @javafx.fxml.FXML
    private TableColumn isbnTC;
    @javafx.fxml.FXML
    private TableColumn categoryTC;
    @javafx.fxml.FXML
    private TextField QuantityTF;
    @javafx.fxml.FXML
    private TableColumn authorTC;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TextField shelfLocationTF;
    @javafx.fxml.FXML
    private TextField AuthorTF;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private ComboBox categoryCB;
    @javafx.fxml.FXML
    private TableColumn quantityTC;
    @javafx.fxml.FXML
    private AnchorPane libraryCatalogMainPanel;

//    @javafx.fxml.FXML
//    public void confirmUpdateButton(ActionEvent actionEvent) {
//    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Searchbutton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void updateButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void RemoveButton(ActionEvent actionEvent) {
    }

//    @Deprecated
//    public void ConfirmUpdateButton(ActionEvent actionEvent) {
//    }

//    @Deprecated
//    public void ConfirmButton(ActionEvent actionEvent) {
//    }

    @javafx.fxml.FXML
    public void confirmOnActionbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
    }

//    @javafx.fxml.FXML
//    public void confirmUpdateButton(ActionEvent actionEvent) {
//    }

    @javafx.fxml.FXML
    public void backOnACtionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/LibrarianDashboardView.fxml"));
        Node node = fxmlLoader.load();
        libraryCatalogMainPanel.getChildren().setAll(node);


    }
}
