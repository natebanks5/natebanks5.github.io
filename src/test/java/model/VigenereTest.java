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
public class VigenereTest {
    
    public VigenereTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of decrypt method, of class Vigenere.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        String text = "Obywtjo";
        String key = "KEY";
        Vigenere instance = new Vigenere();
        String expResult = "Example";
        String result = instance.decrypt(text, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
        /**
     * Test of decrypt method, of class Vigenere.
     */
    @Test
    public void testDecrypt2() {
        System.out.println("decrypt");
        String text = "dlgc mq k kmyh rowr";
        String key = "KEY";
        Vigenere instance = new Vigenere();
        String expResult = "Thisisagoodtest";
        String result = instance.decrypt(text, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
