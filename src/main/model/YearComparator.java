package model;

// a class that compares years read for books
public class YearComparator implements java.util.Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        return b1.getYearRead() - b2.getYearRead();
    }
}
