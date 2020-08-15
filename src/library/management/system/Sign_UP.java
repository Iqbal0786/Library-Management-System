
package library.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class Sign_UP  extends JFrame implements ActionListener{
       JPanel panel;
       JTextField jt1,jt2,jt3;
       JPasswordField password;
       JLabel l1,l2,l3,l4,l5,l6;
       Choice question;
       JButton button,button2;
       
    public Sign_UP()  {
        super("Sign Up here");
        setSize(700,600);
        setLocation(250,90);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
          setResizable(false);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(8,2,30,30));
       // panel.setBorder(new TitledBorder(new LineBorder(new Color(128,128,0), 2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(34,139,34)));
        l1 = new JLabel("User Name :");
        l1.setFont(new Font("senserif",Font.BOLD, 16));
        panel.add(l1);
        jt1 = new JTextField();
        jt1.setFont(new Font("senserif",Font.PLAIN, 14));
        panel.add(jt1);
        
        l2 = new JLabel(" Name :");
        l2.setFont(new Font("senserif",Font.BOLD, 16));
        panel.add(l2);
        jt2 = new JTextField();
        jt2.setFont(new Font("senserif",Font.PLAIN, 14));
        panel.add(jt2);
        
        l3 = new JLabel("Password : ");
        l3.setFont(new Font("senserif",Font.BOLD, 16));
        panel.add(l3);
        password = new JPasswordField();
        panel.add(password);
         
        l4 = new JLabel("Security Question :");
        l4.setFont(new Font("Senserif",Font.BOLD, 16));
        panel.add(l4);
        question = new Choice();
        question.add("What is your fevorate Food ?");
        question.add("Who is your Best Friend ?");
        question.add("Who is your SuperHero?");
        question.add("Your Old School Name");
        panel.add(question);
        l5 = new JLabel("Your Answer :");
        l5.setFont(new Font("Senserif", Font.BOLD, 16));
        panel.add(l5);
         jt3 = new JTextField();
         jt3.setFont(new Font("Senserif", Font.PLAIN, 14));
        panel.add(jt3);
        button = new JButton("Sign Up");
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.addActionListener(this);
        panel.add(button);
        button2 = new JButton("Back");
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.addActionListener(this);
        panel.add(button2);
        
        
        
        add(panel,"Center");
        
        // adding images
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/digital2.png"));
        Image image= icon.getImage().getScaledInstance(300,350,Image.SCALE_DEFAULT);
        ImageIcon icon2= new ImageIcon(image);
        l6 = new JLabel(icon2);
       add(l6,"West");
        
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
      public void actionPerformed(ActionEvent ae){
          if (ae.getSource()== button) {
              String userId1=jt1.getText();
              String name1= jt2.getText();
              char pass1[] = password.getPassword();
              String password1= new String(pass1);
              String securityQuestion= question.getSelectedItem();
              String answer1= jt3.getText();
              Validation v = new Validation();
              if (!v.userIdValidate(userId1)) {
                  
                  JOptionPane.showMessageDialog(null, "UserId is not Valid!!! Your UserId will be your Email Id","Error",JOptionPane.ERROR_MESSAGE);
                  
                 }
              else if (!v.nameValidate(name1)) {
                   JOptionPane.showMessageDialog(null, "Name is not Valid!!! Only English letters is allow","Error",JOptionPane.ERROR_MESSAGE);
              }
              else if (!v.passwordValidate(password1)) {
                   JOptionPane.showMessageDialog(null, "Password is not Valid!!! Your passowrd lenght must be between 8 to 16","Error",JOptionPane.ERROR_MESSAGE);
              }
              else if (!v.AnswerValidate(answer1)) {
                   JOptionPane.showMessageDialog(null, "Answer is not Valid!!! Only English latters is allow","Error",JOptionPane.ERROR_MESSAGE);
              }
              else{
                  
                try {
                  dbConnection connection= new dbConnection();
                  connection.statement.executeUpdate("insert into sign_up values('"+userId1+"','"+name1+"','"+password1+"','"+securityQuestion+"','"+answer1+"')");
                  JOptionPane.showMessageDialog(null,"Account Created Successfully ");
                  jt1.setText("");
                  jt2.setText("");
                  jt3.setText("");
                  password.setText("");
                  
                } 
              catch (Exception e) {
                  e.printStackTrace();
              }
              
          }
             
       }
           else{
              this.setVisible(false);
          Login l= new Login();
          
          }
              
    
      }
    
    public static void main(String [] args){
    
       new Sign_UP();
    
    }
    
}
