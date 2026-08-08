package rukonuddinshourov;

import java.io.Serializable;

public class FinePayment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String memberId;
    private String memberName;
    private String fineId;
    private String bookTitle;
    private String dueDate;
    private int daysLate;
    private double amount;
    private String paymentMethod;
    private String transactionId;
    private String status;      // Paid / Unpaid
    private String dateTime;

    public FinePayment(String memberId, String memberName, String fineId,
                       String bookTitle, String dueDate, int daysLate,
                       double amount, String paymentMethod,
                       String transactionId, String status, String dateTime) {

        this.memberId = memberId;
        this.memberName = memberName;
        this.fineId = fineId;
        this.bookTitle = bookTitle;
        this.dueDate = dueDate;
        this.daysLate = daysLate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.status = status;
        this.dateTime = dateTime;
    }

    public String getMemberId() { return memberId; }
    public String getMemberName() { return memberName; }
    public String getFineId() { return fineId; }
    public String getBookTitle() { return bookTitle; }
    public String getDueDate() { return dueDate; }
    public int getDaysLate() { return daysLate; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getTransactionId() { return transactionId; }
    public String getStatus() { return status; }
    public String getDateTime() { return dateTime; }

    @Override
    public String toString() {
        return fineId + " | " + memberId + " | " + amount + " TK | "
                + paymentMethod + " | " + status + " | " + dateTime;
    }
}