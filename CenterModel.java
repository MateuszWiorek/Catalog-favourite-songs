package com.wiorekmateusz;

import javax.swing.*;
import javax.swing.JList;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class CenterModel extends AbstractTableModel {
    protected ArrayList<FavouriteSongs> favsongs;
    protected Vector columnNames;

    @Override
    public int getRowCount() {
        return favsongs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FavouriteSongs favsong = (FavouriteSongs) favsongs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return favsong.getId();
            case 1:
                return favsong.getTitle();
            case 2:
                return favsong.getAuthor();
            case 3:
                return favsong.getLink();
            default:
                return new Object();
        }
    }

    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    public String getColumnName(int columnIndex) {
        return (String) columnNames.elementAt(columnIndex);
    }

    public boolean isCellEditable(int row, int column) {
        return true;
    }

    private void initColumnNames() {
        columnNames = new Vector<String>();
        columnNames.addElement("ID");
        columnNames.addElement("TITLE");
        columnNames.addElement("AUTHOR");
        columnNames.addElement("LINK");
    }

    public CenterModel(ArrayList<FavouriteSongs> favsongs) {
        this.initColumnNames();
        this.favsongs = favsongs;
    }
}

