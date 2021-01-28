
package hotel.managment.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public class Search_Room extends JFrame implements ActionListener{
   JButton b1,b2;
   JCheckBox ck;
   JComboBox c;
   JTable t;
    public Search_Room() {
       JLabel l1=new JLabel("Search Room");
       l1.setFont(new Font("Arial",Font.PLAIN,30));
       l1.setForeground(Color.BLUE);
       l1.setBounds(200,10,200,30);
       add(l1);
       
       JLabel l2=new JLabel("Room_Type");
       l2.setFont(new Font("Arial",Font.PLAIN,20));
       l2.setForeground(Color.BLUE);
       l2.setBounds(50,100,200,30);
       add(l2);
       
       JLabel l3=new JLabel("Only Availabel Room");
       l3.setFont(new Font("Arial",Font.PLAIN,20));
       l3.setForeground(Color.BLUE);
       l3.setBounds(500,100,200,30);
       add(l3);
       
       c=new JComboBox(new String[]{"Double","Single"});
       c.setBounds(170,100, 200,30);
       add(c);
       
       ck=new JCheckBox();
       ck.setBounds(470,100,30,30);
       add(ck);
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
                 if(ck.isSelected())
                 {    
                   rs=c1.s.executeQuery("select *from room where Room_Status='Availabel' And Bed_Type='"+c.getSelectedItem()+"'");
                   t.setModel(DbUtils.resultSetToTableModel(rs));
                 }else
                 {
                   rs=c1.s.executeQuery("select *from room where Bed_Type='"+c.getSelectedItem()+"'");
                   t.setModel(DbUtils.resultSetToTableModel(rs));
                 }   
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
     new Search_Room().setVisible(true);
   }        
}
