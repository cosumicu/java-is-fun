
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;

import gui.Admin.Table;

public class Customer extends Admin {
	// 
	final JFrame customer_Order_Page_Frame = new JFrame();
	private JTable  table = new JTable();
	private DefaultTableModel dtm;
	GridBagConstraints gbc = new GridBagConstraints();
	
	// Text field for payment
	JTextField subtotal_TextField = new JTextField();
	JTextField discount_TextField = new JTextField();
	JTextField total_TextField = new JTextField();
	JTextField payment_TextField = new JTextField();
	JTextField change_TextField = new JTextField();
	
	String discount = "";
	double change = 0;
	double totalv2 = 0;
	
	// Fields for items, FRUITS
	private static final int FRUIT_ELEMETS = 9;
	static private JLabel[] fruitLabel;
	static private JLabel[] fruitImage;
	static private Double[] fruitPrice;
	static private String[] fruitFile;
	private JSpinner[] numSpinnerFruits = new JSpinner[FRUIT_ELEMETS];
	SpinnerNumberModel spnummodel;
	
	 // Receipt variables
	static String receipt_Subtotal = null;
	static String receipt_Discount = null;
	static String receipt_Total = null;
	static String receipt_Payment = null;
	static String receipt_Change = null;
	
	// Real Quantity for Fruits
//	static private int[] fruitQty = {get_Item_Qty_Fruit1(), 5, 5, 5, 5, 5, 5, 5, 5};
	static private int[] fruitQty = new int[FRUIT_ELEMETS];
	
	// PRICES
	// price items
	double f1, f2, f3, f4, f5, f6, f7, f8, f9;
	// these are the total price of the item, formula: price_Of_Item * Quantity
	double fruit1, fruit2, fruit3, fruit4, fruit5, fruit6, fruit7, fruit8, fruit9;	// fruit
	// these are the total price of the items bought in the same category, formula: total_Price_Of_Item + total_Price_Of_Item + ...
	double totalForFruits;
	
	// not sure
	double totalPrice = 0;
	// this variable is unnecessary, can delete this
	double total = 0;
	
	// Hashmap for saving the selected items
//	private static HashMap<String, Integer> customer_Cart = new HashMap<String, Integer>();
	
	public static void create_Customer_Front_Page() {
		final JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label1 = new JLabel();
		JLabel title = new JLabel();
		ImageIcon myPicture;
		JButton orderNowButton = new JButton();
		JButton backButton = new JButton();
		
        frame.setTitle("Welcome Customer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // Panel setting
        panel1 = new JPanel();
        panel2 = new JPanel();

        panel1.setPreferredSize(new Dimension(100, 285));
        panel2.setPreferredSize(new Dimension(100, 100));

        panel1.setLayout(new GridLayout(1, 1));

        // For visual
//        panel1.setBackground(Color.GRAY);
//        panel2.setBackground(Color.LIGHT_GRAY);


        // Label setting
        label1 = new JLabel();
        myPicture = new ImageIcon(new ImageIcon("/front_logo.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        label1.setIcon(myPicture);
        label1.setPreferredSize(new Dimension(100, 100));
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label1);

        // Button setting
        orderNowButton.setText("Order Now");
        orderNowButton.setSize(50, 25);
        orderNowButton.setFocusable(false);
        
        backButton.setText("Back");
        backButton.setSize(50, 25);
        backButton.setFocusable(false);
        panel2.add(backButton);
        panel2.add(orderNowButton);
        
        // Button customize
        orderNowButton.setFont(new Font("Lato", Font.PLAIN, 13));
        backButton.setFont(new Font("Lato", Font.PLAIN, 13));

        // Add panels
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);
        
        // Set Qty
        try {
			fruitQty[0] = get_Item_Qty_Fruit1();
	        fruitQty[1] = get_Item_Qty_Fruit2();
	        fruitQty[2] = get_Item_Qty_Fruit3();
	        fruitQty[3] = get_Item_Qty_Fruit4();
	        fruitQty[4] = get_Item_Qty_Fruit5();
	        fruitQty[5] = get_Item_Qty_Fruit6();
	        fruitQty[6] = get_Item_Qty_Fruit7();
	        fruitQty[7] = get_Item_Qty_Fruit8();
	        fruitQty[8] = get_Item_Qty_Fruit9();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        // Button action listener
		orderNowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer food;
				try {
					food = new Customer();
					food.create_Customer_Order_Page();
					food.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				User_Page.create_User_Page();
			}
		});

        // End methods
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}
	
	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void create_Customer_Order_Page() throws IOException {
		JButton backButton = new JButton();
		JButton orderButton = new JButton();
		
		// Frame setting
		customer_Order_Page_Frame.setTitle("Palengke Express");
		customer_Order_Page_Frame.setBounds(100, 100, 750, 550);
		customer_Order_Page_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		customer_Order_Page_Frame.getContentPane().setLayout(null);
		customer_Order_Page_Frame.setLocationRelativeTo(null);
		
		// Label setting
		JLabel lblFoodOrdered = new JLabel("Food Ordered");
		lblFoodOrdered.setBounds(529, 11, 81, 14);
		
		// Label setting on TabbedPane
		JLabel tp1, tp2, tp3;
		tp1 = new JLabel("Fruits");
		tp1.setFont(new Font("Lato", Font.PLAIN, 12));
		tp2 = new JLabel("Fruits");
		tp2.setFont(new Font("Lato", Font.PLAIN, 12));
		tp3 = new JLabel("Fruits");
		tp3.setFont(new Font("Lato", Font.PLAIN, 12));
		
		table = new JTable();
		backButton = new JButton();
		orderButton = new JButton();
		dtm = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		table = new JTable();
		table.setModel(dtm);
		table.setBounds(475, 31, 1, 1); // int x, int y, int width, int height
		table.setSize(245, 300); // width,height
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(0); // hide spinner
															// column
		table.getColumnModel().getColumn(3).setMaxWidth(0); // hide spinner
															// column
		table.setShowGrid(false); // remove cell boarder
		
		customer_Order_Page_Frame.getContentPane().add(table);

		// Payment
		// sub total label, text field
		JLabel subtotal_label = new JLabel("Subtotal  : ");
		subtotal_label.setBounds(519, 340, 100, 14);
		customer_Order_Page_Frame.getContentPane().add(subtotal_label);
		
		subtotal_TextField.setBounds(585, 340, 86, 20);
		customer_Order_Page_Frame.getContentPane().add(subtotal_TextField);
		subtotal_TextField.setColumns(10);
		subtotal_TextField.setEditable(false);

		// discount label, text field
		JLabel discount_Label = new JLabel("Discount  : ");
		discount_Label.setBounds(519, 365, 100, 14);
		customer_Order_Page_Frame.getContentPane().add(discount_Label);
		
		discount_TextField.setBounds(585, 365, 86, 20);
		customer_Order_Page_Frame.getContentPane().add(discount_TextField);
		discount_TextField.setColumns(10);
		discount_TextField.setEditable(false);
		
		// total label, text field
		JLabel total_label = new JLabel("Total  : ");
		total_label.setBounds(519, 390, 46, 14);
		customer_Order_Page_Frame.getContentPane().add(total_label);
		
		total_TextField.setBounds(585, 390, 86, 20);
		customer_Order_Page_Frame.getContentPane().add(total_TextField);
		total_TextField.setColumns(10);
		total_TextField.setEditable(false);
		
		// payment label, text field
		JLabel payment_Label = new JLabel("Payment  : ");
		payment_Label.setBounds(519, 415, 100, 14);
		customer_Order_Page_Frame.getContentPane().add(payment_Label);
		
		payment_TextField.setBounds(585, 415, 86, 20);
		customer_Order_Page_Frame.getContentPane().add(payment_TextField);
		payment_TextField.setColumns(10);
		
		// change label, text field
		JLabel change_Label = new JLabel("Change  : ");
		change_Label.setBounds(519, 440, 100, 14);
		customer_Order_Page_Frame.getContentPane().add(change_Label);
		
		change_TextField.setBounds(585, 440, 86, 20);
		customer_Order_Page_Frame.getContentPane().add(change_TextField);
		change_TextField.setColumns(10);
		change_TextField.setEditable(false);
		
		
		// Setting buttons
		orderButton = new JButton("Order");
		orderButton.setBounds(500, 475, 89, 23);
		customer_Order_Page_Frame.getContentPane().add(orderButton);
		backButton = new JButton("Back");
		backButton.setBounds(610, 475, 89, 23);
		customer_Order_Page_Frame.getContentPane().add(backButton);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		add_Fruits(tabbedPane, "Fruits");
		tabbedPane.setBounds(18, 11, 450, 450);
		customer_Order_Page_Frame.getContentPane().add(tabbedPane);
		customer_Order_Page_Frame.setVisible(true);
		
		//edit
		backButton.setFont(new Font("Lato", Font.PLAIN, 13));
		orderButton.setFont(new Font("Lato", Font.PLAIN, 13));
		backButton.setFocusable(false);
		orderButton.setFocusable(false);
		
		lblFoodOrdered.setFont(new Font("Lato", Font.PLAIN, 13));
		
		subtotal_label.setFont(new Font("Lato", Font.PLAIN, 13));
		discount_Label.setFont(new Font("Lato", Font.PLAIN, 13));
		total_label.setFont(new Font("Lato", Font.PLAIN, 13));
		payment_Label.setFont(new Font("Lato", Font.PLAIN, 13));
		change_Label.setFont(new Font("Lato", Font.PLAIN, 13));
		
		Image image = ImageIO.read(this.getClass().getResource("/front_logo.png"));
		customer_Order_Page_Frame.setIconImage(image);
		//edit-end

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create_Customer_Front_Page();
				customer_Order_Page_Frame.dispose();
			}
		});

		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				add_To_Cart();
				if(customer_Cart.isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "You not ordered anything yet");
				} else if(Double.parseDouble(subtotal_TextField.getText()) > Double.parseDouble(payment_TextField.getText())) {
					JOptionPane.showMessageDialog(null, "Insufficient payment");
				} else if (customer_Cart.isEmpty() == true && Double.parseDouble(change_TextField.getText()) < 0) {
					JOptionPane.showMessageDialog(null, "Transaction error");
				}
				else {
					try {
						
				    	receipt_Subtotal = subtotal_TextField.getText();
				    	receipt_Discount = discount_TextField.getText();
				    	receipt_Total = total_TextField.getText();	
				    	receipt_Payment = payment_TextField.getText();
				    	receipt_Change = change_TextField.getText();
				    	
						customer_Order_Page_Frame.setVisible(false);
						create_Customer_Order_Form();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
	}

	void add_Fruits(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints(); // getting constraints for the specified
		// component
		gbc.insets = new Insets(10, 0, 0, 0);
		fruitImage = new JLabel[FRUIT_ELEMETS];
		fruitLabel = new JLabel[FRUIT_ELEMETS];
//		numSpinnerFruits = new JSpinner[FRUIT_ELEMETS];
		fruitFile = new String[FRUIT_ELEMETS];
		fruitPrice = new Double[FRUIT_ELEMETS];

		fruitFile[0] = new String("/banana.png");
		fruitFile[1] = new String("/dragon_fruit.png");
		fruitFile[2] = new String("/grapes.png");
		fruitFile[3] = new String("/green_apple.png");
		fruitFile[4] = new String("/mango.png");
		fruitFile[5] = new String("/orange.png");
		fruitFile[6] = new String("/rambutan.png");
		fruitFile[7] = new String("/red_apple.png");
		fruitFile[8] = new String("/strawberry.png");

		fruitLabel[0] = new JLabel("Banana 1kg");
		fruitLabel[1] = new JLabel("Dragon Fruit");
		fruitLabel[2] = new JLabel("Grapes 1kg");
		fruitLabel[3] = new JLabel("Green Apple");
		fruitLabel[4] = new JLabel("Mango");
		fruitLabel[5] = new JLabel("Orange");
		fruitLabel[6] = new JLabel("Rambutan 1kg");
		fruitLabel[7] = new JLabel("Red Apple");
		fruitLabel[8] = new JLabel("Strawberry 250g");
		fruitPrice[0] = 75.0;
		fruitPrice[1] = 158.0;
		fruitPrice[2] = 400.0;
		fruitPrice[3] = 39.0;
		fruitPrice[4] = 180.0;
		fruitPrice[5] = 47.00;
		fruitPrice[6] = 100.0;
		fruitPrice[7] = 89.50;
		fruitPrice[8] = 235.50;

		// customize
		for(int i = 0; i < fruitLabel.length; i++) {
			fruitLabel[i].setFont(new Font("Lato", Font.PLAIN, 14));
		}



		for (int i = 0; i < FRUIT_ELEMETS; i++) {

			System.out.print(fruitFile[i]);	
			try {

				Image image = ImageIO.read(this.getClass().getResource(fruitFile[i]));
				Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(imageScaled);		
				fruitImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		
		// My for-loop for setting spinner
		for(int i = 0; i < FRUIT_ELEMETS; i++) {	
			spnummodel = new SpinnerNumberModel(0, 0, fruitQty[i], 1);
			numSpinnerFruits[i] = new JSpinner(spnummodel);
			numSpinnerFruits[i].addChangeListener(listener);
		}
		

		gbc.gridx = 0; // gridx 0 represent the most left
		for (int i = 0; i < FRUIT_ELEMETS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(fruitImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(fruitLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinnerFruits[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
		}
	}

// (EDIT)COMPUTE FRUITS (FOOD), all about JTable
	ChangeListener listener = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			
			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Banana 1kg")) {
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(f1 * quantity, row, 2);
						fruit1 = f1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Dragon Fruit")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f2 * quantity, row, 2);
						fruit2 = f2 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Grapes 1kg")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f3 * quantity, row, 2);
						fruit3 = f3 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Green Apple")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f4 * quantity, row, 2);
						fruit4 = f4 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Mango")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f5 * quantity, row, 2);
						fruit5 = f5 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Orange")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f6 * quantity, row, 2);
						fruit6 = f6 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Rambutan 1kg")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f7 * quantity, row, 2);
						fruit7 = f7 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Red Apple")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f8 * quantity, row, 2);
						fruit8 = f8 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Strawberry 250g")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f9 * quantity, row, 2);
						fruit9 = f9 * quantity;
						
					}
					if (quantity == 0) {
						dtm.removeRow(row);
					}
// total of all items selected fruits, vegetable, meat (this doesnt add row)
					
					// Computation (Payment)
					// ubtotal text field
					totalForFruits = fruit1 + fruit2 + fruit3 + fruit4 + fruit5 + fruit6 + fruit7 + fruit8 + fruit9;
					total = totalForFruits;
					subtotal_TextField.setText(total + "");
					
					// discount text field
					if(Double.parseDouble(subtotal_TextField.getText()) >= 500 && Double.parseDouble(subtotal_TextField.getText()) < 1000) {
						discount = "10%";
						discount_TextField.setText(discount + "");
						totalv2 = Double.parseDouble(subtotal_TextField.getText()) - (Double.parseDouble(subtotal_TextField.getText()) * 0.10);
						total_TextField.setText(totalv2 + "");
					}
					else if(Double.parseDouble(subtotal_TextField.getText()) >= 1000) {
						discount = "15%";
						discount_TextField.setText(discount + "");
						totalv2 = Double.parseDouble(subtotal_TextField.getText()) - (Double.parseDouble(subtotal_TextField.getText()) * 0.15);
						total_TextField.setText(totalv2 + "");
					}
					else {
						discount_TextField.setText(discount + "");
						totalv2 = Double.parseDouble(subtotal_TextField.getText());
						total_TextField.setText(totalv2 + "");
					}
					
					// change text field
			        payment_TextField.getDocument().addDocumentListener(new DocumentListener() {

			            @Override
			            public void insertUpdate(DocumentEvent de) {
			            	
			            	if(Double.parseDouble(payment_TextField.getText()) >= Double.parseDouble(subtotal_TextField.getText())) {
			            		change = Double.parseDouble(payment_TextField.getText()) - Double.parseDouble(subtotal_TextField.getText());
								change_TextField.setText(String.valueOf(change) + "");
			            	}
			            	else if(Double.parseDouble(payment_TextField.getText()) < Double.parseDouble(subtotal_TextField.getText())) {
			            		change = Double.parseDouble(payment_TextField.getText()) - Double.parseDouble(subtotal_TextField.getText());
								change_TextField.setText(String.valueOf(change) + "");
			            	}

			            }

			            @Override
			            public void removeUpdate(DocumentEvent de) {
			            	change_TextField.setText(payment_TextField.getText());
			            }

			            @Override
			            public void changedUpdate(DocumentEvent de) {
			            //Plain text components don't fire these events.
			            }
			        });
			        
			    	
					return;
				}
			}
// (EDIT) for prices * QTY
			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < FRUIT_ELEMETS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerFruits[i] == e.getSource()) {
					totalPrice = fruitPrice[i];
					switch (fruitLabel[i].getText()) {
					case "Banana 1kg":
						f1 = 75.0;
						fruit1 = f1;
						break;
					case "Dragon Fruit":
						f2 = 158.0;
						fruit2 = f2;
						break;
					case "Grapes 1kg":
						f3 = 400.0;
						fruit3 = f3;
						break;
					case "Green Apple":
						f4 = 39.0;
						fruit4 = f4;
						break;
					case "Mango":
						f5 = 180.0;
						fruit5 = f5;
						break;
					case "Orange":
						f6 = 47.00;
						fruit6 = f6;
						break;
					case "Rambutan 1kg":
						f7 = 100.0;
						fruit7 = f7;
						break;
					case "Red Apple":
						f8 = 89.50;
						fruit8 = f8;
						break;
					case "Strawberry 250g":
						f9 = 235.50;
						fruit9 = f9;
						break;
					}
					totalForFruits = fruit1 + fruit2 + fruit3 + fruit4 + fruit5 + fruit6 + fruit7 + fruit8 + fruit9;
					total = totalForFruits;
					subtotal_TextField.setText(total + "");
					dtm.addRow(new Object[] { fruitLabel[i].getText(), quantity, totalPrice, numSpinnerFruits[i] }); // add row for item, qty, total price in JTable
					return;
				}

			}
		}
	};
	
	// This method creates the frame for Customer Order Form
	public void create_Customer_Order_Form() throws IOException {
		
		// Setting frame
		final JFrame frame = new JFrame("Order Form");
		frame.setBounds(100, 100, 420, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		// Setting labels , text fields
		JLabel lblFillInDetails = new JLabel("Fill in Details");
		lblFillInDetails.setBounds(120, 11, 131, 26);
		lblFillInDetails.setFont(new Font("Serif", Font.PLAIN, 16));
		lblFillInDetails.setForeground(Color.BLUE);
		frame.getContentPane().add(lblFillInDetails);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 46, 46, 14);
		frame.getContentPane().add(lblName);

		subtotal_TextField = new JTextField();
		subtotal_TextField.setBounds(82, 43, 176, 20);
		frame.getContentPane().add(subtotal_TextField);
		subtotal_TextField.setColumns(10);

		JLabel lblAddress = new JLabel("Tel No");
		lblAddress.setBounds(10, 92, 46, 14);
		frame.getContentPane().add(lblAddress);

		final JTextField textField_1 = new JTextField();
		textField_1.setBounds(82, 89, 176, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setBounds(10, 137, 62, 14);
		frame.getContentPane().add(lblAddress_1);

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		final JTextArea textArea = new JTextArea();
		
		textArea.setBounds(82, 132, 236, 85);
		textArea.setMargin(new Insets(10,10,10,10));
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		frame.getContentPane().add(textArea);

		// Setting buttons
		JButton btnCancel = new JButton("Cancel ");
		btnCancel.setBounds(130, 228, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					subtotal_TextField.setText("");
					payment_TextField.setText("");
					discount_TextField.setText("");
					
					Customer cus = new Customer();
					cus.create_Customer_Order_Page();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(229, 228, 89, 23);
		frame.getContentPane().add(btnConfirm);

		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (subtotal_TextField.getText().equals("") || textField_1.getText().equals("")
						|| textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field cannot be empty");
				} else {
					
					//customer Cart is working
					System.out.println("\n" + customer_Cart);
					
					// Iterates through the HashMap to reduce the quantity of an item
					for (Map.Entry<String, Integer> entry : customer_Cart.entrySet()) {
					    String key = entry.getKey();
					    Object value = entry.getValue();
					    
					    switch(key) {
					    case "Banana 1kg":
					    	fruitQty[0] -= (int) value;
					    	break;
					    case "Dragon Fruit":
					    	fruitQty[1] -= (int) value;
					    	break;
					    case "Grapes 1kg":
					    	fruitQty[2] -= (int) value;
					    	break;
					    case "Green Apple":
					    	fruitQty[3] -= (int) value;
					    	break;
					    case "Mango":
					    	fruitQty[4] -= (int) value;
					    	break;
					    case "Orange":
					    	fruitQty[5] -= (int) value;
					    	break;
					    case "Rambutan 1kg":
					    	fruitQty[6] -= (int) value;
					    	break;
					    case "Red Apple":
					    	fruitQty[7] -= (int) value;
					    	break;
					    case "Strawberry 250g":
					    	fruitQty[8] -= (int) value;
					    	break;
					  }
					}
					
					// method receipt put here
					Receipt receipt = new Receipt();
					receipt.show_Receipt();
							
					// Update methods
					updateSpinners();
					dtm.setRowCount(1);
					try {
						remove_Bought_Items();
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					customer_Cart.clear();
					
					JOptionPane.showMessageDialog(null, "Your foods will be delivered soon, thanks for ordering.\n");
					frame.dispose();
				}
			}
		});
		Image image = ImageIO.read(this.getClass().getResource("/order_logo.png"));
		Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(imageScaled);
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(268, 19, 126, 90);
		frame.getContentPane().add(lblNewLabel);
		
		// Label setting
		lblFillInDetails.setFont(new Font("Lato", Font.PLAIN, 16));
		lblName.setFont(new Font("Lato", Font.PLAIN, 14));
		lblAddress.setFont(new Font("Lato", Font.PLAIN, 14));
		lblAddress_1.setFont(new Font("Lato", Font.PLAIN, 14));
		btnConfirm.setFont(new Font("Lato", Font.PLAIN, 14));
		btnCancel.setFont(new Font("Lato", Font.PLAIN, 14));
		
		frame.setVisible(true);

	}
	
	// add items to a HashMap
	public void add_To_Cart() {
		
		for(int i = 0; i < FRUIT_ELEMETS; i++) {
			int quantity = (int) numSpinnerFruits[i].getValue();
			
			if(fruitLabel[i].getText() == "Banana 1kg") {
				if(quantity > 0) {
					customer_Cart.put("Banana 1kg", (Integer) numSpinnerFruits[0].getValue());
				}
			} 
			if(fruitLabel[i].getText() == "Dragon Fruit") {
				if(quantity > 0) {
					customer_Cart.put("Dragon Fruit", (Integer) numSpinnerFruits[1].getValue());
				}
			} 
			if(fruitLabel[i].getText() == "Grapes 1kg") {
				if(quantity > 0) {
					customer_Cart.put("Grapes 1kg", (Integer) numSpinnerFruits[2].getValue());
				}
			} 
			if(fruitLabel[i].getText() == "Green Apple") {
				if(quantity > 0) {
					customer_Cart.put("Green Apple", (Integer) numSpinnerFruits[3].getValue());
				}
			} 
			if(fruitLabel[i].getText() == "Mango") {
				if(quantity > 0) {
					customer_Cart.put("Mango", (Integer) numSpinnerFruits[4].getValue());
				}
			} 
			if(fruitLabel[i].getText() == "Orange") {
				if(quantity > 0) {
					customer_Cart.put("Orange", (Integer) numSpinnerFruits[5].getValue());
				}
			} 
			if(fruitLabel[i].getText() == "Rambutan 1kg") {
				if(quantity > 0) {
					customer_Cart.put("Rambutan 1kg", (Integer) numSpinnerFruits[6].getValue());
				}
			} 
			if(fruitLabel[i].getText() == "Red Apple") {
				if(quantity > 0) {
					customer_Cart.put("Red Apple", (Integer) numSpinnerFruits[7].getValue());
				}
			} 
			if(fruitLabel[i].getText() == "Strawberry 250g") {
				if(quantity > 0) {
					customer_Cart.put("Strawberry 250g", (Integer) numSpinnerFruits[8].getValue());
				}
			}
		}
	}
	
	// Updates maximum value of spinners base on quantity of item
	public void updateSpinners() {
		for(int i = 0; i < FRUIT_ELEMETS; i++) {
			SpinnerNumberModel newModel = new SpinnerNumberModel();
			newModel.setMaximum(fruitQty[i]);
			newModel.setMinimum(0);
			newModel.setStepSize(1);
			newModel.setValue(0);
			numSpinnerFruits[i].setModel(newModel);
		}
	}
	
	
	public static class Receipt extends JPanel{

	    JTable jt;
	    public Receipt() {

			
			// Setting table
			JTable table = new JTable();
			
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			
			table.setShowGrid(false);
			
			String[] header = {"Item Ordered", "Quantity", "Price"};
			dtm.setColumnIdentifiers(header);
			int a = 0;
			
			Double receipt_Fruit_Total[] = new Double[customer_Cart.size()];
			
			for(Map.Entry<String,Integer> entry: customer_Cart.entrySet()){

				if(entry.getKey() == "Banana 1kg") {
					receipt_Fruit_Total[a] = (entry.getValue() * 75.0);
				}
				else if (entry.getKey() == "Dragon Fruit") {
					receipt_Fruit_Total[a] = (entry.getValue() * 158.0);
				}
				else if (entry.getKey() == "Grapes 1kg") {
					receipt_Fruit_Total[a] = (entry.getValue() * 400.0);
				}
				else if (entry.getKey() == "Green Apple") {
					receipt_Fruit_Total[a] = (entry.getValue() * 39.0);
				}
				else if (entry.getKey() == "Mango") {
					receipt_Fruit_Total[a] = (entry.getValue() * 180.0);
				}
				else if (entry.getKey() == "Orange") {
					receipt_Fruit_Total[a] = (entry.getValue() * 47.00);
				}
				else if (entry.getKey() == "Rambutan 1kg") {
					receipt_Fruit_Total[a] = (entry.getValue() * 100.0);
				}
				else if (entry.getKey() == "Red Apple") {
					receipt_Fruit_Total[a] = (entry.getValue() * 89.50);
				}
				else if (entry.getKey() == "Strawberry 250g") {
					receipt_Fruit_Total[a] = (entry.getValue() * 235.50);
				}
				
				dtm.addRow(new Object[]{entry.getKey(), entry.getValue(), receipt_Fruit_Total[a]});
				a++;
				
			}

			 dtm.addRow(new Object[]{" ", " "});
			 
			 dtm.addRow(new Object[] {"SUBTOTAL: ",receipt_Subtotal});
			 dtm.addRow(new Object[] {"DISCOUNT: ",receipt_Discount});
			 dtm.addRow(new Object[] {"TOTAL: ",receipt_Total});
			 dtm.addRow(new Object[] {"PAYMENT: ",receipt_Payment});
			 dtm.addRow(new Object[] {"CHANGE: ",receipt_Change});
			 dtm.addRow(new Object[] {" "," "});
			 dtm.addRow(new Object[] {"THANK YOU","FOR", "ORDERING!!"});
			 
	        table.setPreferredScrollableViewportSize(new Dimension(500,400));
	        table.setFillsViewportHeight(true);

	        JScrollPane js=new JScrollPane(table);
	        js.setVisible(true);
	        add(js);
	    }

	    public void show_Receipt() {

	        final JFrame frame_Receipt=new JFrame();
	        
	        // Setting table
	        Receipt table_inventory= new Receipt();
	        
	        // Setting frame
	        frame_Receipt.setTitle("Receipt");
	        frame_Receipt.setSize(500, 500);
	        frame_Receipt.setResizable(false);
	        frame_Receipt.setVisible(true);
	        frame_Receipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame_Receipt.setLayout(new BorderLayout());
	        
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
					frame_Receipt.dispose();
					try {
						Customer customer = new Customer();
						customer.create_Customer_Order_Page();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			// Customize button
			back_Button.setFont(new Font("Lato", Font.PLAIN, 15));
	        
	        // Add components
	        panel1.add(table_inventory);
	        panel2.add(back_Button);
	        frame_Receipt.add(panel1, BorderLayout.NORTH);
	        frame_Receipt.add(panel2, BorderLayout.SOUTH);
	        
	        // End methods
	        frame_Receipt.setLocationRelativeTo(null);
	        frame_Receipt.pack();
	    }

	}
	
	
	
	public void copy_Items_Bought() {
		
	}

	// Getters & Setters
	public static int[] getFruitQty() {
		return fruitQty;
	}

	public static void setFruitQty(int[] fruitQty) {
		Customer.fruitQty = fruitQty;
	}

	public static HashMap<String, Integer> getCustomer_Cart() {
		return customer_Cart;
	}

	public static void setCustomer_Cart(HashMap<String, Integer> customer_Cart) {
		Customer.customer_Cart = customer_Cart;
	}
	
}
