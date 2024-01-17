package com.stingray.hidesandskins;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

public class AddNewSupplier extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstname;
	private JTextField txtSecondname;
	private JTextField txtArea;
	private JTextField txtOccupation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewSupplier frame = new AddNewSupplier();
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
	public AddNewSupplier() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewSupplier.class.getResource("/com/stingray/hidesandskins/Assests/leather-16.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 473);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(43, 53, 68)), "Add new supplier", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 200, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(10, 25, 374, 347);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel firstname = new JLabel("First name");
		firstname.setHorizontalAlignment(SwingConstants.RIGHT);
		firstname.setForeground(Color.WHITE);
		firstname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		firstname.setBorder(null);
		firstname.setBounds(10, 79, 142, 27);
		panel.add(firstname);
		
		JLabel lblSecondName = new JLabel("Second name");
		lblSecondName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecondName.setForeground(Color.WHITE);
		lblSecondName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblSecondName.setBorder(null);
		lblSecondName.setBounds(10, 131, 142, 27);
		panel.add(lblSecondName);
		
		JLabel lblTownarea = new JLabel("Town/Area");
		lblTownarea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTownarea.setForeground(Color.WHITE);
		lblTownarea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblTownarea.setBorder(null);
		lblTownarea.setBounds(10, 182, 142, 27);
		panel.add(lblTownarea);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOccupation.setForeground(Color.WHITE);
		lblOccupation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblOccupation.setBorder(null);
		lblOccupation.setBounds(10, 230, 142, 27);
		panel.add(lblOccupation);
		
		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		txtFirstname.setColumns(10);
		txtFirstname.setBounds(198, 84, 170, 27);
		panel.add(txtFirstname);
		
		txtSecondname = new JTextField();
		txtSecondname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		txtSecondname.setColumns(10);
		txtSecondname.setBounds(198, 131, 170, 27);
		panel.add(txtSecondname);
		
		txtArea = new JTextField();
		txtArea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		txtArea.setColumns(10);
		txtArea.setBounds(198, 182, 170, 27);
		panel.add(txtArea);
		
		txtOccupation = new JTextField();
		txtOccupation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		txtOccupation.setColumns(10);
		txtOccupation.setBounds(198, 235, 170, 27);
		panel.add(txtOccupation);
		
		JComboBox product = new JComboBox();
		product.setModel(new DefaultComboBoxModel(new String[] {"--Select Product--", "Hides", "Skins(goat/sheep)"}));
		product.setForeground(Color.WHITE);
		product.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		product.setBorder(null);
		product.setBackground(Color.DARK_GRAY);
		product.setBounds(78, 41, 262, 27);
		panel.add(product);
		
		JLabel lblNewLabel_11_3_1 = new JLabel("Start date");
		lblNewLabel_11_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11_3_1.setForeground(Color.WHITE);
		lblNewLabel_11_3_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_11_3_1.setBorder(null);
		lblNewLabel_11_3_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_11_3_1.setBounds(10, 288, 142, 27);
		panel.add(lblNewLabel_11_3_1);
		
		JDateChooser supplierStartDate = new JDateChooser();
		supplierStartDate.setDateFormatString("YYYY-MM-dd");
		supplierStartDate.setBounds(198, 288, 170, 27);
		panel.add(supplierStartDate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.windowBorder);
		panel_1.setBounds(10, 378, 374, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFirstname.setText(null);
				txtSecondname.setText(null);
				txtArea.setText(null);
				txtOccupation.setText(null);
				product.setSelectedItem("--Select Product--");
				supplierStartDate.setDate(null);
			}
		});
		btnReset.setIcon(new ImageIcon(AddNewSupplier.class.getResource("/com/stingray/hidesandskins/Assests/Reset-24.png")));
		btnReset.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnReset.setBounds(31, 11, 117, 27);
		panel_1.add(btnReset);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
					
					String query = "insert into suppliers(product,firstName, secondName,town,occupation,startdate)"+"values(?,?,?,?,?,?)";
					PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
					pstmt.setString(1, (String) product.getSelectedItem());
					pstmt.setString(2, txtFirstname.getText());
					pstmt.setString(3, txtSecondname.getText());
					pstmt.setString(4, txtArea.getText());
					pstmt.setString(5, txtOccupation.getText());
					pstmt.setString(6, ((JTextField)supplierStartDate.getDateEditor().getUiComponent()).getText());
					
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "Supplier has been successfully added.");
					txtFirstname.setText(null);
					txtSecondname.setText(null);
					txtArea.setText(null);
					txtOccupation.setText(null);
					product.setSelectedItem(null);
					supplierStartDate.setDate(null);
				}
				catch(Exception e2) {
					
					JOptionPane.showInternalMessageDialog(null, e2);
				}
			}
		});
		btnSave.setIcon(new ImageIcon(AddNewSupplier.class.getResource("/com/stingray/hidesandskins/Assests/save-24.png")));
		btnSave.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		btnSave.setBounds(233, 11, 117, 27);
		panel_1.add(btnSave);
		
		//Center display
		setLocationRelativeTo(null);
	}
}
