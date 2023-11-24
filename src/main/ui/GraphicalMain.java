package ui;

import java.io.FileNotFoundException;

public class GraphicalMain {

    public static void main(String[] args) {
        try {
            new YourStoriesGraphicalApp();
        } catch (FileNotFoundException e) {
            System.out.println("Warning! Unable to run YourStories.");
            System.out.println("\tReason? --> File not found.");

        }
    }
}
