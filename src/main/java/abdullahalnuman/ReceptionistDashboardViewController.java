package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class ReceptionistDashboardViewController
{
    @javafx.fxml.FXML
    private AnchorPane receptionistMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logoutFromReceptionistDashboardButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/LoginView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void registerVisitorEntryButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/RegisterVisitorEntryView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void issueLibraryCardButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/IssueLibraryCardsView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void registerMemberButton(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/RegisterMemberView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void updateMemberInformationButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/UpdateMemberInformationView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void checkBookAvailabilityButton(ActionEvent actionEvent) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/CheckBookAvailabilityView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void manageBookReservationButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ManageBookReservationView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void createEventButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/CreateEventView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void inquiryMemberButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/InquiryView.fxml"));
        Node node = fxmlLoader.load();
        receptionistMainPane.getChildren().setAll(node);
    }
}