package com.stingray.hidesandskins;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;

public class UpdateCustomerHides extends JFrame {

	private JPanel contentPane;
	private JTextField pieces;
	private JTextField unitprice;
	private JTextField pieces1;
	private JTextField unitprice1;
	private JTextField total;
	private JTextField totalweight;
	private JTextField totalweight1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomerHides frame = new UpdateCustomerHides();
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
	@SuppressWarnings("unchecked")
	public UpdateCustomerHides() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateCustomerHides.class.getResource("/com/stingray/hidesandskins/Assests/leather-16.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 702);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(10, 11, 414, 316);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox skinstate = new JComboBox();
		skinstate.setForeground(SystemColor.activeCaptionText);
		skinstate.setBackground(Color.GRAY);
		skinstate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		skinstate.setModel(new DefaultComboBoxModel(new String[] {"--select skin state--", "Wet salted", "wet unsalted", "Sun dried"}));
		skinstate.setBounds(132, 99, 191, 29);
		panel.add(skinstate);
		
		JLabel lblNewLabel = new JLabel("Number of pieces:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 139, 173, 29);
		panel.add(lblNewLabel);
		
		JLabel lblPricePerUnit = new JLabel("Price per unit:");
		lblPricePerUnit.setForeground(new Color(255, 255, 255));
		lblPricePerUnit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPricePerUnit.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblPricePerUnit.setBounds(10, 179, 173, 29);
		panel.add(lblPricePerUnit);
		
		JLabel lblDateOfSell = new JLabel("Date of sell:");
		lblDateOfSell.setForeground(new Color(255, 255, 255));
		lblDateOfSell.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfSell.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblDateOfSell.setBounds(10, 256, 173, 29);
		panel.add(lblDateOfSell);
		
		pieces = new JTextField();
		pieces.setHorizontalAlignment(SwingConstants.CENTER);
		pieces.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		pieces.setBounds(231, 139, 173, 29);
		panel.add(pieces);
		pieces.setColumns(10);
		
		unitprice = new JTextField();
		unitprice.setHorizontalAlignment(SwingConstants.CENTER);
		unitprice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		unitprice.setColumns(10);
		unitprice.setBounds(231, 179, 173, 29);
		panel.add(unitprice);
		
		JDateChooser selldate = new JDateChooser();
		selldate.setDateFormatString("YYYY-MM-DD");
		selldate.setBounds(231, 256, 173, 29);
		panel.add(selldate);
		selldate.setMaxSelectableDate(new Date());
		
		JLabel lblNewLabel_1 = new JLabel("UPDATE CUSTOMER DETAILS (HIDES)");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 394, 29);
		panel.add(lblNewLabel_1);
		
		totalweight = new JTextField();
		totalweight.setHorizontalAlignment(SwingConstants.CENTER);
		totalweight.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		totalweight.setColumns(10);
		totalweight.setBounds(231, 219, 173, 29);
		panel.add(totalweight);
		
		JLabel lblWeight = new JLabel("Total weight:");
		lblWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblWeight.setBounds(10, 216, 173, 29);
		panel.add(lblWeight);
		
		JComboBox customerName = new JComboBox();
		customerName.setBounds(132, 51, 191, 29);
		panel.add(customerName);
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
			Statement st = con.createStatement();
			ResultSet r=st.executeQuery("select * from customers WHERE product = 'hides' ");

			 while (r.next()) {  

			     customerName.addItem(r.getString("customerName"));  
			 } 
		}
			 catch(Exception e5){
					JOptionPane.showMessageDialog(null, e5);
				}
			 
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.windowBorder);
		panel_1.setBounds(10, 330, 414, 282);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MISCELLANEOUS");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 0, 394, 29);
		panel_1.add(lblNewLabel_2);
		
		JComboBox skinstate1 = new JComboBox();
		skinstate1.setForeground(SystemColor.activeCaptionText);
		skinstate1.setBackground(Color.GRAY);
		skinstate1.setMaximumRowCount(12);
		skinstate1.setModel(new DefaultComboBoxModel(new String[] {"-select skin condition--", "None", "Reject", "Double reject", "Undersize", "Other"}));
		skinstate1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		skinstate1.setBounds(133, 27, 161, 29);
		panel_1.add(skinstate1);
		
		JLabel lblNewLabel_3 = new JLabel("Number of pieces");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 67, 178, 29);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Price per unit:");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setBounds(10, 147, 178, 29);
		panel_1.add(lblNewLabel_3_1);
		
		pieces1 = new JTextField();
		pieces1.setHorizontalAlignment(SwingConstants.CENTER);
		pieces1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		pieces1.setBounds(220, 67, 184, 29);
		panel_1.add(pieces1);
		pieces1.setColumns(10);
		
		unitprice1 = new JTextField();
		unitprice1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		unitprice1.setHorizontalAlignment(SwingConstants.CENTER);
		unitprice1.setColumns(10);
		unitprice1.setBounds(220, 147, 184, 29);
		panel_1.add(unitprice1);
		
		total = new JTextField();
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setFont(new Font("Candara", Font.BOLD, 17));
		total.setBounds(220, 242, 184, 29);
		panel_1.add(total);
		total.setColumns(10);
		
		JLabel lblTotalWeight = new JLabel("Total Weight:");
		lblTotalWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalWeight.setForeground(Color.WHITE);
		lblTotalWeight.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblTotalWeight.setBounds(20, 107, 173, 29);
		panel_1.add(lblTotalWeight);
		
		totalweight1 = new JTextField();
		totalweight1.setHorizontalAlignment(SwingConstants.CENTER);
		totalweight1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		totalweight1.setColumns(10);
		totalweight1.setBounds(220, 107, 184, 29);
		panel_1.add(totalweight1);
		
		JButton calculate = new JButton("CALCULATE");
		calculate.setIcon(new ImageIcon(UpdateCustomerHides.class.getResource("/com/stingray/hidesandskins/Assests/icons8-calculate-20.png")));
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int subtotal = Integer.parseInt(unitprice.getText()) * Integer.parseInt(totalweight.getText());
				
				if(skinstate1.getSelectedItem() == "None") {
					pieces1.setText("0");
					unitprice1.setText("0");
					totalweight1.setText("0");
				};
				
				int subtotal1 = Integer.parseInt(unitprice1.getText()) * Integer.parseInt(totalweight1.getText());
				
				String result = String.valueOf(subtotal+subtotal1);
				total.setText(result);
				
			}
		});
		calculate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calculate.setBounds(133, 197, 173, 34);
		panel_1.add(calculate);
		
		JLabel totalAmnt = new JLabel("TOTAL AMOUNT (KES):");
		totalAmnt.setHorizontalAlignment(SwingConstants.RIGHT);
		totalAmnt.setForeground(Color.WHITE);
		totalAmnt.setFont(new Font("Candara", Font.BOLD, 17));
		totalAmnt.setBounds(20, 242, 178, 29);
		panel_1.add(totalAmnt);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
					
					String query = "insert into updatecustomerhides(saleDate,customerName,okPreservation,okPieces,okPricePerUnit,okTotalWeight,miscPreservation,miscPieces,misctotalWeight,miscPricePerUnit,totalAmount)"+"values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
					pstmt.setString(1, ((JTextField)selldate.getDateEditor().getUiComponent()).getText());
					pstmt.setString(2, (String) customerName.getSelectedItem());
					pstmt.setString(3, (String)skinstate.getSelectedItem());
					pstmt.setString(4, pieces.getText());
					pstmt.setString(5, unitprice.getText());
					pstmt.setString(6, totalweight.getText());
					pstmt.setString(7, (String) skinstate1.getSelectedItem());
					pstmt.setString(8, pieces1.getText());
					pstmt.setString(9, totalweight1.getText());
					pstmt.setString(10, unitprice1.getText());
					pstmt.setString(11, total.getText());
					
					if(skinstate1.getSelectedItem() == "None") {
						pieces1.setText("0");
					};
					pstmt.execute();
				
				JOptionPane.showMessageDialog(null, "Update for "+ customerName.getSelectedItem() +" was successfully done!");
					total.setText("");
					skinstate1.setSelectedIndex(0);
					skinstate.setSelectedIndex(0);
					pieces1.setText("");
					unitprice1.setText("");
					pieces.setText("");
					unitprice.setText("");
					selldate.setDate(null);
					totalweight.setText("");
					totalweight1.setText("");
					
				}
				catch(Exception e5){
					JOptionPane.showMessageDialog(null, e5);
				}
			}
		});
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.setIcon(new ImageIcon(UpdateCustomerHides.class.getResource("/com/stingray/hidesandskins/Assests/save-24.png")));
		btnSave.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnSave.setBounds(10, 623, 120, 29);
		contentPane.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total.setText("");
				skinstate1.setSelectedIndex(0);
				skinstate.setSelectedIndex(0);
				pieces1.setText("");
				unitprice1.setText("");
				pieces.setText("");
				unitprice.setText("");
				selldate.setDate(null);
				totalweight.setText("");
				totalweight1.setText("");
				
			}
		});
		btnReset.setIcon(new ImageIcon(UpdateCustomerHides.class.getResource("/com/stingray/hidesandskins/Assests/Reset-24.png")));
		btnReset.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnReset.setBounds(161, 623, 120, 29);
		contentPane.add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null, "Do you want to close this page?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					UpdateCustomerHides.this.dispose();
				}
				
			}
		});
		btnCancel.setBackground(Color.RED);
		btnCancel.setIcon(new ImageIcon(UpdateCustomerHides.class.getResource("/com/stingray/hidesandskins/Assests/close-24.png")));
		btnCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnCancel.setBounds(304, 623, 120, 29);
		contentPane.add(btnCancel);
		
		setLocationRelativeTo(null);
	}
}
