package com.wiorekmateusz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FavouriteSongsInterface extends JFrame implements ActionListener {
    private JTextField author, title;
    private JButton add, searchByTitle, searchByAuthor, viewAll;;
    ConnectorWithDatabase connectedWithDatabesObject = new ConnectorWithDatabase();
    String response1, response2, response3;
    JTextField title1, author1, link1;
    public static String titleFlag, authorFlag;

    FavouriteSongsInterface() {
        super("App to catalog best songs");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add = new JButton("Dodaj");
        add.addActionListener(this);
        author = new JTextField(16);
        searchByAuthor = new JButton("Search by singer");
        searchByAuthor.addActionListener(this);
        title = new JTextField(16);
        searchByTitle = new JButton("Search by title");
        searchByTitle.addActionListener(this);
        viewAll = new JButton("View all");
        viewAll.addActionListener(this);
        add(add);
        add(author);
        add(searchByAuthor);
        add(title);
        add(searchByTitle);
        add(viewAll);
        pack();
        setVisible(true);
    }

    public void askForContent() {
        response1 = JOptionPane.showInputDialog(null, "Write title");
        title1 = new JTextField(response1, 20);
        response2 = JOptionPane.showInputDialog(null, "Write title");
        author1 = new JTextField(response2, 20);
        response3 = JOptionPane.showInputDialog(null, "Write link");
        link1 = new JTextField(response3, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == searchByAuthor){
            authorFlag = author.getText();
            new ResultsOfSearchingByAuthorInterface();
        }
        else if (source == searchByTitle) {
            titleFlag=title.getText();
            new ResultsOfSearchingByTitleInterface();

        }
        else if (source == viewAll) {
            new ResultsOfViewAllInterface();

        }
        else if (source == add) {
            askForContent();
            connectedWithDatabesObject.addToDatabase(response1, response2, response3);
            repaint();
        }
        repaint();
    }
}