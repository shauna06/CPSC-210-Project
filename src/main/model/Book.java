package model;

// represents a Book object having a title, author, number of pages,
// genre, year book was read, and the user's rating

public class Book {
    private String title;
    private String author;
    private int pages;
    private String genre;
    private int yearRead;
    private double rating;

    // REQUIRES: pages > 0, rating between and including 1 and
    // 5 in which numbers input can only be every 0.5 (ex. 1, 1.5, 2)
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
    // 1 and 5 in which numbers can only be every 0.5
    // MODIFIES: this
    // EFFECTS: changes the initial rating of the book to another number
    public void changeRating(int newRating) {
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
}
