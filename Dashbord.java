
package hotel.managment.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class Dashbord extends JFrame {
    public Dashbord()
    {
         setLayout(null); 
       JMenuBar mb=new JMenuBar();
       setJMenuBar(mb);
       
       JMenu m1=new JMenu("Hotel Managment");
         mb.add(m1);
       JMenuItem mt1=new JMenuItem("Reciption");
       m1.add(mt1);
       
       JMenu m2=new JMenu("Admin");
       mb.add(m2);
       
       JMenuItem it1=new JMenuItem("Add Employee");
       JMenuItem it2=new JMenuItem("Add Rooms");
       JMenuItem it3=new JMenuItem("Add Drivers");
       
       m2.add(it1);
       m2.add(it2);
       m2.add(it3);
       
       mt1.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent e)
          {
              try{
                     new Reciption().setVisible(true);
                 }
              catch(Exception ef){
                     ef.printStackTrace();
                  }
          
          }        
       }
       );
       
        it1.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent e)
          {
              try{
                     new AddEmployee().setVisible(true);
                 }
              catch(Exception ef){
                     ef.printStackTrace();
                  }
          
          }        
       }
       );
        
         it2.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent e)
          {
              try{
                     new AddRooms().setVisible(true);
                 }
              catch(Exception ef){
                     ef.printStackTrace();
                  }
          
          }        
       }
       );
         
          it3.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent e)
          {
              try{
                     new ADDDrivers().setVisible(true);
                 }
              catch(Exception ef){
                     ef.printStackTrace();
                  }
          
          }        
       }
       );
          
       ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Image/hotel.jpg")) ;
       JLabel l1=new JLabel(new ImageIcon(img.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT)));
       l1.setBounds(0, 0, 1950, 1000);
       add(l1);
       
       JLabel l2=new JLabel("Welcome To Hotel Blue Night");
       l2.setBounds(350, 30, 1000, 85);
       l2.setFont(new Font("Tahoma",Font.PLAIN,50));
       l2.setForeground(Color.white);
       l1.add(l2);
     
      setSize(1950,1090);
      setVisible(true);
      setDefaultCloseOperation(3);
      getContentPane().setBackground(Color.white);
    }        
    public static void main(String[] args)
    {
       new Dashbord().setVisible(true);
    }        
}
