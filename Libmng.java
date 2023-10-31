
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
    private int id;
    private String title;
    private String author;
    private String ISBN;
    private boolean available;

    public Book(int id, String title, String author, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true; 
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }
}

class Library {
    private List<Book> books;
    private Map<String, Book> titleToBookMap;

    public Library() {
        books = new ArrayList<>();
        titleToBookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        titleToBookMap.put(book.getTitle(), book);
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            titleToBookMap.remove(book.getTitle());
        }
    }

    public void updateAvailability(int bookId, boolean isAvailable) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (isAvailable) {
                    book.returnBook();
                } else {
                    book.borrow();
                }
                return;
            }
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }

    public Book searchByTitle(String title) {
        return titleToBookMap.get(title);
    }
}

public class Libmng {
    public static void main(String[] args) {
        Library library = new Library();

        
        Book book1 = new Book(1, "Book A", "Author A", "ISBN111");
        Book book2 = new Book(2, "Book B", "Author B", "ISBN222");
        library.addBook(book1);
        library.addBook(book2);

        
        library.displayAvailableBooks();

        
        library.updateAvailability(1, false);

        
        library.displayAvailableBooks();

        
        Book foundBook = library.searchByTitle("Book A");
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }
}
