package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book testBook;
    private Book testBook2;
    private Book testBook3;
    private Book testBook4;
    private BookCollection testBookCollection;

    @BeforeEach
    void runBefore() {
        testBook = new Book("Blood Like Magic", "Liselle Sambury", 484,
                "YA Fantasy", 2022, 4.5);
        testBook2 = new Book("Blood Like Magic", "Liselle Sambury", 484,
                "YA Fantasy", 2022, 4.5);
        testBook3 = new Book("Blood Like Magic", "Liselle Sambury", 500,
                "Fantasy", 2026, 3.0);
        testBook4 = new Book("Legendborn", "Tracy Deonn", 501,
                "YA Fantasy", 2022, 5.0);
        testBookCollection = new BookCollection("Shauna's Book Collection");
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

    @Test
    void testBookEquality() {
        assertTrue(testBook.equals(testBook2));
        assertTrue(testBook.equals(testBook3));
        assertTrue(testBook2.equals(testBook3));
        assertFalse(testBook.equals(testBook4));
        assertFalse(testBook2.equals(testBook4));
        assertFalse(testBook3.equals(testBook4));
    }

    @Test
    void testBookEqualityNull() {
        assertFalse(testBook.equals(null));
    }

    @Test
    void testHashCode() {
        assertFalse(testBook.hashCode() == testBook4.hashCode());
        assertTrue(testBook.hashCode() == testBook2.hashCode());
    }

    @Test
    void testNotSameClass() {
        assertFalse(testBook.equals(testBookCollection));
    }
}
