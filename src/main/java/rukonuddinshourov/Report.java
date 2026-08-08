package rukonuddinshourov;

import java.time.LocalDate;

public class Report {

    private String memberId;
    private String bookTitle;
    private String category;
    private LocalDate borrowedDate;
    private String returned;
    private LocalDate date;

    public Report(String memberId, String bookTitle, String category,
                  LocalDate borrowedDate, String returned, LocalDate date) {
        this.memberId = memberId;
        this.bookTitle = bookTitle;
        this.category = category;
        this.borrowedDate = borrowedDate;
        this.returned = returned;
        this.date = date;
    }

    public String getMemberId() { return memberId; }
    public String getBookTitle() { return bookTitle; }
    public String getCategory() { return category; }
    public LocalDate getBorrowedDate() { return borrowedDate; }
    public String getReturned() { return returned; }
    public LocalDate getDate() { return date; }
}