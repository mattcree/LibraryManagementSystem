/**
 * Created by Cree on 01/12/2016.
 */
public class Book implements Comparable<Book>{

    private String bookTitle;
    private String firstName;
    private String initial;
    private String surname;
    private boolean onLoan = false;
    private User borrower = null;

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

    public String getAuthorFirstName() {
        return firstName;
    }

    public void setAuthorFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAuthorInitial() {
        return initial;
    }

    public void setAuthorInitial(String initial) {
        this.initial = initial;
    }

    public String getAuthorSurname() {
        return surname;
    }

    public void setAuthorSurname(String surname) {
        this.surname = surname;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(User user) {
        this.onLoan = true;
        this.borrower = user;
    }

    public void setNotOnLoan() {
        this.onLoan = false;
        this.borrower = null;
    }

    public User getBorrower() {
        return this.borrower;
    }

    public String toString() {
        if (this.initial != null) {
            return this.firstName + " " + this.initial + ". " + this.surname;
        }
        return this.firstName + " " + this.surname;
    }

    public int compareTo(Book book) {
        return this.getAuthorSurname().compareTo(book.getAuthorSurname());
    }

}
