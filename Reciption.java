
package hotel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Reciption extends JFrame implements ActionListener {
  JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    public Reciption() {
        setBounds(200,100,800,600);
        setLayout(null);
        
        b1=new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(10,50,200,30);
        b1.addActionListener(this);
        add(b1);
      
         b2=new JButton("Rooms");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(10,100,200,30);
        b2.addActionListener(this);
        add(b2);
//        
//         b3=new JButton("Department");
//        b3.setBackground(Color.BLACK);
//        b3.setForeground(Color.white);
//        b3.setBounds(10,110,200,30);
//        b3.addActionListener(this);
//        add(b3);
        
        b4=new JButton("All Employee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);
        b4.setBounds(10,150,200,30);
        b4.addActionListener(this);
        add(b4);
        
        b5=new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.white);
        b5.setBounds(10,200,200,30);
        b5.addActionListener(this);
        add(b5);
        
        b6=new JButton("Manager Info");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.white);
        b6.setBounds(10,250,200,30);
        b6.addActionListener(this);
        add(b6);
        
        b7=new JButton("Check Out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.white);
        b7.setBounds(10,300,200,30);
        b7.addActionListener(this);
        add(b7);
        
        b8=new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.white);
        b8.setBounds(10,350,200,30);
        b8.addActionListener(this);
        add(b8);
        
        b9=new JButton("Search Room");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.white);
        b9.setBounds(10,400,200,30);
        b9.addActionListener(this);
        add(b9);
        
        b10=new JButton("Pick Up Service");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.white);
        b10.setBounds(10,450,200,30);
        b10.addActionListener(this);
        add(b10);
        
        b11=new JButton("Log Out");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.white);
        b11.setBounds(10,500,200,30);
        b11.addActionListener(this);
        add(b11);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image/reciption.jpg"));
        JLabel l1=new JLabel(new ImageIcon(i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT)));
        l1.setBounds(250, 0, 500,580);
        add(l1);
        setResizable(false);
        getContentPane().setBackground(Color.white);
    }
    public static void main(String[] args)
    {
       new Reciption().setVisible(true);
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1)
       {
         try{
               new Customer_Form().setVisible(true);
               this.setVisible(false);
            }
         catch(Exception ef)
         {
             ef.printStackTrace();
         }    
       }
       else if(e.getSource()==b2)
       {
         try{
                new Rooms().setVisible(true);
               this.setVisible(false);
            }
         catch(Exception ef)
         {
             JOptionPane.showMessageDialog(null, ef);
         } 
       }   
//       else if(e.getSource()==b3)
//       {
//          try{
//                 new Department().setVisible(true);
//               this.setVisible(false);
//             }
//         catch(Exception ef)
//         {
//             ef.printStackTrace();
//         } 
//       }   
       else if(e.getSource()==b4)
       {
          try{
                 new Employee_Info().setVisible(true);
               this.setVisible(false);
             }
         catch(Exception ef)
         {
             ef.printStackTrace();
         } 
       }   
       else if(e.getSource()==b5)
       {
           try{
                 new Customer_Info().setVisible(true);
               this.setVisible(false);
              }
         catch(Exception ef)
         {
             ef.printStackTrace();
         } 
       }   
       else if(e.getSource()==b6)
       {
          try{
                 new Manager_Info().setVisible(true);
               this.setVisible(false);
             }
         catch(Exception ef)
         {
             ef.printStackTrace();
         } 
       }   
       else if(e.getSource()==b7)
       {
           try{
                 new Check_Out().setVisible(true);
               this.setVisible(false);
              }
         catch(Exception ef)
         {
             ef.printStackTrace();
         } 
       }   
       else if(e.getSource()==b8)
       {
           try{
                  new Update_Check_Status().setVisible(true);
               this.setVisible(false);
              }
         catch(Exception ef)
         {
             ef.printStackTrace();
         } 
       }   
       else if(e.getSource()==b9)
       {
           try{
                 new Search_Room().setVisible(true);
               this.setVisible(false);
              }
         catch(Exception ef)
         {
             ef.printStackTrace();
         } 
       }   
       else if(e.getSource()==b10)
       {
          try{
               new Pick_Up_Service().setVisible(true);
               this.setVisible(false);
             }
         catch(Exception ef)
         {
             ef.printStackTrace();
         } 
       }    
       else if(e.getSource()==b11)
       {  
          this.setVisible(false);
       }    
    }
    
}
