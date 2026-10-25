package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;




public class Available_Page implements ActionListener {

    private JFrame availableFrame;
    private JLabel availableRoomsLabel;
    private JButton BACK;
    private JPanel panel1, panel2, panel3, panel4;
    private GridBagConstraints gbc = new GridBagConstraints();
    //private Room[] roomArray = new Room[20];
    private JButton[] roomButton = new JButton[20];
    private int top = 2, left = 2, bottom = 2, right = 2;
    private Insets i = new Insets(top, left, bottom, right);
    //static int availableRooms, occupiedRooms, outOFOrderRooms;



    Available_Page() {

        //for(int i = 0; i <20; i++) {
        //    Global.roomArray[i] = new Room();
        //}

        //roomArray[1].name = "a";

        availableFrame = new JFrame();
        availableFrame.setTitle("AVAILABLE ROOMS");
        availableFrame.setVisible(true);
        availableFrame.setLayout(new GridBagLayout());
        //availableFrame.setSize(1000, 500);
        availableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        availableRoomsLabel = new JLabel("AVAILABLE ROOMS");
        panel1.add(availableRoomsLabel);
        //panel1.setBackground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 0;
        availableFrame.add(panel1, gbc);


        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4,5));
        panel2.setBackground(Color.GRAY);
        gbc.gridx = 1;
        gbc.gridy = 1;
        availableFrame.add(panel2, gbc);

        for(int x = 0; x < 20; x++) {
            if(Global.getRoomArray(x).name == null) {
                roomButton[x] = new JButton("ROOM" + " " + (x+1));
                roomButton[x].setMinimumSize(new Dimension(150, 50));
                roomButton[x].setMaximumSize(new Dimension(150, 50));
                roomButton[x].setPreferredSize(new Dimension(150, 50));
                roomButton[x].addActionListener(this);
                panel2.add(roomButton[x]);
            }
        }

        panel3 = new JPanel();
        //panel3.setBackground(Color.BLUE);
        gbc.gridx = 2;
        gbc.gridy = 2;
        availableFrame.add(panel3, gbc);

        panel4 = new JPanel();
        panel4.setBackground(Color.BLACK);
        BACK = new JButton("BACK");
        BACK.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel4.add(BACK);
        availableFrame.add(BACK, gbc);


        availableFrame.pack();
        availableFrame.setLocationRelativeTo(null);
        //checking
        //System.out.println(Global.roomArray[1].roomNum);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == BACK) {
            availableFrame.dispose();
            new Main_Page();
        }


        for(int x = 0; x < roomButton.length; x++) {
            if(e.getSource() == roomButton[x]) {
               new Enter_Data(Global.getRoomArray(x));
               roomButton[x].setEnabled(false);
            }
        }
    }

}
