/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.activage.leeds.producer.client.db.Query;
import eu.activage.leeds.producer.config.ProducerConfig;
import eu.activage.leeds.producer.model.proxy.DeviceData;
import eu.activage.leeds.producer.model.smartthings.device.Item;
import eu.activage.leeds.producer.model.smartthings.device.SmartThingDevice;
import eu.activage.leeds.producer.model.smartthings.device.State;
import eu.activage.leeds.producer.model.smartthings.device.state.StateComponent;
import eu.activage.leeds.producer.model.smartthings.device.state.main.DoorStateMain;
import eu.activage.leeds.producer.model.smartthings.device.state.main.EnergyMain;
import eu.activage.leeds.producer.model.smartthings.device.state.main.MotionMain;
import org.hashids.Hashids;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te0003
 */
public class SmartThingsQuery extends Query {
    
    public SmartThingsQuery(){
        super();
    }

    private final Properties prop = new Properties();
//    private final String configPath = "config/api.properties";

    public List<DeviceData> getAllSmartThingsData(String uuid) {

        List<String> users = this.getUsers(uuid);
        System.out.println("User count: " + users.size());

        List<DeviceData> deviceDataList = new ArrayList<>();

        for (String user : users) {

//            try {
//                InputStream inputStream;
//                inputStream = getClass().getClassLoader().getResourceAsStream(configPath);
//
//                if (inputStream != null) {
//                    prop.load(inputStream);
//                } else {
//                    throw new FileNotFoundException("property file '" + configPath + "' not found in the classpath");
//                }
//            } catch (IOException e) {
//                e.getMessage();
//                return null;
//            }

            //read host URL
//            String apiUrlTemplate = prop.getProperty("activageleeds.smartthings.api");
            String apiUrlTemplate = ProducerConfig.getInstance().getSmartThingsApiUrl();
            Map<String, String> parameters = new HashMap<>();
            parameters.put("uuid", user);
            UriBuilder builder;
            builder = UriBuilder.fromUri(apiUrlTemplate);
            URI output = builder.buildFromMap(parameters);

            final Context context = new Context();
            Client client = new Client(new Context(), Protocol.HTTP);
            client.getContext().getParameters().add("maxConnectionsPerHost", "5");
            client.getContext().getParameters().add("maxTotalConnections", "5");
            final ClientResource clientResource = new ClientResource(context, output.toASCIIString());
            clientResource.setNext(client);
            clientResource.accept(MediaType.APPLICATION_JSON);
            clientResource.getLogger().setLevel(Level.WARNING);
            String errorMessage = "";
            try {
                Representation result = clientResource.get(MediaType.APPLICATION_JSON);
                clientResource.release();
                try {
                    String response = result.getText();
                    SmartThingDevice devices = deserializeRespToDevicePojo(response);
                    for (int i = 0; i < devices.getItems().size(); i++) {

                        Item item = devices.getItems().get(i);
                        DeviceData deviceData = new DeviceData();

                        // get device ID
                        deviceData.setDeviceId(item.getDeviceId());
                        deviceData.setUserId(user);

                        // get observation ID
                        Instant instant = Instant.now();
                        long timestampSecond = instant.getEpochSecond();
                        String obsInstanceId = item.getDeviceId().concat("@" + timestampSecond);
                        Hashids obsHashId = new Hashids(obsInstanceId, 10);
                        String obsInstanceHash = obsHashId.encode(1L);
                        deviceData.setObservationId(obsInstanceHash);

                        //get monitored asset
                        deviceData.setMonitoredAsset(item.getLabel());

                        // get timestamp
                        Date timestampDate = Date.from(instant);
                        dateFormat.setTimeZone(tz);
                        deviceData.setTimestamp(dateFormat.format(timestampDate));

                        // get device type
                        switch (item.getDeviceTypeName()) {
                            case "SmartSense Multi Sensor":
                                deviceData.setType("open");
                                DoorStateMain doorMain = (DoorStateMain) devices.getStates().get(i).getComponent().getMain();
                                deviceData.setState(doorMain.getContactSensor().getContact().getValue());
                                break;
                            case "SmartSense Motion Sensor":
                                deviceData.setType("motion");
                                MotionMain motionMain = (MotionMain) devices.getStates().get(i).getComponent().getMain();
                                deviceData.setState(motionMain.getMotionSensor().getMotion().getValue());
                                break;
                            case "Zigbee Metering Plug":
                                deviceData.setType("energy");
                                EnergyMain energyMain = (EnergyMain) devices.getStates().get(i).getComponent().getMain();
                                deviceData.setValue(energyMain.getPowerMeter().getPower().getValue().toString());
                                break;
                        }
                        deviceDataList.add(deviceData);
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getLocalizedMessage());
                }
            } catch (ResourceException ex) {
                System.out.println("ERROR IS THIS: " + ex.getLocalizedMessage());
                errorMessage = ex.getLocalizedMessage();
            }
        }
        return deviceDataList;

    }

    private SmartThingDevice deserializeRespToDevicePojo(String response) {

        ObjectMapper objectMapper = new ObjectMapper();

        SmartThingDevice device = new SmartThingDevice();
        JsonNode deviceNode = null;
        try {
            deviceNode = objectMapper.readTree(response);
        } catch (IOException ex) {
            Logger.getLogger(SmartThingsQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        JsonNode itemsArray = Objects.requireNonNull(deviceNode).get("items");
        ArrayList<Item> items = null;
        try {
            items = objectMapper.readValue(objectMapper.writeValueAsString(itemsArray), new TypeReference<ArrayList<Item>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(SmartThingsQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        device.setItems(items);

        ArrayList<State> states = new ArrayList<>();
        JsonNode statesArray = deviceNode.get("states");
        int statesArraySize = statesArray.size();
        for (int i = 0; i < statesArraySize; i++) {

            State state = new State();
            StateComponent component = new StateComponent();
            JsonNode mainNode = statesArray.get(i).get("components").get("main");
            if (mainNode.has("motionSensor")) {
                try {
                    MotionMain main = objectMapper.readValue(objectMapper.writeValueAsString(mainNode), MotionMain.class);
                    component.setMain(main);
                    state.setComponent(component);
                    states.add(state);
                } catch (IOException ex) {
                    System.out.println(ex.getLocalizedMessage());
                }
            } else if (mainNode.has("contactSensor")) {
                try {
                    DoorStateMain main = objectMapper.readValue(objectMapper.writeValueAsString(mainNode), DoorStateMain.class);
                    component.setMain(main);
                    state.setComponent(component);
                    states.add(state);
                } catch (IOException ex) {
                    System.out.println(ex.getLocalizedMessage());
                }
            } else if (mainNode.has("powerMeter")) {
                try {
                    EnergyMain main = objectMapper.readValue(objectMapper.writeValueAsString(mainNode), EnergyMain.class);
                    component.setMain(main);
                    state.setComponent(component);
                    states.add(state);
                } catch (IOException ex) {
                    System.out.println(ex.getLocalizedMessage());
                }
            }           
        }
        device.setStates(states);

//        try {
//            System.out.println(objectMapper.writeValueAsString(device));
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(SmartThingsQuery.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return device;

    }

}
