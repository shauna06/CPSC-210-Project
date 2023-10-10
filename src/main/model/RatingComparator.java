package model;

// a class that compares ratings for books
public class RatingComparator implements java.util.Comparator<Book> {


    @Override
    public int compare(Book b1, Book b2) {
        if (b1.getRating() > b2.getRating()) {
            return 1;
        } else if (b1.getRating() < b2.getRating()) {
            return -1;
        } else {
            return 0;
        }
    }
}
