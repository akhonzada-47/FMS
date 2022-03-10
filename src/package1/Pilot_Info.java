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
public class Pilot_Info extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel Pilot_CNIC_label;
    private JLabel Pilot_name_label;
    private JLabel Email_label;
    private JLabel Contact_no_label;
    private JLabel Address_label;
    private JLabel Airline_ID_label;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pilot_Info frame = new Pilot_Info();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close()
    {
        this.dispose();
    }
    /**
     * Create the frame.
     * @throws SQLException
     */
    public Pilot_Info() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(10, 34, 965, 450);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String displayPilot_Infosql = "SELECT 'Pilot records' ,pilot.pilot_cnic, pilot.pilot_name AS ,\n" +
                            "pilot.airline_id, airline.Name AS  Airline_names, airline.Country\n" +
                            "FROM airline RIGHT JOIN pilot ON airline.Airline_ID = pilot.Airline_ID";
                    ResultSet rs = c.s.executeQuery(displayPilot_Infosql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(380, 500, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

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
        contentPane.add(btnExit);

        Pilot_CNIC_label = new JLabel("Pilot_CNIC");
        Pilot_CNIC_label.setBounds(14, 11, 96, 14);
        contentPane.add(Pilot_CNIC_label);

        Pilot_name_label = new JLabel("Name");
        Pilot_name_label.setBounds(174, 11, 96, 14);
        contentPane.add(Pilot_name_label);

        Email_label = new JLabel("Email");
        Email_label.setBounds(334, 11, 96, 14);
        contentPane.add(Email_label);

        Contact_no_label = new JLabel("Contact no.");
        Contact_no_label.setBounds(494, 11, 86, 14);
        contentPane.add(Contact_no_label);

        Address_label = new JLabel("Address");
        Address_label.setBounds(654, 11, 86, 14);
        contentPane.add(Address_label);

        Airline_ID_label = new JLabel("Airline_ID");
        Airline_ID_label.setBounds(814, 11, 96, 14);
        contentPane.add(Airline_ID_label);

        getContentPane().setBackground(Color.GRAY);
    }
}