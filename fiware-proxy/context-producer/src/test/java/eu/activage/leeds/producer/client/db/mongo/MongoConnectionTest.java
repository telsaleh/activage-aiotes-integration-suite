/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.db.mongo;

import com.mongodb.client.MongoClient;
import eu.activage.leeds.producer.client.db.MongoConnection;
import org.junit.Test;


/**
 * @author te0003
 */
public class MongoConnectionTest {

    protected MongoClient mongoClient;

    @Test
    public void testConnection() {

        try {
            MongoConnection mongoConnection = MongoConnection.getInstance();
        } catch (Exception ex) {
            return;
        }
        
        MongoClient mc = MongoConnection.getInstance().getMongoClient();

    }
}
