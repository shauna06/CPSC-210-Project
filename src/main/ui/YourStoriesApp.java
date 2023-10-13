package ui;

import model.Book;
import model.BookCollection;
import model.RatingComparator;
import model.YearComparator;

import java.util.Scanner;

// Book Application
public class YourStoriesApp {
    private BookCollection bookCollection;
    private Scanner input;

    // runs the YourStories application and instantiates the user's book collection
    public YourStoriesApp() {
        bookCollection = new BookCollection();
        runYourStories();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runYourStories() {
        boolean keepGoing = true;
        String command = null;

        initialize();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }

        }
        System.out.println("\nHappy reading!");

    }

    // MODIFIES: this
    // EFFECTS: processes the user's command
    private void processCommand(String command) {
        if (command.equals("start")) {
            createBook();
            nextChoices();
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes the scanner
    private void initialize() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays the menu for the user and what to do next
    private void displayMenu() {
        System.out.println("Welcome to YourStories! An application to store all of the books you've read.");
        System.out.println("Type start and click enter/return to input a book");
        System.out.println("Or type quit and click enter/return to quit the application");
    }

    // MODIFIES: this
    // EFFECTS: allows user to input the information for a book they want
    // in the collection
    private void createBook() {
        System.out.println("\nAdd info for the book you want to add here.");
        System.out.println("Enter the title of the book");
        String title = input.next();
        System.out.println("Enter the author");
        String author = input.next();
        System.out.println("Enter the page count");
        int pages = input.nextInt();
        System.out.println("Enter the genre");
        String genre = input.next();
        System.out.println("Enter the year you read the book");
        int yearRead = input.nextInt();
        System.out.println("Enter the rating");
        double rating = input.nextDouble();

        Book book = new Book(title, author, pages, genre, yearRead, rating);
        System.out.println("Book has successfully been made!");
        System.out.println("Adding the book to your collection...");
        bookCollection.addBook(book);
        System.out.println("Successfully added book!");

    }

    // MODIFIES: this
    // EFFECTS : processes the next round of user input
    private void nextChoices() {
        boolean continueOn = true;
        String newCommand = null;

        while (continueOn) {
            nextDisplayMenu();
            newCommand = input.next();
            newCommand = newCommand.toLowerCase();

            if (newCommand.equals("back")) {
                continueOn = false;
            } else {
                processNewCommand(newCommand);
            }
        }

    }

    // EFFECTS: processes more user commands
    private void processNewCommand(String newCommand) {
        if (newCommand.equals("add")) {
            createBook();
        } else if (newCommand.equals("delete")) {
            deleteFromCollection();
        } else if (newCommand.equals("list")) {
            listCollection();
        } else if (newCommand.equals("sort")) {
            sortCollection();
        } else if (newCommand.equals("filter")) {
            filterCollection();
        } else if (newCommand.equals("select")) {
            selectBookFromCollection();
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }

    // EFFECTS: prompts user to either add another book, quit the application, delete a book,
    // list their collection, sort their collection, filter their collection,
    // or select a book in their collection
    private void nextDisplayMenu() {
        System.out.println("\nSelect from the following options");
        System.out.println("\tadd -> add a new book");
        System.out.println("\tdelete -> delete a book in your collection");
        System.out.println("\tlist -> list the books in your collection");
        System.out.println("\tsort -> sort your collection");
        System.out.println("\tfilter -> filter your collection");
        System.out.println("\tselect -> select a book from your collection");
        System.out.println("\tback -> to go back to the start of the application");
    }

    // MODIFIES: this
    // EFFECTS: allows user to delete a book from their collection
    private void deleteFromCollection() {
        System.out.println("Type the title of the book you want to delete.");
        String deleteCommand = input.next();
        System.out.println("Deleting book from collection...");
        if (bookCollection.listAllBooks().contains(deleteCommand)) {
            bookCollection.deleteBook(deleteCommand);
            System.out.println("Success!");
        } else {
            System.out.println("We're sorry. The book you want to delete seems to not be in the collection.");
        }
    }

    // MODIFIES: this
    // EFFECTS: prints list of titles of books in user's collection
    private void listCollection() {
        System.out.println("Printing all titles in your collection...");
        System.out.println(bookCollection.listAllBooks());
        System.out.println("Success!");
    }

    // MODIFIES: this
    // EFFECTS: allows user to sort their collection by either rating or by year
    private void sortCollection() {
        System.out.println("Press r to sort by rating and y to sort by year.");
        String sortCommand = null;
        sortCommand = input.next();
        sortCommand = sortCommand.toLowerCase();

        if (sortCommand.equals("r")) {
            System.out.println(bookCollection.sortBooksByRating(new RatingComparator()));
            System.out.println("Success!");
        } else if (sortCommand.equals("y")) {
            System.out.println(bookCollection.sortBooksByYear(new YearComparator()));
            System.out.println("Success!");
        } else {
            System.out.println("Invalid command. Please try again.");
            sortCollection();
        }
    }

    // MODIFIES: this
    // EFFECTS: allows user to filter their collection by either genre or by author
    private void filterCollection() {
        System.out.println("Press g to filter by genre or a to filter by author");
        String filterCommand = null;
        filterCommand = input.next();
        filterCommand = filterCommand.toLowerCase();
        if (filterCommand.equals("g")) {
            System.out.println("Type the genre you want to filter for.");
            String genreCommand = input.next();
            System.out.println(bookCollection.filterBooksByGenre(genreCommand));
        } else if (filterCommand.equals("a")) {
            System.out.println("Type the author you want to filter for.");
            String authorCommand = input.next();
            System.out.println(bookCollection.filterBooksByAuthor(authorCommand));
        } else {
            System.out.println("Invalid command. Please try again.");
            filterCollection();
        }
    }

    // EFFECTS: allows user to select a book from their collection and view its contents,
    // and change the rating of their book if they choose to do so
    private void selectBookFromCollection() {
        System.out.println("Type the title of the book you want to select.");
        String selectCommand = input.next();
        System.out.println("Selecting book...");

        if (bookCollection.selectBook(selectCommand) == null) {
            System.out.println("We're sorry. The title you've input seems to not be in the collection.");
        } else {
            System.out.println(bookCollection.selectBook(selectCommand).toString());
            System.out.println("Success!");
            System.out.println("Type c if you would like to change the rating of the book."
                    + " Click any another key to exit.");
            String changeRatingCommand = input.next();
            changeRatingCommand = changeRatingCommand.toLowerCase();
            if (changeRatingCommand.equals("c")) {
                System.out.println("Type the new rating.");
                double ratingCommand = input.nextDouble();
                System.out.println("Changing rating...");
                bookCollection.selectBook(selectCommand).changeRating(ratingCommand);
                System.out.println(bookCollection.selectBook(selectCommand).toString());
                System.out.println("Success!");
            }
        }
    }

}
