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
public class Reserved_Classes extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable t1;
    private JLabel City_id_Label;
    private JLabel City_name_Label;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reserved_Classes frame = new Reserved_Classes();
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
    public Reserved_Classes() throws SQLException {
        
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.GRAY);
        setTitle("RESERVED CLASSES");
        
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        t1= new JTable();
        t1.setBounds(0,30,600,350);
        contentPane.add(t1);

        City_id_Label = new JLabel("Number_Of_Reservation");
        City_id_Label.setBounds(10, 11, 66, 14);
        contentPane.add(City_id_Label);

        City_name_Label  = new JLabel("Class Name");
        City_name_Label.setBounds(300, 11, 66, 14);
        contentPane.add(City_name_Label);



        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String displayCitysql = "SELECT COUNT(Reservation_ID) AS Number_of_reservations, Class_name FROM reservation GROUP BY Class_name";
                    ResultSet rs = c.s.executeQuery(displayCitysql );
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(310, 400, 96, 34);
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
        btnExit.setBounds(205, 400, 96, 34);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


        getContentPane().setBackground(Color.GRAY);

    }

}