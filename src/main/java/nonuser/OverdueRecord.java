package nonuser;

import java.time.LocalDate;

public class OverdueRecord {

    private String bookTitle;
    private LocalDate dueDate;
    private LocalDate issueDate;

    public OverdueRecord(String bookTitle,
                         LocalDate dueDate,
                         LocalDate issueDate) {
        this.bookTitle = bookTitle;
        this.dueDate = dueDate;
        this.issueDate = issueDate;
    }

    public String getBookTitle() { return bookTitle; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getIssueDate() { return issueDate; }
}