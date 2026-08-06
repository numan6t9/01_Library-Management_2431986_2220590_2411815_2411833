package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import nonuser.RegisterMember;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

public class RegisterMemberViewController
{
    @javafx.fxml.FXML
    private TextField enterMemberAge;
    @javafx.fxml.FXML
    private RadioButton genderFemaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton genderMaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton othersGenderradioButton;
    @javafx.fxml.FXML
    private TextField enterAddress;
    @javafx.fxml.FXML
    private TextField enterMemberName;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthOfTheMember;
    @javafx.fxml.FXML
    private Label showMembershipId;
    @javafx.fxml.FXML
    private TextField enterEmailAddress;
    @javafx.fxml.FXML
    private AnchorPane registerMemberMainPane;
    @javafx.fxml.FXML
    private Button viewMemberListButton;

    @javafx.fxml.FXML
    public void initialize() {
        ToggleGroup genderGroup = new ToggleGroup();
        genderMaleRadioButton.setToggleGroup(genderGroup);
        genderFemaleRadioButton.setToggleGroup(genderGroup);
    }
    @javafx.fxml.FXML
    public void registerNewMemberAndGenerateIdButton(ActionEvent actionEvent) {
        String gender = "";
        if (genderFemaleRadioButton.isSelected()){
            gender += "Female";
        }
        else{
            gender += "Male";
        }
        RegisterMember member = new RegisterMember(
                enterAddress.getText(),
                Integer.parseInt(enterMemberAge.getText()),
                dateOfBirthOfTheMember.getValue(),
                enterEmailAddress.getText(),
                gender,
                enterMemberName.getText()
        );

        File f = new File("Member.bin");

        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(member);
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/ReceptionistDashboardView.fxml"));
        Node node = fxmlLoader.load();
        registerMemberMainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void viewMemberList(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/viewMemberList.fxml"));
            Node node = fxmlLoader.load();
            registerMemberMainPane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}