/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stingray.hidesandskins;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Color;

/**
 *
 * @author OCTOPUS
 */
@SuppressWarnings("serial")
public class LoadingPage extends javax.swing.JFrame {


    /**
     * Creates new form LoadingPage
     */
    public LoadingPage() {
    	getContentPane().setBackground(SystemColor.textHighlight);
    	getContentPane().setMaximumSize(new Dimension(304, 2147483647));
    	setMaximumSize(new Dimension(2147483647, 2147483534));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setOpaque(false);
        LoadingBar = new javax.swing.JProgressBar();
        LoadingBar.setBounds(0, 247, 502, 14);
        LoadingValue = new javax.swing.JLabel();
        LoadingValue.setBounds(430, 225, 72, 25);
        LoadingLabel = new javax.swing.JLabel();
        LoadingLabel.setBounds(0, 225, 191, 25);

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 0, 15)); // NOI18N
        jLabel1.setText("Loading Resources...");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        LoadingBar.setForeground(new java.awt.Color(51, 255, 0));

        LoadingValue.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        LoadingValue.setForeground(new java.awt.Color(204, 255, 255));
        LoadingValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LoadingValue.setText("0 %");

        LoadingLabel.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        LoadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoadingLabel.setText("Loading Resources ...");
        
        JLabel lblNewLabel = new JLabel("GHOLAN HIDES AND SKINS");
        lblNewLabel.setForeground(Color.ORANGE);
        lblNewLabel.setBounds(0, 124, 502, 32);
        lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel2.setLayout(null);
        jPanel2.add(LoadingBar);
        jPanel2.add(LoadingLabel);
        jPanel2.add(LoadingValue);
        jPanel2.add(lblNewLabel);
        
        lblNewLabel_2 = new JLabel("Copyright @ KOSO 2024");
        lblNewLabel_2.setIcon(new ImageIcon(LoadingPage.class.getResource("/com/stingray/hidesandskins/Assests/icons8-copyright-all-rights-reserved-16.png")));
        lblNewLabel_2.setFont(new Font("Maiandra GD", Font.ITALIC, 13));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        		.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_2)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(LoadingPage.class.getResource("/com/stingray/hidesandskins/Assests/icons8-leather-94.png")));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(207, 11, 92, 102);
        jPanel2.add(lblNewLabel_1);
        getContentPane().setLayout(groupLayout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoadingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      LoadingPage lp = new LoadingPage();
      lp.setVisible(true);
        try {
            for(int i = 0; i<=80;i++){
                Thread.sleep(100);
                lp.LoadingValue.setText(i +"%");
                
                if(i == 10){
                    lp.LoadingLabel.setText("Turning on modules...");
                }
                if(i == 30){
                    lp.LoadingLabel.setText("Loading on modules...");
                }
                if(i == 60){
                    lp.LoadingLabel.setText("Connecting to database...");
                }
                if(i == 70){
                    lp.LoadingLabel.setText(" Launching application...");
                }
                lp.LoadingBar.setValue(i);
         
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        lp.dispose();
        Login p2 = new Login();
        p2.setVisible(true);
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
}
