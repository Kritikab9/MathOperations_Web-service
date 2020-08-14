
package newproject;

import java.sql.*;
import java.util.*;


public class NewProject
{
    
    public static void main(String[] args) 
    {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver loaded");
             Connection con =DriverManager.getConnection(url,"system","kritika");
             System.out.println("connection established");
             Statement s = con.createStatement();
             s.executeUpdate("create table operations (op varchar2(20),no1 Number,no2 Number,result Number)");
                System.out.println("table operation created ");      
               
                
                  //   s.executeUpdate("create table operations (op varchar2(20),no1 Number,no2 Number,result Number)");
                
              
        }
        
         catch(SQLSyntaxErrorException e)    
         {
             Inserting o = new Inserting();
             o.insert();
         }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    }
   
   
    
}
