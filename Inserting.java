
package newproject;
import java.sql.*;
import java.util.*;
import java.lang.*;
public class Inserting
{
    public  void  insert() 
    {
          
          
       
       
        try
        {
             Class.forName("oracle.jdbc.driver.OracleDriver");
           //  System.out.println("driver loaded");
           
            // System.out.println("connection established");
           
            //  s.executeUpdate("Alter table operation add serialno Number");
            //System.out.println("updated table created");
            menue ();
        } 
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    } 
        public static void menue()
        {
              String url="jdbc:oracle:thin:@localhost:1521:xe";
            try{
             Connection con =DriverManager.getConnection(url,"system","kritika");
             Statement s=con.createStatement();
            Operations ob=new Operations();
            String opr = null;
            int res = 0 ;
            int n = 0;
            int n1=0,n2=0;
            Scanner sc=new Scanner(System.in);
            System.out.println("menue enter the options  ");
            System.out.println("1. addition");
            System.out.println("2. subtraction");
            System.out.println("3. multiplication");
            System.out.println("4. division");
            System.out.println("5. Exit");
            System.out.println("6. Show database");
            System.out.println("enter your option");
            try{
               n =sc.nextInt();
             
            }
           catch(Exception InputMismatchException)
           {
               System.out.println("input is not int type");
               System.out.println("try again");
               menue();
           }
            
           if(n!=1 && n!=2 && n!=3 && n!=4 && n!=5 && n!=6 )
           {
               System.out.println("sorry !! invalid option try again");
               menue();
               
           }
           if(n==5)
           {
                System.out.println("exiting....");
              System.exit(0);
            
           }
           if(n==6)
           {
               ResultSet rs=s.executeQuery("Select * from operations");
                 while(rs.next())
                    {
                        System.out.print(rs.getString(1)+" ");
                        System.out.print(rs.getString(2)+" ");
                        System.out.print(rs.getString(3)+" ");
                        System.out.print(rs.getString(4)+" ");
                        System.out.println(" ");
                        
          
            }
                 menue();
           }
            
            System.out.println("enter the 2 nos");
            try
            {
                n1=sc.nextInt();
                n2=sc.nextInt();
            }
             catch(Exception InputMismatchException)
           {
               System.out.println("input is not int type");
               System.out.println("try again");
               menue();
           }
            
            if(n==1)
            {
                 res=ob.add(n1, n2);
                 opr="addition";
            }
                
            else if(n==2)
            {
                   res=ob.sub(n1, n2);
                   opr="subtraction";
            }
                   
            else if(n==3)
            {
                 res=ob.mult(n1, n2);
                 opr="multiplication";
                 
            }
            else 
            {
                if(n2==0)
                {
                    try
                    {
                        throw new ArithmeticException();
                    }
                    catch(Exception ArithmeticException )
                    {
                        System.out.println("divisor cannot be zero");
                        menue();
                    }
                }
                 res=ob.div(n1, n2);
                 opr="division";
                
            }
           
           
            int x  = s.executeUpdate("Insert into operations values ('"+opr+"',"+n1+","+n2+","+res+")");
                System.out.print(opr);
                System.out.print(" "+n1);
                 System.out.print(" "+n2);
                  System.out.println(" "+res);
          
           menue();
            }
            
              catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
            
        
    }
        
        public static void printDatabase()
        {
            String url="jdbc:oracle:thin:@localhost:1521:xe";
            try
            {
                Connection con =DriverManager.getConnection(url,"system","kritika");
             Statement s=con.createStatement();
                 ResultSet rs=s.executeQuery("Select * from operations");
                 while(rs.next())
                    {
                        System.out.print(rs.getString(1)+" ");
                        System.out.print(rs.getString(2)+" ");
                        System.out.print(rs.getString(3)+" ");
                        System.out.print(rs.getString(4)+" ");
                        System.out.println(" ");
                        
          
            }
                 menue();
        }
            catch(SQLException e)
            {
                System.out.println(e);
            }
        
    }
}
        
  
    

