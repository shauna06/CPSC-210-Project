package ui;

import model.BookCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class YourStoriesGraphicalApp extends JFrame implements ActionListener {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private JPanel panel;
    private JButton createBookButton;
    private JButton reloadCollectionButton;
    private JButton saveCollectionButton;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private ImageIcon imageIcon;
    private static BookCollection bookCollection = new BookCollection("Book Collection");
    private static final String JSON_STORE = "./data/workroom.json";

    public static BookCollection getBookCollection() {
        return YourStoriesGraphicalApp.bookCollection;
    }

    // runs the YourStories graphical application, sets size of window and colours, instantiates JSON Reader
    // and JSON Writer
    public YourStoriesGraphicalApp() throws FileNotFoundException {
        super("YourStories Console");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        setSize(WIDTH, HEIGHT);
        panel = new JPanel();
//        panel.setLayout(new GridLayout(2, 1));
        add(panel, BorderLayout.CENTER);
        loadDisplayItems();
        // will need some way to check if the user clicks one of the buttons and code what will happen
//        setBackground(new java.awt.Color(191, 170, 159));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // EFFECTS: displays the buttons user's can interact with and adds action listeners to each button
    public void loadDisplayItems() {
        createBookButton = createNewButton("Add to your Collection");
        createBookButton.setActionCommand("Create");
        createBookButton.addActionListener(this);
        reloadCollectionButton = createNewButton("Reload Collection");
        reloadCollectionButton.setActionCommand("Reload");
        reloadCollectionButton.addActionListener(this);
        saveCollectionButton = createNewButton("Save Your Collection");
        saveCollectionButton.setActionCommand("Save");
        saveCollectionButton.addActionListener(this);
        panel.add(createBookButton);
        panel.add(saveCollectionButton);
        panel.add(reloadCollectionButton);
//        createBookButton.setLocation(300,190);
//        reloadCollectionButton.setLocation(300, 210);
        panel.setBackground(new java.awt.Color(191, 170, 159));
    }

    // EFFECTS: returns JButton with text
    public JButton createNewButton(String text) {
        JButton button = new JButton(text);
        button.setOpaque(true);
        button.setBackground(new java.awt.Color(64, 46, 37));
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(300, 70));
        button.setForeground(Color.black);
        button.setFont(new Font("Times New Roman", Font.BOLD, 10));
        return button;
    }

    // EFFECTS: takes user to next page depending on which button they press
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create")) {
            new CreateBookPage();
        }
        if (e.getActionCommand().equals("Save")) {
            saveBookCollection();
        }
        if (e.getActionCommand().equals("Reload")) {
            loadBookCollection();
        }
    }


    // EFFECTS: saves the reader's book collection
    private void saveBookCollection() {
        imageIcon = new ImageIcon(getClass().getResource("bookCreationSuccess.png"));
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        try {
            jsonWriter.open();
            jsonWriter.write(bookCollection);
            jsonWriter.close();
            JOptionPane.showMessageDialog(
                    null,
                    "Successfully Saved Collection",
                    "Success", JOptionPane.INFORMATION_MESSAGE, imageIcon);
        } catch (FileNotFoundException e) {
            System.out.println("We're sorry. Unable to write this to file: " + JSON_STORE);
        } catch (Exception d) {
            System.out.println("Couldn't find image.");
        }
    }

    // MODIFIES: this
    // EFFECTS: reloads a previously saved book collection from the user
    private void loadBookCollection() {
        try {
            bookCollection = jsonReader.read();
            System.out.println("Loaded " + bookCollection.getName() + " from " + JSON_STORE);
            new ListBookPage(bookCollection);
        } catch (IOException e) {
            System.out.println("We're sorry. Unable to read from file: " + JSON_STORE);
        }
    }

}
