package com.company;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Main_Page implements ActionListener {

    private JFrame mainFrame;
    private JLabel availableLabel, occupiedLabel, outOfOrderLabel, dateLabel, HOTEL_MANAGEMENT_MAIN_PAGE;
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private GridBagConstraints gbc = new GridBagConstraints();
    private JButton AVAILABLE_BUTTON, OCCUPIED_BUTTON, OUT_OF_ORDER_BUTTON, EXIT;
    private int top = 3, left = 3, bottom = 3, right = 3;
    private Insets i = new Insets(top, left, bottom, right);
    LocalDate dateObj = LocalDate.now();

    Main_Page() {
        mainFrame = new JFrame();
        mainFrame.setTitle("MAIN PAGE");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //mainFrame.setSize(500, 250);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setVisible(true);

        gbc.insets = i;

        panel1 = new JPanel();
        HOTEL_MANAGEMENT_MAIN_PAGE = new JLabel("HOTEL MANAGEMENT MAIN PAGE");
        panel1.add(HOTEL_MANAGEMENT_MAIN_PAGE);
        panel1.setLayout(new GridLayout(1, 1));
        panel1.setMinimumSize(new Dimension(150, 50));
        panel1.setMaximumSize(new Dimension(150, 50));
        panel1.setPreferredSize(new Dimension(150, 50));
        //panel1.setBackground(Color.GRAY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainFrame.add(panel1, gbc);


        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        panel2.setMinimumSize(new Dimension(150, 50));
        panel2.setMaximumSize(new Dimension(150, 50));
        panel2.setPreferredSize(new Dimension(150, 50));
        //panel2.setBackground(Color.BLACK);
        dateLabel = new JLabel("DATE: " + dateObj);
        panel2.add(dateLabel);
        gbc.gridx = 12;
        gbc.gridy = 0;
        mainFrame.add(panel2, gbc);


        AVAILABLE_BUTTON = new JButton("AVAILABLE " + Global.getNumAvailableRooms() + "/20");
        AVAILABLE_BUTTON.setMinimumSize(new Dimension(150, 100));
        AVAILABLE_BUTTON.setMaximumSize(new Dimension(150, 100));
        AVAILABLE_BUTTON.setPreferredSize(new Dimension(150, 100));
        //AVAILABLE_BUTTON.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 6;
        gbc.gridheight = 6;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame.add(AVAILABLE_BUTTON, gbc);

        OCCUPIED_BUTTON = new JButton("OCCUPIED " + Global.getNumOccupiedRooms() + "/20");
        OCCUPIED_BUTTON.setMinimumSize(new Dimension(150, 100));
        OCCUPIED_BUTTON.setMaximumSize(new Dimension(150, 100));
        OCCUPIED_BUTTON.setPreferredSize(new Dimension(150, 100));
        //OCCUPIED_BUTTON.setBackground(Color.RED);
        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.gridwidth = 6;
        gbc.gridheight = 6;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame.add(OCCUPIED_BUTTON, gbc);

        OUT_OF_ORDER_BUTTON = new JButton("OUT OF ORDER");
        OUT_OF_ORDER_BUTTON.setMinimumSize(new Dimension(150, 100));
        OUT_OF_ORDER_BUTTON.setMaximumSize(new Dimension(150, 100));
        OUT_OF_ORDER_BUTTON.setPreferredSize(new Dimension(150, 100));
        //OUT_OF_ORDER_BUTTON.setBackground(Color.BLUE);
        gbc.gridx = 12;
        gbc.gridy = 3;
        gbc.gridwidth = 6;
        gbc.gridheight = 6;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame.add(OUT_OF_ORDER_BUTTON, gbc);

        EXIT = new JButton("EXIT");
        gbc.gridx = 12;
        gbc.gridy = 9;
        gbc.gridwidth = 6;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame.add(EXIT, gbc);

        mainFrame.pack();

        AVAILABLE_BUTTON.addActionListener(this);
        OCCUPIED_BUTTON.addActionListener(this);
        OUT_OF_ORDER_BUTTON.addActionListener(this);
        EXIT.addActionListener(this);

        mainFrame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == AVAILABLE_BUTTON) {
            mainFrame.dispose();
            new Available_Page();
        }
        else if(e.getSource() == OCCUPIED_BUTTON) {

        }
        else if(e.getSource() == OUT_OF_ORDER_BUTTON) {

        }
        else if(e.getSource() == EXIT) {
            new Login_Page();
            mainFrame.dispose();
        }
    }

}
