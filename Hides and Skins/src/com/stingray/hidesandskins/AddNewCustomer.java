package com.stingray.hidesandskins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddNewCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField nationalID;
	private JTextField customerFullName;
	private JTextField customerPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewCustomer frame = new AddNewCustomer();
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
	public AddNewCustomer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewCustomer.class.getResource("/com/stingray/hidesandskins/Assests/icons8-leather-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 357);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(43, 53, 68)), "ADD NEW SKINS BUYER", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 200, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("National ID:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 36, 130, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 77, 130, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(10, 124, 130, 23);
		contentPane.add(lblPhoneNumber);
		
		nationalID = new JTextField();
		nationalID.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		nationalID.setBounds(162, 36, 180, 23);
		contentPane.add(nationalID);
		nationalID.setColumns(10);
		
		customerFullName = new JTextField();
		customerFullName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		customerFullName.setColumns(10);
		customerFullName.setBounds(162, 78, 180, 23);
		contentPane.add(customerFullName);
		
		customerPhoneNumber = new JTextField();
		customerPhoneNumber.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		customerPhoneNumber.setColumns(10);
		customerPhoneNumber.setBounds(162, 125, 180, 23);
		contentPane.add(customerPhoneNumber);
		
		JLabel lblNewLabel_2 = new JLabel("Start Date:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 214, 130, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Product:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(10, 172, 130, 23);
		contentPane.add(lblNewLabel_2_1);
		
		JComboBox customerProduct = new JComboBox();
		customerProduct.setModel(new DefaultComboBoxModel(new String[] {"--SELECT PRODUCT--", "Hides", "Skins"}));
		customerProduct.setToolTipText("Select product a customer is buying.");
		customerProduct.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		customerProduct.setBounds(162, 173, 180, 23);
		contentPane.add(customerProduct);
		
		JDateChooser csmSkinsStartDate = new JDateChooser();
		csmSkinsStartDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		csmSkinsStartDate.setDateFormatString("YYYY-MM-dd");
		csmSkinsStartDate.setBounds(162, 214, 180, 23);
		contentPane.add(csmSkinsStartDate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(AddNewCustomer.class.getResource("/com/stingray/hidesandskins/Assests/Reset-24.png")));
		btnReset.setSelectedIcon(new ImageIcon(AddNewCustomer.class.getResource("/com/stingray/hidesandskins/Assests/Reset-24.png")));
		btnReset.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnReset.setBounds(55, 280, 117, 27);
		contentPane.add(btnReset);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setIcon(new ImageIcon(AddNewCustomer.class.getResource("/com/stingray/hidesandskins/Assests/save-24.png")));
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
					
					String query = "insert into customers(nationalID,customerName,phoneNumber,product,startDate)"+"values(?,?,?,?,?)";
					PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
					pstmt.setString(1,  nationalID.getText());
					pstmt.setString(2, customerFullName.getText());
					pstmt.setString(3, customerPhoneNumber.getText());
					pstmt.setString(4, (String) customerProduct.getSelectedItem());
					pstmt.setString(5, ((JTextField)csmSkinsStartDate.getDateEditor().getUiComponent()).getText());
					
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "New customer, "+customerFullName.getText()+", has been successfully added.");
					nationalID.setText(null);
					customerFullName.setText(null);
					customerPhoneNumber.setText(null);
					customerProduct.setSelectedItem("-- SELECT PRODUCT--");
					csmSkinsStartDate.setDate(null);
				}
				catch(Exception e2) {
					
					JOptionPane.showInternalMessageDialog(null, e2);
				}
			}
			
		});
		btnSave_1.setBackground(Color.GREEN);
		btnSave_1.setSelectedIcon(new ImageIcon(AddNewCustomer.class.getResource("/com/stingray/hidesandskins/Assests/save-24.png")));
		btnSave_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnSave_1.setBounds(254, 280, 117, 27);
		
//		Central display
		setLocationRelativeTo(null);
		contentPane.add(btnSave_1);
		
		
	}
}
