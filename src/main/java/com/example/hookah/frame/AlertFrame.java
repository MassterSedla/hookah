package com.example.hookah.frame;

import javax.swing.*;
import java.awt.*;

public class AlertFrame extends JFrame {
    public AlertFrame(int height) {
        alertCreate(height);
    }

    private void alertCreate(int height) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Admin");
        this.getContentPane().setBackground(new Color(250, 250, 250));
        this.setFocusable(true);
        this.setBounds(550, 350, 400, height);
        this.setVisible(true);
    }
}
