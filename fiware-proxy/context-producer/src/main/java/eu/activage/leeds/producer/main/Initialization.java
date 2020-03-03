/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.main;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import eu.activage.leeds.producer.client.db.MongoConnection;
import eu.activage.leeds.producer.config.ProducerConfig;
import org.bson.Document;

/**
 *
 * @author te0003
 */
class Initialization {

//    private static Initialization instance;
void initializeConfig() throws Exception {

    ProducerConfig proxyConfig = ProducerConfig.getInstance();

}

    void initializeDatabaseAccess() throws Exception {

        MongoConnection mongoConnection = MongoConnection.getInstance();
        String database = ProducerConfig.getInstance().getMongoAdminDb();
        MongoDatabase mongoDatabase = MongoConnection.getInstance().getMongoClient()
                .getDatabase(database);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");
        FindIterable<Document> documents;
        mongoCollection.find().first();
    }
}
