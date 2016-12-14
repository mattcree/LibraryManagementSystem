import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Cree on 01/12/2016.
 */
public class LibraryIO {


    public static void main(String[] args) throws FileNotFoundException {
        SortedArrayList<Book> bookList = new SortedArrayList<Book>();
        SortedArrayList<User> userList = new SortedArrayList<User>();
        Scanner inFile = new Scanner(new FileReader("C:\\LibraryManagementSystem\\librarydata.txt"));
        FileHandler.parseFile(inFile, bookList, userList);

        System.out.println(bookList.toString());
        System.out.println(userList.toString());


    }
}
