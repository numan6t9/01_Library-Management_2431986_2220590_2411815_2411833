package nonuser;

import java.io.IOException;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private String status;

    public Book(String bookId, String title, String author, String status) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}