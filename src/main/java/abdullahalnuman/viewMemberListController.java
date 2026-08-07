package abdullahalnuman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import nonuser.ReadAndWriteHelper;
import nonuser.RegisterMember;
import rukonuddinshourov.Member;

import java.io.*;

public class viewMemberListController
{
    @javafx.fxml.FXML
    private TableView<RegisterMember> memberListTableView;
    @javafx.fxml.FXML
    private TableColumn<RegisterMember, String> memberNameTableView;
    @javafx.fxml.FXML
    private TableColumn <RegisterMember, Integer>memberAgeTableView;
    @javafx.fxml.FXML
    private AnchorPane memberlistMainPane;
    @javafx.fxml.FXML
    private TableColumn<RegisterMember,String> genderTableView;
    @javafx.fxml.FXML
    private TableColumn <RegisterMember,String>emailAddressTableView;

    @javafx.fxml.FXML
    public void initialize() {
        memberAgeTableView.setCellValueFactory(new PropertyValueFactory<>("memberAge"));
        memberNameTableView.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        genderTableView.setCellValueFactory(new PropertyValueFactory<>("memberGender"));
        emailAddressTableView.setCellValueFactory(new PropertyValueFactory<>("memberEmailAddress"));
    }

    @javafx.fxml.FXML
    public void loadMemberListTable(ActionEvent actionEvent) {
        memberListTableView.getItems().clear();
        try {
            ObjectInputStream ois =  ReadAndWriteHelper.read("Member.bin");
            while (true){
                try{
                    RegisterMember m = (RegisterMember) ois.readObject();
                    memberListTableView.getItems().add(m);
                }
                catch (EOFException e){

                    break;
                }
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* File f = new File("Member.bin");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(true){
                try {
                    RegisterMember m = (RegisterMember) ois.readObject();
                    memberListTableView.getItems().add(m);
                }
                catch (EOFException e) {
                    ois.close();
                    break;
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        */
    }

    @javafx.fxml.FXML
    public void backPreviousPage(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/abdullahalnuman/RegisterMemberView.fxml"));
        Node node = fxmlLoader.load();
        memberlistMainPane.getChildren().setAll(node);
    }
}