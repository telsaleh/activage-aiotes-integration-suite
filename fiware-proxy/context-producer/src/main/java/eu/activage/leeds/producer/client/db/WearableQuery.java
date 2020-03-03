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
import eu.activage.leeds.producer.model.proxy.DeviceData;
import eu.activage.leeds.producer.model.proxy.DeviceProfile;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.orderBy;

/**
 *
 * @author te0003
 */
public class WearableQuery extends Query{
    
    public WearableQuery(){
        super();
    }

    public List<DeviceData> getAllWearableData(String uuid) {

        List<String> users = this.getUsers(uuid);
        List<DeviceProfile> dpl = getUserDeviceProfiles(users);
        System.out.println("User profile count: "+ dpl.size());
        return getSHealthAggregatedDeviceData(dpl);
    }
    
    private List<DeviceProfile> getUserDeviceProfiles(List<String> users) {
        
        // get collecion
        String deviceProfileCollection = "energenieuserconfigs";
        mongoCollection = mongoDatabase.getCollection(deviceProfileCollection);
        // query key

        List<DeviceProfile> dps = new ArrayList<>();

        // for each user
        for (String user : users) {

            // find documents that match user and has required fields
            FindIterable<Document> documents;
            String deviceProfileQueryKey = "device";
            documents = mongoCollection.find(and(eq(deviceProfileQueryKey, user),
                    exists("user", true), exists("gearSerialNumber", true), exists("phoneIMEI", true),
                    ne("gearSerialNumber", null), ne("gearSerialNumber", ""), ne("phoneIMEI", null), ne("phoneIMEI", "")));

            documents.projection(fields(include("user", "gearSerialNumber", "phoneIMEI"), excludeId()));
            documents.projection(fields(exclude("devices._id"), excludeId()));
            documents.limit(1);
            documents.sort(orderBy(descending("user")));

            for (Document document : documents) {

                DeviceProfile dp = new DeviceProfile();
                dp.setUser(document.get("user").toString());
                dp.setGearSerialNumber(document.get("gearSerialNumber").toString());
                dp.setPhoneIMEI(document.get("phoneIMEI").toString()); 
                dps.add(dp);
            }
        }
        return dps;
    }

    private List<DeviceData> getSHealthAggregatedDeviceData(List<DeviceProfile> dpl) {
        
        // get database
        
//        MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
        // get collecion
        String sHealthAggrCollection = "shealthaggregateddatas";
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(sHealthAggrCollection);
        // query key
        

        List<DeviceData> ddl = new ArrayList<>();

        for (DeviceProfile dp : dpl) {

//            System.out.println(dp.getUser());

            FindIterable<Document> documents;
            String sHealthQueryKey = "user_uuid";
            documents = mongoCollection.find(and(eq(sHealthQueryKey, dp.getUser()),
                    exists("user_uuid", true), exists("parameter", true), exists("value", true), exists("timestamp", true)));
            documents.projection(fields(include("user_uuid", "parameter", "value", "timestamp", "value_label")));
            documents.sort(orderBy(descending("_id"))); //latest value since ObjectId is generated from timestamp            
            documents.limit(1);
            Document document = documents.first();
            DeviceData deviceData = new DeviceData();
            try {
                deviceData.setDeviceId(dp.getGearSerialNumber());
                deviceData.setUserId(Objects.requireNonNull(document).get("user_uuid").toString());
                deviceData.setType(document.get("parameter").toString());
                deviceData.setObservationId(document.get("_id").toString());
                deviceData.setValue(document.get("value").toString());
                deviceData.setValueLabel(document.get("value_label").toString());
                long millisecondsSinceUnixEpoch = Long.parseLong(document.get("timestamp").toString()) * 1000;
                deviceData.setTimestamp(dateFormat.format(millisecondsSinceUnixEpoch));
            } catch (NullPointerException npe) {
                System.out.println("ERROR:" + npe.getLocalizedMessage());
                System.out.println("INCOMPLETE OR MISSING SHEALTH DEVICE AGGREGATED DATA");
                continue;
            }

            ddl.add(deviceData);

        }
        return ddl;
    }    

}
