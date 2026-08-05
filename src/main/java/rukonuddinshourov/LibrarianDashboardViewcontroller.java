package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import javax.xml.namespace.QName;
import java.io.IOException;

public class LibrarianDashboardViewcontroller {

    @javafx.fxml.FXML
    private AnchorPane librarianDashboardMainPane;

    @javafx.fxml.FXML
    public void MemberRegistrationButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/MemberRegistrationView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void ManageLostorDamagedBooksButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/ManageLostorDamagedBooksView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void ProcessBookReturnsButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/ProcessBookReturnsView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);




    }

    @javafx.fxml.FXML
    public void UpdateLibraryCatalogButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/UpdateLibraryCatalogView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void IssueBookButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/IssueBookToMemberview.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void GenerateLibraryReportsButton(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/GenerateLibraryReportsView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);




    }

    @javafx.fxml.FXML
    public void ManageOverdueBooksandFinesButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/ManageOverdueBooksandFinesView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);



    }

    @javafx.fxml.FXML
    public void CreateNewAnnouncementOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/CreateNewAnnouncementView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/LoginView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPane.getChildren().setAll(node);
    }
}
