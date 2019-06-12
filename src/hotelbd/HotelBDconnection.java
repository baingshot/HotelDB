package hotelbd;
import java.sql.Connection;
import java.sql.DriverManager;

public class HotelBDconnection
{
   public Connection dbConnect(String db_connect_string,
            String db_userid,
            String db_password)
   {
       Connection conn = null;
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection(db_connect_string,
                  db_userid, db_password);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }

   
   public static void main(String[] args)
   {
   }
}