/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.api;

import com.mongodb.client.MongoClient;
import eu.activage.leeds.producer.client.db.MongoConnection;
import eu.activage.leeds.producer.formatter.HomeNgsiFormatter;
import eu.activage.leeds.producer.model.proxy.DeviceData;
import org.junit.Test;

import java.util.List;

/**
 *
 * @author te0003
 */
public class SmartThingsQueryTest {

    @Test
    public void testGetAllSmartThingsData() {
        
        try {
            MongoConnection mongoConnection = MongoConnection.getInstance();
        } catch (Exception ex) {
            return;
        }
        
        MongoClient mongoClient = MongoConnection.getInstance().getMongoClient();
              
        SmartThingsQuery eq = new SmartThingsQuery();
        List<DeviceData> ddle = eq.getAllSmartThingsData("5d7a562e4b574561c24bd331"); 
        System.out.println("SmartThings device count: " + ddle.size());
        HomeNgsiFormatter ngsiFormatter = new HomeNgsiFormatter();
        String requestBody = ngsiFormatter.getNgsiFormat(ddle);
        System.out.println(requestBody);
    }

}
