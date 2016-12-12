
public class User implements Comparable<User>{

    String firstName;
    String surname;
    int numberOfBooks = 0;

    public User(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public int compareTo(User user) {
        return this.getSurname().compareTo(user.getSurname());
    }

    public String toString() {
        return firstName + " " + surname;
    }

}
