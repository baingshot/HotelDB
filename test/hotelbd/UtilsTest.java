/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bvc
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of modTest method, of class Utils.
     */

    /**
     * Test of getdatafortable method, of class Utils.
     */
//    @Test
//    public void testGetdatafortable() {
//        System.out.println("Testing: getdatafortable");
//              boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    /**
     * Test of changepassvxodframeGuest method, of class Utils.
     */
    @Test
    public void testChangepassvxodframeGuest() {
        System.out.println("Testing: changepassvxodframeGuest");
           
        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
        String db_userid = "HotelBD";
        String db_password = "12345";
        HotelBDconnection instance = new HotelBDconnection();
        Connection connection = instance.dbConnect(db_connect_string, db_userid, db_password);
   
        int id = 1005;
        String expResult = "testKey";
        User1 guest = new User1();
        guest.setMe(guest);
        guest.getconn(connection);
        guest.setcurrentuserid(id);
        guest.getnewpass().setText(expResult);
        new Utils().changepassvxodframeGuest(guest);
              
        String result = null;
        try(PreparedStatement statementGet = connection.prepareStatement("select Visitors.password from Visitors where Visitors.idvisitor =1005;");
               ResultSet rs = statementGet.executeQuery(); ){   
         while (rs.next()) {
         result = rs.getString(1);  
         }
        } catch( SQLException e ){
            System.out.println(e.getMessage());
        }
        
        assertEquals(expResult, result);
    }

    //Testing---------------------------------------------------------
    /*
       System.out.println("Testing: changepassvxodframeGuest");
           
        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
        String db_userid = "HotelBD";
        String db_password = "12345";
        HotelBDconnection instance = new HotelBDconnection();
        Connection connection = instance.dbConnect(db_connect_string, db_userid, db_password);
   
        String expResult = "testKey";
        int id = 1005;
        try( PreparedStatement statementSet = connection.prepareStatement("UPDATE Visitors SET password=? WHERE Visitors.idvisitor=? ;"); ) 
        {
            statementSet.setString(1, expResult);
            statementSet.setInt(2, id);
            statementSet.executeUpdate();
        }catch( SQLException e){
            System.out.println(e.getMessage());
        }
        
        String result = null;
        try(PreparedStatement statementGet = connection.prepareStatement("select Visitors.password from Visitors where Visitors.idvisitor =1005;");
               ResultSet rs = statementGet.executeQuery(); ){   
     
         while (rs.next()) {
         result = rs.getString(1);  
         }
        
        } catch( SQLException e ){
            System.out.println(e.getMessage());
        }
        
        assertEquals(expResult, result);
    */
    
    /**
     * Test of addmealvxodframeGuest method, of class Utils.
     */
//    @Test
//    public void testAddmealvxodframeGuest() {
//        System.out.println("Testing: addmealvxodframeGuest");
//                boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
//
////
//    /**
//     * Test of zaselenieGuest method, of class Utils.
//     */
//    @Test
//    public void testZaselenieGuest() {
//        System.out.println("Testing: zaselenieGuest");
//               boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//
//    /**
//     * Test of newGuestHadmin method, of class Utils.
//     */
//    @Test
//    public void testNewGuestHadmin() {
//        System.out.println("Testing: newGuestHadmin");
//               boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Test of editRoomHAdmin method, of class Utils.
//     */
//    @Test
//    public void testEditRoomHAdmin() {
//        System.out.println("Testing: editRoomHAdmin");
//                 boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    /**
//     * Test of deletesmthHAdmin method, of class Utils.
//     */
//    @Test
//    public void testDeletesmthHAdmin() {
//        System.out.println("Testing: deletesmthHAdmin");
//                boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    /**
//     * Test of newmealRestAdmin method, of class Utils.
//     */
//    @Test
//    public void testNewmealRestAdmin() {
//        System.out.println("Testing: newmealRestAdmin");
//                boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
////
//    /**
//     * Test of editmealRestAdmin method, of class Utils.
//     */
//    @Test
//    public void testEditmealRestAdmin() {
//        System.out.println("Testing: editmealRestAdmin");
//                boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    /**
//     * Test of deletesmthRestAdmin method, of class Utils.
//     */
//    @Test
//    public void testDeletesmthRestAdmin() {
//        System.out.println("Testing: deletesmthRestAdmin");
//                 boolean expResult = true;
//        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
//        String db_userid = "HotelBD";
//        String db_password = "12345";
//        HotelBDconnection instance = new HotelBDconnection();
//        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
//        try {
//            assertEquals(expResult, result.isValid(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilsTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
////    
}
