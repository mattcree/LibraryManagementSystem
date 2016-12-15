import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 15/12/2016.
 */
public class SortedArrayListTest {

    @Test
    public void createNewSortedArrayListOfBookShouldNotBeNull () {
        SortedArrayList<Book> bookList = createValidSortedBookList();
        Assert.assertNotNull(bookList);
    }

    @Test
    public void createNewSortedArrayListOfUserShouldNotBeNull () {
        SortedArrayList<User> userList = createValidSortedUserList();
        Assert.assertNotNull(userList);
    }

    @Test
    public void checkUserListOrderShouldBeOrderedByUserSurname() {
        SortedArrayList<User> userList = createValidSortedUserList();
        Assert.assertSame(userList.get(0), user2);
        Assert.assertSame(userList.get(1), user3);
        Assert.assertSame(userList.get(2), user1);
    }

    @Test
    public void checkBookListOrderShouldBeOrderedBySurname() {
        SortedArrayList<Book> bookList = createValidSortedBookList();
        Assert.assertSame(bookList.get(0), book2);
        Assert.assertSame(bookList.get(1), book1);
        Assert.assertSame(bookList.get(2), book3);
    }

    @Test
    public void checkUserListOrderWhenNewUserAddedShouldRetainOrdering() {
        SortedArrayList<User> userList = createValidSortedUserList();

        User newUser = new User("Harold", "Kyle");

        userList.add(newUser);

        Assert.assertSame(userList.get(0), user2);
        Assert.assertSame(userList.get(1), user3);
        Assert.assertSame(userList.get(2), newUser);
        Assert.assertSame(userList.get(3), user1);
    }

    @Test
    public void checkBookListOrderWhenNewUserAddedShouldRetainOrdering() {
        SortedArrayList<Book> bookList = createValidSortedBookList();

        Book newBook = new Book ("Assyria", "Jill", "Stein");

        bookList.add(newBook);

        Assert.assertSame(bookList.get(0), book2);
        Assert.assertSame(bookList.get(1), book1);
        Assert.assertSame(bookList.get(2), newBook);
        Assert.assertSame(bookList.get(3), book3);
    }

    @Test
    public void checkUserListOrderShouldBeOrderedBySurnameButAlsoByFirstNameIfSameSurname() {
        SortedArrayList<User> userList = createValidSortedUserList();
        User newUser = new User("Barry", "Davro");
        userList.add(newUser);
        User newUser2 = new User("Aaron", "Smith");
        userList.add(newUser2);

        Assert.assertSame(userList.get(0), user2);
        Assert.assertSame(userList.get(1), newUser);
        Assert.assertSame(userList.get(2), user3);
        Assert.assertSame(userList.get(3), newUser2);
        Assert.assertSame(userList.get(4), user1);
    }

    //Test Helpers
    private User user1 = new User("John", "Smith");
    private User user2 = new User("Barry", "Bant");
    private User user3 = new User("Bobby", "Davro");

    private Book book1 = new Book("Killing Fields", "Jason", "J", "Jones");
    private Book book2 = new Book("Bible", "Jesus", "Christ");
    private Book book3 = new Book("Don Quixote", "Bobby", "J", "Xervantes");


    private SortedArrayList<Book> createValidSortedBookList() {
        SortedArrayList<Book> bookList = new SortedArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        return bookList;
    }

    private SortedArrayList<User> createValidSortedUserList() {
        SortedArrayList<User> userList = new SortedArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
