package nonuser;

import java.io.Serializable;

public class Book implements Serializable {

    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private String category;
    private int quantity;
    private String status;

    public Book(String bookId, String isbn, String title,
                String author, String category,
                int quantity, String status) {

        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.status = status;
    }

    // ================= Getters =================

    public String getBookId() { return bookId; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }

    // ================= Setters =================

    public void setBookId(String bookId) { this.bookId = bookId; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setCategory(String category) { this.category = category; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return bookId + " - " + title + " - " + author;
    }
}