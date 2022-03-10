package package1;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Passenger extends JFrame{


    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;

    public Add_Passenger(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD CUSTOMER DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(420, 24, 442, 35);
        add(AddPassengers);


        JLabel Passenger_CNIC_Label = new JLabel("Passenger CNIC");
        Passenger_CNIC_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Passenger_CNIC_Label.setBounds(60, 30, 150, 27);
        add(Passenger_CNIC_Label);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);


        JLabel Name_Label = new JLabel("Name");
        Name_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Name_Label.setBounds(60, 80, 150, 27);
        add(Name_Label);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        JLabel Age_Label = new JLabel("Age");
        Age_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Age_Label.setBounds(60, 120, 150, 27);
        add(Age_Label);

        textField_2 = new JTextField();
        textField_2.setBounds(200, 120, 150, 27);
        add(textField_2);


        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Gender.setBounds(60, 170, 150, 27);
        add(Gender);

        JRadioButton NewRadioButton = new JRadioButton("Male");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(200, 170, 70, 27);
        add(NewRadioButton);

        JRadioButton Female = new JRadioButton("Female");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 170, 100, 27);
        add(Female);


        JLabel Nationality = new JLabel("Nationality");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        JLabel DOB_label = new JLabel("Date Of Birth");
        DOB_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        DOB_label.setBounds(60, 270, 150, 27);
        add(DOB_label);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);



        JLabel Phno = new JLabel("PH NO");
        Phno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Phno.setBounds(60, 320, 150, 27);
        add(Phno);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 320, 150, 27);
        add(textField_5);




        JLabel Flightcode = new JLabel("Flight Code");
        Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Flightcode.setBounds(60, 370, 150, 27);
        add(Flightcode);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        add(textField_6);


//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icon/emp.png"));
//        JLabel image = new JLabel(i1);
//        image.setBounds(450,80,280,410);
//        add(image);

        JButton Next = new JButton("SAVE");
        Next.setBounds(200, 420, 120, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);

        setVisible(true);


        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String CNIC = textField.getText();
                String name = textField_1.getText();
                String age =  textField_2.getText();
                String nationality = textField_3.getText();
                String dob = textField_4.getText();
                String phn_no = textField_5.getText();

                String gender = null;
                String flight_id = textField_6.getText();

                if(NewRadioButton.isSelected()){
                    gender = "male";

                }else if(Female.isSelected()){
                    gender = "female";
                }

                try {
                    connection c = new connection();
                    String str = "INSERT INTO passenger values( '"+CNIC+"', '"+name+"', '"+age+"','"+gender+"', '"+nationality+"', '"+dob+"','"+phn_no+"', '"+flight_id+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Customer Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        JButton Payment_btn = new JButton("PAYMENT");
        Payment_btn.setBounds(60, 420, 120, 30);
        Payment_btn.setBackground(Color.BLACK);
        Payment_btn.setForeground(Color.WHITE);
        add(Payment_btn);

        setVisible(true);


        Payment_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Payment().setVisible(true);
            }
        });


        setSize(900,600);
        setVisible(true);
        setLocation(400,200);

    }

    public static void main(String[] args){

        new Add_Passenger();
    }
}