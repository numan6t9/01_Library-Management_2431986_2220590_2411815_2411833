package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import nonuser.RegisterMember;

import java.io.*;
public class IssueLibraryCardViewController
{
    @javafx.fxml.FXML
    private TextField enterMemberId;
    @javafx.fxml.FXML
    private Label showMemberStatus;
    @javafx.fxml.FXML
    private AnchorPane libraryCardsMainPane;
    @javafx.fxml.FXML
    private Label successfullText;

    @javafx.fxml.FXML
    public void initialize() {
    }


    private boolean isValid(){
        if (enterMemberId.getText().isEmpty()){
            return false;
        }
        return true;
    }
    @javafx.fxml.FXML
    public void GenerateLibraryCardsAndExport(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void SearchMemberButton(ActionEvent actionEvent) {

        if (!isValid()){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Field Is Empty");
            a.showAndWait();
        }
        else {
            String memberId = enterMemberId.getText();
            File f = new File("Member.bin");
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (true) {
                    try {
                        RegisterMember member = (RegisterMember) ois.readObject();
                        if (member.getMemberId().equals(memberId)) {
                            showMemberStatus.setText("Member Is Active");
                            break;
                        }
                        else {
                            showMemberStatus.setText("Member Not Found");
                        }
                    } catch (EOFException e) {
                        ois.close();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        libraryCardsMainPane.getChildren().setAll(node);
    }
}