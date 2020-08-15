
package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class LibraryManagementSystem  extends JFrame implements ActionListener{

   JLabel l1,l2;
    JButton button2;
    public LibraryManagementSystem()  {
        setSize(900,450);
        setLocation(250,90);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
         // adding search Icon
         ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/elib2.jpg"));
         Image image= icon.getImage().getScaledInstance(900, 450, Image.SCALE_DEFAULT);
         ImageIcon icon2= new ImageIcon(image);
        l2 = new JLabel(icon2);
        l2.setBounds(0, 0, 900, 450);
        add(l2);
        button2 = new JButton(" Next ");
        button2.setFont(new Font("senserif", Font.PLAIN, 20));
        button2.setBackground(Color.cyan);
        button2.setBounds(700, 90, 120, 45);
        button2.setForeground(Color.BLACK);
        button2.addActionListener(this);
        add(button2);
        
        
        setVisible(true);
       
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button2) {
            new Login().setVisible(true);
            this.setVisible(false);
            
        }
    }
    
}
