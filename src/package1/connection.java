package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class connection{

    Connection c;
    Statement s;
    public connection(){
        try{

            c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","gm");

            s =c.createStatement();
            System.out.println("Connected!");

        }catch(Exception e){
            e.printStackTrace();;
            System.out.println(e);
        }
    }
}
