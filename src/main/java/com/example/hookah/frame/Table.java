package com.example.hookah.frame;

import javax.swing.*;
import java.awt.*;

public class Table extends JTable {
    public Table(String[][] data, String[] columnName, int secondColumn) {
        super(data, columnName);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setRowHeight(30);
        this.getColumnModel().getColumn(0).setMinWidth(30);
        this.getColumnModel().getColumn(0).setMaxWidth(30);
        this.getColumnModel().getColumn(1).setMinWidth(secondColumn);
        this.getColumnModel().getColumn(1).setMaxWidth(secondColumn);
        this.getColumnModel().getColumn(2).setMinWidth(75);
        this.getColumnModel().getColumn(2).setMaxWidth(75);
        this.setForeground(new Color(224, 3, 20));
        this.setFont(new Font("MV Boli", Font.PLAIN, 15));
        this.setBackground(new Color(250, 250, 250));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
    }
}
