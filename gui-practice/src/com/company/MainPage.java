package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back) {
            HomePage homepage = new HomePage();
            this.frame.dispose();
        }

    }

    public JFrame frame = new JFrame();
    public JLabel label = new JLabel();
    public JButton back = new JButton();


    public MainPage () {
        //frame
        frame.setTitle("Main Page");
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.add(this.label);
        frame.add(this.back);

        //label
        label.setText("this is MAIN PAGE");
        label.setFont(new Font("HelvLight", Font.PLAIN, 20));
        label.setBounds(120, 120, 250, 150);

        //button
        back.setText("BACK");
        back.setBounds(310, 325, 75, 30);
        back.addActionListener(this);
        back.setFont(new Font("HelvLight", Font.PLAIN, 15));
        back.setFocusable(false);



    }

}
