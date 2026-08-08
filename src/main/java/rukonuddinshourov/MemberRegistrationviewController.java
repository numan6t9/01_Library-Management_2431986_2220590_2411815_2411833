//package rukonuddinshourov;
//
////import abdullahalnuman.AppendableObjectOutputStream;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.control.*;
//import javafx.scene.layout.BorderPane;
//import nonuser.RegisterMember;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Label;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.util.Random;
//
//public class MemberRegistrationviewController {
//
//    @javafx.fxml.FXML
//    private TextArea addressTA;
//    @javafx.fxml.FXML
//    private TextField fullNameTF;
//
//    @javafx.fxml.FXML
//    private PasswordField PasswordPF;
//    @javafx.fxml.FXML
//    private TextField userNameTF;
//    @javafx.fxml.FXML
//    private TextField librarianNameTF;
//    @javafx.fxml.FXML
//    private RadioButton femaleRB;
//    @javafx.fxml.FXML
//    private RadioButton otherRB;
//    @javafx.fxml.FXML
//    private TextField emailTF;
//    @javafx.fxml.FXML
//    private RadioButton maleRB;
//    @javafx.fxml.FXML
//    private DatePicker birthDateDP;
//    @javafx.fxml.FXML
//    private TextField librarianIdTF;
//    @javafx.fxml.FXML
//    private PasswordField ConfirmPasswordPF;
//    @javafx.fxml.FXML
//    private BorderPane memberRegistrationMainPane;
//    @javafx.fxml.FXML
//    private TextField enterMemberAgeTF;
//
//    @javafx.fxml.FXML
//    public void initialize() {
//        ToggleGroup genderGroup = new ToggleGroup();
//        maleRB.setToggleGroup(genderGroup);
//        femaleRB.setToggleGroup(genderGroup);
//    }
//    private String generateMemberId() {
//        Random random = new Random();
//        return "Member" + (100000 + random.nextInt(900000));
//    }
//
//    @javafx.fxml.FXML
//    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));
//        Node node = fxmlLoader.load();
//        memberRegistrationMainPane.getChildren().setAll(node);
//
//    }
//
//
//    @javafx.fxml.FXML
//    public void registerOnActionButton(ActionEvent actionEvent) {
//        String gender = "";
//        if (femaleRB.isSelected()){
//            gender += "Female";
//        }
//        else{
//            gender += "Male";
//        }
//
//        RegisterMember member = new RegisterMember(
//                addressTA.getText(),
//                Integer.parseInt(enterMemberAgeTF.getText()),
//                birthDateDP.getValue(),
//                emailTF.getText(),
//                gender,
//                fullNameTF.getText()
//        );
//        addressTA.clear();
//        birthDateDP.setValue(null);
//        fullNameTF.clear();
//
//        File f = new File("Member.bin");
//        FileOutputStream fos;
//        ObjectOutputStream oos;
//
//        try {
//            if(f.exists()){
//                fos = new FileOutputStream(f,true);
//                oos = new AppendableobjectoutputStrream(fos);
//            }
//            else{
//                fos = new FileOutputStream(f);
//                oos = new ObjectOutputStream(fos);
//            }
//            oos.writeObject(member);
//            oos.close();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
////        String memberId = generateMemberId();
////        memberId.setText(memberId);
//    }
//
//    @javafx.fxml.FXML
//    public void clearOnActionbutton(ActionEvent actionEvent) {
//    }
//}
