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
public class Cities extends JFrame {
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
    public static void main(String[] args) throws SQLException
    {
        Cities city = new Cities();
        city.setVisible(true);
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                        Cities frame = new Cities();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
    public void close()
    {
        this.dispose();
    }
    /**
     * Create the frame.
     * @throws SQLException
     */
    public Cities() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(230, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //contentPane.setLayout(null);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        t1= new JTable();
        t1.setBounds(10,30,965,450);
        contentPane.add(t1);

        City_id_Label = new JLabel("City_id");
        City_id_Label.setBounds(15, 11, 46, 14);
        contentPane.add(City_id_Label);

        City_name_Label  = new JLabel("Airport Name");
        City_name_Label.setBounds(255, 11, 46, 14);
        contentPane.add(City_name_Label);

        Country_Label = new JLabel("Country");
        Country_Label.setBounds(490, 11, 46, 14);
        contentPane.add(Country_Label);

        Zip_Code_Label = new JLabel("Zip_Code");
        Zip_Code_Label.setBounds(735, 11, 86, 14);
        contentPane.add(Zip_Code_Label);



        JButton btnLoadData = new JButton("Load Data");       
        btnLoadData.setBounds(510, 500, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);
        
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String displayCitysql = "select * from City order by city_name asc";
                    ResultSet rs = c.s.executeQuery(displayCitysql );
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
         
        



        JButton btnExit = new JButton("Back");
        btnExit.setBounds(385, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true);
                setVisible(false);
            }
        });
        


        getContentPane().setBackground(Color.GRAY);

    }

}