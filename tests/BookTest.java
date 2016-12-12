import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 12/12/2016.
 */

public class BookTest {

    @Test
    public void createNewBookWithInitial() {
        Book book = createValidBookWithInitial();
        Assert.assertNotNull(book);
    }

    @Test
    public void createNewBookWithoutInitial() {
        Book book = createValidBookWithoutInitial();
        Assert.assertNotNull(book);
    }

    @Test
    public void getAuthorBookTitle() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.getBookTitle().equals(bookTitle));
    }

    @Test
    public void setAuthorBookTitle() {
        Book book = createValidBookWithInitial();
        book.setBookTitle("Barry Does Science");
        Assert.assertTrue(book.getBookTitle().equals("Barry Does Science"));
    }

    @Test
    public void getAuthorFirstName() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.getAuthorFirstName().equals(firstName));
    }

    @Test
    public void setAuthorFirstName() {
        Book book = createValidBookWithInitial();
        book.setAuthorFirstName("Jimmy");
        Assert.assertTrue(book.getAuthorFirstName().equals("Jimmy"));
    }

    @Test
    public void getInitialWhenBookAuthorHasInitial() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.getAuthorInitial().equals(initial));
    }

    @Test
    public void getInitialWhenBookAuthorHasNoInitial() {
        Book book = createValidBookWithoutInitial();
        Assert.assertNull(book.getAuthorInitial());
    }

    @Test
    public void setAuthorInitial() {
        Book book = createValidBookWithoutInitial();
        book.setAuthorInitial("B");
        Assert.assertTrue(book.getAuthorInitial().equals("B"));
    }

    @Test
    public void getAuthorSurname() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.getAuthorSurname().equals(lastName));
    }

    @Test
    public void setAuthorSurname() {
        Book book = createValidBookWithInitial();
        book.setAuthorSurname("Bojangles");
        Assert.assertTrue(book.getAuthorSurname().equals("Bojangles"));
    }

    @Test
    public void isOnLoan() {
        Book book = createValidBookWithInitial();
        Assert.assertFalse(book.isOnLoan());
    }

    @Test
    public void setOnLoan() {
        Book book = createValidBookWithInitial();
        User user = createValidUser();
        book.setOnLoan(user);
        Assert.assertTrue(book.isOnLoan());
        Assert.assertNotNull(book.getBorrower());
    }

    @Test
    public void setNotOnLoan() {
        Book book = createValidBookWithInitial();
        User user = createValidUser();
        book.setOnLoan(user);
        book.setNotOnLoan();

        Assert.assertFalse(book.isOnLoan());
        Assert.assertNull(book.getBorrower());
    }

    @Test
    public void toStringWithInitial() {
        Book book = createValidBookWithInitial();
        Assert.assertTrue(book.toString().equals("John J. Wilkes"));
    }

    @Test
    public void toStringWithNoInitial() {
        Book book = createValidBookWithoutInitial();
        Assert.assertTrue(book.toString().equals("John Wilkes"));
    }

    @Test
    public void compareToBookWithAuthorSurnameAfterSurnameInAlphabet() {
        Book book1 = createValidBookWithInitial();
        Book book2 = createValidBookWithInitial();
        book2.setAuthorSurname("Zyklon");
        Assert.assertTrue(book1.compareTo(book2) < 0);
    }

    @Test
    public void compareToBookWithAuthorSurnameBeforeSurnameInAlphabet() {
        Book book1 = createValidBookWithInitial();
        Book book2 = createValidBookWithInitial();
        book2.setAuthorSurname("Brooks");
        Assert.assertTrue(book1.compareTo(book2) > 0);
    }

    @Test
    public void compareToBookWithSameAuthorSurname() {
        Book book1 = createValidBookWithInitial();
        Book book2 = createValidBookWithInitial();
        Assert.assertTrue(book1.compareTo(book2) == 0);
    }












    //@Test
//    public void createNewBookWithoutAuthorInitial() {
//        Book book = new Book("Fun Barry", "John", "Wilkes");
//        Assert.assertNull(book.getAuthorInitial());
//        Assert.assertTrue(book.getAuthorFirstName().equals("John"));
//        Assert.assertTrue(book.getAuthorSurname().equals("Wilkes"));
//        Assert.assertNotNull(book.getBookTitle());
//    }
//
//    @Test
//    public void createNewBookWithAuthorInitial() {
//        Book book = new Book("Fun Barry", "John", "J","Wilkes");
//        Assert.assertTrue(book.getAuthorInitial().equals("J"));
//        Assert.assertTrue(book.getAuthorFirstName().equals("John"));
//        Assert.assertTrue(book.getAuthorSurname().equals("Wilkes"));
//        Assert.assertNotNull(book.getBookTitle());
//    }


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
