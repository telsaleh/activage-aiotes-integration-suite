package eu.activage.leeds.producer.client.db;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package eu.activage.leeds.client.database.mongo.services;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mongodb.MongoClient;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import eu.activage.leeds.client.database.mongo.MongoConnection;
//import static com.mongodb.client.model.Filters.and;
//import static com.mongodb.client.model.Filters.eq;
//import static com.mongodb.client.model.Filters.exists;
//import static com.mongodb.client.model.Filters.ne;
//import static com.mongodb.client.model.Indexes.descending;
//import static com.mongodb.client.model.Projections.exclude;
//import static com.mongodb.client.model.Projections.excludeId;
//import static com.mongodb.client.model.Projections.fields;
//import static com.mongodb.client.model.Projections.include;
//import static com.mongodb.client.model.Sorts.orderBy;
//import eu.activage.leeds.io.formatter.ngsi.ADLNgsiFormatter;
//import eu.activage.leeds.models.proxy.ActivityData;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.TimeZone;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.bson.Document;
//import org.json.*;
//
///**
// *
// * @author te0003
// */
//public class ADLQuery {
//
//    protected MongoClient mongoClient;
//    protected MongoDatabase mongoDatabase;
//    protected MongoCollection<Document> mongoCollection;
//    protected final String database = "activage";
//    protected TimeZone tz = TimeZone.getTimeZone("UTC");
//    protected DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
//
//    
//    public String getAllActivityData() {
//
//        MongoConnection ct = new MongoConnection();
//        mongoClient = ct.openConnection();
//        
//        List<String> users = getUsers();
//
//        String collection = "homemonitoringdatas";
//
//        // get database
//        mongoDatabase = mongoClient.getDatabase(database);
//        mongoCollection = mongoDatabase.getCollection(collection);
//        
//        List<ActivityData> adList = new ArrayList<>();
//        
//        String queryKey1 = "uuid";
//        
//         for (String user : users) {
//
//        FindIterable<Document> documents;
//        documents = mongoCollection.find(and(ne("data", null),eq(queryKey1, user)));
//        
//
//        //JSON document parsing and extraction
//        for (Document document : documents) {
//
//            String userId = document.getString("uuid");
//            String jsonDoc = document.toJson();
//            JSONObject root = new JSONObject(jsonDoc);
//            JSONObject data = root.getJSONObject("data");
//
//            ActivityData activityData = new ActivityData();
//
//            try {
//                String activity = data.names().getString(0); // THIS IS NOT ENOUGH, YOU NEED TO GET ALL STRINGS
//                JSONObject dailyResult = data.getJSONObject(activity).getJSONArray("yesterday").getJSONObject(0);
//
//                activityData.setUserId(userId);
//                activityData.setType(activity);
//                long millisecondsSinceUnixEpoch = dailyResult.getLong("timestamp") * 1000;
//                dateFormat.setTimeZone(tz);
//                activityData.setTimestamp(dateFormat.format(millisecondsSinceUnixEpoch));
////                activityData.setTimestamp(String.valueOf(dailyResult.getInt("timestamp")));
//                activityData.setGreenUpper(dailyResult.getInt("green_upper"));
//                activityData.setYellowUpper(dailyResult.getInt("yellow_upper"));                
//                activityData.setGreenLower(dailyResult.getInt("green_lower"));
//                activityData.setYellowLower(dailyResult.getInt("yellow_lower"));
//                try{
//                activityData.setRedUpper(dailyResult.getInt("red_upper"));
//                activityData.setRedLower(dailyResult.getInt("red_lower"));}
//                catch(org.json.JSONException npe){
////                    System.out.println(npe.getLocalizedMessage());
//                }
//                
//                ObjectMapper objectMapper = new ObjectMapper();
//                try {
//                    System.out.println(objectMapper.writeValueAsString(activityData));
//                } catch (JsonProcessingException ex) {
//                    Logger.getLogger(ADLQuery.class.getName()).log(Level.SEVERE, null, ex);
//                }
////                System.out.println(JSONStringer.valueToString(activityData.toString()));
//
//                adList.add(activityData);
//
//            } catch (org.json.JSONException | java.lang.NullPointerException jsonEx) {
////                System.out.println(jsonEx.getLocalizedMessage());
//                continue;
//            }
//        }
//        
//         }
//         
//         ADLNgsiFormatter nf = new ADLNgsiFormatter();
//         String requestBody = nf.getAllServicesNgsiFormat(adList);
//          return requestBody;
//
//    }
//
//    public List<String> getUsers() {
//
//        String collection = "users";
//
//        String queryKey1 = "agreement.participation";
//        String queryKey2 = "agreement.personalData";
//        boolean queryValue = true;
//
//        // get database
//        mongoDatabase = mongoClient.getDatabase(database);
//
//        mongoCollection = mongoDatabase.getCollection(collection);
//
//        FindIterable<Document> documents;
//        documents = mongoCollection.find(and(eq(queryKey1, queryValue), eq(queryKey2, queryValue))).projection(include("_id"));
//
////        System.out.println("Query results:");
//        List<String> userIds = new ArrayList<>();
//        for (Document document : documents) {
//            userIds.add(document.get("_id").toString());
////            System.out.println(document.toJson());
//        }
//
//        //print
////        for (String id : userIds) {
////            System.out.println(id);
////        }
//        return userIds;
//
//    }
//
//    public List<DeviceProfile> getUserDeviceProfiles(List<String> users) {
//
//        String collection = "energenieuserconfigs";
//
//        // get database
//        mongoDatabase = mongoClient.getDatabase(database);
//        // get collecion
//        mongoCollection = mongoDatabase.getCollection(collection);
//        // query key
//        String queryKey1 = "user";
//
//        List<DeviceProfile> dps = new ArrayList<>();
//
//        // for each user
//        for (String user : users) {
//
//            // find documents that match user and has required fields
//            FindIterable<Document> documents;
//            documents = mongoCollection.find(and(eq(queryKey1, user),
//                    exists("user", true), exists("mac", true), exists("gearSerialNumber", true), exists("electricMonitorId", true), exists("phoneIMEI", true), exists("devices", true),
//                    ne("mac", null), ne("mac", ""), ne("gearSerialNumber", null), ne("gearSerialNumber", ""), ne("phoneIMEI", null), ne("phoneIMEI", ""),
//                    ne("devices", null), ne("devices", "[]"), ne("electricMonitorId", null)));
//
//            documents.projection(fields(include("user", "mac", "gearSerialNumber", "electricMonitorId", "phoneIMEI", "devices"), excludeId()));
//            documents.projection(fields(exclude("devices._id"), excludeId()));
//            documents.limit(1);
//            documents.sort(orderBy(descending("user")));
//
//            for (Document document : documents) {
//
////                System.out.println(document.toJson());
//                DeviceProfile dp = new DeviceProfile();
//                dp.setUser(document.get("user").toString());
//                dp.setMac(document.get("mac").toString());
//                dp.setGearSerialNumber(document.get("gearSerialNumber").toString());
//                dp.setElectricalMonitorId(document.get("electricMonitorId").toString());
//                dp.setPhoneIMEI(document.get("phoneIMEI").toString());
//
//                ArrayList<Document> devicesDoc = new ArrayList<>();
//                ArrayList<Device> devices = new ArrayList<>();
//                devicesDoc = (ArrayList<Document>) document.get("devices");  //problem here!!!
//
////                System.out.println(dp.getMac());
//                for (Document deviceDoc : devicesDoc) {
//
//                    Device device = new Device();
//
//                    device.setId(deviceDoc.get("id").toString());
////                    System.out.println(device.getId());
//                    device.setType(deviceDoc.get("type").toString());
////                    System.out.println(device.getType());
//                    device.setName(deviceDoc.get("name").toString());
////                    System.out.println(device.getName());
//                    try {
//                        devices.add(device);
//                    } catch (NullPointerException npe) {
//
//                        System.out.println("ERROR:" + npe.getLocalizedMessage());
//                        System.out.println("INCOMPLETE OR MISSING DEVICE PROFILE");
//                        continue;
//                    }
//                }
//
//                dp.setDevices(devices);
//
//                dps.add(dp);
//
//            }
//        }
//
////        System.out.println(dps.size());
//        return dps;
//
//    }
//
//    private List<DeviceData> getEnergenieDeviceData(List<DeviceProfile> dpl) {
//
//        String collection = "energystatesstorages";
//
//        // get database
//        MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
//        // get collecion
//        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collection);
//        // query key
//        String queryKey1 = "device";
//
//        List<DeviceData> ddl = new ArrayList<DeviceData>();
//
//        for (DeviceProfile dp : dpl) {
//
//            List<Device> devices = dp.getDevices();
//
//            for (Device device : devices) {
//
//                FindIterable<Document> documents;
//                documents = mongoCollection.find(and(eq(queryKey1, device.getId()),
//                        exists("user", true), exists("device", true), exists("type", true), exists("value", true), exists("ts", true), exists("state", true)));
//                documents.projection(fields(include("user", "device", "type", "value", "ts", "state")));
//                documents.sort(orderBy(descending("_id")));
//                documents.limit(1);
//
//                Document document = documents.first();
//                DeviceData deviceData = new DeviceData();
//                try {
//                    deviceData.setDeviceId(document.get("device").toString());
//                    deviceData.setUserId(document.get("user").toString());
//                    deviceData.setType(document.get("type").toString());
//                    deviceData.setValue(document.get("value").toString());
//                    deviceData.setState(document.get("state").toString());
//                    long millisecondsSinceUnixEpoch = Long.valueOf(document.get("ts").toString()) * 1000;
//                    deviceData.setTimestamp(dateFormat.format(millisecondsSinceUnixEpoch));
//                } catch (NullPointerException npe) {
//
//                    System.out.println("ERROR:" + npe.getLocalizedMessage());
//                    System.out.println("INCOMPLETE OR ENERGENIE DEVICE DATA");
//                    continue;
//
//                }
//
//                ddl.add(deviceData);
//            }
//
//        }
//        return ddl;
//
//    }
//
//    private List<DeviceData> getSHealthDeviceData(List<DeviceProfile> dpl) {
//
//        String collection = "shealthcachedatas";
//
//        // get database
//        MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
//        // get collecion
//        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collection);
//        // query key
//        String queryKey1 = "user_id";
//
//        List<DeviceData> ddl = new ArrayList<DeviceData>();
//
//        for (DeviceProfile dp : dpl) {
//
//            FindIterable<Document> documents;
//            documents = mongoCollection.find(and(eq(queryKey1, dp.getUser()),
//                    exists("user_id", true), exists("type", true), exists("value", true), exists("ts", true)));
//            documents.projection(fields(include("user_id", "type", "value", "ts")));
//            documents.sort(orderBy(descending("_id"))); //latest value since ObjectId is generated from timestamp
//            documents.limit(1);
//            Document document = documents.first();
//            DeviceData deviceData = new DeviceData();
//            try {
//                deviceData.setDeviceId(dp.getGearSerialNumber());
//                deviceData.setUserId(document.get("user_id").toString());
//                deviceData.setType(document.get("type").toString());
//                deviceData.setValue(document.get("value").toString());
//                long millisecondsSinceUnixEpoch = Long.valueOf(document.get("ts").toString()) * 1000;
//                deviceData.setTimestamp(dateFormat.format(millisecondsSinceUnixEpoch));
//            } catch (NullPointerException npe) {
//                System.out.println("ERROR:" + npe.getLocalizedMessage());
//                System.out.println("INCOMPLETE OR MISSING SHEALTH DEVICE DATA");
//                continue;
//
//            }
//
//            ddl.add(deviceData);
//
//        }
//        return ddl;
//
//    }
//
//    private List<DeviceData> getSHealthAggregatedDeviceData(List<DeviceProfile> dpl) {
//
//        String collection = "shealthaggregateddatas";
//
//        // get database
//        MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
//        // get collecion
//        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collection);
//        // query key
//        String queryKey1 = "user_uuid";
//
//        List<DeviceData> ddl = new ArrayList<DeviceData>();
//
//        for (DeviceProfile dp : dpl) {
//
//            System.out.println(dp.getUser());
//
//            FindIterable<Document> documents;
//            documents = mongoCollection.find(and(eq(queryKey1, dp.getUser()),
//                    exists("user_uuid", true), exists("parameter", true), exists("value", true), exists("timestamp", true)));
//            documents.projection(fields(include("user_uuid", "parameter", "value", "timestamp", "value_label")));
//            documents.sort(orderBy(descending("_id"))); //latest value since ObjectId is generated from timestamp            
//            documents.limit(1);
//            Document document = documents.first();
//            DeviceData deviceData = new DeviceData();
//            try {
//                deviceData.setDeviceId(dp.getGearSerialNumber());
//                deviceData.setUserId(document.get("user_uuid").toString());
//                deviceData.setType(document.get("parameter").toString());
//                deviceData.setValue(document.get("value").toString());
//                deviceData.setValueLabel(document.get("value_label").toString());
//                long millisecondsSinceUnixEpoch = Long.valueOf(document.get("timestamp").toString()) * 1000;
//                deviceData.setTimestamp(dateFormat.format(millisecondsSinceUnixEpoch));
//            } catch (NullPointerException npe) {
//                System.out.println("ERROR:" + npe.getLocalizedMessage());
//                System.out.println("INCOMPLETE OR MISSING SHEALTH DEVICE AGGREGATED DATA");
//                continue;
//            }
//
//            ddl.add(deviceData);
//
//        }
//        return ddl;
//
//    }
//
//}
