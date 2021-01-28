
package hotel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.ResultSet;
public class Customer_Form  extends JFrame implements ActionListener{
   JTextField t1,t2,t3,t4,t5;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8;
   JRadioButton male,female;
   ButtonGroup b;
   JButton b1,b2;
   JComboBox cb;
   Choice c;
    public Customer_Form() {
      JLabel logo=new JLabel("Customer Details");
      logo.setBounds(100,10,300,30);
      setResizable(false);
      logo.setFont(new Font("tahoma",Font.PLAIN,30));
      add(logo);
      l1=new JLabel("ID_Proof");
      l1.setBounds(10,50, 100,30);
      l1.setFont(new Font("tahoma",Font.PLAIN,20));
      add(l1);
      
      cb=new JComboBox(new String[]{"PassPort","Adhar_Card","Voter_Id","Driving_Licence"});
      cb.setBounds(120,50,200,25);
      cb.setBackground(Color.white);
      add(cb);
      
      l2=new JLabel("ID_Number");
      l2.setBounds(10,100, 150,30);
      l2.setFont(new Font("tahoma",Font.PLAIN,20));
      add(l2);
      
      t1=new JTextField();
      t1.setBounds(120, 100,200,25);
      add(t1);
      
      l3=new JLabel("Name");
      l3.setBounds(10,150, 100,30);
      l3.setFont(new Font("tahoma",Font.PLAIN,20));
      add(l3);
      
      t2=new JTextField();
      t2.setBounds(120, 150,200,25);
      add(t2);
      
      l4=new JLabel("Gender");
      l4.setBounds(10,200, 100,30);
      l4.setFont(new Font("tahoma",Font.PLAIN,20));
      add(l4);
      
      male=new JRadioButton("Male");
      male.setBounds(120,200,90,25);
      add(male);
      
      female=new JRadioButton("Female");
      female.setBounds(220,200,100,25);
      add(female);
      
      b=new ButtonGroup();
      b.add(male);
      b.add(female);
   
      l5=new JLabel("Mobile_No");
      l5.setBounds(10,250, 100,30);
      l5.setFont(new Font("tahoma",Font.PLAIN,20));
      add(l5);
      
      t3=new JTextField();
      t3.setBounds(120, 250,200,25);
      add(t3);
      
      l6=new JLabel("Room_No");
      l6.setBounds(10,300, 100,30);
      l6.setFont(new Font("tahoma",Font.PLAIN,20));
      add(l6);
      
      c=new Choice();
      try{
           Conn c1=new Conn();
           ResultSet rs=c1.s.executeQuery("select *from room");
           while(rs.next())
           {
             c.add(rs.getString("Room_No"));
           }    
         }
      catch(Exception ef)
      {
        ef.printStackTrace();
      } 
      c.setBounds(120, 300,200,30);
      add(c);
      
      l7=new JLabel("Check_In");
      l7.setBounds(10,350, 100,30);
      l7.setFont(new Font("tahoma",Font.PLAIN,20));
      add(l7);
      
      t4=new JTextField();
      t4.setBounds(120,350,200,25);
      add(t4);
      
      l8=new JLabel("Deposite");
      l8.setBounds(10,400,100,30);
      l8.setFont(new Font("tahoma",Font.PLAIN,20));
      add(l8);
      
      t5=new JTextField();
      t5.setBounds(120,400,200,25);
      add(t5);
      ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("Image/customer.png"));
      JLabel l9=new JLabel(new ImageIcon(mg.getImage().getScaledInstance(300,550,Image.SCALE_DEFAULT)));
      l9.setBounds(400,0, 300,550);
      add(l9);
      b1=new JButton("Submit");
      b1.setBounds(50,450,100,25);
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.white);
      b1.addActionListener(this);
      add(b1);
      
      b2=new JButton("Back");
      b2.setBounds(200,450,100,25);
      b2.setBackground(Color.BLACK);
      b2.setForeground(Color.white);
      b2.addActionListener(this);
      add(b2);
      
      setBounds(100,100,800,550);
      getContentPane().setBackground(Color.white);
      setLayout(null);
      setVisible(true);
    }
 public static void main(String[] args)
 {
   new Customer_Form().setVisible(true);
 }       
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
          String s1=(String) cb.getSelectedItem();
          String s2=t1.getText();
          String s3=t2.getText();
          String s4="";
          if(male.isSelected())
          {
            s4="Male";
          } 
          else if(female.isSelected())
          {
            s4="Female";
          }
          String s5=t3.getText();
          String s6=c.getSelectedItem();
          String s7=t4.getText();
          String s8=t5.getText();
          try{
               Conn c1=new Conn();
               c1.s.executeUpdate("insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')");
               c1.s.executeUpdate("Update room set Room_Status='Book' where Room_No='"+s6+"'");
               JOptionPane.showMessageDialog(null,"Booking Succes");
               
            }
          catch(Exception ef)
          {
            ef.printStackTrace();
          }
        }  
        else if(e.getSource()==b2)
        {
          new Reciption().setVisible(true);
          this.setVisible(false);
        }    
    }
    
}
