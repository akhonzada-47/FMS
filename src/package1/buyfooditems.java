package package1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Random;
public class buyfooditems extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    //Choice c1;

   

    public buyfooditems() throws SQLException {
        setBounds(450, 200, 1000, 450);

        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setLayout(null);


        JLabel l = new JLabel("Select Food");
        l.setFont(new Font("Tahoma", Font.BOLD, 18));
        l.setBounds(194, 10, 120, 22);
        contentPane.add(l);


        JLabel l1 = new JLabel("Food Item ID");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 102, 22);
        contentPane.add(l1);


        t1 = new JTextField();
        t1.setBounds(200, 70, 156, 20);
        boolean flag = true;
        boolean flag2 = true;
        Random rand = new Random();
        connection c = new connection();

        while(flag2){
            rand.setSeed(System.nanoTime());
            ResultSet rs = c.s.executeQuery("select fooditem_id from fooditems");
            int randId = rand.nextInt(1000);
            while(rs.next()){
                if(rs.getInt(1) == randId){
                    flag = false;
                    break;
                }
                if(flag){
                    flag2 = false;
                    t1.setText(Integer.toString(randId));
                }
            }
        }
        contentPane.add(t1);


        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 102, 22);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setBounds(200, 110, 156, 20);

        contentPane.add(t2);

        JLabel l3 = new JLabel("Price");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 102, 22);
        contentPane.add(l3);

        t3 = new JTextField();
        t3.setBounds(200, 150, 156, 20);
        contentPane.add(t3);

        JLabel l4 = new JLabel("Quantity");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 102, 22);
        contentPane.add(l4);

        t4 = new JTextField();
        t4.setBounds(200, 190, 156, 20);
        contentPane.add(t4);

        JLabel l5 = new JLabel("Extras");
        l5.setForeground(new Color(25, 34, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 102, 22);
        contentPane.add(l5);


        t5 = new JTextField();
        t5.setBounds(200, 230, 156, 20);
        contentPane.add(t5);

        JLabel l6 = new JLabel("Passenger CNIC");
        l6.setForeground(new Color(25, 25, 112));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 270, 150, 22);
        contentPane.add(l6);


        t6= new JTextField();
        t6.setBounds(200, 270, 156, 20);
        contentPane.add(t6);

        b1 = new JButton("Buy");
        b1.addActionListener(this);
        b1.setBounds(64, 341, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(198, 341, 111, 33);
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
                    String airline_id = t6.getText();
                    String str = "INSERT INTO fooditems(fooditem_id, fooditem_name, price, quantity, extras, passenger_cnic) values( '" + cnic + "', '" + name + "', '" + email + "','" + contact_no + "', '" + address + "', '" + airline_id+ "')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Food Items successfully added");
                    this.setVisible(false);

                } catch (Exception ee) {
                    System.out.println(ee);
                }
            } else if (ae.getSource() == b2) {
                new Dashboard().setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception eee) {

        }
    }
    
     public static void main(String[] args) throws SQLException {

        new buyfooditems().setVisible(true);
    }

}