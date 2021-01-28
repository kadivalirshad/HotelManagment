

package hotel.managment.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class ADDDrivers extends JFrame implements ActionListener {
private JPanel p1;
private JTextField t1,t2,t3,t4,t5;
JRadioButton male,Female;
 JButton b1,b2;
    public ADDDrivers() {
     setBounds(200,150,1000,500);
     setResizable(false);
     p1=new JPanel();
     setContentPane(p1);
     p1.setLayout(null);
     
     ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("Image/driver.jpg"));
     JLabel l1=new JLabel(new ImageIcon(mg.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT)));
     l1.setBounds(400,30, 500, 370);
     p1.add(l1);
     
     JLabel l2=new JLabel("ADD Driver");
     l2.setBounds(200,20, 200, 30);
     l2.setForeground(new Color(25,25,100));
     l2.setFont(new Font("tahoma",Font.BOLD,30));
     p1.add(l2);
     
      JLabel l3=new JLabel("Name");
     l3.setBounds(30,70, 200, 20);
     l3.setForeground(new Color(25,25,100));
     l3.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l3);
     
     t1=new JTextField();
     t1.setBounds(210, 70, 170, 25);
     p1.add(t1);
     
      JLabel l4=new JLabel("Age");
     l4.setBounds(30,120, 200, 20);
     l4.setForeground(new Color(25,25,100));
     l4.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l4);
     
     t2=new JTextField();
     t2.setBounds(210, 120,170, 25);
     t2.setBackground(Color.white);
     p1.add(t2);
     
     JLabel l5=new JLabel("Gender");
     l5.setBounds(30,180, 200, 20);
     l5.setForeground(new Color(25,25,100));
     l5.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l5);
     
     male=new JRadioButton("Male");
     Female=new JRadioButton("Female");  
    ButtonGroup br=new ButtonGroup();
    male.setBounds(210, 180,80, 25);
    Female.setBounds(300, 180,80, 25);
     p1.add(male);
     p1.add(Female);
     br.add(male);
     br.add(Female);
     male.setBackground(Color.red);
     Female.setBackground(Color.red);
     
     JLabel l6=new JLabel("Mobile NO");
     l6.setBounds(30,230, 200, 20);
     l6.setForeground(new Color(25,25,100));
     l6.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l6); 
     
     t3=new JTextField();
     t3.setBounds(210, 230, 170, 25);
     p1.add(t3);
     
       
     JLabel l7=new JLabel("Car Name");
     l7.setBounds(30,280, 200, 20);
     l7.setForeground(new Color(25,25,100));
     l7.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l7);
     
      t4=new JTextField();
     t4.setBounds(210, 280, 170, 25);
     p1.add(t4);
     
     JLabel l8=new JLabel("Car Company");
     l8.setBounds(30,330, 200, 20);
     l8.setForeground(new Color(25,25,100));
     l8.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l8);
      
     t5=new JTextField();
     t5.setBounds(210, 330, 170, 25);
     p1.add(t5);
    
     
     b1=new JButton("ADD");
     b1.setBounds(60,380,100, 30);
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.white);
     b1.addActionListener(this);
     p1.add(b1);
     b2=new JButton("BACK");
     b2.setBounds(200,380,100, 30);
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.white);
     b2.addActionListener(this);
     p1.add(b2);     
     getContentPane().setBackground(Color.white);
    }
   public static void main(String[] args )
   {
      new ADDDrivers().setVisible(true);
   }        

    @Override
    public void actionPerformed(ActionEvent e) {
       try{
            if(e.getSource()==b1)
            {
               try{
                   Conn c=new Conn();
                   String s1=t1.getText();
                   String s2=t2.getText();
                   String s3=t3.getText();
                   String s4=t4.getText();
                   String s5=t5.getText();
                   String s6=null;
                     if(male.isSelected())
                     {
                      s6="Male";
                     }   
        
                    else if(Female.isSelected())
                   {
                      s6="Female";
                   } 
                   c.s.executeUpdate("insert into Driver values('"+s1+"','"+s2+"','"+s6+"','"+s3+"','"+s4+"','"+s5+"')");
                   JOptionPane.showMessageDialog(null,"Driver Add SuccesFully");
                   this.setVisible(false);
                  }
               catch(Exception ef)
               {
               
               }      
            }  
            if(e.getSource()==b2)
            {
               this.setVisible(false);
            }    
          }
       catch(Exception ef)
       {
         ef.printStackTrace();
       }   
    }
}

