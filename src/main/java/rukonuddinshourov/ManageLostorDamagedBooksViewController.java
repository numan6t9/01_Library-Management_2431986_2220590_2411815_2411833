package rukonuddinshourov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class ManageLostorDamagedBooksViewController implements Initializable {

    // ===== TextFields =====
    @FXML private TextField BookIDTF;
    @FXML private TextField MemberIDTF;
    @FXML private TextField BookTitleTF;
    @FXML private TextField AuthorTF;
    @FXML private TextField fineperDayTF;

    @FXML private TextArea RemarksTA;


    @FXML private ComboBox<String> bookconditionCB;


    @FXML private DatePicker IssueDateDP;
    @FXML private DatePicker ReportDateDP;

    @FXML private TableView<LostBook> lostTableView;
    @FXML private TableColumn<LostBook, String> bookIDTC;
    @FXML private TableColumn<LostBook, String> memberIdTC;
    @FXML private TableColumn<LostBook, String> titleTC;
    @FXML private TableColumn<LostBook, String> conditionTC;
    @FXML private TableColumn<LostBook, Double> fineTC;
    @FXML private TableColumn<LostBook, String> statusTC;

    @FXML private AnchorPane lostordamagedBooksMainPane;

    private final ObservableList<LostBook> lostBookList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bookconditionCB.setItems(FXCollections.observableArrayList("Lost", "Damaged"));

        bookIDTC.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        memberIdTC.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        conditionTC.setCellValueFactory(new PropertyValueFactory<>("condition"));
        fineTC.setCellValueFactory(new PropertyValueFactory<>("fine"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        lostBookList.addAll(
                new LostBook("B101", "M101", "Java Programming", "Damaged", 200, "Pending"),
                new LostBook("B102", "M102", "Math Algebra", "Lost", 500, "Pending")
        );

        lostTableView.setItems(lostBookList);

        ReportDateDP.setValue(LocalDate.now());


        lostTableView.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldV, newV) -> {
                    if (newV != null) {
                        BookIDTF.setText(newV.getBookId());
                        MemberIDTF.setText(newV.getMemberId());
                        BookTitleTF.setText(newV.getTitle());
                        bookconditionCB.setValue(newV.getCondition());
                        fineperDayTF.setText(String.valueOf(newV.getFine()));
                    }
                });
    }

    @FXML
    public void SearchDamageorLostBook(ActionEvent actionEvent) {

        String id = BookIDTF.getText().trim();

        if (id.isEmpty()) {
            showAlert("Enter Book ID to search!");
            return;
        }

        for (LostBook b : lostBookList) {
            if (b.getBookId().equalsIgnoreCase(id)) {
                MemberIDTF.setText(b.getMemberId());
                BookTitleTF.setText(b.getTitle());
                bookconditionCB.setValue(b.getCondition());
                fineperDayTF.setText(String.valueOf(b.getFine()));
                lostTableView.getSelectionModel().select(b);
                showAlert("Book record found.");
                return;
            }
        }

        showAlert("No record found for Book ID: " + id);
    }

    @FXML
    public void CalculateFineOnActionButton(ActionEvent actionEvent) {

        if (IssueDateDP.getValue() == null || ReportDateDP.getValue() == null) {
            showAlert("Select Issue Date and Report Date!");
            return;
        }

        long days = ChronoUnit.DAYS.between(IssueDateDP.getValue(), ReportDateDP.getValue());

        if (days < 0) {
            showAlert("Report date cannot be before issue date!");
            return;
        }

        double perDay = 10;
        double base = "Lost".equals(bookconditionCB.getValue()) ? 500 : 100;

        double totalFine = base + (days * perDay);
        fineperDayTF.setText(String.valueOf(totalFine));
    }


    @FXML
    public void SaveRecordOnActionBitton(ActionEvent actionEvent) {

        if (BookIDTF.getText().isEmpty() || MemberIDTF.getText().isEmpty()
                || BookTitleTF.getText().isEmpty() || bookconditionCB.getValue() == null) {
            showAlert("Please fill all required fields!");
            return;
        }

        double fine;
        try {
            fine = Double.parseDouble(fineperDayTF.getText());
        } catch (NumberFormatException e) {
            showAlert("Calculate fine first!");
            return;
        }

        LostBook newBook = new LostBook(
                BookIDTF.getText(),
                MemberIDTF.getText(),
                BookTitleTF.getText(),
                bookconditionCB.getValue(),
                fine,
                "Recorded"
        );

        lostBookList.add(newBook);
        lostTableView.refresh();

        showAlert("Record saved successfully!");
    }

    @FXML
    public void UpdateLostorDamageBooksButton(ActionEvent actionEvent) {

        LostBook selected = lostTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Select a record from table to update!");
            return;
        }

        if (bookconditionCB.getValue() == null) {
            showAlert("Select book condition!");
            return;
        }

        selected.setCondition(bookconditionCB.getValue());

        try {
            selected.setFine(Double.parseDouble(fineperDayTF.getText()));
        } catch (NumberFormatException ignored) { }

        selected.setStatus("Updated");
        lostTableView.refresh();

        showAlert("Book status updated successfully!");
    }


    @FXML
    public void ClearRecordOnACtionButton(ActionEvent actionEvent) {

        BookIDTF.clear();
        MemberIDTF.clear();
        BookTitleTF.clear();
        AuthorTF.clear();
        fineperDayTF.clear();
        RemarksTA.clear();
        bookconditionCB.setValue(null);
        IssueDateDP.setValue(null);
        ReportDateDP.setValue(LocalDate.now());
        lostTableView.getSelectionModel().clearSelection();
    }

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/cse213finalproject/_1_librarymanagement_2431986_2220590_2411815_2411833/rukonuddinshourov/LibrarianDashboardview.fxml"));

        Node node = fxmlLoader.load();
        lostordamagedBooksMainPane.getChildren().setAll(node);
    }


    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}