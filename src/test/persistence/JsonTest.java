package persistence;

import model.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JsonTest {
    protected void checkBook(String title, String author, int pages,
                             String genre, int yearRead, double rating, Book book) {
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(pages, book.getPages());
        assertEquals(genre, book.getGenre());
        assertEquals(yearRead, book.getYearRead());
        assertEquals(rating, book.getRating());
    }
}
