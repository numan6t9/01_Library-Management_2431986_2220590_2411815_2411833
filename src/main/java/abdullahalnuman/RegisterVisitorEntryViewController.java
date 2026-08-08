package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import user.Visitor;

import java.io.*;
import java.util.Random;

public class RegisterVisitorEntryViewController
{
    @javafx.fxml.FXML
    private TextField enterPhoneNumber;
    @javafx.fxml.FXML
    private TextField enterVisitorName;
    @javafx.fxml.FXML
    private Label showVisitorPass;
    @javafx.fxml.FXML
    private TextField enterNID;
    @javafx.fxml.FXML
    private TextField enterPurposeOfVisit;
    @javafx.fxml.FXML
    private AnchorPane visitorEntryMainPane;
    @javafx.fxml.FXML
    private TableColumn <Visitor,String>phoneNumberTableView;
    @javafx.fxml.FXML
    private TableColumn<Visitor, String> visitorPassTableView;
    @javafx.fxml.FXML
    private TableColumn<Visitor,String> nidTableView;
    @javafx.fxml.FXML
    private TableView <Visitor>visitorTableView;
    @javafx.fxml.FXML
    private TableColumn<Visitor,String> nameTableView;

    @javafx.fxml.FXML
    public void initialize() {
        phoneNumberTableView.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        visitorPassTableView.setCellValueFactory(new PropertyValueFactory<>("visitorPass"));
        nidTableView.setCellValueFactory(new PropertyValueFactory<>("visitorNID"));
        nameTableView.setCellValueFactory(new PropertyValueFactory<>("visitorName"));
    }

    public boolean isValid() {
        if (enterPhoneNumber.getText().isEmpty() && enterNID.getText().isEmpty() && enterPurposeOfVisit.getText().isEmpty()
                && enterVisitorName.getText().isEmpty()) {

            return false;
        }
        if (enterPhoneNumber.getText().length() != 11 && enterNID.getText().length() != 15) {

            return false;
        }
        else {

            return true;
        }

    }

    public String generateVisitorPass(){
        Random random = new Random();
        return "visitor" + (10000+random.nextInt(900000));
    }

    @javafx.fxml.FXML
    public void registerVisitorAndGenerateVisitorPassButton(ActionEvent actionEvent) {
        String visitorPass = generateVisitorPass();
        if (!isValid()){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Input Every Fields correctly");
            a.showAndWait();
        }
        else {

            Visitor visitor = new Visitor(
                    enterPhoneNumber.getText(),
                    enterPurposeOfVisit.getText(),
                    enterVisitorName.getText(),
                    enterNID.getText(),
                    visitorPass
            );
            showVisitorPass.setText(visitorPass);
            enterNID.clear();
            enterPhoneNumber.clear();
            enterPhoneNumber.clear();
            enterPurposeOfVisit.clear();


            File f = new File("Visitor.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            try {
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(visitor);
                oos.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        visitorEntryMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void loadVisitorButton(ActionEvent actionEvent) {
        visitorTableView.getItems().clear();
        File f = new File("Visitor.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                try {
                    Visitor visitor = (Visitor) ois.readObject();
                    visitorTableView.getItems().add(visitor);
                }
                catch (EOFException e){
                    ois.close();
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
}
