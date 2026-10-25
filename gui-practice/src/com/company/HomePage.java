package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HomePage implements ActionListener {

    public JFrame frame = new JFrame();
    public JButton button = new JButton();

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button) {
            MainPage mainpage = new MainPage();
            this.frame.dispose();
        }
    }

    public HomePage () {
        //frame
        frame.setTitle("Home Page");
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(button);

        //button
        button.setText("START");
        button.addActionListener(this);
        button.setBounds(120,150, 150,50);
        button.setFont(new Font("HelvLight", Font.PLAIN, 20));
        button.setFocusable(false);
    }
}
