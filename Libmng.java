import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
    private int nextBookId = 1;

    public Library() {
        books = new ArrayList<>();
        titleToBookMap = new HashMap<>();
    }

    public int generateBookId() {
        return nextBookId++;
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

    public void removeBookById(int bookId) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getId() == bookId) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            removeBook(bookToRemove);
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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter book title (or 'quit' to exit): ");
            String title = scanner.nextLine();
            if (title.equals("quit")) {
                break;
            }

            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            System.out.print("Enter book ISBN: ");
            String isbn = scanner.nextLine();

            int bookId = library.generateBookId();
            Book book = new Book(bookId, title, author, isbn);
            library.addBook(book);

            System.out.println("Book added with ID: " + bookId);
        }

        library.displayAvailableBooks();

        System.out.print("Enter the ID of the book to remove: ");
        int bookIdToRemove = scanner.nextInt();
        library.removeBookById(bookIdToRemove);

        library.displayAvailableBooks();

        scanner.nextLine(); 
        System.out.print("Enter the title to search for: ");
        String searchTitle = scanner.nextLine();
        Book foundBook = library.searchByTitle(searchTitle);

        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.getTitle());
        } else {
            System.out.println("Book not found.");
        }

        scanner.close();
    }
}
