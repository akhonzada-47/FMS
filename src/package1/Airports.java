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
public class Airports extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable t1;
    private JLabel City_id_Label;
    private JLabel City_name_Label;
    private JLabel Country_Label;
    private JLabel Zip_Code_Label;


    /**
     * Launch the application.
     */
   public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Airports frame = new Airports();
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
    public Airports() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(230, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


       t1= new JTable();
        t1.setBounds(10,30,965,450);
        contentPane.add(t1);

        City_id_Label = new JLabel("Airport ID");
        City_id_Label.setBounds(15, 11, 46, 14);
        contentPane.add(City_id_Label);

        City_name_Label  = new JLabel("City ID");
        City_name_Label.setBounds(195, 11, 46, 14);
        contentPane.add(City_name_Label);

        Country_Label = new JLabel("Name");
        Country_Label.setBounds(285, 11, 46, 14);
        contentPane.add(Country_Label);

        Zip_Code_Label = new JLabel("Contact_no");
        Zip_Code_Label.setBounds(380, 11, 86, 14);
        contentPane.add(Zip_Code_Label);


       JLabel Email_Label = new JLabel("Email");
        Email_Label.setBounds(480, 11, 86, 14);
        contentPane.add(Email_Label);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String displayAirportssql = "select * from Airport order by airportname asc";
                    ResultSet rs = c.s.executeQuery(displayAirportssql );
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(510, 500, 120, 30);
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
        btnExit.setBounds(375, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


        getContentPane().setBackground(Color.GRAY);

    }

}