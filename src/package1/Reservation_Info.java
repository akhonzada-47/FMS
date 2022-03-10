package package1;


import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Reservation_Info extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel Reservation_ID_label;
    private JLabel Seat_no_label;
    private JLabel Class_name_label;
    private JLabel Flight_id_label;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reservation_Info frame = new Reservation_Info();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Reservation_Info() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

//        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/eight.jpg"));
//        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i3);
//        JLabel l1 = new JLabel(i2);
//        l1.setBounds(500,0,600,600);
//        add(l1);


        table = new JTable();
        table.setBounds(5, 40, 1074, 430);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    connection c = new connection();
                    String displayReservation_Infosql = "select * from Reservation";
                    ResultSet rs = c.s.executeQuery(displayReservation_Infosql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnLoadData.setBounds(460, 510, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton.setBounds(600, 510, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        Reservation_ID_label= new JLabel("Reservation_ID");
        Reservation_ID_label.setBounds(10, 15, 96, 14);
        contentPane.add(Reservation_ID_label);

        Seat_no_label = new JLabel("Seat No");
        Seat_no_label.setBounds(220, 15, 76, 14);
        contentPane.add(Seat_no_label);

        Class_name_label = new JLabel("Class name");
        Class_name_label.setBounds(430, 15, 76, 14);
        contentPane.add(Class_name_label);

        Flight_id_label = new JLabel("Flight ID");
        Flight_id_label.setBounds(645, 15, 76, 14);
        contentPane.add(Flight_id_label);
        
        Flight_id_label = new JLabel("Passenger's CNIC");
        Flight_id_label.setBounds(860, 15, 106, 14);
        contentPane.add(Flight_id_label);



        getContentPane().setBackground(Color.GRAY);
    }
}
