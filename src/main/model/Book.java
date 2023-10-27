package model;

// represents a Book object having a title, author, number of pages,
// genre, year book was read, and the user's rating

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

public class Book implements Writable {
    private final String title;
    private final String author;
    private final int pages;
    private String genre;
    private int yearRead;
    private double rating;

    // REQUIRES: pages > 0, rating between and including 1 and
    // 5 in which numbers input can only be every 0.25 (ex. 1, 1.25, 1.5, 1.75)
    // EFFECTS: creates Book object with its parameters
    public Book(String title, String author, int pages, String genre,
                int yearRead, double rating) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
        this.yearRead = yearRead;
        this.rating = rating;
    }

    // REQUIRES: rating input must be between and including
    // 1 and 5 in which numbers can only be every 0.25
    // MODIFIES: this
    // EFFECTS: changes the initial rating of the book to another number
    public void changeRating(double newRating) {
        this.rating = newRating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearRead() {
        return yearRead;
    }

    public double getRating() {
        return rating;
    }

    // MODIFIES: this
    // EFFECTS: turns a Book object into a string
    @Override
    public String toString() {
        String pagesAsString = Integer.toString(pages);
        String yearReadAsString = Integer.toString(yearRead);
        String ratingAsString = Double.toString(rating);
        return "Book [Title = " + title + ", Author = " + author + ", Page Count = " + pagesAsString
                + ", Genre = " + genre + ", Year Read = " + yearReadAsString + ", Rating = " + ratingAsString + "]";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("author", author);
        json.put("pages", pages);
        json.put("genre", genre);
        json.put("year read", yearRead);
        json.put("rating", rating);
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (!Objects.equals(title, book.title)) {
            return false;
        }
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
