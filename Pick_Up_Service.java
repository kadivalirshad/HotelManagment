
package hotel.managment.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public class Pick_Up_Service extends JFrame implements ActionListener{
   JButton b1,b2;
   JCheckBox ck;
   Choice c;
   JTable t;
    public Pick_Up_Service() {
       JLabel l1=new JLabel("Pick_Up_Services");
       l1.setFont(new Font("Arial",Font.PLAIN,30));
       l1.setForeground(Color.BLUE);
       l1.setBounds(250,10,300,30);
       add(l1);
       
       JLabel l2=new JLabel("Car Name");
       l2.setFont(new Font("Arial",Font.PLAIN,20));
       l2.setForeground(Color.BLUE);
       l2.setBounds(200,100,100,30);
       add(l2);
       
    
       c=new Choice();
       try{
             Conn c1=new Conn();
             ResultSet rs=c1.s.executeQuery("Select *from driver");
             while(rs.next())
             {
               c.add(rs.getString("Car_Name"));
             }    
          }
       catch(Exception ef)
       {
       
       }    
       c.setBounds(350,100, 200,30);
       add(c);
       
     
       t=new JTable();
       t.setBounds(0,150,800,250);
       add(t);
       
      b1=new JButton("Show");
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.white);
      b1.setBounds(200,420,100,30);
      b1.addActionListener(this);
      add(b1);
      
      b2=new JButton("Exit");
      b2.setBackground(Color.BLACK);
      b2.setForeground(Color.white);
      b2.setBounds(400,420,100,30);
      b2.addActionListener(this);
      add(b2);
      
       setLayout(null);
       setResizable(false);
      setBounds(200,200,800,500);
      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
           try{
                 Conn c1=new Conn();
                 ResultSet rs;  
                   rs=c1.s.executeQuery("select *from driver where  Car_Name='"+c.getSelectedItem()+"'");
                   t.setModel(DbUtils.resultSetToTableModel(rs));
                
              }
           catch(Exception ef)
           {
              System.out.println(ef);
           }    
        }
        else if(e.getSource()==b2)
        {
            new Reciption().setVisible(true);
            this.setVisible(false);
        }    
    }
   public static void main(String[] args)
   {
     new Pick_Up_Service().setVisible(true);
   }        
}
