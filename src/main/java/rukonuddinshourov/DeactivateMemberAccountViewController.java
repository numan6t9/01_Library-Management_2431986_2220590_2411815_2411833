package rukonuddinshourov;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import rukonuddinshourov.Member;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DeactivateMemberAccountViewController {

    private static final String MEMBER_FILE = "members.bin";

    @FXML
    private TextField memberNameTF;

    @FXML
    private TextArea warningTA;

    @FXML
    private RadioButton noRB;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField memberIdTF;
    @FXML
    private RadioButton yesRB;
    @FXML
    private Label deactivatelabell;
    @FXML
    private Label statusLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private AnchorPane deactivateAccountMainPane;

    private ToggleGroup confirmationGroup;
    private String selectedAction = "";

    @FXML
    public void initialize() {

        confirmationGroup = new ToggleGroup();
        yesRB.setToggleGroup(confirmationGroup);
        noRB.setToggleGroup(confirmationGroup);

        noRB.setSelected(true);

        warningTA.setText(
                "Deactivate:\n" +
                        "• Disable access to library system\n" +
                        "• Cancel current login session\n\n" +
                        "Delete:\n" +
                        "• Permanently remove your account"
        );

        memberNameTF.setEditable(false);
        emailTF.setEditable(false);
        statusLabel.setText("Active");
    }

    @FXML
    public void deactivateAccountOnActionButton(ActionEvent actionEvent) {

        if (!loadMemberFromFile()) {
            return;
        }

        selectedAction = "DEACTIVATE";
        messageLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: darkorange;");
        messageLabel.setText("Select Yes and enter password/OTP, then click Confirm.");
    }

    @FXML
    public void deleteAccountOnActionButton(ActionEvent actionEvent) {

        if (!loadMemberFromFile()) {
            return;
        }

        selectedAction = "DELETE";
        messageLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: red;");
        messageLabel.setText("Warning: Delete permanently removes the account. Select Yes and confirm.");
    }

    @FXML
    public void confirmOnActionButton(ActionEvent actionEvent) {

        String memberId = memberIdTF.getText().trim();
        String enteredPassword = passwordTF.getText().trim();

        if (selectedAction.isEmpty()) {
            showMessage("First click Deactivate Account or Delete Account.", true);
            return;
        }

        if (memberId.isEmpty()) {
            showMessage("Enter Member ID first.", true);
            return;
        }

        if (!yesRB.isSelected()) {
            showMessage("Please select Yes to confirm this action.", true);
            return;
        }

        if (enteredPassword.isEmpty()) {
            showMessage("Enter password or OTP.", true);
            return;
        }

        List<Member> memberList = readMembers();

        Member foundMember = null;

        for (Member member : memberList) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                foundMember = member;
                break;
            }
        }

        if (foundMember == null) {
            showMessage("Member ID was not found in members.bin.", true);
            return;
        }


        if (!foundMember.getPassword().equals(enteredPassword)) {
            showMessage("Incorrect password or OTP.", true);
            return;
        }

        if (selectedAction.equals("DEACTIVATE")) {

            foundMember.setStatus("Inactive");
            saveMembers(memberList);

            statusLabel.setText("Inactive");
            passwordTF.clear();

            showMessage("Account deactivated successfully. Status saved in members.bin.", false);

        } else if (selectedAction.equals("DELETE")) {

            memberList.remove(foundMember);
            saveMembers(memberList);

            clearFields();

            showMessage("Account deleted successfully from members.bin.", false);
        }

        selectedAction = "";
        noRB.setSelected(true);
    }

    @FXML
    public void logoutOnActionButton(ActionEvent actionEvent) {

        clearFields();
        selectedAction = "";

        showMessage("Logout successful.", false);

        /*
         * If you have LoginView.fxml, uncomment and correct its path:
         *
         * try {
         *     FXMLLoader loader = new FXMLLoader(getClass().getResource(
         *         "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LoginView.fxml"
         *     ));
         *     Node node = loader.load();
         *     deactivateAccountMainPane.getChildren().setAll(node);
         * } catch (IOException e) {
         *     showMessage("Could not load login page.", true);
         * }
         */
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberDashboardView.fxml"
        ));

        Node node = fxmlLoader.load();
        deactivateAccountMainPane.getChildren().setAll(node);
    }

    private boolean loadMemberFromFile() {

        String memberId = memberIdTF.getText().trim();

        if (memberId.isEmpty()) {
            showMessage("Please enter Member ID.", true);
            return false;
        }

        List<Member> memberList = readMembers();

        for (Member member : memberList) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {

                memberNameTF.setText(member.getName());
                emailTF.setText(member.getEmail());
                statusLabel.setText(member.getStatus());

                return true;
            }
        }

        memberNameTF.clear();
        emailTF.clear();
        statusLabel.setText("");

        showMessage("Member was not found in members.bin.", true);
        return false;
    }

    private List<Member> readMembers() {

        List<Member> memberList = new ArrayList<>();

        Path filePath = Path.of(MEMBER_FILE);

        if (!Files.exists(filePath)) {
            return memberList;
        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(new FileInputStream(MEMBER_FILE))) {

            Object object = inputStream.readObject();
            memberList = (List<Member>) object;

        } catch (EOFException e) {
            // Empty .bin file: return empty list.
        } catch (IOException | ClassNotFoundException e) {
            showMessage("Could not read members.bin: " + e.getMessage(), true);
        }

        return memberList;
    }

    private void saveMembers(List<Member> memberList) {

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream(MEMBER_FILE))) {

            outputStream.writeObject(memberList);

        } catch (IOException e) {
            showMessage("Could not save members.bin: " + e.getMessage(), true);
        }
    }

    private void clearFields() {

        memberIdTF.clear();
        memberNameTF.clear();
        emailTF.clear();
        passwordTF.clear();

        statusLabel.setText("Active");

        yesRB.setSelected(false);
        noRB.setSelected(true);
    }

    private void showMessage(String message, boolean isError) {

        if (isError) {

            messageLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: red;");
        } else {
            messageLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: darkgreen;");
        }

        messageLabel.setText(message);
    }

    @FXML
    public void searhonActionButton(ActionEvent actionEvent) {
        String memberIdText = memberIdTF.getText().trim();

        if (memberIdText.isEmpty()) {
            showMessage("Please enter Member ID to search.", true);
            return;
        }

        List<Member> memberList = readMembers();
        boolean found = false;

        for (Member member : memberList) {
            // যদি মেম্বার আইডি int হয় তবে String.valueOf(member.getMemberId()) ব্যবহার করুন
            if (String.valueOf(member.getMemberId()).equals(memberIdText)) {
                memberNameTF.setText(member.getName());
                emailTF.setText(member.getEmail());
                statusLabel.setText(member.getStatus());
                showMessage("Member found: " + member.getName(), false);
                found = true;
                break;
            }

        }


    }



}