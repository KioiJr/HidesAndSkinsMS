package com.stingray.hidesandskins;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField employeeid;
	private JTextField txtfirstname;
	private JTextField txtsecname;
	private JTextField user_name;
	private JTable userdetailtable;
	private JPasswordField userPassword;
	private JTable customerstable;
	private JTable supplierstable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Homepage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/leather-16.png")));
		setTitle("H&SMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1361, 765);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(246, 0, 1110, 736);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel dashboard = new JPanel();
		dashboard.setBackground(Color.GRAY);
		layeredPane.add(dashboard, "name_12753301345700");
		dashboard.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(0, 0, 1086, 35);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dashboard.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(28, 46, 317, 122);
		dashboard.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/suppliers.png")));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBorder(null);
		lblNewLabel_8.setBounds(0, 0, 89, 122);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("SUPPLIERS");
		lblNewLabel_9.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(88, 11, 229, 26);
		panel.add(lblNewLabel_9);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(98, 48, 209, 63);
		panel.add(textField_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(378, 46, 317, 122);
		dashboard.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/customer-grp.png")));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setBorder(null);
		lblNewLabel_8_1.setBounds(0, 0, 89, 122);
		panel_1.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("CUSTOMERS");
		lblNewLabel_9_1.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setBounds(88, 11, 229, 26);
		panel_1.add(lblNewLabel_9_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(98, 48, 209, 63);
		panel_1.add(textField_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(729, 46, 317, 122);
		dashboard.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8_2 = new JLabel("");
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/towns.png")));
		lblNewLabel_8_2.setBorder(null);
		lblNewLabel_8_2.setBounds(0, 0, 89, 122);
		panel_2.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_9_2 = new JLabel("TOWNS");
		lblNewLabel_9_2.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2.setBounds(88, 11, 229, 26);
		panel_2.add(lblNewLabel_9_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(98, 48, 209, 63);
		panel_2.add(textField_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(28, 227, 317, 122);
		dashboard.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8_3 = new JLabel("");
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/purchases.png")));
		lblNewLabel_8_3.setBorder(null);
		lblNewLabel_8_3.setBounds(0, 0, 89, 122);
		panel_3.add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_9_3 = new JLabel("PURCHASES");
		lblNewLabel_9_3.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3.setBounds(88, 11, 229, 26);
		panel_3.add(lblNewLabel_9_3);
		
		textField = new JTextField();
		textField.setBounds(98, 48, 209, 63);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(378, 227, 317, 122);
		dashboard.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8_5 = new JLabel("");
		lblNewLabel_8_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_5.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/total sales.png")));
		lblNewLabel_8_5.setBorder(null);
		lblNewLabel_8_5.setBounds(0, 0, 89, 122);
		panel_4.add(lblNewLabel_8_5);
		
		JLabel lblNewLabel_9_4 = new JLabel("SALES");
		lblNewLabel_9_4.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNewLabel_9_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_4.setBounds(88, 11, 229, 26);
		panel_4.add(lblNewLabel_9_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 48, 209, 63);
		panel_4.add(textField_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(729, 227, 317, 122);
		dashboard.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_8_4 = new JLabel("");
		lblNewLabel_8_4.setBorder(null);
		lblNewLabel_8_4.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/icons8-stack-96.png")));
		lblNewLabel_8_4.setBounds(0, 0, 88, 122);
		panel_5.add(lblNewLabel_8_4);
		
		JLabel lblNewLabel_9_5 = new JLabel("TOTAL STOCK");
		lblNewLabel_9_5.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		lblNewLabel_9_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_5.setBounds(87, 11, 230, 26);
		panel_5.add(lblNewLabel_9_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(98, 48, 209, 63);
		panel_5.add(textField_2);
		
		JPanel suppliers = new JPanel();
		suppliers.setBackground(Color.GRAY);
		layeredPane.add(suppliers, "name_88338829423200");
		suppliers.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Suppliers");
		lblNewLabel_1.setBounds(0, 11, 1086, 25);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		suppliers.add(lblNewLabel_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.windowBorder);
		panel_10.setBounds(10, 47, 1076, 98);
		suppliers.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("Select supplier to edit");
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(0, 11, 1090, 27);
		panel_10.add(lblNewLabel_15);
		
		JComboBox<String> town1 = new JComboBox();
		town1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		town1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		town1.setForeground(Color.WHITE);
		town1.setBackground(Color.GRAY);
		town1.setModel(new DefaultComboBoxModel(new String[] {"--Select area--"}));
		town1.setBounds(10, 49, 226, 27);
		panel_10.add(town1);
		
		JComboBox selectproduct = new JComboBox();
		selectproduct.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		selectproduct.setForeground(Color.WHITE);
		selectproduct.setBackground(Color.GRAY);
		selectproduct.setModel(new DefaultComboBoxModel(new String[] {"--Select product--", "Hides", "Skins(goat/sheep)"}));
		selectproduct.setBounds(533, 49, 246, 27);
		panel_10.add(selectproduct);
		
		JButton gettowns = new JButton("Get Towns");
		gettowns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3308/hidesandskins", "joshua","JoshuA13!");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select town from suppliers");
					while(rs.next()) {
						String town = rs.getString("town");
						town1.addItem(town);					}
					
				} catch (Exception  e3) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e3);
				}
				
			}
		});
		gettowns.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		gettowns.setBounds(285, 49, 116, 27);
		panel_10.add(gettowns);
		
		JButton displaydata = new JButton("Display Suppliers");
		displaydata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hidesandskins", "joshua","JoshuA13!");
					String sql2 = "select Town, Product, First_name,Second_name,Occupation from suppliers WHERE town = '"+town1.getSelectedItem()+"' AND product = '"+selectproduct.getSelectedItem()+"'";
//					PreparedStatement st = (PreparedStatement) con.prepareStatement(sql2);
					Statement st = con.prepareStatement(sql2);
					ResultSet rs  = st.executeQuery(sql2);
						while(rs.next()) {
							supplierstable.add(town1,selectproduct);
							
						}
						supplierstable.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
			}
		});
		displaydata.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		displaydata.setBounds(831, 49, 144, 27);
		panel_10.add(displaydata);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.DARK_GRAY);
		panel_11.setBounds(10, 156, 1076, 557);
		suppliers.add(panel_11);
		panel_11.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 623, 444);
		panel_11.add(scrollPane);
		
		supplierstable = new JTable();
		supplierstable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Town", "Product", "First name", "Second name", "Occupation"
			}
		));
		supplierstable.getColumnModel().getColumn(0).setPreferredWidth(115);
		supplierstable.getColumnModel().getColumn(1).setPreferredWidth(115);
		supplierstable.getColumnModel().getColumn(2).setPreferredWidth(115);
		supplierstable.getColumnModel().getColumn(3).setPreferredWidth(115);
		supplierstable.getColumnModel().getColumn(4).setPreferredWidth(118);
		supplierstable.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		scrollPane.setViewportView(supplierstable);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.DARK_GRAY);
		panel_9.setBounds(10, 466, 623, 63);
		panel_11.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnAddNewUser_1 = new JButton("Add new supplier");
		btnAddNewUser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddNewSupplier ans = new AddNewSupplier();
				ans.setVisible(true);
				}
		});
		btnAddNewUser_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnAddNewUser_1.setBounds(460, 25, 136, 27);
		panel_9.add(btnAddNewUser_1);
		
		JButton btnPrintList = new JButton("Print list");
		btnPrintList.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnPrintList.setBounds(254, 25, 129, 27);
		panel_9.add(btnPrintList);
		
		JButton btnRemoveSupplier = new JButton("Remove Supplier");
		btnRemoveSupplier.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnRemoveSupplier.setBounds(32, 25, 136, 27);
		panel_9.add(btnRemoveSupplier);
		
		JPanel customers = new JPanel();
		customers.setBackground(Color.GRAY);
		layeredPane.add(customers, "name_182326840129200");
		customers.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Customers");
		lblNewLabel_2.setBounds(0, 11, 1086, 31);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		customers.add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.GRAY);
		panel_7.setBounds(10, 55, 617, 595);
		customers.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 597, 487);
		panel_7.add(scrollPane_1);
		
		customerstable = new JTable();
		scrollPane_1.setViewportView(customerstable);
		customerstable.setBorder(new LineBorder(new Color(0, 0, 0)));
		customerstable.setFillsViewportHeight(true);
		customerstable.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		customerstable.setBackground(Color.LIGHT_GRAY);
		customerstable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Name", "Company", "Product", "Money owed(KSHS)", "Last purchase amt", "Purchase date"
			}
		));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(10, 509, 597, 86);
		panel_7.add(panel_15);
		panel_15.setLayout(null);
		
		JButton updatecustomers = new JButton("Update Skins Customers");
		updatecustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateCustomerSkins ucs = new UpdateCustomerSkins();
				ucs.setVisible(true);			}
		});
		updatecustomers.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		updatecustomers.setBounds(204, 11, 184, 27);
		panel_15.add(updatecustomers);
		
		JButton btnUpdateHidesCustomers = new JButton("Update Hides Customers");
		btnUpdateHidesCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateCustomerHides uch = new UpdateCustomerHides();
				uch.setVisible(true);
			}
		});
		btnUpdateHidesCustomers.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		btnUpdateHidesCustomers.setBounds(403, 11, 184, 27);
		panel_15.add(btnUpdateHidesCustomers);
		
		JButton addCustomerSkins = new JButton("Add New Customer");
		addCustomerSkins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewCustomer cstmskins = new AddNewCustomer();
				cstmskins.setVisible(true);
				
			}
		});
		addCustomerSkins.setToolTipText("Add a new buyer for your skins.");
		addCustomerSkins.setBounds(10, 12, 184, 27);
		panel_15.add(addCustomerSkins);
		customerstable.getColumnModel().getColumn(3).setPreferredWidth(105);
		customerstable.getColumnModel().getColumn(4).setPreferredWidth(98);
		customerstable.getColumnModel().getColumn(5).setPreferredWidth(80);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(637, 55, 447, 595);
		customers.add(panel_8);
		panel_8.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 427, 573);
		panel_8.add(textArea);
		
		JPanel getrecords = new JPanel();
		layeredPane.add(getrecords, "name_182995402370600");
		getrecords.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Get Records");
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 11, 1086, 27);
		getrecords.add(lblNewLabel_4);
		
		JPanel settings = new JPanel();
		layeredPane.add(settings, "name_183089644331900");
		settings.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Settings");
		lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 11, 1086, 27);
		settings.add(lblNewLabel_5);
		
		JPanel addnewuser = new JPanel();
		addnewuser.setBackground(Color.GRAY);
		layeredPane.add(addnewuser, "name_8216435296899");
		addnewuser.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Add new user");
		lblNewLabel_10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(0, 11, 1100, 27);
		addnewuser.add(lblNewLabel_10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(43, 53, 68)), "New user details", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
		panel_12.setBackground(Color.DARK_GRAY);
		panel_12.setBounds(10, 49, 437, 524);
		addnewuser.add(panel_12);
		panel_12.setLayout(null);
		
		JComboBox employeepost = new JComboBox();
		employeepost.setBounds(166, 42, 186, 27);
		employeepost.setModel(new DefaultComboBoxModel(new String[] {"--Select new user position--", "Admin", "User"}));
		employeepost.setBackground(Color.GRAY);
		employeepost.setForeground(Color.WHITE);
		panel_12.add(employeepost);
		employeepost.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel_16_5 = new JLabel("Start date:");
		lblNewLabel_16_5.setBounds(10, 399, 186, 27);
		lblNewLabel_16_5.setForeground(Color.WHITE);
		panel_12.add(lblNewLabel_16_5);
		lblNewLabel_16_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		JDateChooser Userstartdate = new JDateChooser();
		Userstartdate.setDateFormatString("YYYY-MM-dd");
		Userstartdate.setBounds(241, 398, 186, 27);
		panel_12.add(Userstartdate);
		
		JLabel lblNewLabel_16_4 = new JLabel("Password:");
		lblNewLabel_16_4.setBounds(10, 340, 186, 27);
		lblNewLabel_16_4.setForeground(Color.WHITE);
		panel_12.add(lblNewLabel_16_4);
		lblNewLabel_16_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16_4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel_16_3 = new JLabel("Username:");
		lblNewLabel_16_3.setBounds(10, 274, 186, 27);
		lblNewLabel_16_3.setForeground(Color.WHITE);
		panel_12.add(lblNewLabel_16_3);
		lblNewLabel_16_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		user_name = new JTextField();
		user_name.setBounds(241, 277, 186, 27);
		user_name.setHorizontalAlignment(SwingConstants.CENTER);
		user_name.setBackground(Color.WHITE);
		user_name.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		panel_12.add(user_name);
		user_name.setColumns(10);
		
		txtsecname = new JTextField();
		txtsecname.setBounds(241, 214, 186, 27);
		txtsecname.setHorizontalAlignment(SwingConstants.CENTER);
		txtsecname.setBackground(Color.WHITE);
		txtsecname.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		panel_12.add(txtsecname);
		txtsecname.setColumns(10);
		
		JLabel lblNewLabel_16_2 = new JLabel("Second name:");
		lblNewLabel_16_2.setBounds(10, 211, 186, 27);
		lblNewLabel_16_2.setForeground(Color.WHITE);
		panel_12.add(lblNewLabel_16_2);
		lblNewLabel_16_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel_16_1 = new JLabel("First Name:");
		lblNewLabel_16_1.setBounds(10, 143, 186, 27);
		lblNewLabel_16_1.setForeground(Color.WHITE);
		panel_12.add(lblNewLabel_16_1);
		lblNewLabel_16_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel_16 = new JLabel("Employee ID:");
		lblNewLabel_16.setBounds(10, 80, 186, 27);
		lblNewLabel_16.setForeground(Color.WHITE);
		panel_12.add(lblNewLabel_16);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(241, 143, 186, 27);
		txtfirstname.setHorizontalAlignment(SwingConstants.CENTER);
		txtfirstname.setBackground(Color.WHITE);
		txtfirstname.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		panel_12.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		employeeid = new JTextField();
		employeeid.setBounds(241, 80, 186, 27);
		employeeid.setHorizontalAlignment(SwingConstants.CENTER);
		employeeid.setBackground(Color.WHITE);
		employeeid.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		panel_12.add(employeeid);
		employeeid.setColumns(10);
		
		JButton btnSaveUser = new JButton("Save");
		btnSaveUser.setBounds(52, 470, 144, 27);
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hidesandskins", "joshua","JoshuA13!");
					String query = "insert into users(id,fname,sname,username,password,rank,startdate)"+"values(?,?,?,?,?,?,?)";
					PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
					pstmt.setString(1, employeeid.getText());
					pstmt.setString(2, txtfirstname.getText());
					pstmt.setString(3, txtsecname.getText());
					pstmt.setString(4, user_name.getText());
					pstmt.setString(5, userPassword.getText());
					pstmt.setString(6, employeepost.getSelectedItem().toString());
					pstmt.setString(7, ((JTextField)Userstartdate.getDateEditor().getUiComponent()).getText());
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "User successfully added");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
//					e1.printStackTrace();
				}
				
			}
		
		});
		btnSaveUser.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		panel_12.add(btnSaveUser);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(262, 470, 144, 27);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code to clear all fields
				txtfirstname.setText(null);
				employeeid.setText(null);
				txtfirstname.setText(null);
				txtsecname.setText(null);
				user_name.setText(null);
				userPassword.setText(null);
				Userstartdate.setDate(null);
				employeepost.setSelectedIndex(0);
			}
		});
		btnClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		panel_12.add(btnClear);
		
		userPassword = new JPasswordField();
		userPassword.setBounds(241, 337, 186, 27);
		panel_12.add(userPassword);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.DARK_GRAY);
		panel_13.setBounds(457, 49, 643, 421);
		addnewuser.add(panel_13);
		panel_13.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 623, 170);
		panel_13.add(scrollPane_2);
		
		userdetailtable = new JTable();
		scrollPane_2.setViewportView(userdetailtable);
		userdetailtable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", "", "", "", "", ""},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Employee ID", "First name", "Second name", "Username", "Password", "Position", "Start Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, Object.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		userdetailtable.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		userdetailtable.setBorder(new LineBorder(new Color(0, 0, 0)));
		userdetailtable.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.DARK_GRAY);
		panel_14.setBounds(457, 481, 643, 92);
		addnewuser.add(panel_14);
		panel_14.setLayout(null);
		
		JButton btndelete = new JButton("Delete user");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hidesandskins", "joshua","JoshuA13!");
					
					String query = "delete from users where id = '?'";
					PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
					DefaultTableModel tbl = (DefaultTableModel) userdetailtable.getModel();
//					pstmt.setArray(1, userdetailtable.getSelectedRow());
					if(userdetailtable.getSelectedRowCount() == 1){
						
						
					int opt = JOptionPane.showConfirmDialog(null, "Do you want to delete this user?\nOperation once done cannot be undone");
					if(opt == 0) {
//					tbl.removeRow(userdetailtable.getSelectedRow());
					pstmt.execute();
					}
				}
				}
				catch (Exception e7) {
					JOptionPane.showMessageDialog(null, e7);				}
			}
		});
		btndelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		btndelete.setBounds(461, 31, 144, 27);
		panel_14.add(btndelete);
		
		JButton btnprint = new JButton("Print details");
		btnprint.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		btnprint.setBounds(255, 31, 144, 27);
		panel_14.add(btnprint);
		
		JButton btnShowAllUsers = new JButton("Show all users");
		btnShowAllUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hidesandskins", "joshua","JoshuA13!");
					String sql = "select * from users";
					Statement stmt = con.prepareStatement(sql);
					ResultSet rs  = stmt.executeQuery(sql);
					
					userdetailtable.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch (Exception ex4) {
					JOptionPane.showMessageDialog(null, ex4);
				}
				
			}
		});
		btnShowAllUsers.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		btnShowAllUsers.setBounds(41, 31, 144, 27);
		panel_14.add(btnShowAllUsers);
		
		JButton btndashboard = new JButton("Dashboard");
		btndashboard.setHorizontalAlignment(SwingConstants.LEADING);
		btndashboard.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/icons8-home-24.png")));
		btndashboard.setForeground(new Color(255, 255, 255));
		btndashboard.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btndashboard.setBackground(SystemColor.windowBorder);
		btndashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(dashboard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btndashboard.setBounds(33, 85, 179, 23);
		contentPane.add(btndashboard);
		
		JButton btnSuppliers = new JButton("Suppliers");
		btnSuppliers.setHorizontalAlignment(SwingConstants.LEADING);
		btnSuppliers.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/supplier-24.png")));
		btnSuppliers.setForeground(new Color(255, 255, 255));
		btnSuppliers.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnSuppliers.setBackground(SystemColor.windowBorder);
		btnSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(suppliers);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		btnSuppliers.setBounds(33, 146, 179, 23);
		contentPane.add(btnSuppliers);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setHorizontalAlignment(SwingConstants.LEADING);
		btnCustomers.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/cuustomer1.png")));
		btnCustomers.setForeground(new Color(255, 255, 255));
		btnCustomers.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnCustomers.setBackground(SystemColor.windowBorder);
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(customers);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnCustomers.setBounds(33, 215, 179, 23);
		contentPane.add(btnCustomers);
		
		JButton getrec = new JButton("Get Records");
		getrec.setHorizontalAlignment(SwingConstants.LEADING);
		getrec.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/getrecords.png")));
		getrec.setForeground(new Color(255, 255, 255));
		getrec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(getrecords);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		getrec.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		getrec.setBackground(SystemColor.windowBorder);
		getrec.setBounds(33, 290, 179, 23);
		contentPane.add(getrec);
		
		JButton sett = new JButton("Settings");
		sett.setHorizontalAlignment(SwingConstants.LEADING);
		sett.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/settings.png")));
		sett.setForeground(new Color(255, 255, 255));
		sett.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(settings);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		sett.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		sett.setBackground(SystemColor.windowBorder);
		sett.setBounds(33, 440, 179, 23);
		contentPane.add(sett);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setHorizontalAlignment(SwingConstants.LEADING);
		btnLogout.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/power.png")));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(SystemColor.windowBorder);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to Log out?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					Homepage.this.dispose();
					Login login = new Login();
					login.setVisible(true);
				}
			}
		});
		btnLogout.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnLogout.setBounds(33, 507, 179, 23);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel_6 = new JLabel("HIDES AND SKINS MANAGEMENT SYSTEM");
		lblNewLabel_6.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_6.setForeground(new Color(255, 255, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 47, 246, 23);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/icons8-leather-32.png")));
		lblNewLabel_7.setBounds(98, 11, 38, 39);
		contentPane.add(lblNewLabel_7);
		
		JButton btnAddNewUser = new JButton("Add new user");
		btnAddNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(addnewuser);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		btnAddNewUser.setIcon(new ImageIcon(Homepage.class.getResource("/com/stingray/hidesandskins/Assests/add user.png")));
		btnAddNewUser.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddNewUser.setForeground(Color.WHITE);
		btnAddNewUser.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		btnAddNewUser.setBackground(SystemColor.desktop);
		btnAddNewUser.setBounds(33, 366, 179, 23);
		contentPane.add(btnAddNewUser);
		
		//set display location to centre
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}
