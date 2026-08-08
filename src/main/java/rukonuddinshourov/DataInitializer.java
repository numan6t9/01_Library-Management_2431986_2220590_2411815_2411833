package rukonuddinshourov;

import nonuser.Book;
import nonuser.IssuedBook;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static void main(String[] args) {

        // ============================
        // ১. Book.bin (আগের মতোই আছে)
        // ============================
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("B001", "Java Basics", "Herbert Schildt", "Issued"));
        bookList.add(new Book("B002", "Effective Java", "Joshua Bloch", "Issued"));
        bookList.add(new Book("B003", "Clean Code", "Robert Martin", "Issued"));
        bookList.add(new Book("B004", "Python Crash Course", "Eric Matthes", "Available"));
        bookList.add(new Book("B005", "Head First Design Patterns", "Eric Freeman", "Available"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Book.bin"))) {
            oos.writeObject(bookList);
            System.out.println("Book.bin Created Successfully ✅");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ======================================
        // ২. IssuedBooks.bin (এটুকু নতুন যোগ করুন)
        // ======================================
        List<IssuedBook> issuedList = new ArrayList<>();

        issuedList.add(new IssuedBook(
                "B001", "Java Basics", "M001",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2026, 7, 15),
                "Issued"
        ));

        issuedList.add(new IssuedBook(
                "B003", "Clean Code", "M001",
                LocalDate.of(2026, 7, 5),
                LocalDate.of(2026, 7, 19),
                "Issued"
        ));

        issuedList.add(new IssuedBook(
                "B002", "Effective Java", "M002",
                LocalDate.of(2026, 7, 10),
                LocalDate.of(2026, 7, 24),
                "Issued"
        ));

        try (ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("IssuedBooks.bin"))) {
            oos2.writeObject(issuedList);
            System.out.println("IssuedBooks.bin Created Successfully ✅");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("All files created! ✅");
    }
}