import java.io.*;
import java.util.Scanner;

/**
 * Created by Cree on 13/12/2016.
 */

public class FileHandler {

    /**
     * Parses the main text file containing the
     * @param inFile
     * @param bookList
     * @param userList
     * @return
     */
    public static boolean readFromFile(Scanner inFile, SortedArrayList<Book> bookList, SortedArrayList<User> userList){
        SortedArrayList<Book> tempBookList = new SortedArrayList<Book>();
        SortedArrayList<User> tempUserList = new SortedArrayList<User>();
        while (inFile.hasNextLine()) {
            try {
                int numberOfBooks = Integer.parseInt(inFile.nextLine());

                for (int i = 0; i < numberOfBooks; i++) {
                    tempBookList.add(makeBook(inFile.nextLine(), inFile.nextLine()));
                }
            } catch (Exception e) {
                return false;
            }

            try {
                int numberOfUsers = Integer.parseInt(inFile.nextLine());

                for (int i = 0; i < numberOfUsers; i++) {
                    tempUserList.add(makeUser(inFile.nextLine()));
                }
            } catch (Exception e) {
                return false;
            }

        }
        bookList.addAll(tempBookList);
        userList.addAll(tempUserList);
        return true;
    }

    /**
     * Writes a message to a specified file
     * @param outFile The file to be written to
     * @param message The message to be written to the file
     */
    public static void writeToFile(PrintWriter outFile, String message){
        outFile.println(message);
        outFile.close();
    }

    /**
     * Helper method which returns Book objects.
     * @param title The Title of the Book
     * @param name The Author's name
     * @return A valid Book.
     */
    public static Book makeBook(String title, String name) {
        String[] nameArray = name.split(" ");
        if (name.split(" ").length == 3) {
            return new Book(title, nameArray[0], nameArray[1], nameArray[2]);
        }
        return new Book(title, nameArray[0], nameArray[1]);
    }

    /**
     * Helper method which returns User objects.
     * @param name A name for the User
     * @return A valid User
     */
    public static User makeUser(String name) {
        String[] nameArray = name.split(" ");
        return new User(nameArray[0], nameArray[1]);
    }

}
