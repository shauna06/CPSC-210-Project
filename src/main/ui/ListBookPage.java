package ui;

import model.BookCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListBookPage extends JFrame {
    private JLabel listOfBooks;
    private BookCollection bookCollection;
    private JPanel panel;

    // sets size of and colour of new page and sets the bookCollection parameter
    public ListBookPage(BookCollection bookCollection) {
        super("List Book Page");
        setPreferredSize(new Dimension(600, 400));
        this.bookCollection = bookCollection;
        panel = new JPanel();
        panel.setBackground(new java.awt.Color(191, 159, 190));
        listingBooks();
        panel.add(listOfBooks);
        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // EFFECTS: gets list of book titles in collection and assigns it to JLabel text
    private void listingBooks() {
        String bookTitles = String.join(", ", bookCollection.listAllBookTitles());
        listOfBooks = new JLabel(bookTitles);
        listOfBooks.setSize(400, 400);
        listOfBooks.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }

}
