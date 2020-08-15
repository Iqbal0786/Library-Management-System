
package library.management.system;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AboutUs extends JFrame implements ActionListener{
     
     JLabel label,label2,label3,label4,label5,label6,label7,label8;
    public AboutUs()  {
       
        setSize(750,500);
        setLocation(250,90);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        label= new JLabel(" Welcome to the Digital World !");
        label.setFont(new Font("Senserif", Font.PLAIN, 24));
        label.setForeground(Color.BLUE);
        label.setBounds(200,40,700,30);
        add(label);
        label2= new JLabel("I am Mohammad Iqbal and this project is created using Java core concepts,Java Swing and JDBC  ");
        label2.setFont(new Font("Senserif", Font.PLAIN, 16));
        label2.setForeground(Color.BLACK);
        label2.setBounds(80,110,700,30);
        add(label2);
        label3= new JLabel("Contact Me :  ");
        label3.setFont(new Font("Senserif", Font.PLAIN, 16));
        label3.setForeground(Color.BLACK);
        label3.setBounds(80,140,700,30);
        add(label3);
        
        label4= new JLabel("Email_Id : iqbal240456@gmail.com ");
        label4.setFont(new Font("Senserif", Font.PLAIN, 16));
        label4.setForeground(Color.BLACK);
        label4.setBounds(80,170,700,30);
        add(label4);
        label5= new JLabel("Instagram_UserName : iqbal4546 ");
        label5.setFont(new Font("Senserif", Font.PLAIN, 16));
        label5.setForeground(Color.BLACK);
        label5.setBounds(80,200,700,30);
        add(label5);
        
        label6= new JLabel("If you have any querry or doubts You can mail me or send message directly on my Instagram ");
        label6.setFont(new Font("Senserif", Font.PLAIN, 16));
        label6.setForeground(Color.BLACK);
        label6.setBounds(80,240,700,30);
        add(label6);
        label7= new JLabel("Back");
         label7.setFont(new Font("Cinzel", Font.PLAIN, 24));
         label7.setForeground(Color.BLACK);
         label7.setBounds(15,0,150,30);
         label7.addMouseListener(new MouseAdapter() {
             
             public void mouseClicked(MouseEvent me){
                 new Home().setVisible(true);
                 setVisible(false);
             
             }
             
             
             
                } );
         add(label7);
          setResizable(false);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    
    }
    public static void main(String[] args) {
        new AboutUs();
    }
}
