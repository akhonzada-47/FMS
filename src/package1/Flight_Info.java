package package1;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Flight_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;

    public static void main(String[] args){
        new Flight_Info().setVisible(true);
    }

    public Flight_Info(){

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(860,523);
        setLayout(null);
        setVisible(true);

        JLabel F_ID_Label = new JLabel("FLIGHT_ID");
        F_ID_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        F_ID_Label.setBounds(50, 100, 200, 30);
        add(F_ID_Label);


        JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
        FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
        FlightDetails.setForeground(new Color(100, 149, 237));
        FlightDetails.setBounds(500, 30, 570, 35);
        add(FlightDetails);

        JButton btnShow = new JButton("SHOW");
        btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));

        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String code = textField.getText();

                try {
                    connection c = new connection();
                    String str = "select flight_id, flight_name,source,destination,Arrival,Departure, class_name from flight where flight_id = '"+code+"'";

                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
        add(btnShow);

        table = new JTable();
        table.setBackground(Color.WHITE);
        table.setBounds(23, 250, 800, 300);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);

        textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
        add(textField);



        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900,650);
        setVisible(true);
        setLocation(400,200);

    }
}