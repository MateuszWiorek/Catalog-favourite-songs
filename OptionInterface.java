package com.wiorekmateusz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class OptionInterface extends JPanel implements ActionListener{
    private JTextField author, title;
    private JButton add, searchByTitle, searchByAuthor, viewAll;;
    String response1, response2, response3;
    JTextField title1, author1, link1;
    public static String titleFlag, authorFlag;
    OptionInterface(){
        add = new JButton("Add");
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
            FavouriteSongsInterface.resultsTable.setModel(new CenterModel((ArrayList<FavouriteSongs>) new ConnectorWithDatabase().searchByAuthor(authorFlag)));

        }
        else if (source == searchByTitle) {
            titleFlag=title.getText();
            FavouriteSongsInterface.resultsTable.setModel(new CenterModel((ArrayList<FavouriteSongs>) new ConnectorWithDatabase().searchByTitle(FavouriteSongsInterface.titleFlag)));

        }
        else if (source == viewAll) {
            FavouriteSongsInterface.resultsTable.setModel(new CenterModel((ArrayList<FavouriteSongs>) new ConnectorWithDatabase().viewAll()));
repaint();
        }
        else if (source == add) {
            askForContent();
            new ConnectorWithDatabase().addToDatabase(response1, response2, response3);
            repaint();
        }
        repaint();
    }
}
