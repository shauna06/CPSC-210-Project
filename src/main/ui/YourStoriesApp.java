package ui;

import model.Book;
import model.BookCollection;

// Book Application
public class YourStoriesApp {
    private Book book;
    private BookCollection bookCollection;

    // runs the YourStories application
    public YourStoriesApp() {
        runYourStories();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runYourStories() {
        // stub
    }

    // EFFECTS: displays the menu for the user and what to do next
    private void displayMenu() {
        System.out.println("Welcome to YourStories! An application to store all of the books you've read.");
        System.out.println("Type start to input a book");
        System.out.println("Or type q to quit the application");
    }
}
