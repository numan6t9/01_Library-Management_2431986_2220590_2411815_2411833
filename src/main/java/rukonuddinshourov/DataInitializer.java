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

        new Book("B101","1111","Java Programming","James Gosling","Science",5,"Available");
                new Book("B102","2222","Database System","Elmasri","Science",3,"Reserved");
                new Book("B103","3333","Operating System","Silberschatz","Science",4,"Available");
                new Book("B104","4444","Clean Code","Robert Martin","Science",6,"Available");
                new Book("B105","5555","Java Basics","Herbert Schildt","Science",8,"Available");
                new Book("B106","6666","Effective Java","Joshua Bloch","Science",2,"Reserved");
                new Book("B107","7777","Database Systems","Elmasri","Science",4,"Available");
                new Book("B108","8888","Operating Systems","Silberschatz","Science",9,"Available");
                new Book("B109","9999","Artificial Intelligence","Russell Norvig","Science",3,"Unavailable");
                new Book("B110","1010","Discrete Mathematics","Rosen","Math",15,"Available");
                new Book("B111","1112","Data Structures","Mark Allen","Science",11,"Available");
                new Book("B112","1113","Computer Networks","Andrew Tanenbaum","Science",5,"Available");
                new Book("B113","1114","Software Engineering","Ian Sommerville","Science",6,"Available");
                new Book("B114","1115","Linear Algebra","Gilbert Strang","Math",10,"Available");
                new Book("B115","1116","Modern History","William Jones","History",8,"Unavailable");
                new Book("B116","1117","C Programming","Dennis Ritchie","Science",9,"Available");
                new Book("B117","1118","Python Programming","Guido Rossum","Science",14,"Available");
                new Book("B118","1119","Digital Logic Design","Morris Mano","Science",7,"Available");
                new Book("B119","1120","Statistics Basics","Robert Johnson","Math",13,"Available");
                new Book("B120","1121","Machine Learning","Tom Mitchell","Science",4,"Unavailable");

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