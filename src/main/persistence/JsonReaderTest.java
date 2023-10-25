package persistence;

import model.BookCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            BookCollection bc = reader.read();
            fail("Expected an IOException.");
        } catch (IOException e) {
            // this passes
        }
    }

    @Test
    void testReaderEmptyBookCollection() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyBookCollection.json");
        try {
            BookCollection bc = reader.read();
            assertEquals("Shauna's Book Collection", bc.getName());
            assertEquals(0, bc.getTotalNumberOfBooks());
        } catch (IOException e) {
            fail("Error. Couldn't read from the file.");
        }
    }

    @Test
    void testReaderMultipleBooksBookCollection() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralBookCollection.json");
        try {
            BookCollection bc = reader.read();
            assertEquals("Shauna's Book Collection", bc.getName());
            assertEquals(5, bc.getTotalNumberOfBooks());
            checkBook("Legendborn", "Tracy Deonn", 501, "YA Fantasy",
                    2022, 5.0, bc.getBookAtIndex(1));
        } catch (IOException e) {
            fail("Error. Couldn't read from the file.");
        }
    }
}
