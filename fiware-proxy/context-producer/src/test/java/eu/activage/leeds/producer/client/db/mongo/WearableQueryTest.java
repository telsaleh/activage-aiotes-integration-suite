/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.db.mongo;

import com.mongodb.client.MongoClient;
import eu.activage.leeds.producer.client.db.MongoConnection;
import eu.activage.leeds.producer.client.db.WearableQuery;
import eu.activage.leeds.producer.formatter.HomeNgsiFormatter;
import eu.activage.leeds.producer.model.proxy.DeviceData;
import org.junit.Test;

import java.util.List;

/**
 *
 * @author te0003
 */
public class WearableQueryTest {

    @Test
    public void testGetAllWearableData() {

        try {
            MongoConnection mongoConnection = MongoConnection.getInstance();
        } catch (Exception ex) {
            return;
        }
        
        MongoClient mongoClient = MongoConnection.getInstance().getMongoClient();

        WearableQuery wq = new WearableQuery();
        List<DeviceData> ddls = wq.getAllWearableData("all");
        System.out.println("SHealth device count: " + ddls.size());
        HomeNgsiFormatter ngsiFormatter = new HomeNgsiFormatter();
        String requestBody = ngsiFormatter.getNgsiFormat(ddls);
        System.out.println(requestBody);

    }

}
