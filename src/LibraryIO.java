import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Cree on 01/12/2016.
 */

public class LibraryIO {

    private static Scanner scanner = new Scanner(System.in);
    private static SortedArrayList<Book> bookList = new SortedArrayList<Book>();
    private static SortedArrayList<User> userList = new SortedArrayList<User>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader("C:\\LibraryManagementSystem\\librarydata.txt"));

        if (FileHandler.parseFile(inFile, bookList, userList)) {
            MainMenu.show();
        } else {
            println("Error parsing file.");
        }

    }

    public static class MainMenu {

        private static final String DISPLAY_BOOK_INFO = "b";
        private static final String DISPLAY_USER_INFO = "u";
        private static final String ISSUE_BOOK = "i";
        private static final String RETURN_BOOK = "r";
        private static final String QUIT_PROGRAM = "f";

        public static void show() {
            boolean finished = false;
            println("Welcome to the Library Management System");
            println("");
            while (!finished) {

                switch (MainMenu.selection()) {
                    case MainMenu.DISPLAY_BOOK_INFO:
                        printAllBooks();
                        break;
                    case MainMenu.DISPLAY_USER_INFO:
                        printAllUsers();
                        break;
                    case MainMenu.ISSUE_BOOK:
                        //StatsMenu.show();
                        break;
                    case MainMenu.RETURN_BOOK:
                        //StatsMenu.show();
                        break;
                    case MainMenu.QUIT_PROGRAM:
                        print("Exiting. Goodbye!");
                        finished = true;
                        break;
                    default:
                        println("Invalid selection. Please try again.");
                        continuationPrompt();
                }
            }
        }


        private static String selection() {
            println("b - Display Library Contents");
            println("u - Display User List");
            println("i - Issue Book");
            println("r - Return Book");
            println("f - Quit Program");
            println("");
            String input = prompt();
            return input;
        }

    }

    private static void printAllBooks() {
        for (Book book : bookList) {
            printBookInfo(book);
        }
        continuationPrompt();
    }

    private static void printAllUsers() {
        for (User user : userList) {
            printUserInfo(user);
        }
        continuationPrompt();
    }


    private static void printBookInfo(Book book) {
        boolean onLoan = book.isOnLoan();

        println("Title: " + book.getBookTitle());
        println("Author: " + book.toString());
        println("On Loan: " + onLoan);
        if (onLoan) {
            println("Borrowed by: " + book.getBorrower().toString());
        }
        println("");
    }

    private static void printUserInfo(User user) {
        println("Name: " + user.toString());
        println("Book Count: " + user.getNumberOfBooks());
        println("");
    }




    private static String prompt() {
        print(">> ");
        String item = scanner.nextLine();
        println("");
        return item;
    }

    private static void continuationPrompt() {
        println("Press enter to continue...");
        prompt();
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static User checkUser(String name) {
        for(User user : userList) {
            if (user.toString().equals(name)) {
                return user;
            }
        }
        return null;
    }

    private static Book checkBook(String bookName) {
        for(Book book : bookList) {
            if (book.getBookTitle().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

}
