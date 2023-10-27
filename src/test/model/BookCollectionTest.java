package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookCollectionTest {
    private BookCollection testBookCollection;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    @BeforeEach
    void runBefore() {
        this.testBookCollection = new BookCollection("Shauna's Book Collection");
        book1 = new Book("Blood Like Magic", "Liselle Sambury", 484,
                "YA Fantasy", 2022, 4.5);
        book2 = new Book("Love and Other Words", "Christina Lauren",
                372, "Romance", 2023, 4);
        book3 = new Book("Legendborn", "Tracy Deonn", 501,
                "YA Fantasy", 2022, 5);
        book4 = new Book("Bloodmarked", "Tracy Deonn", 561,
                "YA Fantasy", 2022, 4.5);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testBookCollection.getTotalNumberOfBooks());
        assertNull(testBookCollection.getBookAtIndex(0));
        assertEquals("Shauna's Book Collection", testBookCollection.getName());
    }

    @Test
    void testAddOneBook() {
        testBookCollection.addBook(book1);
        assertEquals(1, testBookCollection.getTotalNumberOfBooks());
        assertEquals(book1, testBookCollection.getBookAtIndex(0));
    }

    @Test
    void testAddMultipleBooks() {
        testBookCollection.addBook(book1);
        testBookCollection.addBook(book2);
        assertEquals(2, testBookCollection.getTotalNumberOfBooks());
        assertEquals(book1, testBookCollection.getBookAtIndex(0));
        assertEquals(book2, testBookCollection.getBookAtIndex(1));

    }

    @Test
    void testAddMultipleSameBook() {
        testBookCollection.addBook(book3);
        testBookCollection.addBook(book3);
        testBookCollection.addBook(book4);
        assertEquals(2, testBookCollection.getTotalNumberOfBooks());
        assertEquals(book3, testBookCollection.getBookAtIndex(0));
        assertEquals(book4, testBookCollection.getBookAtIndex(1));
    }

    @Test
    void testDeleteOneBook() {
        testBookCollection.addBook(book1);
        testBookCollection.addBook(book2);
        testBookCollection.deleteBook("Love and Other Words", "Christina Lauren");
        assertEquals(1, testBookCollection.getTotalNumberOfBooks());
        boolean success = testBookCollection.containsBook(book2);
        assertFalse(success);
    }

    @Test
    void testDeleteMultipleBooks() {
        testBookCollection.addBook(book1);
        testBookCollection.addBook(book2);
        testBookCollection.deleteBook("Love and Other Words", "Christina Lauren");
        testBookCollection.deleteBook("Blood Like Magic", "Liselle Sambury");
        assertEquals(0, testBookCollection.getTotalNumberOfBooks());
        boolean success = testBookCollection.containsBook(book2);
        assertFalse(success);
        boolean success2 = testBookCollection.containsBook(book1);
        assertFalse(success2);
    }

    @Test
    void testDeleteBookBookAlreadyDeleted() {
        testBookCollection.addBook(book1);
        testBookCollection.deleteBook("Blood Like Magic", "Liselle Sambury");
        testBookCollection.deleteBook("Blood Like Magic", "Liselle Sambury");
        assertEquals(0, testBookCollection.getTotalNumberOfBooks());
        boolean success = testBookCollection.containsBook(book1);
        assertFalse(success);
    }

    @Test
    void testDeleteBookIncorrectAuthor() {
        testBookCollection.addBook(book1);
        testBookCollection.deleteBook("Blood Like Magic", "Shauna Ndoping");
        assertEquals(1, testBookCollection.getTotalNumberOfBooks());
        boolean success = testBookCollection.containsBook(book1);
        assertTrue(success);
    }

    @Test
    void testDeleteBookIncorrectTitle() {
        testBookCollection.addBook(book1);
        testBookCollection.deleteBook("Blood Magic", "Liselle Sambury");
        assertEquals(1, testBookCollection.getTotalNumberOfBooks());
        boolean success = testBookCollection.containsBook(book1);
        assertTrue(success);
    }

    @Test
    void testListAllBookTitles() {
        testBookCollection.addBook(book1);
        testBookCollection.addBook(book2);
        testBookCollection.addBook(book3);
        testBookCollection.addBook(book4);
        assertEquals(4, testBookCollection.getTotalNumberOfBooks());
        assertEquals("Blood Like Magic", testBookCollection.listAllBookTitles().get(0));
        assertEquals("Love and Other Words", testBookCollection.listAllBookTitles().get(1));
        assertEquals("Legendborn", testBookCollection.listAllBookTitles().get(2));
        assertEquals("Bloodmarked", testBookCollection.listAllBookTitles().get(3));
    }

    @Test
    void testSortBooksByRating() {
        RatingComparator comparator = new RatingComparator();
        testBookCollection.addBook(book1); // 4.5
        testBookCollection.addBook(book2); // 4.0
        testBookCollection.addBook(book3); // 5.0
        testBookCollection.addBook(book4);  // 4.5
        assertEquals("Legendborn", testBookCollection.sortBooksByRating(comparator).get(0));
        assertEquals("Blood Like Magic", testBookCollection.sortBooksByRating(comparator).get(1));
        assertEquals("Bloodmarked", testBookCollection.sortBooksByRating(comparator).get(2));
        assertEquals("Love and Other Words", testBookCollection.sortBooksByRating(comparator).get(3));
    }

    @Test
    void testSortBooksByYear() {
        YearComparator comparator = new YearComparator();
        testBookCollection.addBook(book1); // 2022
        testBookCollection.addBook(book2); // 2023
        testBookCollection.addBook(book3); // 2022
        testBookCollection.addBook(book4);  // 2022
        assertEquals("Love and Other Words", testBookCollection.sortBooksByYear(comparator).get(0));
        assertEquals("Blood Like Magic", testBookCollection.sortBooksByYear(comparator).get(1));
        assertEquals("Legendborn", testBookCollection.sortBooksByYear(comparator).get(2));
        assertEquals("Bloodmarked", testBookCollection.sortBooksByYear(comparator).get(3));
    }

    @Test
    void testFilterBooksByGenre() {
        testBookCollection.addBook(book1);
        testBookCollection.addBook(book2);
        testBookCollection.addBook(book3);
        testBookCollection.addBook(book4);
        assertEquals(3, testBookCollection.filterBooksByGenre("YA Fantasy").size());
        assertEquals("Blood Like Magic", testBookCollection.filterBooksByGenre("YA Fantasy").get(0));
        assertEquals("Legendborn", testBookCollection.filterBooksByGenre("YA Fantasy").get(1));
        assertEquals("Bloodmarked", testBookCollection.filterBooksByGenre("YA Fantasy").get(2));
    }

    @Test
    void testFilterBooksByGenreNoBooksAdded() {
        assertEquals(0, testBookCollection.filterBooksByGenre("YA Fantasy").size());
    }

    @Test
    void testFilterBooksByAuthor() {
        testBookCollection.addBook(book1);
        testBookCollection.addBook(book2);
        testBookCollection.addBook(book3);
        testBookCollection.addBook(book4);
        assertEquals(2, testBookCollection.filterBooksByAuthor("Tracy Deonn").size());
        assertEquals("Legendborn", testBookCollection.filterBooksByAuthor("Tracy Deonn").get(0));
        assertEquals("Bloodmarked", testBookCollection.filterBooksByAuthor("Tracy Deonn").get(1));
    }

    @Test
    void testFilterBooksByAuthorNoBooksAdded() {
        assertEquals(0, testBookCollection.filterBooksByAuthor("Leigh Bardugo").size());
    }

    @Test
    void testSelectOneBook() {
        testBookCollection.addBook(book1);
        testBookCollection.addBook(book2);
        testBookCollection.addBook(book3);
        testBookCollection.addBook(book4);
        assertEquals(book3, testBookCollection.selectBook("Legendborn",
                "Tracy Deonn"));
    }

    @Test
    void testSelectMultipleBooks() {
        testBookCollection.addBook(book1);
        testBookCollection.addBook(book2);
        testBookCollection.addBook(book3);
        testBookCollection.addBook(book4);
        assertEquals(book4, testBookCollection.selectBook("Bloodmarked", "Tracy Deonn"));
        assertEquals(book1, testBookCollection.selectBook("Blood Like Magic", "Liselle Sambury"));
    }

    @Test
    void testSelectBookNotInCollection () {
        assertNull(testBookCollection.selectBook("Legendborn", "Tracy Deonn"));
    }

    @Test
    void testSelectBookIncorrectAuthor() {
        testBookCollection.addBook(book3);
        assertNull(testBookCollection.selectBook("Legendborn", "Shauna Ndoping"));
    }

    @Test
    void testSelectBookIncorrectTitle() {
        assertNull(testBookCollection.selectBook("Legends", "Tracy Deonn"));
    }

}