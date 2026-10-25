package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Login_Page implements ActionListener {

    static JFrame loginFrame;
    private JLabel usernameLabel, passwordLabel;
    private JButton loginButton;
    private JTextField usernameTextField, passwordTextField;
    private JPanel panel1, panel2, panel3;
    private final String[] username = new String[]{"a"};
    private final String[] password = new String[]{"a"};

    Login_Page() {
        loginFrame = new JFrame();
        loginFrame.setTitle("LOGIN PAGE");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(500, 250);
        loginFrame.setLayout(new GridLayout(3,0,0,0));
        loginFrame.setBackground(Color.BLACK);
        loginFrame.isOpaque();

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        //panel1.setBackground(new Color(0x0));
        usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(250, 20));
        usernameTextField.addActionListener(this);
        panel1.add(usernameLabel);
        panel1.add(usernameTextField);
        loginFrame.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        passwordLabel = new JLabel("Password:");
        passwordTextField = new JTextField();
        passwordTextField.setPreferredSize(new Dimension(250, 20));
        passwordTextField.addActionListener(this);
        panel2.add(passwordLabel);
        panel2.add(passwordTextField);
        loginFrame.add(panel2);

        panel3 = new JPanel();
        loginButton = new JButton("login");
        loginButton.addActionListener(this);
        panel3.add(loginButton);
        loginFrame.add(panel3);


        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            String usernameInput = this.usernameTextField.getText();
            String passwordInput = this.usernameTextField.getText();
            if(Objects.equals(usernameInput, username[0]) && Objects.equals(passwordInput, password[0])) {
                loginFrame.dispose();
                new Main_Page();
            }
        }
    }
}
