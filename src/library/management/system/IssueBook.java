package library.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;

import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.*;

public class IssueBook extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JTextField jt1, jt2, jt3, jt4, jt5, jt6, jt7, jt8, jt9, jt10,jt11,jt12,jt13;
    JPanel panel, panel2, panel3;
    JButton button1, button2, button3, button4;
  

    public IssueBook() {

        setSize(1100, 620);
        setLocation(90, 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
          setResizable(false);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        //adding image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/book5.png"));
        Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image);
        l1 = new JLabel(icon2);
        l1.setBounds(10, 0, 150, 150);
        //  add(l1);

        //Book details Area
        l2 = new JLabel("Book Id    :");
        l2.setFont(new Font("Cinzel", Font.BOLD, 20));
        l2.setBounds(10, 40, 400, 30);
        add(l2);
        jt1 = new JTextField();
        jt1.setBounds(130, 40, 200, 30);
        add(jt1);

        l3 = new JLabel("Book Name:");
        l3.setFont(new Font("Cinzel", Font.BOLD, 20));
        l3.setBounds(10, 100, 400, 30);
        add(l3);
        jt2 = new JTextField();
        jt2.setBounds(130, 100, 200, 30);
        add(jt2);

        l4 = new JLabel("Punlisher :");
        l4.setFont(new Font("Cinzel", Font.BOLD, 20));
        l4.setBounds(10, 160, 400, 30);
        add(l4);
        jt3 = new JTextField();
        jt3.setBounds(130, 160, 200, 30);
        add(jt3);

        l5 = new JLabel("Edition :");
        l5.setFont(new Font("Cinzel", Font.BOLD, 20));
        l5.setBounds(10, 220, 400, 30);
        add(l5);
        jt4 = new JTextField();
        jt4.setBounds(130, 220, 200, 30);
        add(jt4);

        l6 = new JLabel("Price :");
        l6.setFont(new Font("Cinzel", Font.BOLD, 20));
        l6.setBounds(10, 280, 400, 30);
        add(l6);
        jt5 = new JTextField();
        jt5.setBounds(130, 280, 200, 30);
        add(jt5);

        l7 = new JLabel("Total Pages:");
        l7.setFont(new Font("Cinzel", Font.BOLD, 20));
        l7.setBounds(8, 340, 400, 30);
        add(l7);
        jt6 = new JTextField();
        jt6.setBounds(130, 340, 200, 30);
        add(jt6);

        //Search button 
        button1 = new JButton("Search");
        button1.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button1.setBackground(new Color(0, 204, 153));
        button1.setBounds(350, 40, 150, 30);
        button1.setForeground(Color.BLACK);
        add(button1);

        button2 = new JButton("Issue");
        button2.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button2.setBackground(new Color(0, 204, 153));
        button2.setBounds(130, 420, 150, 40);
        button2.setForeground(Color.BLACK);
        add(button2);

        button3 = new JButton("Back");
        button3.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button3.setBackground(new Color(0, 204, 153));
        button3.setBounds(300, 420, 150, 40);
        button3.setForeground(Color.BLACK);
        add(button3);
        //adding border line
        panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(128, 134, 60), 2),
                "Book Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(60, 150, 60)));
        panel2.setBounds(0, 20, 500, 600);
       // panel.add(panel2);

        //adding student details
        l8 = new JLabel("Student Id :");
        l8.setBounds(540, 40, 200, 30);
        l8.setFont(new Font("Cinzel", Font.BOLD, 20));
        add(l8);
        jt7 = new JTextField();
        jt7.setBounds(660, 40, 200, 30);
        add(jt7);

        // second search button
        button4 = new JButton("Search");
        button4.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button4.setBackground(new Color(0, 204, 153));
        button4.setBounds(880, 40, 150, 30);
        button4.setForeground(Color.BLACK);
        add(button4);

        l9 = new JLabel("Student Name :");
        l9.setBounds(500, 100, 200, 30);
        l9.setFont(new Font("Cinzel", Font.BOLD, 20));
        add(l9);
        jt8 = new JTextField();
        jt8.setBounds(660, 100, 200, 30);
        add(jt8);

        l10 = new JLabel("Father's Name :");
        l10.setBounds(500, 160, 200, 30);
        l10.setFont(new Font("Cinzel", Font.BOLD, 20));
        add(l10);
        
        jt9 = new JTextField();
        jt9.setBounds(660, 160, 200, 30);
        add(jt9);

        l11 = new JLabel("Course Name :");
        l11.setBounds(500, 220, 200, 30);
        l11.setFont(new Font("Cinzel", Font.BOLD, 20));
        add(l11);
        
        jt10 = new JTextField();
        jt10.setBounds(660, 220, 200, 30);
        add(jt10);
        
        l12 = new JLabel("Branch Name :");
        l12.setBounds(500, 280, 200, 30);
        l12.setFont(new Font("Cinzel", Font.BOLD, 20));
        add(l12);
        
        jt11 = new JTextField();
        jt11.setBounds(660, 280, 200, 30);
        add(jt11);
        
        l13 = new JLabel("Year :");
        l13.setBounds(500, 340, 200, 30);
        l13.setFont(new Font("Cinzel", Font.BOLD, 20));
        add(l13);
        
        jt12 = new JTextField();
        jt12.setBounds(660, 340, 200, 30);
        add(jt12);

        l14 = new JLabel("Semester :");
        l14.setBounds(500, 400, 200, 30);
        l14.setFont(new Font("Cinzel", Font.BOLD, 20));
        add(l14);
        
        jt13 = new JTextField();
        jt13.setBounds(660, 400, 200, 30);
        add(jt13);
        
        // adding action events on buttons
         button1.addActionListener(this);
         button2.addActionListener(this);
         button3.addActionListener(this);
         button4.addActionListener(this);
         //seting textfield uneditable
         jt2.setEditable(false);
         jt3.setEditable(false);
         jt4.setEditable(false); 
         jt5.setEditable(false);
         jt6.setEditable(false);
        
         jt8.setEditable(false);
         jt9.setEditable(false); 
         jt10.setEditable(false);
         jt11.setEditable(false);
         jt12.setEditable(false);
         jt13.setEditable(false);
        
        add(panel, "Center");
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==button1) {
            String bookid=jt1.getText();
            try {
                dbConnection connection= new dbConnection();
                ResultSet rs= connection.statement.executeQuery("select*from add_book where Book_Id='"+bookid+"'");
                if (rs.next()) {
                    jt2.setText(rs.getString("Book_Name"));
                    jt3.setText(rs.getString("Publisher"));
                    jt4.setText(rs.getString("Edition"));
                    jt5.setText(rs.getString("Price"));
                    jt6.setText(rs.getString("Total_Pages"));
                    jt2.setEditable(true);
                    jt3.setEditable(true);
                    jt4.setEditable(true); 
                    jt5.setEditable(true);
                    jt6.setEditable(true);
                    
                }
                else{
                JOptionPane.showMessageDialog(null, "Not Found In DataBase");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        else if (ae.getSource()==button2) {
            
            String bookId=jt1.getText();
            String bookName=jt2.getText();
            String StudentId=jt7.getText();
            String StudentName=jt8.getText();
            String branchName=jt11.getText();
            String year=jt12.getText();
            String semester=jt13.getText();
            
            String courseName=jt10.getText();
            
           Date d= new Date();
           SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yy");
           String date1=sdf1.format(d);
           SimpleDateFormat sdf2= new SimpleDateFormat("HH:mm:ss");
           String time1= sdf2.format(d);
            try {
                
                dbConnection connection= new dbConnection();
                connection.statement.executeUpdate("insert into issue_book values('"+bookId+"','"+StudentId+"','"+bookName+"','"+StudentName+"','"+branchName+"','"+year+"','"+semester+"','"+courseName+"','"+time1+"','"+date1+"')");
                JOptionPane.showMessageDialog(null, "Book Issued Successfully!!!");
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");
                jt6.setText("");
                jt7.setText("");
                jt8.setText("");
                jt9.setText("");
                jt10.setText("");
                jt11.setText("");
                jt12.setText("");
                jt13.setText("");
                           
                
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
            
            
         }
        else if (ae.getSource()==button3) {
             new Home().setVisible(true);
            this.setVisible(false);
          }
        
        else if (ae.getSource()==button4) {
           String studentid=jt7.getText();
            try {
                dbConnection connection= new dbConnection();
                ResultSet rs= connection.statement.executeQuery("select*from add_student where Student_Id='"+studentid+"'");
                if (rs.next()) {
                    jt8.setText(rs.getString("Student_Name"));
                    jt9.setText(rs.getString("Father_Name"));
                    jt10.setText(rs.getString("Course_Name"));
                    jt11.setText(rs.getString("Branch_Name"));
                    jt12.setText(rs.getString("Year"));
                    jt13.setText(rs.getString("Semester"));
                  
                    jt8.setEditable(true);
                    jt9.setEditable(true); 
                    jt10.setEditable(true);
                    jt11.setEditable(true);
                    jt12.setEditable(true);
                     jt13.setEditable(true);                
                    
                }
                else{
                JOptionPane.showMessageDialog(null, "Not Found In DataBase");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

    public static void main(String[] args) {
        new IssueBook();
    }

}
