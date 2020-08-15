package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Date;

public class ReturnBooks extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7,l8,l9;
    JButton button1, button2, button3,button4;
    JPanel panel;
    JTextField jt1, jt2, jt3, jt4, jt5, jt6, jt7,jt8,jt9;

    public ReturnBooks() {
        super("Return Book ");
        setSize(1000, 430);
        setLocation(250, 90);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
          setResizable(false);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        l1 = new JLabel("Book Id :");
        l1.setBounds(10, 40, 250, 30);
        l1.setFont(new Font("Cinzel", Font.BOLD, 20));
        l1.setForeground(Color.BLACK);
        panel.add(l1);
        jt1 = new JTextField();
        jt1.setBounds(155, 40, 200, 30);
        panel.add(jt1);

        l2 = new JLabel("Book Name  :");
        l2.setBounds(10, 100, 250, 30);
        l2.setFont(new Font("Cinzel", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        panel.add(l2);
        jt2 = new JTextField();
        jt2.setBounds(155, 100, 200, 30);
        panel.add(jt2);

        l3 = new JLabel("Course Name ");
        l3.setBounds(5, 160, 250, 30);
        l3.setFont(new Font("Cinzel", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        panel.add(l3);
        jt3 = new JTextField();
        jt3.setBounds(155, 160, 200, 30);
        panel.add(jt3);
        
        
        l8 = new JLabel("   Year : ");
        l8.setBounds(5, 220, 250, 30);
        l8.setFont(new Font("Cinzel", Font.BOLD, 20));
        l8.setForeground(Color.BLACK);
        panel.add(l8);
        jt8 = new JTextField();
        jt8.setBounds(155, 220, 200, 30);
        panel.add(jt8);
        
        
        l4 = new JLabel("Date of Issue :");
        l4.setBounds(5, 280, 250, 30);
        l4.setFont(new Font("Cinzel", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        panel.add(l4);
        jt4 = new JTextField();
        jt4.setBounds(155, 280, 200, 30);
        panel.add(jt4);
       
        
        l5 = new JLabel("Student Id :");
        l5.setBounds(400,40,200,30);
        l5.setFont(new Font("Cinzel", Font.BOLD, 20));
        l5.setForeground(Color.BLACK);
        panel.add(l5);
        jt5 = new JTextField();
        jt5.setBounds(540,40,200,30);
        panel.add(jt5);
        
         l6 = new JLabel("Student Name :");
        l6.setBounds(370,100,200,30);
        l6.setFont(new Font("Cinzel", Font.BOLD, 20));
        l6.setForeground(Color.BLACK);
        panel.add(l6);
        jt6 = new JTextField();
        jt6.setBounds(540,100,200,30);
        panel.add(jt6);
        
         l7 = new JLabel("Branch :");
        l7.setBounds(400,160,200,30);
        l7.setFont(new Font("Cinzel", Font.BOLD, 20));
        l7.setForeground(Color.BLACK);
        panel.add(l7);
        jt7 = new JTextField();
        jt7.setBounds(540,160,200,30);
        panel.add(jt7);
        
        l9 = new JLabel("Semester :");
        l9.setBounds(400,220,200,30);
        l9.setFont(new Font("Cinzel", Font.BOLD, 20));
        l9.setForeground(Color.BLACK);
        panel.add(l9);
        jt9 = new JTextField();
        jt9.setBounds(540,220,200,30);
        panel.add(jt9);
        
        button1 = new JButton("Search");
        button1.setBounds(780, 40, 120, 30);
        button1.setBackground(new Color(0, 204, 153));
        button1.setForeground(Color.BLACK);
        button1.setFont(new Font("Cinzel", Font.BOLD, 18));
        panel.add(button1);
        
        button2 = new JButton("Return");
        button2.setBounds(160, 330, 190, 40);
        button2.setBackground(new Color(0, 204, 153));
        button2.setForeground(Color.BLACK);
        button2.setFont(new Font("Cinzel", Font.BOLD, 18));
        panel.add(button2);
        
        button3 = new JButton("Back");
        button3.setBounds(450, 330, 190, 40);
        button3.setBackground(new Color(0, 204, 153));
        button3.setForeground(Color.BLACK);
        button3.setFont(new Font("Cinzel", Font.BOLD, 18));
        panel.add(button3);
        button1.addActionListener(this);
        button2.addActionListener(this);
       button3.addActionListener(this);
      
       jt2.setEditable(false);
       jt3.setEditable(false); 
       jt4.setEditable(false);  
       jt6.setEditable(false);
       jt7.setEditable(false);
       jt8.setEditable(false);
       jt9.setEditable(false); 
        
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) {
            String bookId=jt1.getText();
           String studentId=jt5.getText();
          try {
              
           dbConnection connection= new dbConnection();
           ResultSet rs= connection.statement.executeQuery("select* from issue_book where Book_Id='"+bookId+"' and Student_Id='"+studentId+"'");
            if (rs.next()) {
                jt2.setText(rs.getString("Book_Name"));
                jt3.setText(rs.getString("Course_Name"));
                jt4.setText(rs.getString("Date_Of_Issue"));
                jt6.setText(rs.getString("Student_Name"));
                jt7.setText(rs.getString("Branch_Name"));
                jt8.setText(rs.getString("Year"));
                jt9.setText(rs.getString("Semester"));
                
                
                jt2.setEditable(true);
                jt3.setEditable(true); 
                jt4.setEditable(true);  
                jt6.setEditable(true);
                jt7.setEditable(true);
                jt9.setEditable(true);
                jt8.setEditable(true);
                
                
             }
          } 
             catch (Exception e1) {
              e1.printStackTrace();
              
              
             }
        }
        else if (e.getSource()==button2) {
            String bookId=jt1.getText();
            String bookName=jt2.getText();
            String course=jt3.getText();
            String issuedate=jt4.getText();
            String studentId= jt5.getText();
            String studentName=jt6.getText();
            String branchName=jt7.getText();
            String year=jt8.getText();
            String semester=jt9.getText();
           
           Date d= new Date();
           SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yy");
           String date1=sdf1.format(d);
            try {
                dbConnection connection= new dbConnection();
                connection.statement.executeUpdate("insert into return_book values('"+bookId+"','"+studentId+"','"+bookName+"','"+studentName+"','"+branchName+"','"+year+"','"+semester+"','"+issuedate+"','"+date1+"')");
                JOptionPane.showMessageDialog(null, "Processing.........");
                Thread.sleep(1000);
                JOptionPane.showMessageDialog(null, "Book Returned Successfully!!!!");
                
            } 
            catch (Exception e1) {
                e1.printStackTrace();
            }
          
        }
        else if (e.getSource()==button3) {
            new Home().setVisible(true);
            this.setVisible(false);
            
        }

    }

    public static void main(String[] args) {
        new ReturnBooks();
    }

}
