package hotel.managment.system;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.*;
public class Employee_Info extends JFrame implements ActionListener{
   JTable t;
   JButton b1,b2,b3;
    public Employee_Info() {
      setBounds(100,100,1000,550);
       setResizable(false);
      setLayout(null);
      
      t=new JTable();
      t.setBounds(0,30, 1000,450);
      add(t);
      JLabel l1=new JLabel("Name");
      l1.setBounds(20, 0, 100,30);
      add(l1);
      
        JLabel l2=new JLabel("Age");
      l2.setBounds(180, 0, 100,30);
      add(l2);
      
        JLabel l3=new JLabel("Gender");
      l3.setBounds(290, 0, 100,30);
      add(l3);
      
        JLabel l4=new JLabel("Job");
      l4.setBounds(410, 0, 100,30);
      add(l4);
      
        JLabel l5=new JLabel("Salary");
      l5.setBounds(550, 0, 100,30);
      add(l5);
      
        JLabel l6=new JLabel("Phone");
      l6.setBounds(650, 0, 100,30);
      add(l6);
      
        JLabel l7=new JLabel("Adhar");
      l7.setBounds(780, 0, 100,30);
      add(l7);
      
        JLabel l8=new JLabel("Email");
      l8.setBounds(900, 0, 100,30);
      add(l8);
      
      b1=new JButton("Load Data");
      b2=new JButton("Exit");
      b3=new JButton("Print");
      b1.setBounds(300, 480, 100, 30);
      b2.setBounds(450, 480, 100, 30);
      b3.setBounds(600,480 ,100,30);
      b1.setBackground(Color.BLACK);
      b2.setBackground(Color.BLACK);
      b3.setBackground(Color.BLACK);
      b1.setForeground(Color.white);
      b2.setForeground(Color.white);
      b3.setForeground(Color.white);
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      add(b2);
      add(b1);
      add(b3);
      setVisible(true);
    }
  public static void main(String[] args)
  {
     new Employee_Info().setVisible(true);
  }        

    @Override
    public void actionPerformed(ActionEvent e) {
         Conn c1=new Conn();
       if(e.getSource()==b1)
       {
           try{
                
                 ResultSet rs=c1.s.executeQuery("select *from addemployee");
                 t.setModel(DbUtils.resultSetToTableModel(rs));
                 
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
       else if(e.getSource()==b3)
       {
             try {
                 t.print();
             } catch (PrinterException ex) {
                ex.printStackTrace();
             }
       }    
    } 
  
}
