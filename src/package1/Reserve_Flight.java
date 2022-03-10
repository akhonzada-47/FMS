package package1;

import java.awt.EventQueue;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Reserve_Flight extends JFrame
{ //Third Frame


    JTextField textField,textField_1,textField_2,textField_3,textField_4;

    public Reserve_Flight(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("RESERVATION PANEL");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel Passportno = new JLabel("RESERVATION ID");
        Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno.setBounds(60, 80, 150, 27);
        add(Passportno);

        textField = new JTextField();
        textField.setBounds(200, 80, 150, 27);
        add(textField);

        JButton Next = new JButton("RESERVE");
        Next.setBounds(140, 320, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);
        
        JLabel Pnrno = new JLabel("SEAT NO");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 120, 150, 27);
        add(Pnrno);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 120, 150, 27);
        add(textField_1);

        JLabel Address = new JLabel("CLASS_NAME");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 150, 27);
        add(Address);

        textField_2 = new JTextField();
        textField_2.setBounds(200, 170, 150, 27);
        add(textField_2);

        JLabel Nationality = new JLabel("FLIGHT ID");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        JLabel Name = new JLabel("PASSENGER_CNIC");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 270, 150, 27);
        add(Name);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);
        
        
        
        
        
        JLabel RSRV = new JLabel("RESERVE YOUR FLIGHT");
        RSRV.setForeground(Color.blue);
        RSRV.setFont(new Font("Tahoma", Font.PLAIN, 28));
        RSRV.setBounds(520, 24, 442, 35);
        add(RSRV);


        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String Res_ID = textField.getText();
                String seat_no = textField_1.getText();
                String class_N =  textField_2.getText();
                String F_id = textField_3.getText();
                String p_cnic = textField_4.getText();
                

                try {
                    connection c = new connection();
                    String str = "INSERT INTO reservation values( '"+Res_ID+"', '"+seat_no+"', '"+class_N+"','"+F_id+"','"+p_cnic+"')";
                    String str1 = "Update flight set flight_status='reserved' where flight_id='"+F_id+"'";
                    c.s.executeUpdate(str);
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null,"Flight reserved");
                    setVisible(false);
                    new Add_Payment();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
       
        
       

        setSize(900,600);
        setVisible(true);
        setLocation(400,200);

    }

    public static void main(String[] args){
        new Reserve_Flight().setVisible(true);
    }
}