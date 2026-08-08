package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class IssuedBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bookId;
    private String title;
    private String memberId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private String status;

    public IssuedBook(String bookId, String title, String memberId,
                      LocalDate issueDate, LocalDate dueDate, String status) {
        this.bookId = bookId;
        this.title = title;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getMemberId() { return memberId; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getDueDate() { return dueDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}