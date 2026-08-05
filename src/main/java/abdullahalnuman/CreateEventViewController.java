package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.Event;

import java.io.IOException;
import java.util.ArrayList;

public class CreateEventViewController
{
    @javafx.fxml.FXML
    private DatePicker enterEventSchedule;
    @javafx.fxml.FXML
    private TextField enterEventName;
    @javafx.fxml.FXML
    private TextField enterEventorganizer;
    @javafx.fxml.FXML
    private TextField enterEventVenue;
    @javafx.fxml.FXML
    private
    AnchorPane eventManagementMainPane;
    ArrayList<Event> eventList = new ArrayList<Event>();

    @javafx.fxml.FXML
    public void initialize() {

    }
    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        eventManagementMainPane.getChildren().setAll(node);
    }
    @javafx.fxml.FXML
    public void createEventAndViewEventButton(ActionEvent actionEvent) throws IOException {
//String eventName, LocalDate eventSchedule, String eventVenue, String organizerName
        Event event = new Event(
                enterEventName.getText(),
                enterEventSchedule.getValue(),
                enterEventVenue.getText(),
                enterEventorganizer.getText()
        );
        eventList.add(event);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ViewEvent.fxml"));
        Node node = fxmlLoader.load();
        ViewEventController controller = fxmlLoader.getController();
        controller.toReceive = eventList;
        eventManagementMainPane.getChildren().setAll(node);
    }
}