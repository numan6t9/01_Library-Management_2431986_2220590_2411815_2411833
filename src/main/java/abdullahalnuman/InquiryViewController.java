package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.ReadAndWriteHelper;
import nonuser.RegisterMember;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;

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
    private Label showInquirySavedText;

    private boolean isValid(){
        if (enterMemberIdorVisitorPass.getText().isEmpty()) {
            return false;
        }
        return true;

    }


    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void saveInquiryButton(ActionEvent actionEvent) {
        if (inquiryDetails.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Field Cannot be empty");
        }
        else{
            showInquirySavedText.setText("Your Inquiry has been saved");
        }
    }

    @javafx.fxml.FXML
    public void searchMemberOrVisitorButton(ActionEvent actionEvent) {
        if (!isValid()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Field can not be empty");
        }
        else {
            try {
                ObjectInputStream ois = ReadAndWriteHelper.read("Member.bin");
                boolean found = false;
                while (true) {
                    try {
                        RegisterMember m = (RegisterMember) ois.readObject();
                        if (enterMemberIdorVisitorPass.getText().equals(m.getMemberId())) {
                            showMemberOrVisitorStatus.setText("Member Is Active");
                        }
                        if (!found){
                            Alert b = new Alert(Alert.AlertType.INFORMATION);
                            b.setContentText("Member Not Found");
                            b.showAndWait();
                        }
                    } catch (EOFException e) {
                        break;
                    }
                }
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        inquiryMainPane.getChildren().setAll(node);


    }
}