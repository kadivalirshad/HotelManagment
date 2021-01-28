
package hotel.managment.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
public class Check_Out extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    JTextField t1;
    Choice c;
    public Check_Out() {
       JLabel l1=new JLabel("Check_Out");
       l1.setFont(new Font("Arial",Font.PLAIN,30));
       l1.setForeground(Color.BLUE);
       l1.setBounds(100,10,200,30);
       add(l1);
       
       JLabel l2=new JLabel("Customer_Id");
       l2.setFont(new Font("Arial",Font.PLAIN,20));
       l2.setForeground(Color.BLUE);
       l2.setBounds(40,80,120,30);
       add(l2);
       
       c=new Choice();
       try{
            Conn c1=new Conn();
            ResultSet rs=c1.s.executeQuery("select *from customer where Room_No In(select Room_No from room where Room_Status=\"Book\")");
            while(rs.next())
            {
              c.add(rs.getString("Id_Number"));
            } 
          }
       catch(Exception ef)
       {
         ef.printStackTrace();
       }  
       c.setBounds(170,80,200,30);
       add(c);
       
       JLabel l3=new JLabel("Room_No");
       l3.setFont(new Font("Arial",Font.PLAIN,20));
       l3.setForeground(Color.BLUE);
       l3.setBounds(40,130,120,30);
       add(l3);
       
       t1=new JTextField();
       t1.setBounds(170,130,200,30);
       add(t1);
       
       b1=new JButton("Show");
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.white);
       b1.setBounds(100,200,100,30);
       b1.addActionListener(this);
       add(b1);
       
        b2=new JButton("Check_Out");
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.white);
       b2.setBounds(250,200,100,30);
       b2.addActionListener(this);
       add(b2);
       
        b3=new JButton("Exit");
       b3.setBackground(Color.BLACK);
       b3.setForeground(Color.white);
       b3.setBounds(170,250,100,30);
       b3.addActionListener(this);
       add(b3);
       
       ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("Image/check_Out.jpg"));
       JLabel l4=new JLabel(new ImageIcon(mg.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT)));
       l4.setBounds(380,0,300,400);
       add(l4);
       setLayout(null);
        setResizable(false);
       setBounds(200,150,700,400);
       setVisible(true);
    }
   public static void main(String[] args)
   {
     new Check_Out().setVisible(true);
   }        

    @Override
    public void actionPerformed(ActionEvent e) {
        Conn c1=new Conn(); 
         if(e.getSource()==b1)
      {
         try{
             
              ResultSet rs=c1.s.executeQuery("select *from customer where Id_Number='"+c.getSelectedItem()+"'");
              while(rs.next())
              {
                t1.setText(rs.getString("Room_No"));
              }    
            }
         catch(Exception ef)
         {
            JOptionPane.showMessageDialog(null,ef);
         }   
      }   
      else if(e.getSource()==b2)
      {
          try{
               c1.s.executeUpdate("Update room set Room_Status='Availabel' where Room_No="+t1.getText());
               JOptionPane.showMessageDialog(null,"Check_Out SuccesFull");
               this.setVisible(false);
             }
          catch(Exception ef)
          {
              JOptionPane.showMessageDialog(null,"Try Again");
          }      
      }
      else if(e.getSource()==b3)
      {
          new Reciption().setVisible(true);
          this.setVisible(false);
      }    
    }
}
