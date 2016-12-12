import java.util.Collections;

/**
 * Created by Cree on 01/12/2016.
 */
public class LibraryIO {
    public static void main(String[] args) {
        SortedArrayList<Integer> barry = new SortedArrayList<>();

        barry.add(1);
        barry.add(2);
        barry.add(1);

        int bigger = barry.get(0).compareTo(barry.get(1));
        int smaller = barry.get(1).compareTo(barry.get(0));
        int theSame = barry.get(0).compareTo(barry.get(2));

        System.out.println(bigger + "");
        System.out.println(smaller + "");
        System.out.println(theSame + "");


        Book book1 = new Book("Fun Barry", "John", "Wilkes");
        Book book2 = new Book("Fun Barry", "John", "J", "Aaran");
        Book book3 = new Book("Fun Barry", "John", "J", "Baaran");
        Book book4 = new Book("Fun Barry", "John", "J", "Jones");
        Book book5 = new Book("Fun Barry", "John", "J", "Yaris");


        System.out.println(book1.getAuthorSurname().compareTo("Aaran"));

        SortedArrayList<Book> bookList = new SortedArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        bookList.add(book5);

        System.out.println(bookList.toString());
        Collections.sort(bookList);
        System.out.println(bookList.toString());




    }
}
