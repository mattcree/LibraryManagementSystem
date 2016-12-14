/**
 * Created by Cree on 01/12/2016.
 */

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

    public void addBook() {
        this.numberOfBooks = this.numberOfBooks + 1;
    }

    public void removeBook() {
        if (this.numberOfBooks > 0) {
            this.numberOfBooks = this.numberOfBooks - 1;
        }
    }

    public int compareTo(User user) {
        int surnameCompare = this.getSurname().compareTo(user.getSurname());
        if (surnameCompare == 0) {
            return this.getFirstName().compareTo(user.getFirstName()) - surnameCompare;
        }
        return surnameCompare;
    }

    public String toString() {
        return firstName + " " + surname;
    }

}
