
package hotel.managment.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class AddEmployee extends JFrame {

    public AddEmployee() {
       getContentPane().setBackground(Color.white);
       getContentPane().setForeground(Color.blue);
       setLayout(null);
       setTitle("Employee Details");
        setResizable(false);
       setLocation(200,100);
    JLabel l1=new JLabel("Name");
    JLabel l2=new JLabel("Age");
    JLabel l3=new JLabel("Gender");
    JLabel l4=new JLabel("Job");
    JLabel l5=new JLabel("Salary");
    JLabel l6=new JLabel("Phone");
    JLabel l7=new JLabel("Adhar");
    JLabel l8=new JLabel("EMail");
    JLabel l9=new JLabel("Add Employee Details"); 
    
    JTextField t1=new JTextField(20);
    JTextField t2=new JTextField(20);
    JTextField t3=new JTextField(20);
    JTextField t4=new JTextField(20);
    JTextField t5=new JTextField(20);
    JTextField t6=new JTextField(20);
    
    JRadioButton male=new JRadioButton("Male");
    JRadioButton Female=new JRadioButton("Female");  
    ButtonGroup br=new ButtonGroup();
    
    String job[]={"Front Desk Clerck","porters","Kitchen Staff","Room Services","Waiter/waitress","Manager","Acconuntant","Chef"};
    JComboBox c1=new JComboBox(job);
    
    JButton b1=new JButton("Submit");
    b1.setBackground(Color.black);
    b1.setForeground(Color.white);
    b1.setBounds(200, 420, 150, 30);
    add(b1);
    
    l1.setBounds(60,30, 150, 20);
    l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l1);
    
    l2.setBounds(60,80, 150, 20);
    l2.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l2);
    
    l3.setBounds(60,130, 150, 20);
    l3.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l3);
    
    l4.setBounds(60,180,150, 20);
    l4.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l4);
    
    l5.setBounds(60,230, 150, 20);
    l5.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l5);
    
    l6.setBounds(60,280, 150, 20);
    l6.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l6);
    
    l7.setBounds(60,330, 150, 20);
    l7.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l7);
    
    l8.setBounds(60,380, 150, 20);
    l8.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l8);
    
    l9.setBounds(450,24, 442, 35);
    l9.setFont(new Font("Tahoma",Font.PLAIN,30));
    add(l9);
    
    t1.setBounds(200, 30,150, 20);
    add(t1);
    
    t2.setBounds(200, 80,150, 20);
    add(t2);
    
    t3.setBounds(200, 230,150, 20);
    add(t3);
    
    t4.setBounds(200, 280,150, 20);
    add(t4);
    
    t5.setBounds(200, 330,150, 20);
    add(t5);
    
    t6.setBounds(200, 380,150, 20);
    add(t6);
    
    c1.setBounds(200, 180, 150,20);
    add(c1);
    
    male.setBounds(200, 130, 80, 20);
    male.setBackground(Color.white);
    add(male);
    
    Female.setBounds(280, 130, 100, 20);
    Female.setBackground(Color.white);  
    add(Female);
    br.add(male);
    br.add(Female);  
    ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("Image/employee.jpg"));
    JLabel l10=new JLabel(new ImageIcon(mg.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT)));
    l10.setBounds(410,80, 480,410);
    add(l10);
    
    b1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        String s1=t1.getText();
        String s2=t2.getText();
        String s3=t3.getText();
        String s4=t4.getText();
        String s5=t5.getText();
        String s6=t6.getText();
        
        String gender=null;
        if(male.isSelected())
        {
           gender="Male";
        }   
        
       else if(Female.isSelected())
        {
           gender="Female";
        } 
       String s7=(String)c1.getSelectedItem();
       try{
             Conn c2=new Conn();
             c2.s.executeUpdate("insert into addemployee values('"+s1+"','"+s2+"','"+gender+"','"+s7+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
             JOptionPane.showMessageDialog(null,"Employee add SuccesFull");
             
          }
       catch(Exception ef)
       {
            ef.printStackTrace();
       }
      }        
    });
    setSize(900,600);
    setVisible(true);
   
    }
    
public static void main(String[] args)
{
   new AddEmployee().setVisible(true);
}        
}
