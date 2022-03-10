package package1;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dashboard extends JFrame{

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("FLIGHT MANAGEMENT SYSTEM");
        initialize();
    }


    private void initialize() {

        setForeground(Color.CYAN);
        setLayout(null);

//        JLabel NewLabel = new JLabel();
//        NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("E://fms.jpg")));
//        NewLabel.setBounds(0, 0, 1920, 990);
//        add(NewLabel);

        JLabel AirlineManagementSystem = new JLabel("FLIGHT MANAGEMENT SYSTEM");
        AirlineManagementSystem.setForeground(Color.BLUE);
        AirlineManagementSystem.setFont(new Font("Forte", Font.PLAIN, 46));
        AirlineManagementSystem.setBounds(600, 60, 1000, 55);
        add(AirlineManagementSystem);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        

        JMenu AirlineSystem = new JMenu("SYSTEM DETAILS");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem AIRLINE_INFO = new JMenuItem("AIRLINES");
        AirlineSystem.add(AIRLINE_INFO);
        
        AIRLINE_INFO.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Airline_Info().setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        JMenuItem CITIES = new JMenuItem("CITIES");
        AirlineSystem.add(CITIES);
        
        CITIES.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Cities().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem AIRPORTS = new JMenuItem("AIRPORTS");
        AirlineSystem.add(AIRPORTS);
        AIRPORTS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Airports().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem AIRPLANES = new JMenuItem("AIRPLANES");
        AirlineSystem.add(AIRPLANES);
        AIRPLANES.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Airplanes().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        
        JMenu ad = new JMenu("ADD DATA");
        ad.setForeground(Color.BLUE);
        menuBar.add(ad);

        JMenuItem addPilot=new JMenuItem("Add Pilot");
        ad.add(addPilot);
        addPilot.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Add_Pilot().setVisible(true);
            } 
            
        });
        
        
        JMenuItem addEmployee=new JMenuItem("Add Employee");
        ad.add(addEmployee);
        addEmployee.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Add_Employees().setVisible(true);
            }           
            
        });
        
        JMenuItem addLug=new JMenuItem("Add Luggage");
        ad.add(addLug);
        addLug.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Add_Luggage().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }           
            
        });
        
        JMenuItem addFood=new JMenuItem("Add Food Items");
        ad.add(addFood);
        addFood.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new buyfooditems().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }           
            
        });
        
        
        JMenu fd = new JMenu("VIEW DATA");
        fd.setForeground(Color.BLUE);
        menuBar.add(fd);
        
         JMenuItem f=new JMenuItem("Flight Details");
        fd.add(f);
        f.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Flight_Info().setVisible(true);
            } 
            
        });
        
        JMenuItem p=new JMenuItem("Pilot Details");
        fd.add(p);
        p.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Pilot_Info().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            
        });
        
        
        JMenuItem emp=new JMenuItem("Employee Details");
        fd.add(emp);
        emp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Employee_Info().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            
        });
        
        
        JMenuItem rsd=new JMenuItem("Reservation Details");
        fd.add(rsd);
        rsd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Reservation_Info().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            
        });
        
       JMenuItem pay=new JMenuItem("Payment Details");
        fd.add(pay);
        pay.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Payment().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            
        });
        
        JMenuItem food=new JMenuItem("Refreshment Details");
        fd.add(food);
        food.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Food_item_info().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            
        });  
        
        JMenu RESERVE = new JMenu("RESERVATION");
        RESERVE.setForeground(Color.BLUE);
        menuBar.add(RESERVE);

        JMenuItem rsf=new JMenuItem("Reserve Flight ");
        RESERVE.add(rsf);
        rsf.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Reserve_Flight().setVisible(true);
            }
            
        });
        
        
        
        JMenuItem rsc= new JMenuItem("Show Reserved Classes");
        RESERVE.add(rsc);
        rsc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                try {
                    new Reserved_Classes().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JMenuItem cancel= new JMenuItem("Cancel Reservation");
        RESERVE.add(cancel);
        rsc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                try {
                    new cancellation().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        setSize(1950,1090);
        setVisible(true);
        getContentPane().setBackground(Color.orange);
    }
}
