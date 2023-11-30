package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// represents a Book Collection having many books
public class BookCollection implements Writable {
    private String name;
    private List<Book> books;

    // constructs an empty book collection
    public BookCollection(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a book to the book collection
    public void addBook(Book book) {
        if (!books.contains(book)) {
            this.books.add(book);
            EventLog.getInstance().logEvent(new Event("New book "
                    + book.toString() + " added to collection"));
        }
    }

    // MODIFIES: this
    // EFFECTS: deletes a specific book from the book collection
    public void deleteBook(String title, String author) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title) && books.get(i).getAuthor().equals(author)) {
                books.remove(books.get(i));
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: shows the titles of all the books currently in the book collection
    public List<String> listAllBookTitles() {
        List<String> titles = new ArrayList<>();
        for (Book book : books) {
            titles.add(book.getTitle());
        }
        EventLog.getInstance().logEvent(new Event("Displayed all titles in collection."));
        return titles;
    }


    // MODIFIES: this
    // EFFECTS: sorts book collection from the highest rating to the lowest rating and returns the titles
    // if rating is the same, first book added should appear first in the list
    public List<String> sortBooksByRating(RatingComparator comparator) {
        Collections.sort(books, comparator.reversed());

        List<String> sortedBooksRating = new ArrayList<>();
        for (Book book : books) {
            sortedBooksRating.add(book.getTitle());
        }
        EventLog.getInstance().logEvent(new Event("Sorted book collection by rating."));
        return sortedBooksRating;
    }

    // MODIFIES this
    // EFFECTS: sorts book collection from the most recent book read to the least recent and returns the titles
    // if year is the same, first book added should appear first in the list
    public List<String> sortBooksByYear(YearComparator comparator) {
        Collections.sort(books, comparator.reversed());

        List<String> sortedBooks = new ArrayList<>();
        for (Book book : books) {
            sortedBooks.add(book.getTitle());
        }
        EventLog.getInstance().logEvent(new Event("Sorted book collection by year read."));
        return sortedBooks;
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
    public Book selectBook(String title, String author) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)
                    && books.get(i).getAuthor().equals(author)) {
                return books.get(i);
            }
        }
        return null;
    }


    // getter methods

    public String getName() {
        return name;
    }

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

    // EFFECTS: returns json object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("books", booksToJson());
        return json; // stub
    }

    public JSONArray booksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Book book : books) {
            jsonArray.put(book.toJson());
        }

        return jsonArray;
    }

}
