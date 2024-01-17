package com.stingray.hidesandskins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/stingray/hidesandskins/Assests/icons8-leather-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 333);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Maiandra GD", Font.PLAIN, 11));
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("Maiandra GD", Font.BOLD, 17));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBackground(new Color(255, 255, 255));
		username.setToolTipText("username");
		username.setBounds(148, 78, 286, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		pass = new JPasswordField();
		pass.setEchoChar('*');
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() ==  KeyEvent.VK_ENTER) {
					
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
						Statement stmt = con.createStatement();
						@SuppressWarnings("deprecation")
						String sql = "select * from users where username = '"+username.getText()+"' and password = '"+pass.getText().toString()+"' ";
						ResultSet rs  = stmt.executeQuery(sql);
						
						if(rs.next()) {
							
							
							
							Login.this.dispose();
							Homepage hmpg = new Homepage();
							hmpg.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Credentials please try again");
						}
						
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
			}
		});
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setFont(new Font("Maiandra GD", Font.BOLD, 17));
		pass.setBackground(new Color(255, 255, 255));
		pass.setToolTipText("password");
		pass.setBounds(148, 137, 286, 26);
		contentPane.add(pass);
		
		JButton login = new JButton("Login");
		login.setBorder(null);
		login.addKeyListener(new KeyAdapter() {
		});
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
					Statement stmt = con.createStatement();
					@SuppressWarnings("deprecation")
					String sql = "select * from users where username = '"+username.getText()+"' and password = '"+pass.getText().toString()+"' ";
					ResultSet rs  = stmt.executeQuery(sql);
					
					
					
					if(rs.next()) {
						
						JProgressBar progressBar = new JProgressBar();
						progressBar.setBounds(0, 319, 534, 14);
						contentPane.add(progressBar);
						
						JLabel loadingLabel = new JLabel("Turning on modules ...");
						loadingLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 11));
						loadingLabel.setBounds(0, 308, 118, 14);
						contentPane.add(loadingLabel);
						
						try {
							for(int i = 0; i<=80;i++){
				                Thread.sleep(100);
				                progressBar.setValue(i);
							}
						}catch(Exception e2) {
							
						}
						
						
						
						Login.this.dispose();
						Homepage hmpg = new Homepage();
						hmpg.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Credentials please try again");
					}
					
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		login.setIcon(new ImageIcon(Login.class.getResource("/com/stingray/hidesandskins/Assests/icons8-login-20.png")));
		login.setBackground(new Color(0, 206, 209));
		login.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		login.setBounds(148, 226, 95, 26);
		contentPane.add(login);
		
		JButton close = new JButton("Exit");
		close.setBorder(null);
		close.setForeground(Color.BLACK);
		close.setIcon(new ImageIcon(Login.class.getResource("/com/stingray/hidesandskins/Assests/icons8-exit-20.png")));
		close.setBackground(SystemColor.window);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		close.setFont(new Font("Maiandra GD", Font.PLAIN, 14));
		close.setBounds(333, 226, 101, 26);
		contentPane.add(close);
		
		JButton fgtpass = new JButton("Forgot password? Click here");
		fgtpass.setForeground(new Color(255, 255, 255));
		fgtpass.setBorder(null);
		fgtpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
				SetPassword sp = new SetPassword();
				sp.setVisible(true);
			}
		});
		fgtpass.setBackground(SystemColor.windowBorder);
		fgtpass.setIcon(null);
		fgtpass.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		fgtpass.setBounds(148, 274, 286, 26);
		contentPane.add(fgtpass);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/com/stingray/hidesandskins/Assests/icons8-name-30.png")));
		lblNewLabel_1.setBounds(88, 78, 30, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/com/stingray/hidesandskins/Assests/icons8-password-24.png")));
		lblNewLabel_2.setBounds(88, 137, 30, 26);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox showPass = new JCheckBox("Show password");
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showPass.isSelected()) {
					pass.setEchoChar((char)0);
				}
				else {
					pass.setEchoChar('*');
				}
			}
		});
		showPass.setForeground(Color.WHITE);
		showPass.setBackground(SystemColor.windowBorder);
		showPass.setFont(new Font("Maiandra GD", Font.PLAIN, 13));
		showPass.setBounds(148, 182, 117, 23);
		contentPane.add(showPass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/com/stingray/hidesandskins/Assests/icons8-leather-32.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 534, 42);
		contentPane.add(lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 319, 534, 14);
		contentPane.add(progressBar);
		
//		JProgressBar progressBar = new JProgressBar();
//		progressBar.setBounds(0, 319, 534, 14);
//		contentPane.add(progressBar);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}
