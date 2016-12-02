import java.util.Comparator;

class BookComparator implements Comparator<Book> {

    public int compare(Book book1, Book book2) {
        String ISBN1 = book1.getAll()[3];
        String ISBN2 = book2.getAll()[3];

        return ISBN1.compareTo(ISBN2);
    }
}
