/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoovb
 */
public class CaesarTest {
    
    public CaesarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of decrypt method, of class Caesar.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        String text = "Lehtwsl";
        Caesar instance = new Caesar();
        String expResult = "Example";
        String result = instance.decrypt(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
        /**
     * Test of decrypt method, of class Caesar.
     */
    @Test
    public void testDecrypt2() {
        System.out.println("decrypt");
        String text = "aopz pz h svun alza";
        Caesar instance = new Caesar();
        String expResult = "this is a long test";
        String result = instance.decrypt(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
