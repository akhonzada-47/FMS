package package1;
import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Employees extends JFrame{ //Third Frame


    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
    JComboBox c1;

    public Add_Employees(){
        getContentPane().setForeground(Color.WHITE);
        getContentPane().setBackground(Color.BLACK);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel CNIC_no_label = new JLabel("CNIC No");
        CNIC_no_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        CNIC_no_label.setForeground(Color.WHITE);
        CNIC_no_label.setBounds(60, 30, 150, 27);
        add(CNIC_no_label);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);


        JLabel Name_Label = new JLabel("Name");
        Name_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name_Label.setForeground(Color.WHITE);
        Name_Label.setBounds(60, 80, 150, 27);
        add(Name_Label);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        JLabel Address_Label = new JLabel("Address");
        Address_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address_Label.setForeground(Color.WHITE);
        Address_Label.setBounds(60, 120, 150, 27);
        add(Address_Label);



        textField_2 = new JTextField();
        textField_2.setBounds(200, 120, 150, 27);
        add(textField_2);

        JLabel Salary_label = new JLabel("Salary");
        Salary_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Salary_label.setForeground(Color.WHITE);
        Salary_label.setBounds(60, 170, 150, 27);
        add(Salary_label);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 170, 150, 27);
        add(textField_3);

        JLabel Designation_label = new JLabel("Designation");
        Designation_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Designation_label.setForeground(Color.WHITE);
        Designation_label.setBounds(60, 220, 150, 27);
        add(Designation_label);

        String course[] = {"CEO","Manager","Branch Manager","Operator","Employee","Technical Manager","Marketing Manager","Air Force Commander"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,220,150,30);
        add(c1);


        JLabel Email_Label = new JLabel("Email");
        Email_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Email_Label.setForeground(Color.WHITE);
        Email_Label.setBounds(60, 270, 150, 27);
        add(Email_Label);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);

        JLabel Phone_No_label = new JLabel("Phone No");
        Phone_No_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phone_No_label.setForeground(Color.WHITE);
        Phone_No_label.setBounds(60, 320, 150, 27);
        add(Phone_No_label);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 320, 150, 27);
        add(textField_5);


        JLabel Airport_id_label = new JLabel("Airport ID");
        Airport_id_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Airport_id_label.setForeground(Color.WHITE);
        Airport_id_label.setBounds(60, 370, 150, 27);
        add(Airport_id_label);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        add(textField_6);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.WHITE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);


//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/tenth.jpg"));
//        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i3);
//        JLabel image = new JLabel(i2);
//        image.setBounds(410,80,480,410);
//        add(image);


        JButton Next = new JButton("SAVE");
        Next.setBounds(200, 420, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);


        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String employee_Cnic = textField.getText();
                String employee_name = textField_1.getText();
                String address = textField_2.getText();
                String salary = textField_3.getText();
                String designation = (String)c1.getSelectedItem();
                String email = textField_4.getText();
                String Phone_no = textField_5.getText();
                String Airport_id = textField_6.getText();



                try {
                    connection c = new connection();
                    String str = "INSERT INTO employees values( '"+employee_Cnic+"', '"+employee_name+"', '"+address+"','"+salary+"', '"+designation+"', '"+email+"','"+Phone_no+"', '"+Airport_id+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Employee Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900,600);
        setVisible(true);
        setLocation(530,200);

    }

    public static void main(String[] args){

        new Add_Employees();
    }
}