
package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;

public class Statics  extends JFrame implements ActionListener{
          JTable table1,table2;
          JScrollPane scrollPane,scrollPane2;
          JPanel panel,panel2,panel3;
          JLabel label;
    public Statics()  {
        super("All Records Details");
        setSize(1000,710);
        setLocation(150,40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
          setResizable(false);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
       //Creating First Table
        table1 = new JTable();
        //table1.setBackground(Color.WHITE);
        table1.setForeground(new Color(153,51,0));
        table1.setFont(new Font("Cinzel", Font.PLAIN, 14));
        
        scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(20,55,940,270);
        
        scrollPane.setBackground(Color.white);
        scrollPane.setViewportView(table1);
        panel.add(scrollPane);
        // adding border around table
         panel2 = new JPanel();
         panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2),"Issued Book Details ",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(34,139,34)));
         panel2.setBackground(Color.WHITE);
         panel2.setBounds(10,35,960,300);
         panel.add(panel2);
         
         // Adding Second Table
           
         table2 = new JTable();
        //table1.setBackground(Color.WHITE);
        table2.setForeground(new Color(153,51,0));
        table2.setFont(new Font("Cinzel", Font.PLAIN, 14));
        
        scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(20,365,940,285);
        
        scrollPane2.setBackground(Color.white);
        scrollPane2.setViewportView(table2);
        panel.add(scrollPane2);
        // adding border around table
         panel3 = new JPanel();
         panel3.setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2),"Returned Book Details ",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(34,139,34)));
         panel3.setBackground(Color.WHITE);
         panel3.setBounds(10,340,960,320);
         panel.add(panel3);
         
         label= new JLabel("Back");
         label.setFont(new Font("Cinzel", Font.PLAIN, 24));
         label.setForeground(Color.BLACK);
         label.setBounds(15,0,150,30);
         label.addMouseListener(new MouseAdapter() {
             
             public void mouseClicked(MouseEvent me){
                 new Home().setVisible(true);
                 setVisible(false);
             
             }
             
             
             
                } );
         panel.add(label);
        
        IssueBook();
       ReturnBook();
        add(panel);
        setVisible(true);
     }
    public void IssueBook(){
        try {
            
        dbConnection connection= new dbConnection();
        ResultSet rs=connection.statement.executeQuery("select* from issue_book");
         table1.setModel(DbUtils.resultSetToTableModel(rs));
        }  
        catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
    public void ReturnBook(){
          try {
            
        dbConnection connection= new dbConnection();
        ResultSet rs=connection.statement.executeQuery("select*from return_book");
        table2.setModel(DbUtils.resultSetToTableModel(rs));
        } 
          catch (Exception e) {
              e.printStackTrace();
        }
    
       
      }
    
    
     
    public void actionPerformed(ActionEvent ae){
    
    
      }
    
    
    public static void main(String[] args) {
        
        new Statics();
    
        
        }
  }
