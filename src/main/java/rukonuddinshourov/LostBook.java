package rukonuddinshourov;

public class LostBook {

    private String bookId;
    private String memberId;
    private String title;
    private String condition;
    private double fine;
    private String status;

    public LostBook(String bookId, String memberId, String title,
                    String condition, double fine, String status) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.title = title;
        this.condition = condition;
        this.fine = fine;
        this.status = status;
    }

    public String getBookId() { return bookId; }
    public String getMemberId() { return memberId; }
    public String getTitle() { return title; }
    public String getCondition() { return condition; }
    public double getFine() { return fine; }
    public String getStatus() { return status; }

    public void setCondition(String condition) { this.condition = condition; }
    public void setFine(double fine) { this.fine = fine; }
    public void setStatus(String status) { this.status = status; }
}