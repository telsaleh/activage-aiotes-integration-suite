/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.db.mongo;

import com.mongodb.client.MongoClient;
import eu.activage.leeds.producer.client.db.EnergenieQuery;
import eu.activage.leeds.producer.client.db.MongoConnection;
import eu.activage.leeds.producer.formatter.HomeNgsiFormatter;
import eu.activage.leeds.producer.model.proxy.DeviceData;
import org.junit.Test;

import java.util.List;

/**
 *
 * @author te0003
 */
public class EnergenieQueryTest {

    @Test(expected = Exception.class)
    public void testGetAllEnergenieData() {

        try {
            MongoConnection mongoConnection = MongoConnection.getInstance();
        } catch (Exception ex) {
            return;
        }
        MongoClient mongoClient = MongoConnection.getInstance().getMongoClient();
        
        // eqt = new EnergenieQueryTest();
        EnergenieQuery eq = new EnergenieQuery();
        List<DeviceData> ddle = eq.getAllEnergenieData("5caedc4a14c937331eae8069"); 
        System.out.println("Energenie device count: " + ddle.size());
        HomeNgsiFormatter ngsiFormatter = new HomeNgsiFormatter();
        String requestBody = ngsiFormatter.getNgsiFormat(ddle);
        System.out.println(requestBody);
    }

}
