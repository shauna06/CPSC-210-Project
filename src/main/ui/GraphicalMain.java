package ui;

import javax.swing.*;
import java.awt.*;

public class GraphicalMain extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private JPanel panel;
    private JButton createBookButton;
    private JButton reloadCollectionButton;

    public static void main(String[] args) {
        new GraphicalMain();
    }

    // MODIFIES: this
    // EFFECTS: creates display window with buttons
    public GraphicalMain() {
        super("YourStories Console");
        setSize(WIDTH, HEIGHT);
        panel = new JPanel();
        add(panel);
        loadDisplayItems();
        // will need some way to check if the user clicks one of the buttons and code what will happen
//        setBackground(new java.awt.Color(191, 170, 159));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates panel and buttons to be displayed and used
    public void loadDisplayItems() {
//        panel.setBackground(new java.awt.Color(191, 170, 159));
        createBookButton = createNewButton(createBookButton, "Create book");
        reloadCollectionButton = createNewButton(reloadCollectionButton, "Reload Collection");
        panel.add(createBookButton);
        panel.add(reloadCollectionButton);
        createBookButton.setLocation(300,190);
        reloadCollectionButton.setLocation(300, 210);
        panel.setBackground(new java.awt.Color(191, 170, 159));
    }

    // EFFECTS: returns JButton with text
    public JButton createNewButton(JButton button, String text) {
        button = new JButton(text);
        button.setOpaque(true);
        button.setBackground(new java.awt.Color(64, 46, 37));
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(300, 70));
        button.setForeground(Color.black);
        button.setFont(new Font("Times New Roman", Font.BOLD, 10));
        return button;
    }

    // ASK HOW TO PUT THE BUTTONS IN THE RIGHT PLACE AS I AM CONFUSED WITH HOW TO DO IT
}
