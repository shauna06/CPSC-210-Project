package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    private Book testBook;

    @BeforeEach
    void runBefore() {
        testBook = new Book("Blood Like Magic", "Liselle Sambury", 484,
                "YA Fantasy", 2022, 4.5);
    }

    @Test
    void testConstructor() {
        assertEquals("Blood Like Magic", testBook.getTitle());
        assertEquals("Liselle Sambury", testBook.getAuthor());
        assertEquals(484, testBook.getPages());
        assertEquals("YA Fantasy", testBook.getGenre());
        assertEquals(2022, testBook.getYearRead());
        assertEquals(4.5, testBook.getRating());
    }

    @Test
    void testChangeRating() {
        testBook.changeRating(4);
        assertEquals(4, testBook.getRating());
    }

    @Test
    void testToString() {
        assertEquals("Book [Title = " + "Blood Like Magic" + ", Author = " + "Liselle Sambury"
                        + ", Page Count = " + "484" + ", Genre = " + "YA Fantasy" + ", Year Read = " + "2022"
                        + ", Rating = " + "4.5" + "]", testBook.toString());
    }
}
