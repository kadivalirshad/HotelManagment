package hotel.managment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Rooms extends JFrame implements ActionListener {

    JTable t;
    JButton b1, b2;
    DefaultTableModel model;
    JScrollPane pane;

    public Rooms() {

        setResizable(false);
//      JLabel l2=new JLabel("Room_No");
//      l2.setBounds(20,0, 100,30);
//      p1.add(l2);
//      
//      JLabel l3=new JLabel("Room_Status");
//      l3.setBounds(110,0, 150,30);
//      p1.add(l3);
//      
//      JLabel l4=new JLabel("Room_Condition");
//      l4.setBounds(200,0, 100,30);
//      p1.add(l4);
//      
//      JLabel l5=new JLabel("Price");
//      l5.setBounds(330,0, 100,30);
//      p1.add(l5);
//      
//     // JLabel l6=new JLabel("Bed_Type");
//      l6.setBounds(410,0, 100,30);
//      p1.add(l6);

//      p1=new JPanel();
//      p2=new JPanel();
//      p3=new JPanel();
        b1 = new JButton("Load Data");
        b1.setBounds(50, 530, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Exit");
        b2.setBounds(250, 530, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Image/rooms.jpg"));
        JLabel l1 = new JLabel(new ImageIcon(i1.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT)));
        l1.setBounds(500, 0, 500, 600);
        add(l1);

        model = new DefaultTableModel(0, 5);
        String[] columnName = {"Room_No", "Room_Status ", "Room_Condition", "Price", "Bed_Type"};
        model.setColumnIdentifiers(columnName);
        t = new JTable(model);
        pane = new JScrollPane(t);
        pane.setBounds(0, 0, 500, 500);
        add(pane);

        setBounds(100, 100, 1000, 600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Rooms();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            try {
                Conn c1 = new Conn();
                ResultSet rs = c1.s.executeQuery("select *from room");

                while (rs.next()) {
                    String s1 = rs.getString(1);
                    String s2 = rs.getString(2);
                    String s3 = rs.getString(3);
                    String s4 = rs.getString(4);
                    String s5 = rs.getString(5);

                    Object[] row = {s1, s2, s3, s4, s5};
                    model.addRow(row);
                }
                c1.c.close();
            } catch (Exception ef) {
                JOptionPane.showMessageDialog(null, "Something went Wrong.....");
            }

        } else if (e.getSource() == b2) {
            new Reciption().setVisible(true);
            this.setVisible(false);
        }
    }
}
