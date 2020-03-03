/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.db;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import eu.activage.leeds.producer.config.ProducerConfig;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author te0003
 */
public class MongoConnection {

    private static MongoConnection instance;
    private MongoClient mongoClient;

    public MongoClient getMongoClient() {
        return mongoClient;
    }
    
    private MongoConnection(){
        
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
        String mongoHostname = ProducerConfig.getInstance().getMongoHostname();
        int mongoPort = Integer.parseInt(ProducerConfig.getInstance().getMongoPort());
        String adminDb = ProducerConfig.getInstance().getMongoAdminDb();
        String username = ProducerConfig.getInstance().getMongoUsername();
        String password = ProducerConfig.getInstance().getMongoPassword();

        System.out.println("Connecting to DB at..." + mongoHostname + ":" + mongoPort);
        //  Use username, authtication database and password in MongoCredential object
        MongoCredential mongoCredential = MongoCredential.createCredential(username, adminDb, password.toCharArray());
        ServerAddress serverAddress = new ServerAddress(mongoHostname, mongoPort);
        MongoClientSettings settings = MongoClientSettings.builder().credential(mongoCredential)
                .applyToSslSettings(builder -> builder.enabled(false))
                .applyToClusterSettings(builder -> builder.hosts(Collections.singletonList(serverAddress)))
                .applyToClusterSettings(builder -> builder.serverSelectionTimeout(5, TimeUnit.SECONDS))
                .build();
        
        mongoClient = MongoClients.create(settings);
                
        System.out.println("Connected to DB...");       
    
    
    }

//    public MongoClient openConnection() {
//        
//        
//
//        return mongoClient;
//
//    }
    
    public static synchronized MongoConnection getInstance() {
        if (instance == null) {
            instance = new MongoConnection();
        }
        return instance;
    }
}
