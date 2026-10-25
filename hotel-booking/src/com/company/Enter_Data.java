package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enter_Data implements ActionListener {

    JFrame bookingFrame = new JFrame();
    JLabel numberLabel, nameLabel, roomNumLabel, checkInLabel, checkOutLabel;
    JLabel dayLabel, monthLabel, yearLabel;
    JTextField numberTextField, nameTextField;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    String[] days = new String[32];
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] years = {"2022", "2023"};
    JComboBox daysComboBox, monthComboBox, yearComboBox;
    JButton ADD_BUTTON, CANCEL_BUTTON;
    int num;


    Enter_Data (Room room) {

        this.num = room.getRoomNum() - 1;

        for(int i = 0; i < 32; i++) {
            days[i] = "" + (i+1);
        }

        bookingFrame.setTitle("ADD DATA");
        bookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookingFrame.setSize(500, 250);

        bookingFrame.setLayout(new GridLayout(6, 1));
        bookingFrame.setVisible(true);

        panel1 = new JPanel();
        roomNumLabel = new JLabel("ROOM " + (room.getRoomNum()));
        panel1.add(roomNumLabel);
        bookingFrame.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        numberLabel = new JLabel("NO. ");
        numberTextField = new JTextField();
        numberTextField.setPreferredSize(new Dimension(250, 20));
        panel2.add(numberLabel);
        panel2.add(numberTextField);
        bookingFrame.add(panel2);

        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        nameLabel = new JLabel("NAME: ");
        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(250, 20));
        panel3.add(nameLabel);
        panel3.add(nameTextField);
        bookingFrame.add(panel3);

        panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
        checkInLabel = new JLabel("CHECK IN: ");
        monthLabel = new JLabel("Month: ");
        monthComboBox = new JComboBox(months);
        dayLabel = new JLabel("Day: ");
        daysComboBox = new JComboBox(days);
        yearLabel = new JLabel("Year: ");
        yearComboBox = new JComboBox(years);
        panel4.add(checkInLabel);
        panel4.add(monthLabel);
        panel4.add(monthComboBox);
        panel4.add(dayLabel);
        panel4.add(daysComboBox);
        panel4.add(yearLabel);
        panel4.add(yearComboBox);
        bookingFrame.add(panel4);

        panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
        checkInLabel = new JLabel("CHECK OUT: ");
        monthLabel = new JLabel("Month: ");
        monthComboBox = new JComboBox(months);
        dayLabel = new JLabel("Day: ");
        daysComboBox = new JComboBox(days);
        yearLabel = new JLabel("Year: ");
        yearComboBox = new JComboBox(years);
        panel5.add(checkInLabel);
        panel5.add(monthLabel);
        panel5.add(monthComboBox);
        panel5.add(dayLabel);
        panel5.add(daysComboBox);
        panel5.add(yearLabel);
        panel5.add(yearComboBox);
        bookingFrame.add(panel5);

        panel6 = new JPanel();
        ADD_BUTTON = new JButton("Add");
        ADD_BUTTON.addActionListener(this);
        CANCEL_BUTTON = new JButton("Cancel");
        CANCEL_BUTTON.addActionListener(this);
        panel6.add(ADD_BUTTON);
        panel6.add(CANCEL_BUTTON);
        bookingFrame.add(panel6);

        bookingFrame.pack();
        bookingFrame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == CANCEL_BUTTON) {
            bookingFrame.dispose();
        }
        if(e.getSource() == ADD_BUTTON) {
            Global.getRoomArray(num).setName(nameTextField.getText());
            System.out.println("ROOM: "+ Global.getRoomArray(num).getRoomNum()+ " " + "NAME: " + Global.getRoomArray(num).getName());
            bookingFrame.dispose();
        }
    }

}
