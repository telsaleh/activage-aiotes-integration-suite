/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.db;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import eu.activage.leeds.producer.model.proxy.Device;
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
public class EnergenieQuery extends Query {
    
    public EnergenieQuery(){
        super();
    }

    public List<DeviceData> getAllEnergenieData(String uuid) {

        List<String> users = this.getUsers(uuid);
        System.out.println("User count: " + users.size());
        List<DeviceProfile> dpl = getUserDeviceProfiles(users);
        // userDeviceProfiles.forEach(System.out::println);
        System.out.println("User profile count: " + dpl.size());

        return getEnergenieDeviceData(dpl);
    }

    @SuppressWarnings("unchecked")
    private List<DeviceProfile> getUserDeviceProfiles(List<String> users) {

        String collection = "energenieuserconfigs";

        // get collecion
        mongoCollection = mongoDatabase.getCollection(collection);
        // query key
        String queryKey = "user";

        List<DeviceProfile> dps = new ArrayList<>();

        // for each user
        for (String user : users) {

            // find documents that match user and has required fields
            FindIterable<Document> documents;
            documents = mongoCollection.find(and(eq(queryKey, user),
                    exists("user", true), exists("mac", true), ne("mac", null), ne("mac", ""),
                    exists("electricMonitorId", true), exists("electricMonitorLabel", true), exists("devices", true),
                    //                    ne("electricMonitorId", null), ne("electricMonitorLabel", null), 
                    ne("devices", null), ne("devices", "[]")));

            documents.projection(fields(include("user", "mac", "devices"), excludeId()));
            documents.projection(fields(exclude("devices._id"), excludeId()));
            documents.limit(1);
            documents.sort(orderBy(descending("user")));

            for (Document document : documents) {

//                System.out.println(document.toJson());
                DeviceProfile dp = new DeviceProfile();
                dp.setUser(document.get("user").toString());
                dp.setMac(document.get("mac").toString());
                try {
                    dp.setElectricalMonitorId(document.get("electricMonitorId").toString());
                    dp.setElectricMonitorLabel(document.get("electricMonitorLabel").toString());
                } catch (NullPointerException npe) {
                    dp.setElectricalMonitorId("none");
                    dp.setElectricMonitorLabel("none");
                }
                dp.setPhoneIMEI(document.get("phoneIMEI").toString());

                ArrayList<Document> devicesDoc;
                ArrayList<Device> devices = new ArrayList<>();
                devicesDoc = (ArrayList<Document>) document.get("devices"); 

//                System.out.println(dp.getMac());
                for (Document deviceDoc : devicesDoc) {

                    Device device = new Device();

                    device.setId(deviceDoc.get("id").toString());
//                    System.out.println(device.getId());
                    device.setType(deviceDoc.get("type").toString());
//                    System.out.println(device.getType());
                    device.setName(deviceDoc.get("name").toString());
//                    System.out.println(device.getName());
                    try {
                        devices.add(device);
                    } catch (NullPointerException npe) {
                        System.out.println("ERROR:" + npe.getLocalizedMessage());
                        System.out.println("INCOMPLETE OR MISSING DEVICE PROFILE");
                    }
                }
                dp.setDevices(devices);
                dps.add(dp);
            }
        }
//        System.out.println(dps.size());
        return dps;
    }

    private List<DeviceData> getEnergenieDeviceData(List<DeviceProfile> dpl) {

        // get collecion
        String collectionName = "energystatesstorages";
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collectionName);

        List<DeviceData> ddl = new ArrayList<>();

        for (DeviceProfile dp : dpl) {

            List<Device> devices = dp.getDevices();

            for (Device device : devices) {

                FindIterable<Document> documents;
                String queryKey = "device";
                documents = mongoCollection.find(and(eq(queryKey, device.getId()),
                        exists("user", true), exists("device", true), exists("type", true), exists("value", true), exists("ts", true), exists("state", true)));
                documents.projection(fields(include("user", "device", "type", "value", "ts", "state")));
                documents.sort(orderBy(descending("_id")));
                documents.limit(1);

                Document document = documents.first();
                DeviceData deviceData = new DeviceData();
                try {
                    deviceData.setDeviceId(Objects.requireNonNull(document).get("device").toString());
                    deviceData.setUserId(document.get("user").toString());
                    deviceData.setType(document.get("type").toString());
                    deviceData.setObservationId(document.get("_id").toString());
                    deviceData.setMonitoredAsset(device.getName());
                    deviceData.setValue(document.get("value").toString());
                    deviceData.setState(document.get("state").toString());
                    long millisecondsSinceUnixEpoch = Long.parseLong(document.get("ts").toString()) * 1000;
                    deviceData.setTimestamp(dateFormat.format(millisecondsSinceUnixEpoch));
                } catch (NullPointerException npe) {
                    System.out.println("ERROR:" + npe.getLocalizedMessage());
                    System.out.println("INCOMPLETE OR ENERGENIE DEVICE DATA");
                    continue;

                }

                ddl.add(deviceData);
            }

        }
        return ddl;

    }

}
