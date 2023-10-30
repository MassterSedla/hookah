package com.example.hookah.frame;

import javax.swing.*;
import java.awt.*;

public class Input extends JTextField {
    public Input(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setForeground(new Color(224, 3, 20));
        this.setFont(new Font("MV Boli", Font.PLAIN, 15));
        this.setBackground(new Color(255, 255, 255));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setVisible(true);
        this.setBounds(x, y , width, height);
    }
}
