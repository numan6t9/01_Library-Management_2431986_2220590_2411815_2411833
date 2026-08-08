package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class CreateNewAnnouncementViewController {

    @FXML
    private Label createNewAnnouncement;
    @FXML
    private DatePicker EndingDateDP;
    @FXML
    private TextField attachmentTF;
    @FXML
    private ComboBox<String> CategoryCB;
    @FXML
    private TextArea AnnouncementTitleTA;
    @FXML
    private TextArea optionalAttachmentTA;
    @FXML
    private DatePicker StartingDateDP;
    @FXML
    private ComboBox<String> TargetAudianceCB;
    @FXML
    private AnchorPane createNewAnnouncementMainPane;

    @FXML
    public void initialize() {

        TargetAudianceCB.getItems().addAll("Visitor", "Staff", "All Member");
        CategoryCB.getItems().addAll("General", "Alert", "Event", "New Arrival");

        optionalAttachmentTA.setText("No file Attach");
    }

    @FXML
    public void browseButtonOnAction(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Attachment");

        File file = fileChooser.showOpenDialog(
                createNewAnnouncementMainPane.getScene().getWindow()
        );

        if (file != null) {
            attachmentTF.setText(file.getAbsolutePath());
            optionalAttachmentTA.setText("File Attached:\n" + file.getName());
        }
    }


    @FXML
    public void resetButtonOnACtion(ActionEvent actionEvent) {

        attachmentTF.clear();
        TargetAudianceCB.getSelectionModel().clearSelection();
        CategoryCB.getSelectionModel().clearSelection();
        optionalAttachmentTA.setText("No file Attach");
        StartingDateDP.setValue(null);
        EndingDateDP.setValue(null);
        AnnouncementTitleTA.clear();
    }


    @FXML
    public void publishButtonOnAction(ActionEvent actionEvent) {

        String title = AnnouncementTitleTA.getText().trim();
        String audience = TargetAudianceCB.getValue();
        String category = CategoryCB.getValue();
        String attachment = attachmentTF.getText().trim();


        if (title.isEmpty()) {
            showAlert("Validation Error", "Announcement Title is required!");
            return;
        }

        if (audience == null) {
            showAlert("Validation Error", "Please select Target Audience!");
            return;
        }

        if (category == null) {
            showAlert("Validation Error", "Please select Category!");
            return;
        }

        if (StartingDateDP.getValue() == null) {
            showAlert("Validation Error", "Please select Starting Date!");
            return;
        }

        if (EndingDateDP.getValue() == null) {
            showAlert("Validation Error", "Please select Ending Date!");
            return;
        }

        if (EndingDateDP.getValue().isBefore(StartingDateDP.getValue())) {
            showAlert("Validation Error", "Ending Date must be after Starting Date!");
            return;
        }

        showAlert("Success", "Announcement Published Successfully!");

        resetButtonOnACtion(null);
    }

    private void showAlert(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"
        ));
        Node node = fxmlLoader.load();
        createNewAnnouncementMainPane.getChildren().setAll(node);
    }
}