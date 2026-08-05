package abdullahalnuman;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;
import nonuser.Event;
public class ViewEventController
{
    @javafx.fxml.FXML
    private TableColumn <Event,String>eventNameTableView;
    @javafx.fxml.FXML
    private TableColumn<Event,String> eventOrganizerTableView;
    @javafx.fxml.FXML
    private TableColumn <Event,String>venueTableView;
    @javafx.fxml.FXML
    private TableView<Event> eventViewTable;
    @javafx.fxml.FXML
    private TableColumn <Event, LocalDate>eventScheduleTableView;
    ArrayList <Event> toReceive;
    @javafx.fxml.FXML
    private AnchorPane eventInformationMainPane;

    //String eventName, LocalDate eventSchedule, String eventVenue, String organizerName
    @javafx.fxml.FXML
    public void initialize() {
        eventNameTableView.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        eventScheduleTableView.setCellValueFactory(new PropertyValueFactory<>("eventSchedule"));
        venueTableView.setCellValueFactory(new PropertyValueFactory<>("eventVenue"));
        eventOrganizerTableView.setCellValueFactory(new PropertyValueFactory<>("organizerName"));
    }

    @javafx.fxml.FXML
    public void backPreviousPageButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/CreateEventView.fxml"));
        Node node = fxmlLoader.load();
        eventInformationMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void viewEventButton(ActionEvent actionEvent) {

        for (Event e:toReceive){
            eventViewTable.getItems().addAll(e);
        }


    }
}