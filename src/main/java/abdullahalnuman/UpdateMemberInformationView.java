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

public class UpdateMemberInformationView
{
    @javafx.fxml.FXML
    private Label showMemberId;
    @javafx.fxml.FXML
    private TextField enterMemberId;
    @javafx.fxml.FXML
    private Label showMemberName;
    @javafx.fxml.FXML
    private TextField updateEmail;
    @javafx.fxml.FXML
    private TextField updateAddress;
    @javafx.fxml.FXML
    private Label showEmailAddress;
    @javafx.fxml.FXML
    private Label showAddress;
    @javafx.fxml.FXML
    private TextField updateName;
    @javafx.fxml.FXML
    private AnchorPane memberInformationMainPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private boolean isValid() {
        if (enterMemberId.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    @javafx.fxml.FXML
    public void updateMemberAndInformationAndSaveButton(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void searchMemberButton(ActionEvent actionEvent) {

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
                        if (m.getMemberId().equals(enterMemberId.getText())) {
                            showMemberId.setText(m.getMemberId());
                            showAddress.setText(m.getMemberAddress());
                            showEmailAddress.setText(m.getMemberEmailAddress());
                            showMemberName.setText(m.getMemberName());
                            found = true;
                            break;
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
        memberInformationMainPane.getChildren().setAll(node);
    }
}