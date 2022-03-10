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
public class Food_item_info extends JFrame {
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
                    Food_item_info frame = new Food_item_info();
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
    public Food_item_info() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(230, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        t1= new JTable();
        t1.setBounds(10,30,965,450);
        t1.setBackground(Color.WHITE);
        contentPane.add(t1);

        Airline_id_Label = new JLabel("Passenger_CNIC");
        Airline_id_Label.setBounds(15, 11, 106, 14);
        contentPane.add(Airline_id_Label);

        Name_Label  = new JLabel("Passenger_Name");
        Name_Label.setBounds(170, 11, 106, 14);
        contentPane.add(Name_Label);

        Contact_no_Label = new JLabel("Food_Item");
        Contact_no_Label.setBounds(330, 11, 106, 14);
        contentPane.add(Contact_no_Label);

        Email_Label = new JLabel("Quantity");
        Email_Label.setBounds(490, 11, 106, 14);
        contentPane.add(Email_Label);

        Country_Label = new JLabel("Price");
        Country_Label.setBounds(655, 11, 106, 14);
        contentPane.add(Country_Label);

        Country_Label = new JLabel("Extras");
        Country_Label.setBounds(815, 11, 106, 14);
        contentPane.add(Country_Label);


        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String displayAirline_Infosql = "SELECT Passenger.Passenger_CNIC , passenger.passenger_name, fooditems.fooditem_name as food_item,\n" +
                            "fooditems.quantity, fooditems.price, fooditems.extras\n" +
                            "FROM passenger, fooditems\n" +
                            "WHERE passenger.passenger_cnic = fooditems.passenger_cnic\n" +
                            "GROUP BY Passenger.Passenger_CNIC , passenger.passenger_name, fooditems.fooditem_name,\n" +
                            "fooditems.quantity, fooditems.price, fooditems.extras";
                    ResultSet rs = c.s.executeQuery(displayAirline_Infosql );
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(390, 500, 120, 30);
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


        getContentPane().setBackground(Color.GRAY);

    }

}
