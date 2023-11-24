package ui;

import model.BookCollection;
import model.RatingComparator;
import model.YearComparator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortBooksPage extends JFrame implements ActionListener {
    private JButton yearButton;
    private JButton ratingButton;
    private BookCollection bookCollection;
    private JPanel panel;
    private YearComparator yearComparator;
    private RatingComparator ratingComparator;

    public SortBooksPage(BookCollection bookCollection) {
        super("Sort books page");
        yearComparator = new YearComparator();
        ratingComparator = new RatingComparator();
        setPreferredSize(new Dimension(600, 400));
        this.bookCollection = bookCollection;
        panel = new JPanel();
        setActionCommands();
        loadDisplayMenu();
        panel.setBackground(new java.awt.Color(191, 159, 190));
        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // EFFECTS: creates buttons
    public JButton createButtons(String text) {
        JButton button = new JButton(text);
        button.setOpaque(true);
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(300, 70));
        button.setForeground(Color.black);
        button.setFont(new Font("Times New Roman", Font.BOLD, 10));
        return button;
    }

    // EFFECTS: instantiates buttons, sets action commands, and adds an action listener
    public void setActionCommands() {
        yearButton = createButtons("Sort by year");
        yearButton.setActionCommand("Year");
        yearButton.addActionListener(this);
        ratingButton = createButtons("Sort by rating");
        ratingButton.setActionCommand("Rating");
        ratingButton.addActionListener(this);


    }

    // EFFECTS: adds and displays two buttons onto the screen
    public void loadDisplayMenu() {
        panel.add(yearButton);
        panel.add(ratingButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Year")) {
            bookCollection.sortBooksByYear(yearComparator);
            new ListBookPage(bookCollection);
        }
        if (e.getActionCommand().equals("Rating")) {
            bookCollection.sortBooksByRating(ratingComparator);
            new ListBookPage(bookCollection);
        }
    }
}
