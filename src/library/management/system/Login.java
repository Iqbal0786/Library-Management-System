
package library.management.system;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
      JPanel panel;
      JTextField jt1;
      JLabel l1,l2,l3,l4,l5;
      JPasswordField password;
      JButton button1,button2,button3;
    public Login(){
        setSize(600,500);
        setLocation(245,90);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panel= new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        l1= new JLabel("Email Id :");
        l1.setBounds(200,145,120,30);
        l1.setFont(new Font("senserif",Font.BOLD,16));
        jt1= new JTextField();
        jt1.setBounds(340,145,180,30);
        l2= new JLabel("Password :");
        l2.setFont(new Font("senserif",Font.BOLD,16));
        l2.setBounds(200,190,160,30);
        password = new JPasswordField();
        password.setBounds(340,190,180,30);
        l3 = new JLabel("Trouble into Login ??");
        l3.setBounds(80,350,190,30);
        l3.setFont(new Font("senserif",Font.BOLD,16));
        l3.setForeground(Color.BLUE);
        button1 = new JButton("Login");
        button1.addActionListener(this);
        button1.setBounds(250,270,120,30);
        button1.setBackground(Color.black);
        button1.setForeground(Color.white);
        button2 = new JButton("Sign Up");
        button2.addActionListener(this);
        button2.setBounds(390,270,120,30);
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        panel.add(button2);
        button3 = new JButton("Forget Password ");
        button3.addActionListener(this);
        button3.setBounds(290,350,190,40);
        button3.setBackground(Color.black);
        button3.setForeground(Color.white);
        // adding book image
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/book1.png"));
        Image i=icon.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
        ImageIcon icon2= new ImageIcon(i);
        l4 = new JLabel(icon2);
        l4.setBounds(20,120,180,180);
        panel.add(l4);
        // adding logo 
        ImageIcon icon3= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/Elib.png"));
        Image i2=icon3.getImage().getScaledInstance(290,100,Image.SCALE_DEFAULT);
        ImageIcon icon4= new ImageIcon(i2);
        l5 = new JLabel(icon4);
        l5.setBounds(220,2,290,100);
        panel.add(l5);
        
        panel.add(button3);
        panel.add(button1);
        panel.add(l1);
        panel.add(jt1);
        panel.add(l2);
        panel.add(password);
        panel.add(l3);
        add(panel);
        
        
        
        
        
        getContentPane().setBackground(Color.white);
        setVisible(true);
      
    }
    public static void main(String[] args) {
        new Login();
    }
    
    public void actionPerformed(ActionEvent ae){
                     
           if (ae.getSource()==button1) {
               String email=jt1.getText();
               char pass1[]= password.getPassword();
               String Password1= new String(pass1);
                    try {
                        dbConnection connection= new dbConnection();
                        ResultSet rs=connection.statement.executeQuery("select * from Login where Email_Id='"+email+"' and Password='"+Password1+"'");
                        if (rs.next()) {
                            new Loading().setVisible(true);
                            this.setVisible(false);
                            
                            
                        }
                        else{
                         JOptionPane.showMessageDialog(null, "Invalid Login !!!","Error",JOptionPane.ERROR_MESSAGE);
                         
                         }
                       } 
                    catch (Exception e) {
                        
                        e.printStackTrace();
                    }
    
            
            }
           else if (ae.getSource()==button2) {
               new Sign_UP().setVisible(true);
               this.setVisible(false);
            
          }
           else if (ae.getSource()==button3) {
               new ForgetPassword().setVisible(true);
               this.setVisible(false);
                       
            
        }
       }
    
}
