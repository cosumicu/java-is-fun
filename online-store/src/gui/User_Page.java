package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class User_Page {
	
	// Creates user page
	public static void create_User_Page() {
		
		final JFrame frame;
		JButton admin_Button, customer_Button;
		JPanel admin_Panel, customer_Panel;
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Frame Setting
		frame = new JFrame("");
		frame.setTitle("Palengke Express");
		frame.setSize(400, 400);
		frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		
		// Label fillers
		JLabel label1 = new JLabel(" ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 75;
		gbc.ipady = 15;
		frame.add(label1, gbc);
		
		JLabel label2 = new JLabel(" ");
		gbc.gridx = 1;
		gbc.gridy = 0;
		frame.add(label2, gbc);
		
		JLabel label3 = new JLabel(" ");
		gbc.gridx = 2;
		gbc.gridy = 0;
		frame.add(label3, gbc);
		
		JLabel label4 = new JLabel(" ");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		frame.add(label4, gbc);
		
		JLabel label5 = new JLabel(" ");
		gbc.gridx = 1;
		gbc.gridy = 4;
		frame.add(label5, gbc);
		
		JLabel label6 = new JLabel(" ");
		gbc.gridx = 1;
		gbc.gridy = 6;
		frame.add(label6, gbc);
		
		// Button Setting (Layout)
		admin_Button = new JButton("Admin");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 150;
		gbc.ipady = 10;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		frame.add(admin_Button, gbc);
		
		customer_Button = new JButton("Customer");
		gbc.gridx = 1;
		gbc.gridy = 3;
		frame.add(customer_Button, gbc);

		JButton exit_Button = new JButton("Exit");
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.ipadx = 10;
		gbc.ipady = -5;
		gbc.fill = GridBagConstraints.EAST;
		frame.add(exit_Button, gbc);
		
		// Button setting
		admin_Button.setFocusable(false);
		customer_Button.setFocusable(false);
		exit_Button.setFocusable(false);
		
		admin_Button.setFont(new Font("Lato", Font.PLAIN, 15));
		customer_Button.setFont(new Font("Lato", Font.PLAIN, 15));
		exit_Button.setFont(new Font("Lato", Font.PLAIN, 13));
		
		
		
		// End methods
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
		// Add action listener
		admin_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.create_Admin_Login();
				frame.setVisible(false);
			}
		});
		
		customer_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer.create_Customer_Front_Page();
				frame.setVisible(false);
			}
		});
		
		exit_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
