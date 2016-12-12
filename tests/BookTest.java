import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 12/12/2016.
 */

public class BookTest {

    @Test
    public void createNewBookWithInitialShouldCreateValidBook() {
        Book book = createValidBookWithInitial();
        Assert.assertNotNull(book);
    }

    @Test
    public void createNewBookWithoutInitialShouldCreateValidBook() {
        Book book = createValidBookWithoutInitial();
        Assert.assertNotNull(book);
    }

    @Test
    public void getAuthorBookTitleShouldReturnBookTitle() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.getBookTitle().equals(bookTitle));
    }

    @Test
    public void setAuthorBookTitleShouldSetNewBookTitle() {
        Book book = createValidBookWithInitial();
        book.setBookTitle("Barry Does Science");
        Assert.assertTrue(book.getBookTitle().equals("Barry Does Science"));
    }

    @Test
    public void getAuthorFirstNameShouldGetAuthorFirstName() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.getAuthorFirstName().equals(firstName));
    }

    @Test
    public void setAuthorFirstNameShouldSetNewAuthorFirstName() {
        Book book = createValidBookWithInitial();
        book.setAuthorFirstName("Jimmy");
        Assert.assertTrue(book.getAuthorFirstName().equals("Jimmy"));
    }

    @Test
    public void getInitialWhenBookAuthorHasInitialShouldReturnAuthorInitial() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.getAuthorInitial().equals(initial));
    }

    @Test
    public void getInitialWhenBookAuthorHasNoInitialShouldReturnNull() {
        Book book = createValidBookWithoutInitial();
        Assert.assertNull(book.getAuthorInitial());
    }

    @Test
    public void setAuthorInitialShouldSetNewAuthorInitial() {
        Book book = createValidBookWithoutInitial();
        book.setAuthorInitial("B");
        Assert.assertTrue(book.getAuthorInitial().equals("B"));
    }

    @Test
    public void getAuthorSurnameShouldGetAuthorSurname() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.getAuthorSurname().equals(lastName));
    }

    @Test
    public void setAuthorSurnameShouldSetNewAuthorSurname() {
        Book book = createValidBookWithInitial();
        book.setAuthorSurname("Bojangles");
        Assert.assertTrue(book.getAuthorSurname().equals("Bojangles"));
    }

    @Test
    public void isOnLoanShouldReturnFalseIfNotOnLoan() {
        Book book = createValidBookWithInitial();
        Assert.assertFalse(book.isOnLoan());
    }

    @Test
    public void setOnLoanShouldReturnTrueIfOnLoan() {
        Book book = createValidBookWithInitial();
        User user = createValidUser();
        book.setOnLoan(user);
        Assert.assertTrue(book.isOnLoan());
        Assert.assertNotNull(book.getBorrower());
    }

    @Test
    public void setNotOnLoanShouldSetNotOnLoan() {
        Book book = createValidBookWithInitial();
        User user = createValidUser();
        book.setOnLoan(user);
        book.setNotOnLoan();

        Assert.assertFalse(book.isOnLoan());
        Assert.assertNull(book.getBorrower());
    }

    @Test
    public void toStringWithInitialShouldReturnFullAuthorName() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.toString().equals("John J. Wilkes"));
    }

    @Test
    public void toStringWithNoInitialShouldReturnFullAuthorName() {
        Book book = createValidBookWithoutInitial();
        Assert.assertTrue(book.toString().equals("John Wilkes"));
    }

    @Test
    public void compareToBookWithAuthorSurnameAfterSurnameInAlphabetShouldReturnNumberLessThanZero() {
        Book book1 = createValidBookWithInitial();
        Book book2 = createValidBookWithInitial();
        book2.setAuthorSurname("Zyklon");
        Assert.assertTrue(book1.compareTo(book2) < 0);
    }

    @Test
    public void compareToBookWithAuthorSurnameBeforeSurnameInAlphabetShouldReturnNumberGreaterThanZero() {
        Book book1 = createValidBookWithInitial();
        Book book2 = createValidBookWithInitial();
        book2.setAuthorSurname("Brooks");
        Assert.assertTrue(book1.compareTo(book2) > 0);
    }

    @Test
    public void compareToBookWithSameAuthorSurnameShouldReturnZero() {
        Book book1 = createValidBookWithInitial();
        Book book2 = createValidBookWithInitial();
        Assert.assertTrue(book1.compareTo(book2) == 0);
    }


    //Test Helpers
    //Creates valid book
    private String firstName = "John";
    private String initial = "J";
    private String lastName = "Wilkes";
    private String bookTitle = "Fun Barry";

    private Book createValidBookWithInitial() {
        return new Book(bookTitle, firstName, initial, lastName);
    }

    private Book createValidBookWithoutInitial() {
        return new Book(bookTitle, firstName, lastName);
    }

    //Creates Valid User
    private String userFirstName = "Adam";
    private String userSurname = "Janus";

    private User createValidUser() {
        return new User(userFirstName, userSurname);
    }





}
