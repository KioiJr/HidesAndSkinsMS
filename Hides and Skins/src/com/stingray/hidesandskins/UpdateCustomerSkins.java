package com.stingray.hidesandskins;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UpdateCustomerSkins extends JFrame {

	private JPanel contentPane;
	private JTextField pieces;
	private JTextField unitprice;
	private JTextField txttotal;
	private JTextField unitprice1;
	private JTextField pieces1;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomerSkins frame = new UpdateCustomerSkins();
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
	public UpdateCustomerSkins() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 433, 610);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 418, 243);
		panel.setBackground(SystemColor.windowBorder);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UPDATE CUSTOMER DETAILS (SKINS)");
		lblNewLabel_1.setBounds(0, 11, 418, 29);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		JComboBox skinstate = new JComboBox();
		skinstate.setModel(new DefaultComboBoxModel(new String[] {"--Select Skin condition--", "Wet salted", "Wet Unsalted", "Sun Dried"}));
		skinstate.setForeground(SystemColor.activeCaptionText);
		skinstate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		skinstate.setBackground(Color.GRAY);
		skinstate.setBounds(129, 83, 191, 29);
		panel.add(skinstate);
		
		JLabel lblNewLabel = new JLabel("Number of pieces:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 123, 173, 29);
		panel.add(lblNewLabel);
		
		JLabel lblPricePerUnit = new JLabel("Price per unit:");
		lblPricePerUnit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPricePerUnit.setForeground(Color.WHITE);
		lblPricePerUnit.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblPricePerUnit.setBounds(10, 163, 173, 29);
		panel.add(lblPricePerUnit);
		
		JLabel lblDateOfSell = new JLabel("Date of sell:");
		lblDateOfSell.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfSell.setForeground(Color.WHITE);
		lblDateOfSell.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblDateOfSell.setBounds(10, 203, 173, 29);
		panel.add(lblDateOfSell);
		
		pieces = new JTextField();
		pieces.setHorizontalAlignment(SwingConstants.CENTER);
		pieces.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		pieces.setColumns(10);
		pieces.setBounds(231, 123, 173, 29);
		panel.add(pieces);
		
		unitprice = new JTextField();
		unitprice.setHorizontalAlignment(SwingConstants.CENTER);
		unitprice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		unitprice.setColumns(10);
		unitprice.setBounds(231, 163, 173, 29);
		panel.add(unitprice);
		
		JDateChooser selldate = new JDateChooser();
		selldate.setDateFormatString("YYYY-MM-DD");
		selldate.setBounds(231, 203, 173, 29);
		panel.add(selldate);
		
		JComboBox customerName = new JComboBox();
		customerName.setForeground(Color.BLACK);
		customerName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		customerName.setBackground(Color.GRAY);
		customerName.setBounds(129, 43, 191, 29);
		panel.add(customerName);
		
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
			Statement st = con.createStatement();
			ResultSet r=st.executeQuery("select * from customers where product = 'skins'");

			 while (r.next()) {  

			     customerName.addItem(r.getString("customerName"));  
			 } 
			 
			 con.close();
		}
			 catch(Exception e5){
					JOptionPane.showMessageDialog(null, e5);
				}
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.windowBorder);
		panel_1.setBounds(0, 248, 418, 187);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MISCELLANEOUS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(0, 0, 394, 29);
		panel_1.add(lblNewLabel_2);
		
		JComboBox skinstate1 = new JComboBox();
		skinstate1.setModel(new DefaultComboBoxModel(new String[] {"--Select Condition--", "None","Reject", "Double reject", "Undersize"}));
		skinstate1.setMaximumRowCount(12);
		skinstate1.setForeground(SystemColor.activeCaptionText);
		skinstate1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		skinstate1.setBackground(Color.GRAY);
		skinstate1.setBounds(123, 40, 161, 29);
		panel_1.add(skinstate1);
		
		JLabel lblNewLabel_3 = new JLabel("Number of pieces");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(0, 93, 178, 29);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Price per unit:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(0, 133, 178, 29);
		panel_1.add(lblNewLabel_3_1);
		
		unitprice1 = new JTextField();
		unitprice1.setHorizontalAlignment(SwingConstants.CENTER);
		unitprice1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		unitprice1.setColumns(10);
		unitprice1.setBounds(210, 133, 184, 29);
		panel_1.add(unitprice1);
		
		pieces1 = new JTextField();
		pieces1.setHorizontalAlignment(SwingConstants.CENTER);
		pieces1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		pieces1.setColumns(10);
		pieces1.setBounds(210, 93, 184, 29);
		panel_1.add(pieces1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.windowBorder);
		panel_2.setBounds(0, 446, 418, 49);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txttotal = new JTextField();
		txttotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		txttotal.setBounds(214, 11, 179, 27);
		panel_2.add(txttotal);
		txttotal.setHorizontalAlignment(SwingConstants.CENTER);
		txttotal.setFont(new Font("Candara", Font.BOLD, 17));
		txttotal.setColumns(10);
		
		JButton btnTotalAmount = new JButton("CALCULATE");
		btnTotalAmount.setIcon(new ImageIcon(UpdateCustomerSkins.class.getResource("/com/stingray/hidesandskins/Assests/icons8-calculate-20.png")));
		btnTotalAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int subtotal = Integer.parseInt(unitprice.getText()) * Integer.parseInt(pieces.getText());
				
				if(skinstate1.getSelectedItem() == "None") {
					pieces1.setText("0");
					unitprice1.setText("0");
					
					};
					
				int subtotal1 = Integer.parseInt(unitprice1.getText()) * Integer.parseInt(pieces1.getText());
				String total = String.valueOf(subtotal1+subtotal);
				txttotal.setText(total);
			}
		});
		btnTotalAmount.setFont(new Font("Candara", Font.BOLD, 17));
		btnTotalAmount.setBackground(SystemColor.controlHighlight);
		btnTotalAmount.setBounds(10, 11, 171, 29);
		panel_2.add(btnTotalAmount);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.windowBorder);
		panel_3.setBounds(0, 506, 418, 54);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(UpdateCustomerSkins.class.getResource("/com/stingray/hidesandskins/Assests/close-24.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to close this form?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					UpdateCustomerSkins.this.dispose();
				}
			}
		});
		btnCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(288, 11, 120, 29);
		panel_3.add(btnCancel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(UpdateCustomerSkins.class.getResource("/com/stingray/hidesandskins/Assests/Reset-24.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txttotal.setText("");
				skinstate1.setSelectedIndex(0);
				skinstate.setSelectedIndex(0);
				pieces1.setText("");
				unitprice1.setText("");
				pieces.setText("");
				unitprice.setText("");
				selldate.setDate(null);
			}
		});
		btnReset.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnReset.setBounds(149, 11, 120, 29);
		panel_3.add(btnReset);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
					
					String query = "insert into updateskinscustomers(SaleDate,customerName,Skinstate,Pieces,Unitprice,OtherSkinState,Other_pieces,Other_unitprice,Total_amount)"+"values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
					pstmt.setString(1, ((JTextField)selldate.getDateEditor().getUiComponent()).getText());
					pstmt.setString(2, (String) customerName.getSelectedItem());
					pstmt.setString(3, (String)skinstate.getSelectedItem());
					pstmt.setString(4, pieces.getText());
					pstmt.setString(5, unitprice.getText());
					pstmt.setString(6, (String) skinstate1.getSelectedItem());
					pstmt.setString(7, pieces1.getText());
					pstmt.setString(8, unitprice1.getText());
					pstmt.setString(9, txttotal.getText());
					pstmt.execute();
				
				JOptionPane.showMessageDialog(null, "Update successful");
					txttotal.setText("");
					skinstate1.setSelectedIndex(0);
					skinstate.setSelectedIndex(0);
					pieces1.setText("");
					unitprice1.setText("");
					pieces.setText("");
					unitprice.setText("");
					selldate.setDate(null);
				}
				catch(Exception e5){
					JOptionPane.showMessageDialog(null, e5);
				}
			}
		});
		btnSave.setIcon(new ImageIcon(UpdateCustomerSkins.class.getResource("/com/stingray/hidesandskins/Assests/save-24.png")));
		btnSave.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.setBounds(10, 11, 120, 29);
		panel_3.add(btnSave);
		
		//set display location to center
		setLocationRelativeTo(null);
	}
}
