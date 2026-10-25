package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel{
	
	// Database variables
	static String username = "root";
	static String password = "root";
	
	public static void execute_Update_Query(String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?", username, password);
		java.sql.Statement st = con.createStatement();
		int rs = st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	public static void execute_Update_Query_v2(String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", username, password);
		java.sql.Statement st = con.createStatement();
		int rs = st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	
	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException {
		
		String query = null;
		
		query = "CREATE DATABASE IF NOT EXISTS my_database";
		execute_Update_Query(query);
		query = "USE my_database";
		execute_Update_Query_v2(query);
		query = "CREATE TABLE IF NOT EXISTS inventory (item_id INT PRIMARY KEY, item_name VARCHAR(20));";
		execute_Update_Query_v2(query);
		
		User_Page.create_User_Page();
	}
}