package com.example.hookah.frame;

import com.example.hookah.model.Coals;
import com.example.hookah.model.Tobacco;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ComboBox extends JComboBox<String> {
    public ComboBox(int x, int y, int width, int height) {
        this.addItem(" ");
        this.setLayout(null);
        this.setForeground(new Color(224, 3, 20));
        this.setFont(new Font("MV Boli", Font.PLAIN, 15));
        this.setBackground(new Color(255, 255, 255));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.setOpaque(true);
        this.setVisible(true);
        this.setBounds(x, y , width, height);
    }
}
