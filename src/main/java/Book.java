import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private String title;
    private String publisher;
    private long isbn10;
    private int publishingYear;
    private float price;
    private boolean own;
    private short authorsCount;
    private int age;
    private String[] authors;

    private ArrayList<Book> books = new ArrayList<>();

    /**
     * Constructor
     */
    Book() {}
    Book(String title, String publisher, long isbn10, int publishingYear, float price, boolean own, short authorsCount) {
        if (title.isBlank() || publisher.isBlank() || isbn10<0 || authorsCount < 0) throw new IllegalArgumentException("Invalid values for type Book");

        this.title = title;
        this.publisher = publisher;
        this.isbn10 = isbn10;
        this.publishingYear = publishingYear;
        setAge(publishingYear);
        setPrice(price);
        this.own = own;
        this.authorsCount = authorsCount;
    }

    /**
     * Setter Getter
     */
    public void setPrice(float price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be < 0");
        this.price = price;
    }
    private void setAge(int publishingYear) {
        if (publishingYear >= LocalDate.now().getYear()) throw new IllegalArgumentException("Publishing year cannot be in the future");
        this.age = LocalDate.now().getYear()-publishingYear;
    }
    private void setAuthors(String[] authors, short authorsCount) {
        if (authors.length != authorsCount) throw new IllegalArgumentException("authors cannot be less or more than authorsCount");
        this.authors = authors;
    }


    /**
     * toString
     */
    // Write your code here ...

    /**
     * Compare
     */
    // Write your code here ...

    /**
     * Read and Write a Book
     */
    public static ArrayList<Book> readBooks(String filepath) {
        ArrayList<Book> books = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filepath))) {
            String libraryTitle = dis.readUTF();
            short bookCount = dis.readShort();
            Book output;

            for (int i = 0; i < bookCount; i++) {
                String title = dis.readUTF();
                String publisher = dis.readUTF();
                long isbn10 = dis.readLong();
                int publishingYear = dis.readInt();
                float price = dis.readFloat();
                boolean own = dis.readBoolean();
                short authorsCount = dis.readShort();
                output = new Book(title, publisher, isbn10, publishingYear, price, own, authorsCount);
                String[] authors = new String[authorsCount];
                for (int j = 0; j < authorsCount-1; j++) {
                    authors[i] = dis.readUTF();
                }
                output.setAuthors(authors, authorsCount);
                books.add(output);
            }
            return books;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Find the Necronomicon and OWN it
     */
    // Write your code here ...


    void main() {
        /*
         * Test your code in the main method and / or write tests
         *
         * Read the binary file "myLibrary.dat"
         *
         * Write down the amount of entries you read and saved to the terminal
         * Print all the books you read
         */

        System.out.println(Book.readBooks("src/main/resources/myLibrary.dat"));
    }
}
