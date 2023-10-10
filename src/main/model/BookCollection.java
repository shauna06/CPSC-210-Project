package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// represents a Book Collection having many books
public class BookCollection {
    private List<Book> books;

    // constructs an empty book collection
    public BookCollection() {
        this.books = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a book to the book collection
    public void addBook(Book book) {
        if (!books.contains(book)) {
            this.books.add(book);
        }
    }

    // MODIFIES: this
    // EFFECTS: deletes a specific book defined by book parameter from the book collection
    public void deleteBook(Book bookToDelete) {
        books.remove(bookToDelete);
    }

    // MODIFIES: this
    // EFFECTS: shows the titles of all the books currently in the book collection
    public List<String> listAllBooks() {
        List<String> titles = new ArrayList<>();
        for (Book book: books) {
            titles.add(book.getTitle());
        }
        return titles;
    }

    // MODIFIES: this
    // EFFECTS: sorts book collection from the highest rating to the lowest rating
    // if rating is the same, first book added should appear first in the list
    public List<Book> sortBooksByRating(RatingComparator comparator) {
        Collections.sort(books, comparator.reversed());
        return books;
    }

    // MODIFIES this
    // EFFECTS: sorts book collection from the most recent book read to the least recent
    // if year is the same, first book added should appear first in the list
    public List<Book> sortBooksByYear(YearComparator comparator) {
        Collections.sort(books, comparator.reversed());
        return books;
    }

    // MODIFIES: this
    // EFFECTS: filters book collection by the genre of the book and shows a resulting list of
    // book titles in order from first added to the list and onward
    public List<String> filterBooksByGenre(String genre) {
        List<String> filteredGenre = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                filteredGenre.add(book.getTitle());
            }
        }
        return filteredGenre;
    }

    // MODIFIES: this
    // EFFECTS: filters book collection by author and shows a resulting list of
    // book titles in order from first added to the list and onward
    public List<String> filterBooksByAuthor(String author) {
        List<String> filteredAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                filteredAuthor.add(book.getTitle());
            }
        }
        return filteredAuthor;
    }


    // EFFECTS: returns the book a user is looking for if it is in their book collection,
    // otherwise returns null
    public Book selectBook(Book book) {
        if (books.contains(book)) {
            return book;
        } else {
            return null;
        }
    }


    // getter methods

    public int getTotalNumberOfBooks() {
        return books.size();
    }

    public Book getBookAtIndex(int i) {
        if (books.isEmpty()) {
            return null;
        } else {
            return books.get(i);
        }
    }

    // EFFECTS: checks to see if the list of books in the collection contains a specific book
    public boolean containsBook(Book book) {
        return this.books.contains(book);
    }

}
