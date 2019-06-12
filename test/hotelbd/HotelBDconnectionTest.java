/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbd;

import java.sql.Connection;
import java.sql.SQLException;
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
public class HotelBDconnectionTest {
    
    public HotelBDconnectionTest() {
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
     * Test of dbConnect method, of class HotelBDconnection.
     */
    @Test
    public void testDbConnect() throws SQLException {
        System.out.println("Testing: dbConnect");
        boolean expResult = true;
        String db_connect_string = "jdbc:sqlserver://localhost:1433;databaseName=HotelBDNEW";
        String db_userid = "HotelBD";
        String db_password = "12345";
        HotelBDconnection instance = new HotelBDconnection();
        Connection result = instance.dbConnect(db_connect_string, db_userid, db_password);
        assertEquals(expResult, result.isValid(1));
     
    }

    /**
     * Test of main method, of class HotelBDconnection.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        HotelBDconnection.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
