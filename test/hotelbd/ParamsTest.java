/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbd;

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
public class ParamsTest {
    
    public ParamsTest() {
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
     * Test of setsqlzaprosiGuest1 method, of class Params.
     */
//    @Test
//    public void testSetsqlzaprosiGuest1() {
//        System.out.println("setsqlzaprosiGuest1");
//        int yearinI = 0;
//        int monthinI = 0;
//        int dayinI = 0;
//        int yearoutI = 0;
//        int monthoutI = 0;
//        int dayoutI = 0;
//        Params instance = new Params();
//        instance.setsqlzaprosiGuest1(yearinI, monthinI, dayinI, yearoutI, monthoutI, dayoutI);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getsqlzaprosiGuest method, of class Params.
     */
    @Test
    public void testGetsqlzaprosiGuest() {
        System.out.println("Testing: getsqlzaprosiGuest");
            int i = 0;
            Params instance = new Params();
            String expResult = "";
            String result = instance.getsqlzaprosiGuest(i);
            String result1 = instance.getsqlzaprosiGuest(i+1);
            String result2 = instance.getsqlzaprosiGuest(i+1);
            result = "";
            assertEquals(expResult, result);
            assertEquals(result1, result2);
            
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getsqlzaprosiHAdmin method, of class Params.
     */
    @Test
    public void testGetsqlzaprosiHAdmin() {
        System.out.println("Testing: getsqlzaprosiHAdmin");
        int i = 0;
        Params instance = new Params();
        String expResult = "";
        String result = instance.getsqlzaprosiHAdmin(i);
        String result1 = instance.getsqlzaprosiHAdmin(i+1);
        String result2 = instance.getsqlzaprosiHAdmin(i+2);
        result = "";
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getsqlzaprosiTOPHAdmin method, of class Params.
     */
    @Test
    public void testGetsqlzaprosiTOPHAdmin() {
        System.out.println("Testing: getsqlzaprosiTOPHAdmin");
        int i = 0;
        Params instance = new Params();
        String expResult = "";
        String result = instance.getsqlzaprosiTOPHAdmin(i);
        result = "";
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getsqlzaprosiRestAdmin method, of class Params.
     */
    @Test
    public void testGetsqlzaprosiRestAdmin() {
        System.out.println("Testing: getsqlzaprosiRestAdmin");
        int i = 0;
        Params instance = new Params();
        String expResult = "";
        String result = instance.getsqlzaprosiRestAdmin(i);
        result = "";
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Params.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Params.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
