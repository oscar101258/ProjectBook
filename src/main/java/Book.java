import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Oscar
 * 08/27/25
 * 0.1.0
 */
public class Book {
    public static final int AUTHOR_ = 4;
    public static final int DUE_DATE_ = 5;
    public static final int ISBN_ = 0;
    public static final int PAGE_COUNT_ = 3;
    public static final int SUBJECT_ = 2;
    public static final int TITLE_ = 1;
    private String author;
    private LocalDate dueDate;
    private String ISBN;
    private int pageCount;
    private String subject;
    private String title;
    public Book(String ISBN, String title, String subject, int pageCount, String author, LocalDate dueDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.subject = subject;
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getPageCount() == book.getPageCount() && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getISBN(), book.getISBN()) && Objects.equals(getSubject(), book.getSubject()) && Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getISBN(), getPageCount(), getSubject(), getTitle());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title + " by " + author + " ISBN: " + ISBN;

    }
}
