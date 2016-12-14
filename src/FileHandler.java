import java.util.Scanner;

/**
 * Created by Cree on 13/12/2016.
 */

public class FileHandler {

    public static boolean parseFile(Scanner inFile, SortedArrayList<Book> bookList, SortedArrayList<User> userList){
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

//    parseBook
//    parseUser

    private static Book makeBook(String title, String name) {
        String[] nameArray = name.split(" ");
        if (name.split(" ").length == 3) {
            return new Book(title, nameArray[0], nameArray[1], nameArray[2]);
        }
        return new Book(title, nameArray[0], nameArray[1]);
    }

    private static User makeUser(String name) {
        String[] nameArray = name.split(" ");
        return new User(nameArray[0], nameArray[1]);
    }
}
