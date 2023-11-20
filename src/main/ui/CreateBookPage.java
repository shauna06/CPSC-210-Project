package ui;

import model.Book;
import model.BookCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateBookPage extends JFrame implements ActionListener {
    private JTextField titleField;
    private JTextField authorField;
    private JTextField pagesField;
    private JTextField genreField;
    private JTextField yearField;
    private JTextField ratingField;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JButton button;
    private JButton backButton;
    private JButton listBooksButton;
    private JPanel panel;
    private Book book;
    private ImageIcon image;
    private BookCollection bookCollection;

    public CreateBookPage() {
        super("Create Book Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        panel = new JPanel();
        setActionCommands();
        setLabels();
        setTextFields();
        loadDisplayMenu();
        panel.setBackground(new java.awt.Color(191, 159, 190));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    // EFFECTS: creates buttons
    public JButton createButtons(String text) {
        JButton button = new JButton(text);
        button.setOpaque(true);
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100, 10));
        button.setForeground(Color.black);
        button.setFont(new Font("Times New Roman", Font.BOLD, 10));
        return button;
    }

    // EFFECTS: sets action commands  and adds action listener to buttons
    public void setActionCommands() {
        button = createButtons("Save All Text Fields");
        button.setActionCommand("Button");
        button.addActionListener(this);
        backButton = createButtons("Back to Main Menu");
        backButton.setActionCommand("BackButton");
        backButton.addActionListener(this);
        listBooksButton = createButtons("List books");
        listBooksButton.setActionCommand("ListButton");
        listBooksButton.addActionListener(this);
    }

    // EFFECTS: creates and returns JLabel
    public JLabel createLabels(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Times New Roman", Font.BOLD, 10));
        return label;
    }

    // EFFECTS: creates the display page
    public void setLabels() {
        label1 = createLabels("Enter book title");
        label2 = createLabels("Enter author");
        label3 = createLabels("Enter page count");
        label4 = createLabels("Enter genre");
        label5 = createLabels("Enter year read");
        label6 = createLabels("Enter rating");

    }

    //  EFFECTS: instantiates the text fields
    public void setTextFields() {
        titleField = new JTextField(10);
        authorField = new JTextField(10);
        pagesField = new JTextField(10);
        genreField = new JTextField(10);
        yearField = new JTextField(10);
        ratingField = new JTextField(10);
    }

    // EFFECTS: creates a display menu with text to be entered
    public void loadDisplayMenu() {
        panel.add(label1);
        panel.add(titleField);
        panel.add(label2);
        panel.add(authorField);
        panel.add(label3);
        panel.add(pagesField);
        panel.add(label4);
        panel.add(genreField);
        panel.add(label5);
        panel.add(yearField);
        panel.add(label6);
        panel.add(ratingField);
        panel.add(button);
        panel.add(listBooksButton);
        panel.add(backButton);
        add(panel, BorderLayout.CENTER);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Button")) {
            creatingBook();
        }
        if (e.getActionCommand().equals("ListButton")) {
            new ListBookPage(bookCollection);
        }
        if (e.getActionCommand().equals("BackButton")) {
            // stub
        }
        // want to now check if all 6 buttons are checked and if they are creates a new book and gives a little image
        // what happens if user does not enter something for any of the number sections. won't it fail to run??
    }

    // EFFECTS: creates a new book object using text field input and adds book to the collection
    private void creatingBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        int pages = Integer.parseInt(pagesField.getText());
        String genre = genreField.getText();
        int yearRead = Integer.parseInt(yearField.getText());
        double rating = Double.parseDouble(ratingField.getText());
        book = new Book(title, author, pages, genre, yearRead, rating);
        bookCollection = new BookCollection("Book Collection");
        bookCollection.addBook(book);
        displaySuccessImage();
    }

    // EFFECTS: displays image telling user they've successfully created and added book to collection
    private void displaySuccessImage() {
        // image part is not working!!
        // also ask about timer. how to have the image pop up only for let's say 3 seconds
        try {
            image = new ImageIcon("bookCreationSuccess.png");
            JLabel displayImage = new JLabel(image);
            displayImage.setSize(20, 20);
            panel.add(displayImage);
            panel.setVisible(true);

        } catch (Exception d) {
            System.out.println("Couldn't find Image");
        }
    }
}
