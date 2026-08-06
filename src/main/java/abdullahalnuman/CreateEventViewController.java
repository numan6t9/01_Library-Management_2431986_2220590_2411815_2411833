package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.Event;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

        File f = new File("Event.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {

            if (f.exists()) {
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

            }
            oos.writeObject(event);
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void goNextPage(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ViewEvent.fxml"));
            Node node = fxmlLoader.load();
            eventManagementMainPane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}