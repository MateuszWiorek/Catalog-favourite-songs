package com.wiorekmateusz;
import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.Date;


public class FavouriteSongsInterface extends JFrame {

    public static String titleFlag, authorFlag;
    private JLabel actualDate, footer;
    FavouriteSongsList bla = new FavouriteSongsList();
    public static BorderLayout borderLayout;
    public static JTable resultsTable;
    OptionInterface optionPanel;
    FavouriteSongsInterface() {
        super("App to catalog best songs");
        setSize(1280, 720);
        borderLayout=new BorderLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(borderLayout);
        resultsTable = new JTable();
        optionPanel = new OptionInterface();
        resultsTable.setModel(new CenterModel((ArrayList<FavouriteSongs>)bla.listaPiosenek));
        actualDate = new JLabel(String.valueOf(new Date()));
        footer = new JLabel("Aplikacja wykonana przez: Mateusz Wiorek ® ");
        add(actualDate);
        add(optionPanel);
        add(footer);
        add(resultsTable);
        borderLayout.addLayoutComponent(actualDate, BorderLayout.NORTH);
        borderLayout.addLayoutComponent(optionPanel, BorderLayout.EAST);
        borderLayout.addLayoutComponent(resultsTable, BorderLayout.CENTER);
        borderLayout.addLayoutComponent(footer, BorderLayout.SOUTH);
        setVisible(true);
    }

}