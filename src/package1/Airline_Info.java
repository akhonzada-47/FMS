package package1;

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
public class Airline_Info extends JFrame {
    
    Connection conn = null;
    
    private JPanel contentPane;
    private JTable t1;
    private JLabel Airline_id_Label;
    private JLabel Name_Label;
    private JLabel Contact_no_Label;
    private JLabel Email_Label;
    private JLabel Country_Label;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Airline_Info frame = new Airline_Info();
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
    public Airline_Info() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        t1= new JTable();
        t1.setBounds(10,30,965,450);
        t1.setBackground(Color.WHITE);
        contentPane.add(t1);
        
        Airline_id_Label = new JLabel("Airline_id");
        Airline_id_Label.setBounds(15, 11, 86, 14);
        contentPane.add(Airline_id_Label);

         Name_Label  = new JLabel("Name");
        Name_Label.setBounds(205, 11, 86, 14);
        contentPane.add(Name_Label);

        Contact_no_Label = new JLabel("Contact_no");
        Contact_no_Label.setBounds(400, 11, 86, 14);
        contentPane.add(Contact_no_Label);

        Email_Label = new JLabel("Email");
        Email_Label.setBounds(590, 11, 86, 14);
        contentPane.add(Email_Label);

        Country_Label = new JLabel("Country");
        Country_Label.setBounds(785, 11, 86, 14);
        contentPane.add(Country_Label);


        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String displayAirline_Infosql = "SELECT * FROM airline ORDER BY Country DESC";
                    ResultSet rs = c.s.executeQuery(displayAirline_Infosql );
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
                setVisible(false);
            }
        });
        btnExit.setBounds(515, 500, 96, 34);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


        getContentPane().setBackground(Color.GRAY);

    }

}