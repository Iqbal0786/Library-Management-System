
package library.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;

import java.awt.Image;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class AddStudent extends JFrame implements ActionListener{
   
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField jt1,jt2,jt3;
    JPanel panel;
    JButton button1,button2;
    Choice c1,c2,c3,c4;
    
    public AddStudent()  {
        
        setSize(1000,720);
        setLocation(90,30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
          setResizable(false);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(10,2,30,30));
        
        //adding image
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/boy6.png"));
        Image image= icon.getImage().getScaledInstance(390, 400,Image.SCALE_DEFAULT);
        ImageIcon icon2= new ImageIcon(image);
        l1 = new JLabel(icon2);
        //l1.setBounds(10,60,400,400);
        add(l1,"West");
        
        l2 = new JLabel("Student Id    :");
        l2.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l2);
        jt1 = new JTextField();
        panel.add(jt1);
        
         l3 = new JLabel("Student Name :");
        l3.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l3);
        jt2 = new JTextField();
        panel.add(jt2);
        
        l4 = new JLabel("Father's Name :");
        l4.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l4);
        jt3 = new JTextField();
        panel.add(jt3);
        
        l5 = new JLabel(" Course Name   :");
        l5.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l5);
         c1 = new Choice();
         c1.add("B.Tech");
         c1.add("B.E.");
         c1.add("Diploma");
         c1.add("BSc");
        panel.add(c1);
        
        l8 = new JLabel("Branch  Name   :");
        l8.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l8);
         c2 = new Choice();
         c2.add("IT");
         c2.add("CSE");
         c2.add("Civil");
         c2.add("Electronics");
         c2.add("Mechanical");
         panel.add(c2);
        
        l6 = new JLabel("   Year :");
        l6.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l6);
        
       c3 = new Choice();
       c3.add("First Year");
       c3.add("Seconed Year");
       c3.add("Third Year");
       c3.add("Fourth");
        panel.add(c3);
        
        l7 = new JLabel(" Semester    :");
        l7.setFont(new Font("Cinzel", Font.BOLD, 20));
        panel.add(l7);
        c4 = new Choice();
        c4.add("First Semester");
        c4.add("Second Semester");
        c4.add("Third Semester");
        c4.add("Fourth Semester");
        c4.add("Fifth Semester");
        c4.add("Sixth Semester");

        panel.add(c4);
        
        button1 = new JButton("Add Student");
        button1.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button1.setBackground(new Color(0, 204, 153));
        button1.setForeground(Color.BLACK);
        button1.addActionListener(this);
        panel.add(button1);
        
        button2 = new JButton("Back  ");
        button2.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button2.setBackground(new Color(0, 204, 153));
        button2.setForeground(Color.BLACK);
        button2.addActionListener(this);
        panel.add(button2);
        
        
        
        RandomeId();
        add(panel,"Center");
        setVisible(true);
        
    }
    public void RandomeId(){
      Random random= new Random();
        jt1.setText(""+random.nextInt(1000));
        }
    public void actionPerformed(ActionEvent ae){
    if (ae.getSource()==button1) {
            String studentId1=jt1.getText();
            String studentName1=jt2.getText();
            String fatherName1=jt3.getText();
            String course1=c1.getSelectedItem();
            String branch1=c2.getSelectedItem();
            String year1=c3.getSelectedItem();
            String semester1=c4.getSelectedItem();
            Validation v= new Validation();
            if (!v.StudentIdValidate(studentId1)) {
                JOptionPane.showMessageDialog(null, "Student Id must be in Integer Number");
            
             }
            else if (!v.StudentNameValidate(studentName1)) {
                JOptionPane.showMessageDialog(null, "Student Name must be in English Only");
            
             }
             else if (!v.FatherNameValidate(fatherName1)) {
                JOptionPane.showMessageDialog(null, "Father Name must be in English Only");
            
             }
            else{
             try {
               dbConnection connection= new dbConnection();
                  connection.statement.executeUpdate("insert into add_student values('"+studentId1+"','"+studentName1+"','"+fatherName1+"','"+course1+"','"+branch1+"','"+year1+"','"+semester1+"')");
                  JOptionPane.showMessageDialog(null,"Student Added Successfully ");
                  jt1.setText("");
                  jt2.setText("");
                  jt3.setText("");
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
        new AddStudent();
    }
    
    
}

