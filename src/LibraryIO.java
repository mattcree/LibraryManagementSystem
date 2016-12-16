import java.io.*;
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

        if (FileHandler.readFromFile(inFile, bookList, userList)) {
            MainMenu.show(); //Entry point to main program loop
        } else {
            println("Error parsing file.");
        }
    }

    /**
     * Contains the main menu loop
     */
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
                        PrintListMenu.printAllBooks(bookList);
                        break;
                    case MainMenu.DISPLAY_USER_INFO:
                        PrintListMenu.printAllUsers(userList);
                        break;
                    case MainMenu.ISSUE_BOOK:
                        IssueMenu.issueBookToUser();
                        break;
                    case MainMenu.RETURN_BOOK:
                        ReturnMenu.returnBookFromUser();
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

        /**
         * Main Menu selection screen.
         * @return
         */
        private static String selection() {
            println("b - Display Library Contents");
            println("u - Display User List");
            println("i - Issue Book");
            println("r - Return Book");
            println("f - Quit Program");
            println("");
            String selection = prompt();
            return selection;
        }

    }

    /**
     * Contains Behavior relating to Printing the Lists of Books
     * and Users.
     */
    private static class PrintListMenu {

        /**
         * Prints a list of all the Books currently in the Library
         */
        private static void printAllBooks(SortedArrayList<Book> bookList) {
            for (Book book : bookList) {
                printBookInfo(book);
            }
            continuationPrompt();
        }

        /**
         * Prints a list of all the Users currently in the User List
         */
        private static void printAllUsers(SortedArrayList<User> userList) {
            for (User user : userList) {
                printUserInfo(user);
            }
            continuationPrompt();
        }

        /**
         * Prints a summary of an individual Book
         * @param book A Book object
         */
        private static void printBookInfo(Book book) {
            boolean bookIsOnLoan = book.isOnLoan();
            println("Title: " + book.getBookTitle());
            println("Author: " + book.toString());
            println("On Loan: " + bookIsOnLoan);
            if (bookIsOnLoan) {
                println("Borrowed by: " + book.getBorrower().toString());
            }
            println("");
        }

        /**
         * Prints a summary of an individual User
         * @param user A User object
         */
        private static void printUserInfo(User user) {
            println("Name: " + user.toString());
            println("Book Count: " + user.getNumberOfBooks());
            println("");
        }

    }

    /**
     * Issue book menu. Prompts user for input several times and issues a book
     * if the User is in the User list, the Book is in the Book list,
     * the Book is not on loan, and if the User currently has fewer
     * than their maximum loans.
     */
    private static class IssueMenu {

        private static void issueBookToUser(){
            println("To issue a Book, you must enter a User's name");
            println("the Book's title and the Author's surname.");
            println("");
            println("Enter user name");
            User validUser = checkUser(prompt(), userList);

            if (validUser != null) {
                Book requestedBook = validateBook();
                if (requestedBook != null) {
                    issueIfAvailable(requestedBook, validUser);
                    continuationPrompt();
                } else {
                    println("Book not found.");
                    continuationPrompt();
                }
            } else {
                println("User not found.");
                continuationPrompt();
            }
        }

        //
        //Issue IO Helpers
        //
        /**
         * Issues a Book to a User if they currently have fewer than the Max Loans count
         * and prints a summary
         * @param book
         * @param user
         */
        private static void finaliseIssue(Book book, User user) {
            boolean loanCountIsNotMax = user.addBook();
            if (loanCountIsNotMax) {
                book.setOnLoan(user);
                printIssueSummary(book, user);
            } else {
                printMaxLoansReachedMessage(user);
            }
        }

        private static void printIssueSummary(Book book, User user) {
            println(book.getBookTitle() + " by " + book.getFullName() + " has been issued to " + user.toString() + ".");
        }

        /**
         * Issues a Book to a User if the Book is not currently on loan
         * @param book The requested Book
         * @param user The User who has requested the Book
         */
        private static void issueIfAvailable(Book book, User user) {
            if (book.isOnLoan()) {
                printIsOnLoanMessage();
                writeNotificationToFile(book);
            } else {
                finaliseIssue(book, user);
            }
        }

        private static void printMaxLoansReachedMessage(User user) {
            println("You currently have " + user.getMaxLoans() + " books.");
            println("You must return one before you can issue any more books.");
        }

        private static void printIsOnLoanMessage() {
            println("Book is currently on loan and the borrower");
            println("has been notified that it has been requested");
            println("by another user.");
        }

        private static void writeNotificationToFile(Book book){
            try {
                File file = new File("C:\\LibraryManagementSystem\\messages.txt");
                FileOutputStream fileOut = new FileOutputStream(file, true);
                PrintWriter outFile = new PrintWriter(fileOut);
                FileHandler.writeToFile(outFile,
                        "MESSAGE TO: " + book.getBorrower().toString() + ". " +
                                book.getBookTitle() + " has been requested by another user. " +
                                "Please return it as soon as you can. Thank you.");
            } catch (Exception e) {
                println("Error printing message to file. File not found.");
            }
        }
    }

    /**
     * Return book menu. Prompts user for input several times and returns a book
     * if the User is in the User list, the Book is in the Book list,
     * and the User is the same as the one listed as the Book's borrower.
     */
    private static class ReturnMenu {

        private static void returnBookFromUser(){
            println("Enter a user name");
            User selectedUser = checkUser(prompt(), userList);

            if (selectedUser != null) {
                Book requestedBook = validateBook();

                if (requestedBook != null) {
                    returnBook(requestedBook, selectedUser);
                    continuationPrompt();
                } else {
                    println("Book not found.");
                    continuationPrompt();
                }

            } else {
                println("User not found.");
                continuationPrompt();
            }
        }

        //
        //Return IO Helpers
        //
        private static void returnBook(Book book, User user) {
            boolean bookIsOnUsersAccount = checkHasBook(book, user);
            if (bookIsOnUsersAccount) {
                finaliseReturn(book, user);
                printReturnSummary(book, user);
            } else {
                printWasNotOnUsersAccount(book, user);
            }
        }

        private static void finaliseReturn(Book book, User user) {
            user.removeBook();
            book.setNotOnLoan();
        }

        private static void printReturnSummary(Book book, User user) {
            println(book.getBookTitle() + " by " + book.getFullName() + " has been returned from " + user.toString() + ".");
        }

        //
        //Messages
        //

        private static void printWasNotOnUsersAccount(Book book, User user) {
            println(book.getBookTitle()+ " was not found on " + user.toString() + "'s account.");
            if (book.isOnLoan()) {
                println("The book is issued to " + book.getBorrower().toString() + " and must be returned");
                println("by that user.");
            } else {
                println("The book is not on loan.");
            }

        }

    }

    //Common Checks and Validations
    /**
     * Returns a User object if the User is found in the userList
     * @param name
     * @return
     */
    private static User checkUser(String name, SortedArrayList<User> userList) {
        for(User user : userList) {
            if (user.toString().equals(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Returns a Book object if the Book is found in the bookList
     * @param bookName
     * @param authorSurname
     * @return
     */
    private static Book checkBook(String bookName, String authorSurname, SortedArrayList<Book> bookList) {
        for(Book book : bookList) {
            if (book.getBookTitle().equals(bookName)
                    && book.getAuthorSurname().equals(authorSurname)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Returns true if the Book's borrower is the same as
     * the User we are checking.
     * @param book The book
     * @param user The user
     * @return
     */
    private static boolean checkHasBook(Book book, User user) {
        if (book.getBorrower() == user) {
            return true;
        }
        return false;
    }

    /**
     * Prompts for details about a Book and returns a Book if the Book is in the library.
     * Returns null if no Book found.
     * @return A Book or null
     */
    private static Book validateBook() {
        println("Enter the book title");
        String title = prompt();

        println("Enter the surname of the Author");
        String authorSurname = prompt();

        return checkBook(title, authorSurname, bookList);
    }

    //IO Helpers
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

}
