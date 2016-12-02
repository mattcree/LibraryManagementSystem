/**
 * Created by Cree on 01/12/2016.
 */
public class Book implements Comparable<Book>{

    private String bookTitle;
    private String firstName;
    private String initial;
    private String surname;
    private boolean onLoan = false;

    public Book(String bookTitle, String firstName, String initial, String surname) {
        this.bookTitle = bookTitle;
        this.firstName = firstName;
        this.initial = initial;
        this.surname = surname;
    }

    public Book(String bookTitle, String firstName, String surname) {
        this.bookTitle = bookTitle;
        this.firstName = firstName;
        this.initial = null;
        this.surname = surname;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public String toString() {
        if (this.initial != null) {
            return this.firstName + " " + this.initial + ". " + this.surname;
        }
        return this.firstName + " " + this.surname;
    }

    public int compareTo(Book book) {
        return this.getSurname().compareTo(book.getSurname());
    }

}
