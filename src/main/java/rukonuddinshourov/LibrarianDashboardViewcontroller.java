package rukonuddinshourov;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import javax.xml.namespace.QName;
import java.io.IOException;

public class LibrarianDashboardViewcontroller {
    @javafx.fxml.FXML
    private AnchorPane librarianDashboardMainPanel;

    @javafx.fxml.FXML
    public void LogoutFOrLibrarianButton(ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name))
//        Node node = fxmlLoader.load();


    }

    @javafx.fxml.FXML
    public void MemberRegistrationButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/MemberRegistrationView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);




    }

    @javafx.fxml.FXML
    public void ManageLostorDamagedBooksButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/ManageLostorDamageedBooksView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);


    }
    @Deprecated
    public void CreateNewAnnouncementButton(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/CreateNewAnnouncementView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void ProcessBookReturnsButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/ProcessBookReturnsView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);




    }

    @javafx.fxml.FXML
    public void UpdateLibraryCatalogButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/UpdateLibraryCatalogView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void IssueBookButton(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/IssuebooksToMemberView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);


    }

    @javafx.fxml.FXML
    public void GenerateLibraryReportsButton(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/GenerateLibraryReportsView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);




    }

    @javafx.fxml.FXML
    public void ManageOverdueBooksandFinesButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/ManageOverdueBooksandFinesView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);



    }

    @javafx.fxml.FXML
    public void CreateNewAnnouncementOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonudddinshourov/CreateNewAnnouncementView.fxml"));
        Node node = fxmlLoader.load();
        librarianDashboardMainPanel.getChildren().setAll(node);


    }
}
