package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class InquiryViewController
{
    @javafx.fxml.FXML
    private TextField inquiryDetails;
    @javafx.fxml.FXML
    private Label showMemberOrVisitorStatus;
    @javafx.fxml.FXML
    private TextField enterMemberIdorVisitorPass;
    @javafx.fxml.FXML
    private AnchorPane inquiryMainPane;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void saveInquiryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchMemberOrVisitorButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        inquiryMainPane.getChildren().setAll(node);


    }
}