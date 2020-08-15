
package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Student_Details extends JFrame implements ActionListener,KeyListener{
      JLabel l1,l2;
      JScrollPane scrollPane;
      JTable table;
      JButton button1,button2;
      JTextField jt1;
      DefaultTableModel model;
      TableRowSorter<TableModel> rowSorter;
    public Student_Details(){
        
        super("Student Detail");
        setSize(800,650);
        setLocation(250,40);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
          setResizable(false);
        setLayout(null);
         
         l1= new JLabel("Back");
         l1.setFont(new Font("Cinzel", Font.PLAIN, 24));
         l1.setForeground(Color.BLACK);
         l1.setBounds(15,0,150,30);
         l1.addMouseListener(new MouseAdapter() {
             
             public void mouseClicked(MouseEvent me){
                 new Home().setVisible(true);
                 setVisible(false);
             
             }
             
             
             
                } );
         
         add(l1);
        // adding search Icon
         ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/search2.png"));
         Image image= icon.getImage().getScaledInstance(60, 55, Image.SCALE_DEFAULT);
         ImageIcon icon2= new ImageIcon(image);
        l2 = new JLabel(icon2);
        l2.setBounds(250, 25, 60, 60);
        add(l2);
        jt1 = new JTextField();
        jt1.setBounds(25,40,200,35);
        jt1.addKeyListener(this);
        add(jt1);
        
         
        button1 = new JButton("Delete");
        button1.setFont(new Font("Cinzel", Font.PLAIN, 20));
        button1.setBackground(new Color(0, 204, 153));
        button1.setBounds(500, 35, 170, 40);
        button1.setForeground(Color.BLACK);
        button1.addActionListener(this);
        add(button1);
         
         //Adding Table
         
         table = new JTable();
         scrollPane = new JScrollPane(table);
         scrollPane.setBounds(20,90,750,490);
         scrollPane.setBackground(Color.WHITE);
         add(scrollPane);
        
        StudentDetails();
        setVisible(true);
       }
    public void StudentDetails(){
          try{
            dbConnection connection= new dbConnection();
            ResultSet rs= connection.statement.executeQuery("select*from add_student");
             table.setModel(DbUtils.resultSetToTableModel(rs));
                  
              
            }
          catch(Exception e){
          
             e.printStackTrace();
          
               }
       
         }
    public static void main(String[] args) {
        new Student_Details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==button1) {
            

      model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        String deleteId = model.getValueAt(row, 0).toString();

       
            try {
                 dbConnection connection= new dbConnection();
                  connection.statement.executeUpdate("delete from add_book where Book_Id='"+deleteId+"'");
                  model.removeRow(row);
            
            JOptionPane.showMessageDialog(null, "Congratulation !! Student has  successfullly Deleted");
            } 
            catch (Exception e1) {
                e1.printStackTrace();
            }


            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
         if (e.getSource()==jt1) {
             model = (DefaultTableModel)table.getModel();
              rowSorter= new TableRowSorter<>(model);
              table.setRowSorter(rowSorter);
              String text = jt1.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
