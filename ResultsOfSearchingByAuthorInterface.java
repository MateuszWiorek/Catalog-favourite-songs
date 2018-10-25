package com.wiorekmateusz;

import javax.swing.*;
import java.awt.*;

public class ResultsOfSearchingByAuthorInterface extends JFrame{
    JList listToView;
    JLabel infoPanel;
    JScrollPane nextScrollPane;

    ResultsOfSearchingByAuthorInterface(){
        super("Searching results: ");
        setSize(720,480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        infoPanel = new JLabel("List of songs");
        listToView = new JList(new ConnectorWithDatabase().searchByAuthor(FavouriteSongsInterface.authorFlag));
        nextScrollPane = new JScrollPane(listToView);
        add(infoPanel);
        add(nextScrollPane);
        pack();
        setVisible(true);

    }

}

