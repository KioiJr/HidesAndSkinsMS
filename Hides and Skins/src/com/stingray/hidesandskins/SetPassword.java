package com.stingray.hidesandskins;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;



import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JCheckBox;

public class SetPassword extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField newpass;
	private JPasswordField conpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetPassword frame = new SetPassword();
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
	public SetPassword() {
		setTitle("H&SMS change password");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetPassword.class.getResource("/com/stingray/hidesandskins/Assests/leather-16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 340);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHANGE PASSWORD");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblNewLabel.setBounds(102, 36, 218, 28);
		contentPane.add(lblNewLabel);
		
		JLabel label1 = new JLabel("USERNAME");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(SystemColor.window);
		label1.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		label1.setBounds(28, 88, 127, 20);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("NEW PASSWORD");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(SystemColor.window);
		label2.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		label2.setBounds(28, 131, 127, 20);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("CONFIRM PASSWORD");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(SystemColor.window);
		label3.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		label3.setBounds(28, 174, 127, 20);
		contentPane.add(label3);
		
		username = new JTextField();
		username.setForeground(SystemColor.window);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBackground(new Color(192, 192, 192));
		username.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		username.setBounds(176, 84, 180, 28);
		contentPane.add(username);
		username.setColumns(10);
		
		newpass = new JPasswordField();
		newpass.setForeground(SystemColor.window);
		newpass.setHorizontalAlignment(SwingConstants.CENTER);
		newpass.setBackground(new Color(192, 192, 192));
		newpass.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		newpass.setBounds(176, 127, 180, 28);
		contentPane.add(newpass);
		
		conpass = new JPasswordField();
		conpass.setForeground(SystemColor.window);
		conpass.setHorizontalAlignment(SwingConstants.CENTER);
		conpass.setBackground(new Color(192, 192, 192));
		conpass.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		conpass.setBounds(176, 170, 180, 28);
		contentPane.add(conpass);
		
		JButton save = new JButton("Save");
		save.setForeground(SystemColor.window);
		save.setIcon(new ImageIcon(SetPassword.class.getResource("/com/stingray/hidesandskins/Assests/icons8-ok-24.png")));
		save.setBackground(new Color(0, 191, 255));
		save.setBorder(null);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "UPDATE users set password = '"+newpass.getText()+"' where username = '"+username.getText()+"'";
				
				try {
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
					Statement stmt = con.prepareStatement(sql);
					if(newpass.getText().equals(conpass.getText())) {
						stmt.execute(sql);
						JOptionPane.showMessageDialog(null, "Successfully changed your password.\nYou can now login again.");
						SetPassword.this.dispose();
						Login lg = new Login();
						lg.setVisible(true);
					}
					
					if (!(newpass.getText().equals(conpass.getText()))) {
						JOptionPane.showMessageDialog(null, "Passwords do not match.\nPlease try again.");
						username.setText("");
						conpass.setText("");
						newpass.setText("");
					}
					
				} catch (SQLException ex) {
					ex.printStackTrace();
					
				}
			}
		});
		save.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		save.setBounds(28, 248, 100, 28);
		contentPane.add(save);
		
		JButton reset = new JButton("Reset");
		reset.setForeground(SystemColor.inactiveCaptionText);
		reset.setIcon(new ImageIcon(SetPassword.class.getResource("/com/stingray/hidesandskins/Assests/reset.png")));
		reset.setBorder(null);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username.setText("");
				newpass.setText("");
				conpass.setText("");
			
			}
		});
		reset.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		reset.setBounds(154, 248, 108, 28);
		contentPane.add(reset);
		
		JButton close = new JButton("Close");
		close.setForeground(SystemColor.window);
		close.setBackground(new Color(255, 0, 0));
		close.setIcon(new ImageIcon(SetPassword.class.getResource("/com/stingray/hidesandskins/Assests/close-24.png")));
		close.setBorder(null);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		close.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		close.setBounds(283, 248, 100, 28);
		contentPane.add(close);
		
		JCheckBox showPass = new JCheckBox("Show password");
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(showPass.isSelected()) {
					newpass.setEchoChar((char)0);
					conpass.setEchoChar((char)0);
				}
				else {
					conpass.setEchoChar('*');
					newpass.setEchoChar('*');
				}
			}
		});
		showPass.setForeground(SystemColor.window);
		showPass.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		showPass.setBackground(SystemColor.desktop);
		showPass.setBounds(176, 205, 117, 23);
		contentPane.add(showPass);
		
		//set display location to centre
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}
