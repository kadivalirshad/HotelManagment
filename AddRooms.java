
package hotel.managment.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener {
private JComboBox c1,c2,c3;
private JPanel p1;
private JTextField t1,t2;
 JButton b1,b2;
    public AddRooms() {
     setBounds(200,150,1000,500);
     setResizable(false);
     p1=new JPanel();
     setContentPane(p1);
     p1.setLayout(null);
     
     ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("Image/room.jpg"));
     JLabel l1=new JLabel(new ImageIcon(mg.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT)));
     l1.setBounds(400,30, 500, 370);
     p1.add(l1);
     
     JLabel l2=new JLabel("ADD ROOMS");
     l2.setBounds(200,20, 200, 30);
     l2.setForeground(new Color(25,25,100));
     l2.setFont(new Font("tahoma",Font.BOLD,30));
     p1.add(l2);
     
      JLabel l3=new JLabel("Room Number");
     l3.setBounds(30,70, 200, 20);
     l3.setForeground(new Color(25,25,100));
     l3.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l3);
     
     t1=new JTextField();
     t1.setBounds(210, 70, 170, 25);
     p1.add(t1);
     
      JLabel l4=new JLabel("Availability");
     l4.setBounds(30,120, 200, 20);
     l4.setForeground(new Color(25,25,100));
     l4.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l4);
     
     c1=new JComboBox(new String[]{"Availabel","Occupied"});
     c1.setBounds(210, 120,170, 25);
     c1.setBackground(Color.white);
     p1.add(c1);
     
     JLabel l5=new JLabel("Room Status");
     l5.setBounds(30,180, 200, 20);
     l5.setForeground(new Color(25,25,100));
     l5.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l5);
     
     c2=new JComboBox(new String[]{"AC","NON AC"});
     c2.setBounds(210, 180,170, 25);
     c2.setBackground(Color.white);
     p1.add(c2);
     
     JLabel l6=new JLabel("Price");
     l6.setBounds(30,230, 200, 20);
     l6.setForeground(new Color(25,25,100));
     l6.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l6); 
     
     t2=new JTextField();
     t2.setBounds(210, 230, 170, 25);
     p1.add(t2);
     
       
     JLabel l7=new JLabel("Bed Type");
     l7.setBounds(30,280, 200, 20);
     l7.setForeground(new Color(25,25,100));
     l7.setFont(new Font("tahoma",Font.BOLD,20));
     p1.add(l7);
     
     c3=new JComboBox(new String[]{"Single","Double"});
     c3.setBounds(210, 280,170, 25);
     c3.setBackground(Color.white);
     p1.add(c3);
     
     b1=new JButton("ADD");
     b1.setBounds(60,350,100, 30);
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.white);
     b1.addActionListener(this);
     p1.add(b1);
     b2=new JButton("BACK");
     b2.setBounds(200,350,100, 30);
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.white);
     b2.addActionListener(this);
     p1.add(b2);     
     getContentPane().setBackground(Color.white);
    }
   public static void main(String[] args )
   {
      new AddRooms().setVisible(true);
   }        

    @Override
    public void actionPerformed(ActionEvent e) {
       try{
            if(e.getSource()==b1)
            {
               try{
                   Conn c=new Conn();
                   String s1=t1.getText();
                   String s2=(String)c1.getSelectedItem();
                   String s3=(String)c2.getSelectedItem();
                   String s4=t2.getText();
                   String s5=(String)c3.getSelectedItem();
                   
                   c.s.executeUpdate("insert into room values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
                   JOptionPane.showMessageDialog(null,"Room Add SuccesFully");
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
