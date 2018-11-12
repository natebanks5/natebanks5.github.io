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
public class TranslationTest {
    
    public TranslationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of translateText method, of class Translation.
     */
    @Test
    public void testTranslateText() {
        System.out.println("translateText");
        String text = "esto es una prueba";
        Translation instance = new Translation();
        String expResult = "this is a test.";
        String result = instance.translateText(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
