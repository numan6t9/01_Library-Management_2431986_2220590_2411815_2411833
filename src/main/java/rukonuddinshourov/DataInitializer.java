package rukonuddinshourov;

import nonuser.Book;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("B001","Java Basics","Herbert Schildt","Available"));
        bookList.add(new Book("B002","Effective Java","Joshua Bloch","Available"));
        bookList.add(new Book("B003","Clean Code","Robert Martin","Available"));
        bookList.add(new Book("B004","Python Crash Course","Eric Matthes","Available"));
        bookList.add(new Book("B005","Head First Design Patterns","Eric Freeman","Available"));

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("Book.bin"))) {

            oos.writeObject(bookList);
            System.out.println("Book.bin Created Successfully ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}