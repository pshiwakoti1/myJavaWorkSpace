package ExamplePackage;
import java.sql.*;



public class ConnectionManager {

   static Connection connection;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
         String url = "jdbc:mysql://localhost/TEST?useSSL=false";
         Class.forName("com.mysql.jdbc.Driver");
         
         try
         {            	
            connection = DriverManager.getConnection(url,"root","test"); 
             								
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return connection;
}
}
