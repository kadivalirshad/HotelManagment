
package hotel.managment.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Update_Check_Status extends JFrame implements ActionListener {
private JPanel p1;
private JTextField t1,t2,t3,t4,t5;
 JButton b1,b2,b3;
 Choice c;
    public Update_Check_Status() {
     setBounds(200,150,1000,500);
     setResizable(false);
     p1=new JPanel();
     setContentPane(p1);
     p1.setLayout(null);
     
     ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("Image/Check_In.jpg"));
     JLabel l1=new JLabel(new ImageIcon(mg.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT)));
     l1.setBounds(400,30, 500, 370);
     p1.add(l1);
     
     JLabel l2=new JLabel("Update Check_Status");
     l2.setBounds(150,20, 400, 30);
     l2.setForeground(new Color(25,25,100));
     l2.setFont(new Font("tahoma",Font.BOLD,30));
     p1.add(l2);
     
      JLabel l3=new JLabel("Customer_Id");
     l3.setBounds(30,70, 150, 20);
     l3.setForeground(new Color(25,25,100));
     l3.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l3);
     
     c=new Choice();
     try{
          Conn c1=new Conn();
          ResultSet rs=c1.s.executeQuery("Select *from customer");
          while(rs.next())
          {
            c.add(rs.getString("Id_Number"));
          }    
        }
     catch(Exception ef)
     {
       ef.printStackTrace();
     }   
     c.setBounds(210,70,170,20);
     p1.add(c);
      JLabel l4=new JLabel("Room_No");
     l4.setBounds(30,120, 200, 20);
     l4.setForeground(new Color(25,25,100));
     l4.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l4);
     
     t1=new JTextField();
     t1.setBounds(210, 120,170, 25);
     p1.add(t1);
     p1.add(t1);
     
     JLabel l5=new JLabel("Name");
     l5.setBounds(30,180, 200, 20);
     l5.setForeground(new Color(25,25,100));
     l5.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l5);
      t2=new JTextField();
     t2.setBounds(210, 180, 170, 25);
     p1.add(t2);
    
     
     JLabel l6=new JLabel("Check_In");
     l6.setBounds(30,230, 200, 20);
     l6.setForeground(new Color(25,25,100));
     l6.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l6); 
     
    
     t3=new JTextField();
     t3.setBounds(210, 230, 170, 25);
     p1.add(t3);
       
     JLabel l7=new JLabel("Paid Amount");
     l7.setBounds(30,280, 200, 20);
     l7.setForeground(new Color(25,25,100));
     l7.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l7);
     
     t4=new JTextField();
     t4.setBounds(210, 280, 170, 25);
     p1.add(t4);
     
     JLabel l8=new JLabel("Panding Amount");
     l8.setBounds(30,330, 200, 30);
     l8.setForeground(new Color(25,25,100));
     l8.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l8);
     
     t5=new JTextField();
     t5.setBounds(210, 330, 170, 25);
     p1.add(t5);
    
     
     b1=new JButton("Check");
     b1.setBounds(60,400,100, 30);
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.white);
     b1.addActionListener(this);
     p1.add(b1);
     b2=new JButton("Update");
     b2.setBounds(180,400,100, 30);
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.white);
     b2.addActionListener(this);
     p1.add(b2);     
     b3=new JButton("Back");
     b3.setBounds(300,400,100, 30);
     b3.setBackground(Color.BLACK);
     b3.setForeground(Color.white);
     b3.addActionListener(this);
     p1.add(b3);     
     getContentPane().setBackground(Color.white);
    }
   public static void main(String[] args )
   {
      new Update_Check_Status().setVisible(true);
   }        

    @Override
    public void actionPerformed(ActionEvent e) {
      
            if(e.getSource()==b1)
            {
               try{
                   Conn c1=new Conn();
                   String pending=null;
                   String room=null;
                    ResultSet rs=c1.s.executeQuery("select *from customer where Id_Number='"+c.getSelectedItem()+"'");
                    while(rs.next())
                    {
                       t1.setText(rs.getString("Room_No"));
                       t2.setText(rs.getString("Name"));
                       t3.setText(rs.getString("Check_In"));
                       t4.setText(rs.getString("Deposite"));
                       pending=rs.getString("Deposite");
                       room=rs.getString("Room_No");
                    }  
                    ResultSet rs2=c1.s.executeQuery("select *from room where Room_No='"+room+"'");
                    while(rs2.next())
                    {
                      int s1=Integer.parseInt(pending);
                      int s2=Integer.parseInt(rs2.getString("Price"));
                      t5.setText(Integer.toString(s2-s1));
                    }
                   
                  }
               catch(Exception ef)
               {
                 ef.printStackTrace();
               }      
            }  
           else if(e.getSource()==b2)
            {
                try{
                    Conn c1=new Conn();
                    String s1=t1.getText();
                    String s2=t2.getText();
                    String s3=t3.getText();
                    String s4=t4.getText();
                    
                    c1.s.executeUpdate("update customer set Room_No='"+s1+"',Name='"+s2+"',Check_In='"+s3+"',Deposite='"+s4+"' where Id_Number='"+c.getSelectedItem()+"' ");
                    JOptionPane.showMessageDialog(null,"Details Update SuccecsFul");
                   }
                catch(Exception ef)
                {
                    
                  
                }    
                  
            }
            else if(e.getSource()==b3)
            {
              new Reciption().setVisible(true);
              this.setVisible(false);
            }  
          }
}

