
package hotel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4;
    JPasswordField pass;
    JTextField t1;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;
    Login()
    {
      l1=new JLabel("UserName");
      l4=new JLabel("   ");
      l2=new JLabel("Password");
      pass=new JPasswordField(15);
      t1=new JTextField(15);
     
     
      
     
      b1 =new JButton("Login");
      b1.addActionListener(this);
      
      b2=new JButton("Cancel");
       b2.addActionListener(this);
       
     
        ImageIcon c3=new ImageIcon(ClassLoader.getSystemResource("Image/login.jpg"));
        Image i3=c3.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i4=new ImageIcon(i3);
        l3=new JLabel(i4);
       
      setLayout(new BorderLayout());
      
      p1=new JPanel();  
      p2=new JPanel();
      p4=new JPanel();
      
      add(l3,BorderLayout.WEST);
      p2.add(l1);
      p2.add(t1);
      p2.add(l2);
      p2.add(pass);
      add(p2,BorderLayout.CENTER);
      
      p4.add(b1);
      p4.add(b2);
      add(p4,BorderLayout.SOUTH);
     
      p1.add(l4);
      add(p1,BorderLayout.NORTH);
      p2.setBackground(Color.white);
      p4.setBackground(Color.white);
      p1.setBackground(Color.white);
      //Dimension sa=Toolkit.getDefaultToolkit().getScreenSize();
     setSize(450,250);
      setLocation(100,100);
      setVisible(true);
       setResizable(false);
      getContentPane().setBackground(Color.white);
      setDefaultCloseOperation(3);
    }
    
    public static void main(String[] args)
    {
      new Login().setVisible(true);
    }        

   
    public void actionPerformed(ActionEvent e) 
    {
         if(e.getSource()==b1)
        {
         try{
            
             Conn c=new Conn();
             String a=t1.getText();
             String b=pass.getText();
             String q="select * from login where username='"+a+"' and password='"+b+"' ";
             ResultSet rs=c.s.executeQuery(q);
             if(rs.next())
             {
                new Dashbord().setVisible(true);
                this.setVisible(false);
             }    
             else
             {
               JOptionPane.showMessageDialog(null,"Invalid UserName or Password");
              
             }
            }
                
           
        catch(Exception ef)
        {
           JOptionPane.showMessageDialog(this,"Check Connection......");
        }
      }   
          else if(e.getSource()==b2)
             {
               System.exit(0);
             }   
    }
}

