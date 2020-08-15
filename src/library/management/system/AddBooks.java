
package library.management.system;

import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;

import java.awt.Image;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.*;


public class AddBooks extends JFrame implements ActionListener{
   
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JPanel panel;
    JButton button1,button2;
    
    public AddBooks()  {
        
        setSize(1000,720);
        setLocation(90,30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(9,2,30,30));
        
        //adding image
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/book4.png"));
        Image image= icon.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
        ImageIcon icon2= new ImageIcon(image);
        l1 = new JLabel(icon2);
        //l1.setBounds(10,60,400,400);
        add(l1,"West");
        
        l2 = new JLabel("Book Id    :");
        l2.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l2);
        jt1 = new JTextField();
      
        
        panel.add(jt1);
        
         l3 = new JLabel("Book Name :");
        l3.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l3);
        jt2 = new JTextField();
        panel.add(jt2);
        
        l4 = new JLabel("Publisher Name :");
        l4.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l4);
        jt3 = new JTextField();
        panel.add(jt3);
        
        l5 = new JLabel("      Edition     :");
        l5.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l5);
        jt4 = new JTextField();
        panel.add(jt4);
        
        l6 = new JLabel("      Price    :");
        l6.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l6);
        jt5 = new JTextField();
        panel.add(jt5);
        
        l7 = new JLabel("Total Pages    :");
        l7.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l7);
        jt6 = new JTextField();
        panel.add(jt6);
        
        button1 = new JButton("Add Book");
        button1.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button1.setBackground(new Color(0, 204, 153));
        button1.setForeground(Color.BLACK);
        panel.add(button1);
        
        button2 = new JButton("Back  ");
        button2.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button2.setBackground(new Color(0, 204, 153));
        button2.setForeground(Color.BLACK);
        panel.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        
        RandomeId();
        
        add(panel,"Center");
        setResizable(false);
        setVisible(true);
        
    }
    public void RandomeId(){
      Random random= new Random();
        jt1.setText(""+random.nextInt(1000));
        }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==button1) {
            String bookid1=jt1.getText();
            String bookName1=jt2.getText();
            String publisher1=jt3.getText();
            String edition1=jt4.getText();
            String price1=jt5.getText();
            String totalpages1=jt6.getText();
            Validation v = new Validation();
            if (!v.bookIdvalidate(bookid1)) {
                JOptionPane.showMessageDialog(null,"BookId must be an Integer Number","Error",JOptionPane.ERROR_MESSAGE);
                
            }
            else if (!v.bookNamevalidate(bookName1)) {
                JOptionPane.showMessageDialog(null,"Book Name  must be in English Only","Error",JOptionPane.ERROR_MESSAGE);
                
            }
            else if (!v.EditionValidate(edition1)) {
                JOptionPane.showMessageDialog(null,"Book Edition  must be an Integer Number ","Error",JOptionPane.ERROR_MESSAGE);
                
            }
            else if (!v.PublisherValidate(publisher1)) {
                JOptionPane.showMessageDialog(null,"Publisher Name  must be in English Only","Error",JOptionPane.ERROR_MESSAGE);
                
            }
            else if (!v.PriceValidate(price1)) {
                JOptionPane.showMessageDialog(null,"Book Price  must be in Integer Number Only","Error",JOptionPane.ERROR_MESSAGE);
                
            }
            else if (!v.PageNOValidate(totalpages1)) {
                JOptionPane.showMessageDialog(null,"Total Page must be in Integer Number Only","Error",JOptionPane.ERROR_MESSAGE);
                
            }
            
            else{
            try {
               dbConnection connection= new dbConnection();
                  connection.statement.executeUpdate("insert into add_book values('"+bookid1+"','"+bookName1+"','"+publisher1+"','"+edition1+"','"+price1+"','"+totalpages1+"')");
                  JOptionPane.showMessageDialog(null,"Book Added Successfully ");
                  jt1.setText("");
                  jt2.setText("");
                  jt3.setText("");
                  jt4.setText("");
                  jt5.setText("");
                  jt6.setText("");
                  
                  RandomeId();
                
            } 
            
            catch (Exception e) {
                e.printStackTrace();
            }
            
            }
            
            
      }
        else{
            this.setVisible(false);
        new Home().setVisible(true);
        
        }
    }
    
    
    public static void main(String[] args) {
        new AddBooks();
    }
    
    
}
