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
        // changed method to only add a book to a collection once, but now i'm wondering about rereads…
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
//        List<Book> sortedBooks = new ArrayList<>();
//        Book firstBook = books.get(0);
//        for (Book book : books) {
//            if (comparator.compare(firstBook, book) >= 0) {
//                sortedBooks.add(firstBook);
//            } else {
//                sortedBooks.add(book);
//            }
//        }
//        return sortedBooks;
        return null; //stub
    }

    // MODIFIES this
    // EFFECTS: sorts book collection from the most recent book read to the least recent
    // if year is the same, first book added should appear first in the list
    public List<Book> sortBooksByYear() {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: filters book collection by the genre of the book and shows a resulting list of
    // book titles in order from first added to the list and onward
    public List<String> filterBooksByGenre(String genre) {
        List<String> filteredGenre = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre() == genre) {
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
            if (book.getAuthor() == author) {
                filteredAuthor.add(book.getTitle());
            }
        }
        return filteredAuthor;
    }


    // MODIFIES: NOT SURE WHAT THIS WOULD MODIFY ( ASK!)
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

    // might need to edit this for case when the books list is empty, and we cannot get an index
    // ask about the implementation of this getter method
    public Book getBookAtIndex(int i) {
        if (books.isEmpty()) {
            return null;
        } else {
            return books.get(i);
        }
    }

    public boolean containsBook(Book book) {
        return this.books.contains(book);
    }

}
