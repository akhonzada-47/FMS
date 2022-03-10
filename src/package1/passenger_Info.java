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
public class passenger_Info extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable t1;
    private JLabel Airline_id_Label;
    private JLabel Name_Label;
    private JLabel Contact_no_Label;
    private JLabel Email_Label;
    private JLabel Country_Label, airport_Label;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    passenger_Info frame = new passenger_Info();
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
    public passenger_Info() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        t1= new JTable();
        t1.setBounds(0,30,1000,450);
        t1.setBackground(Color.LIGHT_GRAY);
        contentPane.add(t1);

        Airline_id_Label = new JLabel("Airline_id");
        Airline_id_Label.setBounds(3, 11, 66, 14);
        contentPane.add(Airline_id_Label);

        Name_Label  = new JLabel("Passenger Name");
        Name_Label.setBounds(168, 11, 126, 14);
        contentPane.add(Name_Label);

        Contact_no_Label = new JLabel("Gender");
        Contact_no_Label.setBounds(335, 11, 46, 14);
        contentPane.add(Contact_no_Label);

        Email_Label = new JLabel("Flight ID");
        Email_Label.setBounds(503, 11, 86, 14);
        contentPane.add(Email_Label);

        Country_Label = new JLabel("Flight Name");
        Country_Label.setBounds(670, 11, 86, 14);
        contentPane.add(Country_Label);

        airport_Label = new JLabel("Airport Name");
        airport_Label.setBounds(835, 11, 86, 14);
        contentPane.add(airport_Label);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String displayPassenger_Infosql = "SELECT DISTINCT flight.Airline_ID, passenger.Passenger_Name, " +
                            "passenger.Gender, flight.Flight_ID, flight.flight_Name AS Flight_name," +
                            "airport.AirportName " + "FROM flight RIGHT JOIN passenger ON flight.Flight_ID = passenger.Flight_ID " +
                            "LEFT JOIN airport ON flight.AirportID = airport.airportid";
                    ResultSet rs = c.s.executeQuery(displayPassenger_Infosql );
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(410, 500, 96, 34);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);



        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true);
                //setVisible(false);
            }
        });
        btnExit.setBounds(515, 500, 96, 34);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


        getContentPane().setBackground(Color.GRAY);

    }

}