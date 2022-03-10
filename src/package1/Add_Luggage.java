package package1;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Random;


public class Add_Luggage extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    //Choice c1;

   


    public Add_Luggage() throws SQLException {
        this.setVisible(true);
        setBounds(250, 100, 700, 450);

        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setBackground(Color.gray);
        contentPane.setLayout(null);
       

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/twelve.jpg"));
//        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i3);
//        JLabel l15 = new JLabel(i2);
//        l15.setBounds(400, 30, 500, 370);
//        add(l15);

        JLabel l = new JLabel("Add Your Luggage");
        l.setFont(new Font("Tahoma", Font.BOLD, 18));
        l.setBounds(194, 10, 300, 22);
        contentPane.add(l);


        JLabel l1 = new JLabel("Luggage_ID");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 102, 22);
        contentPane.add(l1);


        t1 = new JTextField();
        t1.setBounds(200, 70, 156, 20);
        
        contentPane.add(t1);


        JLabel l2 = new JLabel("Bag Color");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 102, 22);
        contentPane.add(l2);

        t2 = new JTextField();
       
            t2.setBounds(200, 110, 156, 20);
        contentPane.add(t2);

        JLabel l3 = new JLabel("Weight");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 102, 22);
        contentPane.add(l3);

        t3 = new JTextField();
        t3.setBounds(200, 150, 156, 20);
        contentPane.add(t3);

        JLabel l4 = new JLabel("Count");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 102, 22);
        contentPane.add(l4);

        t4 = new JTextField();
        t4.setBounds(200, 190, 156, 20);
        contentPane.add(t4);

        JLabel l5 = new JLabel("Passenger CNIC");
        l5.setForeground(new Color(25, 34, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 150, 22);
        contentPane.add(l5);


        t5 = new JTextField();
        t5.setBounds(200, 230, 156, 20);
        contentPane.add(t5);
      b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(200, 341, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Next");
        b2.addActionListener(this);
        b2.setBounds(330, 341, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        contentPane.setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource() == b1) {
                try {
                    connection c = new connection();
                    String cnic = t1.getText();
                    String name = t2.getText();
                    String email = t3.getText();
                    String contact_no = t4.getText();
                    String address = t5.getText();
                    //String airline_id = t6.getText();
                    String str = "INSERT INTO luggage(luggage_id, bag_color, weight, count, passenger_cnic) values( '" + cnic + "', '" + name + "', '" + email + "','" + contact_no + "', '" + address + "')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Luggage Successfully Added");
                    this.setVisible(false);

                } catch (Exception ee) {
                    System.out.println(ee);
                }
            } else if (ae.getSource() == b2) {
                new buyfooditems().setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception eee) {
eee.printStackTrace();
        }
     
    }
    
     public static void main(String[] args) throws SQLException {

        Add_Luggage  L = new Add_Luggage();//
       
    }
}