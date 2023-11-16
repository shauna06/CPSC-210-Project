package ui;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new YourStoriesApp();
        } catch (FileNotFoundException e) {
            System.out.println("Warning! Unable to run YourStories.");
            System.out.println("\tReason? --> File not found.");
        }

    }
}
