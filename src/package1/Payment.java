package package1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Payment extends JFrame{

    JTextField textField;
    JTable table;
    JLabel payment_label;
    JLabel  payment_id_label, Ticket_label, Pay_date_label, CNIC_label,label;

    public static void main(String[] args) {
        new Payment();
    }

    public Payment(){
        initialize();
    }

    private void initialize(){
        setTitle("PAYMENT_DETAILS");
        getContentPane().setBackground(Color.WHITE);
        setSize(860,486);
        setLayout(null);

        JLabel pnr_no_label = new JLabel("Enter your CNIC");
        pnr_no_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pnr_no_label.setBounds(60, 160, 150, 26);
        add(pnr_no_label);

        textField = new JTextField();
        textField.setBounds(200, 160, 150, 26);
        add(textField);

        table = new JTable();
        table.setBounds(25, 329, 866, 87);
        add(table);

        JButton Show = new JButton("SHOW");
        Show.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
        Show.setBounds(200, 210, 150, 26);
        add(Show);

        payment_label = new JLabel("PAYMENT DETAILS");
        payment_label.setForeground(Color.BLUE);
        payment_label.setFont(new Font("Tahoma", Font.PLAIN, 31));
        payment_label.setBounds(51, 17, 300, 39);
        add(payment_label);

        JLabel payment_id_label1 = new JLabel("Payment ID");
        payment_id_label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        payment_id_label1.setBounds(30, 292, 108, 26);
        add(payment_id_label1);

        CNIC_label = new JLabel("TICKET PRICE");
        CNIC_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
        CNIC_label.setBounds(455, 298, 114, 14);
        add(CNIC_label);
        
        JLabel ARL_label = new JLabel("AIRLINE ID");
        ARL_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ARL_label.setBounds(177, 298, 92, 14);
        add(ARL_label);
        
        Ticket_label = new JLabel("AIRLINE NAME");
        Ticket_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Ticket_label.setBounds(310, 298, 92, 14);
        add(Ticket_label);

        Pay_date_label = new JLabel("Pay Date");
        Pay_date_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Pay_date_label.setBounds(603, 294, 101, 24);
        add(Pay_date_label);

        JLabel Cheque_no = new JLabel("CHEQUE_NO");
        Cheque_no.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Cheque_no.setBounds(750, 299, 101, 19);
        add(Cheque_no);

        label = new JLabel("");
        //label.setIcon(new ImageIcon(ClassLoader.getSystemResource("com/company/icon/payment.png")));
        label.setBounds(425, 15, 239, 272);
        add(label);



        setVisible(true);

        Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                try {
                    String code  = textField.getText();

                    connection c = new connection();
                    String str = "SELECT PAYMENT.PAYMENT_ID , flight.Flight_ID, flight.flight_name, payment.Ticket_Price, payment.pay_date, payment.cheque_no FROM passenger LEFT JOIN payment ON passenger.passenger_cnic = payment.passenger_cnic LEFT JOIN flight ON passenger.Flight_ID =flight.Flight_ID\n" +
                            "\n" +
                            "\n" +
                            "\n where passenger.passenger_CNIC = '"+code+"'";

                    ResultSet rs = c.s.executeQuery(str);

                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(960,590);
        setLocation(400,200);
        setVisible(true);

    }
}