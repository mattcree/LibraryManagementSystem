import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 12/12/2016.
 */

public class UserTest {

    @Test
    public void createUserShouldCreateValidUser() {
        User user = createValidUser();
        Assert.assertNotNull(user);
    }

    @Test
    public void getFirstNameShouldReturnFirstName() {
        User user = createValidUser();
        Assert.assertTrue(user.getFirstName().equals(firstName));
    }

    @Test
    public void setFirstNameShouldSetNewFirstName() {
        User user = createValidUser();
        user.setFirstName("Shirley");
        Assert.assertTrue(user.getFirstName().equals("Shirley"));
    }

    @Test
    public void getSurnameShouldReturnSurname() {
        User user = createValidUser();
        Assert.assertTrue(user.getSurname().equals(surname));
    }

    @Test
    public void setSurnameShouldSetNewSurname() {
        User user = createValidUser();
        user.setSurname("Jones");
        Assert.assertTrue(user.getSurname().equals("Jones"));
    }

    @Test
    public void getNumberOfBooksShouldReturnNumberOfBooks() {
        User user = createValidUser();
        Assert.assertTrue(user.getNumberOfBooks() == 0);
    }

    @Test
    public void addBookShouldIncrementNumberOfBooks() {
        User user = createValidUser();
        user.addBook();
        Assert.assertTrue(user.getNumberOfBooks() == 1);
    }

    @Test
    public void removeABookShouldDeincrementNumberOfBooks() {
        User user = createValidUser();
        user.addBook();
        user.addBook();
        user.addBook();
        user.removeBook();

        Assert.assertTrue(user.getNumberOfBooks() == 2);
    }

    @Test
    public void removeABookWhenNoBooksAddedShouldReturnZero() {
        User user = createValidUser();
        user.removeBook();

        Assert.assertTrue(user.getNumberOfBooks() == 0);
    }

    @Test
    public void compareToNameFurtherAlongAlphabetShouldReturnLessThanZero() {
        User user1 = createValidUser();
        User user2 = createValidUser();
        user2.setSurname("Zorro");
        Assert.assertTrue(user1.compareTo(user2) < 0);
    }

    @Test
    public void compareToNameBeforeInAlphabetShouldReturnGreaterThanZero() {
        User user1 = createValidUser();
        User user2 = createValidUser();
        user2.setSurname("Carson");
        Assert.assertTrue(user1.compareTo(user2) > 0);
    }

    @Test
    public void compareToSameNameShouldReturnZero() {
        User user1 = createValidUser();
        User user2 = createValidUser();
        Assert.assertTrue(user1.compareTo(user2) == 0);
    }

    @Test
    public void toStringShouldReturnFullNameAsString() {
        User user = createValidUser();
        Assert.assertTrue(user.toString().equals("Adam Jensen"));
    }

    @Test
    public void getMaxLoansShouldBeThree() {
        User user = createValidUser();
        Assert.assertTrue(user.getMaxLoans() == 3);
    }

    //Helpers
    //Creates valid user
    private String firstName = "Adam";
    private String surname = "Jensen";

    private User createValidUser() {
        return new User(firstName, surname);
    }

}
