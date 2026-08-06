package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CreateNewAnnouncementViewController {
    @javafx.fxml.FXML
    private Label createNewAnnouncement;
    @javafx.fxml.FXML
    private DatePicker EndingDateDP;
    @javafx.fxml.FXML
    private TextField attachmentTF;
    @javafx.fxml.FXML
    private ComboBox CategoryCB;
    @javafx.fxml.FXML
    private TextArea AnnouncementTitleTA;
    @javafx.fxml.FXML
    private TextArea optionalAttachmentTA;
    @javafx.fxml.FXML
    private DatePicker StartingDateDP;
    @javafx.fxml.FXML
    private ComboBox<String> TargetAudianceCB;
    @javafx.fxml.FXML
    private AnchorPane createNewAnnouncementMainPane;


    @FXML
    public void initialize() {

        TargetAudianceCB.getItems().addAll("Visitor", "Staff", "All Member");
        CategoryCB.getItems().addAll("General","Alart","Event","New Arrival");
    }


    @javafx.fxml.FXML
    public void browseButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetButtonOnACtion(ActionEvent actionEvent)throws IOException {
        attachmentTF.clear();
        TargetAudianceCB.getSelectionModel().clearSelection();
        CategoryCB.getSelectionModel().clearSelection();
        optionalAttachmentTA.clear();
        StartingDateDP.setValue(null);
        EndingDateDP.setValue(null);
        AnnouncementTitleTA.clear();
    }



    @javafx.fxml.FXML
    public void publishButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
        Node node = fxmlLoader.load();
        createNewAnnouncementMainPane.getChildren().setAll(node);

    }
}
