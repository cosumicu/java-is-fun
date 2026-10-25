package gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;
import java.awt.*;
import javax.swing.*;
public class Admin{
	
	// important variables
	private static int[] items = {};
	static HashMap<String, Integer> customer_Cart = new HashMap<String, Integer>();
	
	// Database variables
	static String url = "jdbc:mysql://localhost:3306/my_database";
	static String username_Database = "root";
	static String password_Database = "root";
	
	public static void create_Admin_Login() {
		final JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel username_Panel = new JPanel();
		JPanel password_Panel = new JPanel();
		JPanel panel3 = new JPanel();
		JLabel username_Label = new JLabel("Username: ");
		JLabel password_Label = new JLabel("Password: ");
		final JTextField username_TextField = new JTextField();
		final JPasswordField password_TextField = new JPasswordField();
		JButton login_Button = new JButton();
		JButton back_Button = new JButton();

		// Frame setting
		frame.setTitle("Admin Login");
		frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Panel setting
        panel.setLayout(new GridLayout(3, 1));
		
        username_Panel.setLayout(new FlowLayout());
        password_Panel.setLayout(new FlowLayout());
        panel3.setLayout(new GridLayout(1, 2));
        
        // Label setting
        
        // TextField setting
        username_TextField.setPreferredSize(new Dimension(250,30));
        password_TextField.setPreferredSize(new Dimension(250,30));
        
        // Button setting
        login_Button.setText("Login");
        login_Button.setFocusable(false);
        login_Button.setPreferredSize(new Dimension(30,30));
        login_Button.setFont(new Font("Lato", Font.PLAIN, 15));
        
        back_Button.setText("Back");
        back_Button.setFocusable(false);
        back_Button.setPreferredSize(new Dimension(30,30));
        back_Button.setFont(new Font("Lato", Font.PLAIN, 15));
        
        // Add components
        username_Panel.add(username_Label);
        username_Panel.add(username_TextField);
        password_Panel.add(password_Label);
        password_Panel.add(password_TextField);
        
        panel3.add(back_Button);
        panel3.add(login_Button);
        
        panel.add(username_Panel);
        panel.add(password_Panel);
        panel.add(panel3, BorderLayout.EAST);
        
        
        frame.add(panel);
        
        // Adding action listener
		login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = username_TextField.getText();
				String password = password_TextField.getText();
				if(username.equalsIgnoreCase("a") && password.equalsIgnoreCase("a")) {
					frame.dispose();
					create_Admin_Page();
				}
				else {
					JOptionPane.showMessageDialog(null, "incorrect username or password");
				}
			}
		});
		
		back_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				User_Page.create_User_Page();
			}
		});
        
        
        // End methods
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
	}


	// Creates admin main page
	public static void create_Admin_Page() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Setting frame
		final JFrame frame = new JFrame("Admin Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setResizable(false);
		frame.setLayout(new GridBagLayout());
		
		// Label fillers
		JLabel label1 = new JLabel("     ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.add(label1, gbc);
		
		JLabel label2 = new JLabel(" ");
		gbc.gridx = 1;
		gbc.gridy = 0;
		frame.add(label2, gbc);
		
		JLabel label3 = new JLabel("   ");
		gbc.gridx = 2;
		gbc.gridy = 0;
		frame.add(label3, gbc);
		
		JLabel label4 = new JLabel("     ");
		gbc.gridx = 3;
		gbc.gridy = 0;
		frame.add(label4, gbc);
		
		JLabel label5 = new JLabel(" ");
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		frame.add(label5, gbc);
		
		JLabel label6 = new JLabel(" ");
		gbc.gridx = 2;
		gbc.gridy = 4;
		frame.add(label6, gbc);
		
		// Setting panel
		
		// Button setting
		JButton show_Inventory_Button = new JButton("Inventory");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 50;
		gbc.ipady = 10;
		gbc.insets = new Insets(0,10,0,10);
		frame.add(show_Inventory_Button, gbc);
		
		JButton add_Items_Button = new JButton("Restock");
		gbc.gridx = 2;
		gbc.gridy = 1;
		frame.add(add_Items_Button, gbc);
		
		
		JButton back_Button = new JButton("Back");
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.insets = new Insets(10,50,10,10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		frame.add(back_Button, gbc);
		
		
		// Button customize
		show_Inventory_Button.setFocusable(false);
		add_Items_Button.setFocusable(false);
		back_Button.setFocusable(false);
		
		show_Inventory_Button.setFont(new Font("Lato", Font.PLAIN, 15));
		add_Items_Button.setFont(new Font("Lato", Font.PLAIN, 15));
		back_Button.setFont(new Font("Lato", Font.PLAIN, 13));
		
		// Add action listener
		show_Inventory_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.setVisible(false);
					Table table = new Table();
					table.show_Inventory();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		add_Items_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					restock_Inventory();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "All items restocked to 10");
			}
		});
		
		back_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				User_Page.create_User_Page();
			}
		});

		
		// End methods
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	// Adds a specific item
	public static void add_Item() {
		
	}

	// Removes items using cart, from the database
	void remove_Bought_Items() throws ClassNotFoundException, SQLException {
		
		// Iterates through the cart, deletes the items from the database
		for (Entry<String, Integer> entry : customer_Cart.entrySet()) {		
		    String key = entry.getKey();
		    Integer value = entry.getValue();
			
		    String query = null;
		    
			switch(key) {
			case "Banana 1kg":
//				System.out.println(value);
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit1() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 10" + get_Item_Qty_Fruit1();
					else
						query =  "DELETE FROM inventory WHERE item_id = 1" + get_Item_Qty_Fruit1();
					execute_Query_Remove_Item(query);
				}
				break;
			case "Dragon Fruit":
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit2() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 20" + get_Item_Qty_Fruit2();
					else
						query =  "DELETE FROM inventory WHERE item_id = 2" + get_Item_Qty_Fruit2();
					execute_Query_Remove_Item(query);
				}
				break;
			case "Grapes 1kg":
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit3() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 30" + get_Item_Qty_Fruit3();
					else
						query =  "DELETE FROM inventory WHERE item_id = 3" + get_Item_Qty_Fruit3();
					execute_Query_Remove_Item(query);
				}
				break;
			case "Green Apple":
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit4() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 40" + get_Item_Qty_Fruit4();
					else
						query =  "DELETE FROM inventory WHERE item_id = 4" + get_Item_Qty_Fruit4();
					execute_Query_Remove_Item(query);
				}
				break;
			case "Mango":
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit5() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 50" + get_Item_Qty_Fruit5();
					else
						query =  "DELETE FROM inventory WHERE item_id = 5" + get_Item_Qty_Fruit5();
					execute_Query_Remove_Item(query);
				}
				break;
			case "Orange":
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit6() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 60" + get_Item_Qty_Fruit6();
					else
						query =  "DELETE FROM inventory WHERE item_id = 6" + get_Item_Qty_Fruit6();
					execute_Query_Remove_Item(query);
				}
				break;
			case "Rambutan 1kg":
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit7() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 70" + get_Item_Qty_Fruit7();
					else
						query =  "DELETE FROM inventory WHERE item_id = 7" + get_Item_Qty_Fruit7();
					execute_Query_Remove_Item(query);
				}
				break;
			case "Red Apple":
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit8() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 80" + get_Item_Qty_Fruit8();
					else
						query =  "DELETE FROM inventory WHERE item_id = 8" + get_Item_Qty_Fruit8();
					execute_Query_Remove_Item(query);
				}
				break;
			case "Strawberry 250g":
				for(int i = 0; i < value; i++) {
					if(get_Item_Qty_Fruit9() < 10)
						query =  "DELETE FROM inventory WHERE item_id = 90" + get_Item_Qty_Fruit9();
					else
						query =  "DELETE FROM inventory WHERE item_id = 9" + get_Item_Qty_Fruit9();
					execute_Query_Remove_Item(query);
				}
				break;
			default: 
				System.out.println("no items. error");
				break;
			}
		}
	}

	public void execute_Query_Remove_Item(String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username_Database, password_Database);
		java.sql.Statement st = con.createStatement();
		int rs = st.executeUpdate(query);
		
		System.out.println("item removed");
		
		st.close();
		con.close();
	}

	//
	public static int execute_Query_Get_Item_Qty(String query) throws ClassNotFoundException, SQLException {
		
		int qty = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username_Database, password_Database);
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			qty++;
		}
		
		st.close();
		con.close();
		return qty;
	}
	
	// Methods to get Qty of Items in the database 
	public static int get_Item_Qty_Fruit1() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Banana 1kg'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	public static int get_Item_Qty_Fruit2() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Dragon Fruit'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	public static int get_Item_Qty_Fruit3() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Grapes 1kg'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	public static int get_Item_Qty_Fruit4() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Green Apple'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	public static int get_Item_Qty_Fruit5() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Mango'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	public static int get_Item_Qty_Fruit6() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Orange'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	public static int get_Item_Qty_Fruit7() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Rambutan 1kg'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	public static int get_Item_Qty_Fruit8() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Red Apple'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	public static int get_Item_Qty_Fruit9() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM inventory WHERE item_name = 'Strawberry 250g'";
		return execute_Query_Get_Item_Qty(query);
	}
	
	// execute update query for re-stock
	public static void execute_Query_Restock(String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username_Database, password_Database);
		java.sql.Statement st = con.createStatement();
		int rs = st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	// Re-stock inventory, maximum is 10, doesn't delete remaining items on database, only fills empty slots
	public static void restock_Inventory() throws ClassNotFoundException, SQLException {
		
		// Add 'Banana 1kg'
		for(int i = (get_Item_Qty_Fruit1() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(10" + i +  ",'Banana 1kg')";
			else
				query = "INSERT INTO inventory VALUES(1" + i +  ",'Banana 1kg')";
			
			execute_Query_Restock(query);
		}
		
		// Add 'Dragon Fruit'
		for(int i = (get_Item_Qty_Fruit2() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(20" + i +  ",'Dragon Fruit')";
			else
				query = "INSERT INTO inventory VALUES(2" + i +  ",'Dragon Fruit')";
			
			execute_Query_Restock(query);
		}
		
		// Add 'Grapes 1kg'
		for(int i = (get_Item_Qty_Fruit3() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(30" + i +  ",'Grapes 1kg')";
			else
				query = "INSERT INTO inventory VALUES(3" + i +  ",'Grapes 1kg')";
			
			execute_Query_Restock(query);
		}
		
		// Add 'Green Apple'
		for(int i = (get_Item_Qty_Fruit4() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(40" + i +  ",'Green Apple')";
			else
				query = "INSERT INTO inventory VALUES(4" + i +  ",'Green Apple')";
			
			execute_Query_Restock(query);
		}
		
		// Add 'Mango'
		for(int i = (get_Item_Qty_Fruit5() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(50" + i +  ",'Mango')";
			else
				query = "INSERT INTO inventory VALUES(5" + i +  ",'Mango')";
			
			execute_Query_Restock(query);
		}
		
		// Add 'Orange'
		for(int i = (get_Item_Qty_Fruit6() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(60" + i +  ",'Orange')";
			else
				query = "INSERT INTO inventory VALUES(6" + i +  ",'Orange')";
			
			execute_Query_Restock(query);
		}
		
		// Add 'Rambutan 1kg'
		for(int i = (get_Item_Qty_Fruit7() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(70" + i +  ",'Rambutan 1kg')";
			else
				query = "INSERT INTO inventory VALUES(7" + i +  ",'Rambutan 1kg')";
			
			execute_Query_Restock(query);
		}
		
		// Add 'Red Apple'
		for(int i = (get_Item_Qty_Fruit8() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(80" + i +  ",'Red Apple')";
			else
				query = "INSERT INTO inventory VALUES(8" + i +  ",'Red Apple')";
			
			execute_Query_Restock(query);
		}
		
		// Add 'Strawberry 250g'
		for(int i = (get_Item_Qty_Fruit9() + 1); i <= 10; i++) {
			String query = null;
			if(i < 10)
				query = "INSERT INTO inventory VALUES(90" + i +  ",'Strawberry 250g')";
			else
				query = "INSERT INTO inventory VALUES(9" + i +  ",'Strawberry 250g')";
			
			execute_Query_Restock(query);
		}
	}
	
	// this method is not used
	public static void empty_Inventory() throws ClassNotFoundException, SQLException {
		String query = "DELETE FROM inventory;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username_Database, password_Database);
		java.sql.Statement st = con.createStatement();
		int rs = st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	public static class Table extends JPanel{

	    JTable jt;
	    public Table() throws ClassNotFoundException, SQLException{

//	        DefaultTableModel model = new DefaultTableModel(data,header);
//
//	        JTable table = new JTable(model);
	        
			// Query
			String query = "SELECT * FROM inventory";
			
			// Setting table
			JTable table = new JTable();
			
			//Setting database connectivity
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username_Database, password_Database);
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			
			String[] header = {"ITEM ID", "ITEM NAME"};
			dtm.setColumnIdentifiers(header);
			
			while(rs.next()) {
				dtm.addRow(new Object[]{rs.getInt(1), rs.getString(2)});
			}
			
			st.close();
			con.close();

	        table.setPreferredScrollableViewportSize(new Dimension(500,400));
	        table.setFillsViewportHeight(true);

	        JScrollPane js=new JScrollPane(table);
	        js.setVisible(true);
	        add(js);

	    }

	    public void show_Inventory() throws ClassNotFoundException, SQLException {

	        final JFrame frame_Inventory=new JFrame();
	        
	        // Setting table
	        Table table_inventory= new Table();
	        
	        // Setting frame
	        frame_Inventory.setTitle("Inventory");
	        frame_Inventory.setSize(500, 500);
	        frame_Inventory.setResizable(false);
	        frame_Inventory.setVisible(true);
	        frame_Inventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame_Inventory.setLayout(new BorderLayout());
	        
	        // Setting panel
	        JPanel panel1 = new JPanel();
	        panel1.setLayout(new GridLayout(1,1));
	        
	        JPanel panel2 = new JPanel();
	        panel2.setLayout(new GridBagLayout());
	        
	        
	        // Setting button
	        JButton back_Button = new JButton();
	        back_Button.setText("Back");
	        back_Button.setPreferredSize(new Dimension(75, 30));
	        
	        // Add action Listener
			back_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame_Inventory.dispose();
					create_Admin_Page();
				}
			});
			
			// Customize button
			back_Button.setFont(new Font("Lato", Font.PLAIN, 15));
	        
	        // Add components
	        panel1.add(table_inventory);
	        panel2.add(back_Button);
	        frame_Inventory.add(panel1, BorderLayout.NORTH);
	        frame_Inventory.add(panel2, BorderLayout.SOUTH);
	        
	        // End methods
	        frame_Inventory.setLocationRelativeTo(null);
	        frame_Inventory.pack();
	    }

	}
	
	
	
	// Getters and Setters
	public static HashMap<String, Integer> getCustomer_Cart() {
		return customer_Cart;
	}


	public static void setCustomer_Cart(HashMap<String, Integer> customer_Cart) {
		Admin.customer_Cart = customer_Cart;
	}
	
}
