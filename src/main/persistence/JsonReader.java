package persistence;

import model.Book;
import model.BookCollection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads the BookCollection from JSON data stored in file
// Code heavily influenced by the JsonSerializationDemo: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReader {
    private String source;

    // EFFECTS: constructs a reader to read from the source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads BookCollection from file and returns it
    // throws IOException if there's an error that occurs when reading the
    // data from the file
    public BookCollection read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBookCollection(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses BookCollection from JSON object and returns it
    private BookCollection parseBookCollection(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        BookCollection bc = new BookCollection(name);
        addingBooks(bc, jsonObject);
        return bc;
    }

    // MODIFIES: bc
    // EFFECTS:  parses books from JSON Object and adds them to the BookCollection
    private void addingBooks(BookCollection bc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("books");
        for (Object json : jsonArray) {
            JSONObject nextBook = (JSONObject) json;
            addingBook(bc, nextBook);
        }
    }

    // MODIFIES: bc
    // EFFECTS: parses book from JSON object and adds it to the BookCollection
    private void addingBook(BookCollection bc, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String author = jsonObject.getString("author");
        int pages = jsonObject.getInt("pages");
        String genre = jsonObject.getString("genre");
        int yearRead = jsonObject.getInt("year read");
        double rating = jsonObject.getDouble("rating");
        Book book = new Book(title, author, pages, genre, yearRead, rating);
        bc.addBook(book);
    }

}
