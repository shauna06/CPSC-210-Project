package persistence;

import model.Book;
import model.BookCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            BookCollection bc = new BookCollection("Shauna's Book Collection");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("Expected IOException.");
        } catch (IOException e) {
            // this passes
        }
    }

    @Test
    void testWriterEmptyBookCollection() {
        try {
            BookCollection bc = new BookCollection("Shauna's Book Collection");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyBookCollection.json");
            writer.open();
            writer.write(bc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyBookCollection.json");
            bc = reader.read();
            assertEquals("Shauna's Book Collection", bc.getName());
            assertEquals(0, bc.getTotalNumberOfBooks());
        } catch (IOException e) {
            fail("Exception shouldn't have been thrown");
        }
    }

    @Test
    void testWriterMultipleBooksBookCollection() {
        try {
            BookCollection bc = new BookCollection("Shauna's Book Collection");
            bc.addBook(new Book("Blood Like Magic", "Liselle Sambury",
                    484, "YA Fantasy", 2022, 4.5));
            bc.addBook(new Book("Legendborn", "Tracy Deonn", 501,
                    "YA Fantasy", 2022, 5.0));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralBookCollection.json");
            writer.open();
            writer.write(bc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralBookCollection.json");
            bc = reader.read();
            assertEquals("Shauna's Book Collection", bc.getName());
            assertEquals(2, bc.listAllBooks().size());
            checkBook("Blood Like Magic", "Liselle Sambury",
                    484, "YA Fantasy", 2022, 4.5, bc.getBookAtIndex(0));
            checkBook("Legendborn", "Tracy Deonn", 501,
                    "YA Fantasy", 2022, 5.0, bc.getBookAtIndex(1));
        } catch (IOException e) {
            fail("Exception shouldn't have been thrown");
        }
    }
}
