/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import  javax.swing.*;
import javax.swing.border.*;


/**
 *
 * @author MOHAMMAD IQBAL
 */
public class ForgetPassword extends JFrame implements ActionListener,KeyListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField jt1,jt2,jt3,jt4,jt5;
    JPanel panel,panel2;
    JButton button1,button2;
    public ForgetPassword()  {
        setSize(850,500);
        setLocation(280,80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
          setResizable(false);
         // adding panel
         panel = new JPanel();
         panel.setLayout(null);
         panel.setBackground(Color.WHITE);
         
         //Adding buttons
         button1= new JButton("Show Password");
         button1.setBackground(Color.BLACK);
         button1.setForeground(Color.WHITE);
         button1.setBounds(660,269,130,40);
        button1.addActionListener(this);
        panel.add(button1);
        
         button2= new JButton("Back");
         button2.setBackground(Color.cyan);
         button2.setForeground(Color.BLACK);
         button2.setFont(new Font("Senserif", Font.BOLD, 16));
         button2.setBounds(660,40,110,40);
        button2.addActionListener(this);
        panel.add(button2);
        
        // Adding Labels and TextFields
        l2 = new JLabel("User_Name :");
        l2.setFont(new Font("Senserif", Font.PLAIN,20));
        l2.setBounds(320,90,190,30);
        panel.add(l2);
        jt1 = new JTextField();
        jt1.setBounds(440,90,180,30);
        jt1.addKeyListener(this);
        panel.add(jt1);
        
        l3 = new JLabel("Name :");
        l3.setFont(new Font("Senserif", Font.PLAIN,20));
        l3.setBounds(350,150,110,30);
        panel.add(l3);
        jt2 = new JTextField();
        jt2.setBounds(440,150,180,30);
        jt2.setEditable(false);
        panel.add(jt2);
        
        l4 = new JLabel("Security Question :");
        l4.setFont(new Font("Senserif", Font.PLAIN,20));
        l4.setBounds(270,210,290,30);
        panel.add(l4);
        jt3 = new JTextField();
        jt3.setBounds(440,210,180,30);
        jt3.setEditable(false);
        panel.add(jt3);
        
        l5 = new JLabel("Answer :");
        l5.setFont(new Font("Senserif", Font.PLAIN,20));
        l5.setBounds(350,270,110,30);
        panel.add(l5);
        jt4 = new JTextField();
        jt4.setBounds(440,270,180,30);
        
        jt4.setEditable(false);
        panel.add(jt4);
        
        l6 = new JLabel("Your Password :");
        l6.setFont(new Font("Senserif", Font.PLAIN,20));
        l6.setBounds(270,330,250,30);
        panel.add(l6);
        jt5 = new JTextField();
        jt5.setBounds(440,330,180,30);
        jt5.setEditable(false);
        
        panel.add(jt5);
        
        
        
      
        //adding image
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/qes2.png"));
        Image image= icon.getImage().getScaledInstance(230,260,Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image);
        l1 = new JLabel(icon2);
        l1.setBounds(40,130,230,260);
        panel.add(l1);
        add(panel);
       
       
       
         //Adding border
         panel2 = new JPanel();
         panel2.setBorder(new TitledBorder(new LineBorder(new Color(128,128,0), 2),"Manage Password ",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(34,139,34)));
         panel2.setBackground(Color.WHITE);
         panel2.setBounds(20,25,790,400);
         panel.add(panel2);
      
      
      
       
       
       
        setVisible(true);
        
        
    }
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource()==button1 ) {
              String answer=jt4.getText().trim();
            try {
                dbConnection connection= new dbConnection();
                ResultSet rs= connection.statement.executeQuery("select* from sign_up where Answer='"+answer+"' ");
                if (rs.next()) {
                    
                    jt5.setEditable(true);
                    jt5.setText(rs.getString("Password"));
                   
                    
                }
                
                
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
         
         }
           else{
        
        new Login().setVisible(true);
        this.setVisible(false);
        
        }
     
     }
    public static void main(String[] args) {
        new ForgetPassword();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource()==jt1) {
            String userId1=jt1.getText().trim();
             try {
                dbConnection connection= new dbConnection();
                ResultSet rs= connection.statement.executeQuery("select* from sign_up where User_Name='"+userId1+"' ");
                if (rs.next()) {
                    jt2.setEditable(true);
                    jt3.setEditable(true);
                    jt4.setEditable(true);
                    jt5.setEditable(false);
                    jt1.setText(rs.getString("User_Name"));
                    jt2.setText(rs.getString("Name"));
                    jt3.setText(rs.getString("Security_Question"));
                    
                }
                
                
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
            
        }
        
        
    }
}
