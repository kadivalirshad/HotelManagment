
package hotel.managment.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class HotelManagmentSystem extends JFrame implements ActionListener {
     JLabel l1;
     JButton b1,b2;
    HotelManagmentSystem()
    {
       setBounds(100,150,1200,500);
       
       setLayout(null);
       setDefaultCloseOperation(3);
       l1=new JLabel("");
       setUndecorated(true);
       b1=new JButton("LOGIN");
       b2=new JButton("Exit");
       b1.setBackground(Color.BLUE);
       b1.setForeground(Color.white);
       b2.setBackground(Color.BLUE);
       b2.setForeground(Color.white);
       
       
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image/rktkn-ssOtyGE8CyE-unsplash.jpg"));
      ImageIcon i2=new ImageIcon(i1.getImage().getScaledInstance(1200, 500,Image.SCALE_DEFAULT));
       l1=new JLabel(i2);
      l1.setBounds(0, 0, 1200, 500);
        
      JLabel lid=new JLabel("HOTEL BLUE NIGHT");
      lid.setBounds(250, 50, 1500, 100);
      lid.setForeground(Color.RED);
      lid.setFont(new Font("serif",Font.ROMAN_BASELINE,70));
      l1.add(lid);
      
      b1.setBounds(900, 470, 170, 30);
      b1.setFont(new Font("serif",Font.BOLD,30));
      
       b2.setBounds(1100, 470, 100, 30);
      b2.setFont(new Font("serif",Font.BOLD,30));
      l1.add(b1);
      add(l1);
      l1.add(b2);
      b1.addActionListener(this);
      b2.addActionListener(this);
      setVisible(true);
      while(true)
      {
         lid.setVisible(false);
         
         try{
               Thread.sleep(500);
            }
         catch(Exception ef){}
         
         lid.setVisible(true);
         try{
              Thread.sleep(500);
            }
         catch(Exception ef){}
         
      }    
   
    }
    
    public static void main(String[] args) {
       HotelManagmentSystem  hm=new HotelManagmentSystem();
       hm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      new Login().setVisible(true);
      this.setVisible(false);
      
      if(e.getSource()==b2)
      {
         System.exit(0);
      }    
    }
    
}
