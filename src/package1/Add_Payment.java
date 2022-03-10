package package1;

import java.awt.EventQueue;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Payment extends JFrame
{ //Third Frame


    public Add_Payment()
    {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("RESERVATION PANEL");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

       JButton Next1 = new JButton("ADD PAYMENT");
        Next1.setBounds(300, 320, 150, 30);
        Next1.setBackground(Color.BLACK);
        Next1.setForeground(Color.WHITE);
        add(Next1);
        
        JLabel Passportno1 = new JLabel("Payment ID");
        Passportno1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno1.setBounds(60, 80, 150, 27);
        add(Passportno1);

        JTextField textField0 = new JTextField();
        textField0.setBounds(200, 80, 150, 27);
        add(textField0);

        JLabel Pnrno1 = new JLabel("Ticket Price");
        Pnrno1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno1.setBounds(60, 120, 150, 27);
        add(Pnrno1);

        JTextField textField_11 = new JTextField();
        textField_11.setBounds(200, 120, 150, 27);
        add(textField_11);

        JLabel Address1 = new JLabel("Date");
        Address1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address1.setBounds(60, 170, 150, 27);
        add(Address1);

        JTextField textField_21 = new JTextField();
        textField_21.setBounds(200, 170, 150, 27);
        add(textField_21);

        JLabel Nationality1 = new JLabel("Passenger's CNIC");
        Nationality1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality1.setBounds(60, 220, 150, 27);
        add(Nationality1);

        JTextField textField_31 = new JTextField();
        textField_31.setBounds(200, 220, 150, 27);
        add(textField_31);

        JLabel Name1 = new JLabel("Cheque No.");
        Name1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name1.setBounds(60, 270, 150, 27);
        add(Name1);

        JTextField textField_41 = new JTextField();
        textField_41.setBounds(200, 270, 150, 27);
        add(textField_41);
        
        
        
        
        
        JLabel RSRV = new JLabel("ADD PAYMENT");
        RSRV.setForeground(Color.blue);
        RSRV.setFont(new Font("Tahoma", Font.PLAIN, 28));
        RSRV.setBounds(520, 24, 442, 35);
        add(RSRV);


        
        Next1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String Res_ID1 = textField0.getText();
                String seat_no1 = textField_11.getText();
                String class_N1 =  textField_21.getText();
                String F_id1 = textField_31.getText();
                String p_cnic1 = textField_41.getText();
                

                try {
                    connection c = new connection();
                    String str = "INSERT INTO payment values( '"+Res_ID1+"', '"+seat_no1+"', '"+class_N1+"','"+F_id1+"','"+p_cnic1+"')";
                    //String str1 = "Update flight set flight_status='reserved' where flight_id='"+F_id1+"'";
                    c.s.executeUpdate(str);
                    //c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null,"Payment Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });       
       

        setSize(900,600);
        setVisible(true);
        setLocation(400,200);

    }

}

    