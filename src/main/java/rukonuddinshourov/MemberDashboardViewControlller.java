package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MemberDashboardViewControlller {
    @javafx.fxml.FXML
    private Label memberDashboard;
    @javafx.fxml.FXML
    private TableView recentlyBorrowedList;
    @javafx.fxml.FXML
    private TableColumn dueDateTC;
    @javafx.fxml.FXML
    private TextField fineTF;
    @javafx.fxml.FXML
    private TableColumn borrowDateTC;
    @javafx.fxml.FXML
    private ListView notificationLV;
    @javafx.fxml.FXML
    private TextField borrowNumberTF;
    @javafx.fxml.FXML
    private Label dashboardLB;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TableColumn bookidTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TextField reserveBookTF;
    @javafx.fxml.FXML
    private Label manuLB;
    @javafx.fxml.FXML
    private AnchorPane memberDasboardMainPane;


    @javafx.fxml.FXML
    public void payfineOnActionButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberPayFinesView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);




    }

    @javafx.fxml.FXML
    public void profileButtonOnAction(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberRegistrationView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void borrowedBooksButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/BorrowingHistoryView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);



    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberDashboardView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);



    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/LoginView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);



    }

    @javafx.fxml.FXML
    public void reservedBooksButtonOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/ReserveBookMemberView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);




    }

    @javafx.fxml.FXML
    public void borrowHistoryButtonOnAction(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/BorrowingHistoryView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void renewBooksButtonOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/RenewBorrowedBookView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);



    }

    @javafx.fxml.FXML
    public void settingsButtonOnActon(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberRegistrationView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);





    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/SearchBookView.fxml"));
        Node node = fxmlLoader.load();
        memberDasboardMainPane.getChildren().setAll(node);






        }
}
