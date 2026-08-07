package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberpersonalprofileupdateViewController {

    @FXML private ComboBox<String> genderCB;
    @FXML private TextField lastNameTF;
    @FXML private TextField emailIdTF;
    @FXML private DatePicker dateOfBirthDP;
    @FXML private TextField phoneNumberTF;
    @FXML private TextField adressTF;
    @FXML private PasswordField passswordPF;
    @FXML private PasswordField confirmPasswordPF;
    @FXML private TextField firstNameTF;
    @FXML private TextField memberIdTF;
    @FXML private AnchorPane memberprofileUpdateMainPane;

    private static final String FILE_NAME = "members.bin";

    // ⚠ Set this from login system
    private String loggedInMemberId = "101";

    @FXML
    public void initialize() throws IOException{

        genderCB.getItems().addAll("Male", "Female", "Other");

        loadMemberData();
    }

    // ✅ Load members from file
    private List<Member> loadMembers() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (List<Member>) ois.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // ✅ Save members
    private void saveMembers(List<Member> list) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Load current member info
    private void loadMemberData()throws IOException {

        for (Member m : loadMembers()) {
            if (m.getMemberId().equals(loggedInMemberId)){

                firstNameTF.setText(m.getFirstName());
                lastNameTF.setText(m.getLastName());
                memberIdTF.setText(String.valueOf(m.getMemberId()));
                emailIdTF.setText(m.getEmail());
                phoneNumberTF.setText(m.getPhone());
                adressTF.setText(m.getAdress());
                genderCB.setValue(m.getGender());
                dateOfBirthDP.setValue(m.getDateOfBirth());
                break;
            }
        }
    }

    // ✅ Save Changes Button
    @FXML
    public void savechangeButtonOnAction(ActionEvent actionEvent) {

        if (firstNameTF.getText().isEmpty() ||
                lastNameTF.getText().isEmpty() ||
                emailIdTF.getText().isEmpty()) {

            showAlert("Required fields are empty!");
            return;
        }

        if (!passswordPF.getText().equals(confirmPasswordPF.getText())) {
            showAlert("Passwords do not match!");
            return;
        }

        List<Member> list = loadMembers();

        for (Member m : list) {
            if (m.getMemberId().equals(loggedInMemberId)){

                m.setFirstName(firstNameTF.getText());
                m.setLastName(lastNameTF.getText());
                m.setEmail(emailIdTF.getText());
                m.setPhone(phoneNumberTF.getText());
                m.setAdress(adressTF.getText());
                m.setGender(genderCB.getValue());
                m.setDateOfBirth(dateOfBirthDP.getValue());

                if (!passswordPF.getText().isEmpty()) {
                    m.setPassword(passswordPF.getText());
                }

                break;
            }
        }

        saveMembers(list);

        showAlert("Profile Updated Successfully ✅");
    }

    // ✅ Update button (optional extra confirm)
    @FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        savechangeButtonOnAction(actionEvent);
    }

    // ✅ Cancel button
    @FXML
    public void cancelButtonOnAction(ActionEvent actionEvent)throws IOException {
        loadMemberData();
        passswordPF.clear();
        confirmPasswordPF.clear();
    }

    // ✅ Back button
    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"));

        Node node = loader.load();
        memberprofileUpdateMainPane.getChildren().setAll(node);
    }

    // ✅ Alert
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}