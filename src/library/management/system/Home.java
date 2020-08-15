/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.awt.Color;
import java.awt.Font;

import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author MOHAMMAD IQBAL
 */
public class Home extends  JFrame implements ActionListener{
  
         JLabel l1,l2,l3,l4,l5,l6;
         JButton button1,button2,button3,button4,button5,button6;
         JPanel panel,panel2;
         JMenuBar menuBar;
         JMenu record,help,Exit;
         JMenuItem bookDetails,StrudentsDetails,Readme,Aboutus,logout,exit;
         
    public Home()  {
             super("E-Library Management System");
             setSize(900,650);
             setLocation(250,40);
             setDefaultCloseOperation(EXIT_ON_CLOSE);
             getContentPane().setBackground(Color.WHITE);
             panel = new JPanel();
             panel.setLayout(null);
             panel.setBackground(Color.WHITE);
             
             // adding MenuBar 
             menuBar = new JMenuBar();
             menuBar.setBackground(new Color(0, 204, 153));
             record = new JMenu("Record");
             record.setFont(new Font("Cinzel", Font.PLAIN, 20));
             record.setForeground(Color.black);
             bookDetails= new JMenuItem("Books Details");
             bookDetails.setBackground(Color.WHITE);
             bookDetails.setForeground(Color.BLACK);
             bookDetails.setFont(new Font("Time New Roman", Font.PLAIN, 16));
             record.add(bookDetails);
             StrudentsDetails= new JMenuItem("Students Details");
             StrudentsDetails.setBackground(Color.WHITE);
             StrudentsDetails.setForeground(Color.BLACK);
             StrudentsDetails.setFont(new Font("Time New Roman", Font.PLAIN, 16));
             record.add(StrudentsDetails);
             menuBar.add(record);
             
             help = new JMenu("Help");
             help.setFont(new Font("Cinzel", Font.PLAIN, 20));
             help.setForeground(Color.BLACK);
             Readme= new JMenuItem("ReadMe");
             Readme.setBackground(Color.WHITE);
             Readme.setForeground(Color.BLACK);
             Readme.setFont(new Font("Time New Roman", Font.PLAIN, 16));
             help.add(Readme);
             Aboutus= new JMenuItem("About Us");
             Aboutus.setBackground(Color.WHITE);
             Aboutus.setForeground(Color.BLACK);
             Aboutus.setFont(new Font("Time New Roman", Font.PLAIN, 16));
             help.add(Aboutus);
             menuBar.add(help);
             
             
             Exit = new JMenu("Exit");
             Exit.setFont(new Font("Cinzel", Font.PLAIN, 20));
             Exit.setForeground(Color.BLACK);
             logout= new JMenuItem("Log Out");
             logout.setBackground(Color.WHITE);
             logout.setForeground(Color.BLACK);
             logout.setFont(new Font("Time New Roman", Font.PLAIN, 16));
             Exit.add(logout);
             
             exit= new JMenuItem("Exit");
             exit.setBackground(Color.WHITE);
             exit.setForeground(Color.BLACK);
             exit.setFont(new Font("Time New Roman", Font.PLAIN, 16));
             bookDetails.addActionListener(this);
             StrudentsDetails.addActionListener(this);
             Readme.addActionListener(this);
             Aboutus.addActionListener(this);
             exit.addActionListener(this);
             logout.addActionListener(this);
             Exit.add(exit);
             menuBar.add(Exit);
             
             
             
             
             
             
             panel.add(menuBar);
             
             //adding Labels and buttons
             ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/addbook2.png"));
             Image image= icon.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);
             ImageIcon icon2= new ImageIcon(image);
             l1 = new JLabel(icon2);
             l1.setBounds(90,70,140,140);
             
             panel.add(l1);
             button1= new JButton("Add Book");
             button1.setBackground(Color.BLACK);
             button1.setForeground(Color.WHITE);
            
             button1.setBounds(90,230,140,40);
             panel.add(button1);
             
             ImageIcon icon3= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/statics2.png"));
             Image image2= icon3.getImage().getScaledInstance(190,180,Image.SCALE_DEFAULT);
             ImageIcon icon4= new ImageIcon(image2);
             l2 = new JLabel(icon4);
             l2.setBounds(310,70,190,180);
             panel.add(l2);
             button2= new JButton("Statics ");
             button2.setBackground(Color.BLACK);
             button2.setForeground(Color.WHITE);
             button2.setBounds(340,230,140,40);
             panel.add(button2);
             
             ImageIcon icon5= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/boy5.png"));
             Image image3= icon5.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
             ImageIcon icon6= new ImageIcon(image3);
             l3 = new JLabel(icon6);
             l3.setBackground(Color.BLUE);
             l3.setBounds(550,50,180,180);
             panel.add(l3);
             button3= new JButton("Add Student");
             button3.setBackground(Color.BLACK);
             button3.setForeground(Color.WHITE);
             button3.setBounds(570,230,140,40);
             panel.add(button3);
             
             
             ImageIcon icon7= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/book4.png"));
             Image image4= icon7.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
             ImageIcon icon8= new ImageIcon(image4);
             l4 = new JLabel(icon8);
             l4.setBackground(Color.BLUE);
             l4.setBounds(70,310,180,180);
             panel.add(l4);
             button4= new JButton("Issue Book ");
             button4.setBackground(Color.BLACK);
             button4.setForeground(Color.WHITE);
             button4.setBounds(90,490,140,40);
             panel.add(button4);
             
             
             ImageIcon icon9= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/returnbook.png"));
             Image image5= icon9.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
             ImageIcon icon10= new ImageIcon(image5);
             l5 = new JLabel(icon10);
             l5.setBackground(Color.BLUE);
             l5.setBounds(320,300,180,180);
             panel.add(l5);
             button5= new JButton("Return  Book ");
             button5.setBackground(Color.BLACK);
             button5.setForeground(Color.WHITE);
             button5.setBounds(340,490,140,40);
             panel.add(button5);
             
             ImageIcon icon11= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/about-us.png"));
             Image image6= icon11.getImage().getScaledInstance(250,160,Image.SCALE_DEFAULT);
             ImageIcon icon12= new ImageIcon(image6);
             l6 = new JLabel(icon12);
             l6.setBackground(Color.BLUE);
             l6.setBounds(530,300,250,160);
             panel.add(l6);
             button6= new JButton("About Us ");
             button6.setBackground(Color.BLACK);
             button6.setForeground(Color.WHITE);
             button6.setBounds(580,490,140,40);
             panel.add(button6);
             
             button1.addActionListener(this);
             button2.addActionListener(this);
             button3.addActionListener(this);
             button4.addActionListener(this);
             button5.addActionListener(this);
             button6.addActionListener(this);
             bookDetails.addActionListener(this);
             StrudentsDetails.addActionListener(this);
             
             
             setJMenuBar(menuBar);
             add(panel);
             setResizable(false);
             setVisible(true);
        
         }
    
    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) {
            new AddBooks().setVisible(true);
            this.setVisible(false);
            
        }
        else if (e.getSource()==button2) {
            new Statics().setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==button3) {
            new AddStudent().setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==button4) {
            new IssueBook().setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==button5) {
            new ReturnBooks().setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==button6) {
            new AboutUs().setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==bookDetails) {
           new Book_Details().setVisible(true);
           this.setVisible(false);
            
        }
        else if (e.getSource()==StrudentsDetails) {
           new Student_Details().setVisible(true);
           this.setVisible(false);
            
        }
        else if (e.getSource()==logout) {
           new Login().setVisible(true);
           this.setVisible(false);
            
        }
         else if (e.getSource()==exit) {
           System.exit(0);
            
        }
         else if (e.getSource()==Readme) {
           new Readme().setVisible(true);
           this.setVisible(false);
            
        }
         else if (e.getSource()==Aboutus) {
           new AboutUs().setVisible(true);
           this.setVisible(false);
            
        }
    }

   
}
