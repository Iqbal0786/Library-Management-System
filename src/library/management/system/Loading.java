
package library.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.*;


public class Loading extends JFrame implements Runnable{
         private JPanel panel;
         private JProgressBar progressBar;
         private JLabel l1,l2,l3,l4;
         Thread  thread;
    public Loading()  {
           super("Loading........");
           thread = new Thread( this);
           setSize(600,400);
           setLocation(250,90);
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           
           panel= new JPanel();
           panel.setLayout(null);
           panel.setBackground(Color.WHITE);
           l1 = new JLabel("Smart E-Library VS 1.0");
           l1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
           l1.setForeground(new Color(72,209,204));
           l1.setBounds(120,15,400,90);
           panel.add(l1);
           progressBar= new JProgressBar();
           progressBar.setFont(new Font("Thomba", Font.PLAIN, 16));
           progressBar.setForeground(Color.GREEN);
           progressBar.setStringPainted(true);
           progressBar.setBounds(120,140,300,20);
           panel.add(progressBar);
           l2 = new JLabel("Please Wait..........");
           l2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
           l2.setForeground(new Color(160,82,45));
           l2.setBounds(190,165,400,90);
           panel.add(l2);
           
           add(panel);
           getContentPane().setBackground(Color.WHITE);
           setUploading();
           setVisible(true);
        }
    
    public void setUploading(){
             thread.start();
    
       }
    
    
    public void run(){
         try {
            for(int i=0;i<=100;i++){
                int max= progressBar.getMaximum();
                int min= progressBar.getValue();
                if (min<max) {
                    progressBar.setValue(progressBar.getValue()+1);
                }
                else{
                //i=201;
                this.setVisible(false);
                new Home().setVisible(true);
                }
                thread.sleep(50);
             }
        } 
         catch (Exception e) {
             e.printStackTrace();
        }
    
       }
    
    public static void main(String[] args) {
        new Loading();
    }
}
