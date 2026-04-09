import utilities.Code;

import java.util.HashMap;
import java.util.Objects;


/**
 * Shelf class represents a shelf in a library that holds books of a specific subject
 * @author Oscar
 * 08/27/25
 * 0.1.0
 */
public class Shelf {

    public static final int SHELF_NUMBER_ = 0;
    public static final int SUBJECT_ = 1;
    private HashMap<Book, Integer> books;
    private int shelfNumber;
    private String subject;

    public Shelf(int shelfNumber, String subject) {
        this.shelfNumber = shelfNumber;
        this.subject = subject;
        this.books = new HashMap<>();

    }
    public Shelf(){
        this.books = new HashMap<>();

    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Adds a book to the shelf
     * @param book to be added to the shelf
     * @return Code.SUCCESS if added, Code.SHELF_SUBJECT_MISMATCH_ERROR if mismatch
     */
    public Code addBook(Book book){

        if(books.containsKey(book)){
            books.put(book, books.get(book) + 1);
            System.out.println(book.toString() + " added to shelf" + this.toString());
            return Code.SUCCESS;
        } else if(subject.equals(book.getSubject())){
            books.put(book,1);
            System.out.println(book.toString() + " added to shelf" + this.toString());
            return Code.SUCCESS;
        }else {
            return Code.SHELF_SUBJECT_MISMATCH_ERROR;
        }

    }

    /**
     * removes book from shelf
     * @param book the book to be removed
     * @return Code.SUCCESS if book is removed. Code.BOOK_NOT_IN_INVENTORY_ERROR if book is not in inventory
     */
    public Code removeBook(Book book){
        if(!books.containsKey(book)){
            System.out.println(book.toString() + " is not on shelf " + this.subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else if(books.get(book) == 0){
            System.out.println("No copies of " + book.toString() + " remaining on shelf " + this.subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else {
            books.put(book, books.get(book) - 1);
            System.out.println(book.toString() + " removed from shelf" + this.subject);
            return Code.SUCCESS;
        }
    }


    public int getBookCount(Book book){
        if(!books.containsKey(book)){
            return -1;
        } else{
            return books.get(book);
        }
    }

    /**
     * outputs set of total books on a specific shelf
     * @return a string with total book\s on shelf with its category
     */
    public String listBooks(){
        int totalBooks = 0;
        String output = "";
        for(int count : books.values()){
            totalBooks += count;
        }

        if(totalBooks == 1){
            output += totalBooks + " book on shelf: " + this.toString() + "\n";
        } else{
            output += totalBooks + " books on shelf: " + this.toString() + "\n";
        }

        for(HashMap.Entry<Book, Integer> entry : books.entrySet()){
            //entry.getKey() gives book
            //entry.getValue() gives count
            output += entry.getKey().toString() + " " + entry.getValue() + "\n";
        }
        return output;
    }

    /**
     *
     * @return a string with shelfNumber : subject
     */
    public String toString(){
        return shelfNumber + " : " + subject;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return getShelfNumber() == shelf.getShelfNumber() && Objects.equals(getSubject(), shelf.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShelfNumber(), getSubject());
    }
}
