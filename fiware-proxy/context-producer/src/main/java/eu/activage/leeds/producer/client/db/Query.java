/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.db;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.include;
import eu.activage.leeds.producer.config.ProducerConfig;

/**
 *
 * @author te0003
 */
public class Query {

    private final MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> mongoCollection;
    protected final TimeZone tz = TimeZone.getTimeZone("UTC");
    protected final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

    protected Query() {

//        MongoConnection mongoConnection = new MongoConnection();
        this.mongoClient = MongoConnection.getInstance().getMongoClient();

    }

    protected List<String> getUsers(String uuid) {

        String collection = "users";

        String queryKey1 = "agreement.participation";
        String queryKey2 = "agreement.personalData";

        // get database
        String database = ProducerConfig.getInstance().getMongoAdminDb();
        mongoDatabase = mongoClient.getDatabase(database);

        mongoCollection = mongoDatabase.getCollection(collection);

        FindIterable<Document> documents;
        documents = mongoCollection.find(and(eq(queryKey1, true), eq(queryKey2, true))).projection(include("_id"));

        List<String> userIds = new ArrayList<>();
        for (Document document : documents) {
            
            if (uuid.equalsIgnoreCase(document.get("_id").toString()) || uuid.equalsIgnoreCase("all"))
            userIds.add(document.get("_id").toString());
        }
//        userIds.forEach((id) -> {System.out.println(id);});

        return userIds;

    }

}
