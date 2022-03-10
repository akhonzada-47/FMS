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
public class Airplanes extends JFrame {
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
                        Airplanes frame = new Airplanes();
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
    public Airplanes() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(230, 180, 1050, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       t1= new JTable();
        t1.setBounds(10,40,1015,360);
        contentPane.add(t1);

        City_id_Label = new JLabel("Airplane_id");
        City_id_Label.setBounds(15, 11, 100, 30);
        contentPane.add(City_id_Label);

        City_name_Label  = new JLabel("Airplane Name");
        City_name_Label.setBounds(180, 11, 100, 30);
        contentPane.add(City_name_Label);

        Country_Label = new JLabel("Seats");
        Country_Label.setBounds(350, 11, 46, 30);
        contentPane.add(Country_Label);

        JLabel Company_label = new JLabel("Manufacturing Company");
        Company_label.setBounds(515, 11, 150, 30);
        contentPane.add(Company_label);

        JLabel Date_label = new JLabel("Manufacturing Date");
        Date_label.setBounds(685, 11, 150, 30);
        contentPane.add(Date_label);

        JLabel Airline_id_label = new JLabel("Airline_id");
        Airline_id_label.setBounds(850, 11, 90, 30);
        contentPane.add(Airline_id_label);



        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String displayCitysql = "select * from Airplanes";
                    ResultSet rs = c.s.executeQuery(displayCitysql );
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(890, 410, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        add(btnLoadData);



        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(51, 50, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


        getContentPane().setBackground(Color.GRAY);

    }

}