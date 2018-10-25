package com.wiorekmateusz;

import javax.swing.*;
import java.awt.*;

public class ResultsOfSearchingByTitleInterface extends JFrame {
    JList listToView;
    JLabel infoPanel;
    JScrollPane nextScrollPane;

    ResultsOfSearchingByTitleInterface(){
        super("Searching results: ");
        setSize(720,480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        infoPanel = new JLabel("List of songs");
        listToView = new JList(new ConnectorWithDatabase().searchByTitle(FavouriteSongsInterface.titleFlag));
        nextScrollPane = new JScrollPane(listToView);
        add(infoPanel);
        add(nextScrollPane);
        pack();
        setVisible(true);

    }

}

