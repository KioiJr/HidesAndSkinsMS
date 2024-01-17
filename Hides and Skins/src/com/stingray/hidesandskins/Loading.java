package com.stingray.hidesandskins;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;

public class Loading extends JFrame {
	static JProgressBar progressBar;
	int i;

	private JPanel contentPane;
	
	public void iterate() {
		while(i <= 1000) {
			progressBar.setValue(i);
			i = i+5;
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
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
	public Loading() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 247, 414, 14);
		panel.add(progressBar);
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setVisible(true);
//		this.iterate();
		
		
	}

}
