
package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;


public class Readme  extends  JFrame{
      JLabel label,label2;
      JTextArea jTextArea;
      JScrollPane scrollPane;
    public Readme()  {
        setSize(900,450);
        setLocation(240,55);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        label= new JLabel(" Library Management System !");
        label.setFont(new Font("Senserif", Font.PLAIN, 24));
        label.setForeground(Color.BLUE);
        label.setBounds(200,40,700,30);
        add(label);
        jTextArea= new JTextArea();
        jTextArea.setBounds(0,90,900,400);
        jTextArea.setEditable(false);
        jTextArea.setFont(new Font("Senserif", Font.PLAIN, 20));
        jTextArea.setBackground(Color.yellow);
        jTextArea.append(" This Library Management System is created with the help of Java Swing concepts ,\n JDBC and Mysql Data Base.The purpose of this java made application is to provide librarian to \n"
                + " perform all the operations Digitally with less Effort and welll accuracy."
                + " We have made this \n application with a UserFriendly Interface.Though we have tried our best to make this application"
                + "\n but incase any error occurs Contact us at our official mail Id iqbal240456@gmail.com");
        add(jTextArea);
        label2= new JLabel("Back");
         label2.setFont(new Font("Cinzel", Font.PLAIN, 24));
         label2.setForeground(Color.BLACK);
         label2.setBounds(15,0,150,30);
         label2.addMouseListener(new MouseAdapter() {
             
             public void mouseClicked(MouseEvent me){
                 new Home().setVisible(true);
                 setVisible(false);
             
             }
             
             
             
                } );
         add(label2);
          setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Readme();
    }
}
