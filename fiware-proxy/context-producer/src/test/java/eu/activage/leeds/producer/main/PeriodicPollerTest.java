/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.main;

import eu.activage.leeds.producer.main.PeriodicDataPoller;
import org.junit.Test;

/**
 *
 * @author te0003
 */
public class PeriodicPollerTest {

    private final int interval = 5;
    private final String dataGroup = "home";
    //private final String uuid = "5caedc4a14c937331eae8069";
    private final String uuid = "5d7a562e4b574561c24bd331";
    
    @Test
    public void testPoller(){
        
        PeriodicDataPoller dataGroupPoller = new PeriodicDataPoller(dataGroup, interval, uuid);
        Thread dataGroupThread = new Thread(dataGroupPoller);
        dataGroupThread.start();
    
    }    
    
    public static void main(String[] args){
        
        PeriodicPollerTest ppt = new PeriodicPollerTest();
        PeriodicDataPoller dataGroupPoller = new PeriodicDataPoller(ppt.dataGroup, ppt.interval, ppt.uuid);
        Thread dataGroupThread = new Thread(dataGroupPoller);
        dataGroupThread.start();
    
    }    
    
}
