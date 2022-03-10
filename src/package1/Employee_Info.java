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
public class Employee_Info extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel Employee_CNIC_label;
    private JLabel Employee_name_label;
    private JLabel Address_label;
    private JLabel Salary_label;
    private JLabel Designation_label;
    private JLabel Email_label;
    private JLabel Phn_no_label;
    private JLabel Airport_id;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Employee_Info frame = new Employee_Info();
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
    public Employee_Info() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(230, 100, 1000, 600);
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
                    String displayEmployee_Infosql = "SELECT employees.employee_name AS employee_name, employees.employee_cnic, employees.designation, employees.salary, airport.airportid, airport.airportName AS airport_name\n" +
                            "FROM  airport INNER JOIN employees ON employees.airportid = airport.airportid";
                    ResultSet rs = c.s.executeQuery(displayEmployee_Infosql);
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

        Employee_CNIC_label = new JLabel("CNIC");
        Employee_CNIC_label.setBounds(170, 11, 46, 14);
        contentPane.add(Employee_CNIC_label);

        Employee_name_label = new JLabel("Name");
        Employee_name_label.setBounds(15, 11, 46, 14);
        contentPane.add(Employee_name_label);

        

        Salary_label = new JLabel("Salary");
        Salary_label.setBounds(490, 11, 86, 14);
        contentPane.add(Salary_label);

        Designation_label= new JLabel("Designation");
        Designation_label.setBounds(330, 11, 86, 14);
        contentPane.add(Designation_label);

        

        Airport_id = new JLabel("Airport_ID");
        Airport_id.setBounds(650, 11, 86, 14);
        contentPane.add(Airport_id);
        
        Airport_id = new JLabel("Airport Name");
        Airport_id.setBounds(815, 11, 86, 14);
        contentPane.add(Airport_id);

        getContentPane().setBackground(Color.GRAY);
    }
}