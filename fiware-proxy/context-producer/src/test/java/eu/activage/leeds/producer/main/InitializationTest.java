/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author te0003
 */
public class InitializationTest {
    
    public InitializationTest() {
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
     * Test of initializeConfig method, of class Initialization.
     */
    @Test
    public void testInitializeConfig() throws Exception {
        System.out.println("initializeConfig");
        Initialization instance = new Initialization();
        instance.initializeConfig();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeDatabaseAccess method, of class Initialization.
     */
    @Test
    public void testInitializeDatabaseAccess() throws Exception {
        System.out.println("initializeDatabaseAccess");
        Initialization instance = new Initialization();
        instance.initializeDatabaseAccess();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
