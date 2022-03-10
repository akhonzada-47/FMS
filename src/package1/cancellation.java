package package1;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class cancellation extends JFrame{ //Third Frame

    JTextField textField,textField_1,textField_2,textField_3,textField_4;

    public cancellation(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.GRAY);
        setTitle("CANCELLATION PANEL");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,400);
        getContentPane().setLayout(null);

        JLabel Passportno = new JLabel("CANCELLATION ID");
        Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno.setBounds(60, 80, 150, 27);
        add(Passportno);

        textField = new JTextField();
        textField.setBounds(250, 80, 150, 27);
        add(textField);

        JLabel Pnrno = new JLabel("PASSENGER CNIC");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 120, 150, 27);
        add(Pnrno);

        textField_1 = new JTextField();
        textField_1.setBounds(250, 120, 150, 27);
        add(textField_1);

        JLabel Address = new JLabel("CANCELLATION DATE");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 250, 27);
        add(Address);

        textField_2 = new JTextField();
        textField_2.setBounds(250, 170, 150, 27);
        add(textField_2);

        JLabel Nationality = new JLabel("FLIGHT ID");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(250, 220, 150, 27);
        add(textField_3);


        JLabel AddPassengers = new JLabel("CANCEL YOUR FLIGHT");
        AddPassengers.setForeground(Color.blue);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 28));
        AddPassengers.setBounds(520, 24, 442, 35);
        add(AddPassengers);

        JButton Next = new JButton("CANCEL Your Flight");
        Next.setBounds(200, 300, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);


        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String passport_No = textField.getText();
                String pnr_no = textField_1.getText();
                String address =  textField_2.getText();
                String nationality = textField_3.getText();


                try {
                    connection c = new connection();
                    String str = "INSERT INTO cancellation values( '"+passport_No+"', '"+pnr_no+"', '"+address+"','"+nationality+"')";
                    String str1 = "Delete from passenger where passenger_cnic = '"+passport_No+"'";
                    c.s.executeUpdate(str);
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null,"Flight cancelled");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });




        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(510, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);

        setSize(900,400);
        setVisible(true);
        setLocation(400,200);

    }

    public static void main(String[] args){
        new cancellation().setVisible(true);
    }
}