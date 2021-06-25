/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchpad;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.activage.leeds.producer.model.proxy.DeviceData;
import eu.activage.leeds.producer.model.smartthings.device.Item;
import eu.activage.leeds.producer.model.smartthings.device.SmartThingDevice;
import eu.activage.leeds.producer.model.smartthings.device.State;
import eu.activage.leeds.producer.model.smartthings.device.state.StateComponent;
import eu.activage.leeds.producer.model.smartthings.device.state.main.DoorStateMain;
import eu.activage.leeds.producer.model.smartthings.device.state.main.EnergyMain;
import eu.activage.leeds.producer.model.smartthings.device.state.main.MotionMain;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.uri.UriTemplate;
import org.hashids.Hashids;
import org.junit.Test;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import javax.ws.rs.core.UriBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te0003
 */
public class SmartThingsParseTest {

    private SmartThingDevice devices;
    private ObjectMapper objectMapper;
    protected final TimeZone tz = TimeZone.getTimeZone("UTC");
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    private final String uuid = "5caedc4a14c937331eae8069";
    private final Properties prop = new Properties();
    private final String configPath = "config/broker.properties";

    @Test
    public void smartThingsQueryFile() {

        String response = getFile();
        objectMapper = new ObjectMapper();

        try {
            devices = objectMapper.reader().forType(SmartThingDevice.class).readValue(response);
            devices.getItems().get(0).getDeviceId();
            devices.getItems().get(0).getName();
            devices.getItems().get(0).getLabel();
        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(SmartThingsParseTest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getLocalizedMessage());
            assert false;
        }

    }

    @Test
    public void testSmartThingsQueryApi() {
        smartThingsQueryApi();
    }

    private void smartThingsQueryApi() {

        try {
            InputStream inputStream;
            inputStream = getClass().getClassLoader().getResourceAsStream(configPath);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + configPath + "' not found in the classpath");
            }
        } catch (IOException e) {
            e.getMessage();
            return;
        }

        //read host URL
        String apiUrlTemplate = prop.getProperty("url.host.broker.smartthings");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("uuid", "5caedc4a14c937331eae8069");
        UriBuilder builder;
        builder = UriBuilder.fromUri(apiUrlTemplate);
        // Use .buildFromMap()
        URI output = builder.buildFromMap(parameters);

        final Context context = new Context();
        Client client = new Client(new Context(), Protocol.HTTP);
        client.getContext().getParameters().add("maxConnectionsPerHost", "5");
        client.getContext().getParameters().add("maxTotalConnections", "5");
        final ClientResource sicsClientResource = new ClientResource(context, output.toASCIIString());
        sicsClientResource.setNext(client);
        sicsClientResource.accept(MediaType.APPLICATION_JSON);
        String errorMessage = "";
        try {
            Representation result = sicsClientResource.get(MediaType.APPLICATION_JSON);
            sicsClientResource.release();
            try {
                // polymorphic problem here
                devices = objectMapper.readValue(result.getStream(), SmartThingDevice.class);
                List<DeviceData> deviceDataList = new ArrayList<>();

                for (int i = 0; i < devices.getItems().size(); i++) {

                    Item item = devices.getItems().get(i);
                    DeviceData deviceData = new DeviceData();

                    // get device ID
                    deviceData.setDeviceId(item.getDeviceId());
                    deviceData.setUserId("5caedc4a14c937331eae8069");

                    // get observation ID
                    Instant instant = Instant.now();
                    long timestamp = instant.getEpochSecond();
                    String obsInstanceId = item.getDeviceId().concat("@" + timestamp);
                    Hashids obsHashId = new Hashids(obsInstanceId, 10);
                    String obsInstanceHash = obsHashId.encode(1L);
                    deviceData.setObservationId(obsInstanceHash);

                    //get monitored asset
                    deviceData.setMonitoredAsset(item.getLabel());

                    // get timestamp
                    long millisecondsSinceUnixEpoch = instant.getEpochSecond() / 1000;
                    deviceData.setTimestamp(dateFormat.format(millisecondsSinceUnixEpoch));

                    // get device type
                    switch (item.getDeviceTypeId()) {
                        case "SmartSense Multi Sensor":
                            deviceData.setType("open");
                            DoorStateMain doorMain = (DoorStateMain) devices.getStates().get(i).getComponent().getMain();
                            deviceData.setValueLabel(doorMain.getContactSensor().getContact().getValue());
                            break;
                        case "SmartSense Motion Sensor":
                            deviceData.setType("motion");
                            MotionMain motionMain = (MotionMain) devices.getStates().get(i).getComponent().getMain();
                            deviceData.setValueLabel(motionMain.getMotionSensor().getMotion().getValue());
                            break;
                        case "Zigbee Metering Plug":
                            deviceData.setType("energy");
                            EnergyMain energyMain = (EnergyMain) devices.getStates().get(i).getComponent().getMain();
                            deviceData.setValue(energyMain.getEnergyMeter().getEnergy().getValue().toString());
                            break;
                    }
                    deviceData.setType(obsInstanceId);
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

    @Test
    public void testUriBuilder() {

        String apiUrlTemplate = "https://activageleeds.co.uk/api/smartthings/{uuid}/devices/list";
        UriTemplate uriTemplate = new UriTemplate(apiUrlTemplate);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("uuid", uuid);
        UriBuilder builder;
        builder = UriBuilder.fromUri(apiUrlTemplate);
        // Use .buildFromMap()
        URI output = builder.buildFromMap(parameters);
        System.out.println(output.toASCIIString());

    }

    private String getFile() {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            //noinspection deprecation
            result = IOUtils.toString(Objects.requireNonNull(classLoader.getResourceAsStream("data-models/smartthings/smartthing-api-response_user.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    @Test
    public void parseFileToSmartThings() {

        String response = getFile();
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        SmartThingDevice device = new SmartThingDevice();
        JsonNode deviceNode = null;
        try {
            deviceNode = objectMapper.readTree(response);
        } catch (IOException ex) {
            Logger.getLogger(SmartThingsParseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        JsonNode itemsArray = Objects.requireNonNull(deviceNode).get("items");
        ArrayList<Item> items = null;
        try {
            items = objectMapper.readValue(objectMapper.writeValueAsString(itemsArray), new TypeReference<ArrayList<Item>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(SmartThingsParseTest.class.getName()).log(Level.SEVERE, null, ex);
            assert false;
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
                    assert false;
                }
            } else if (mainNode.has("contactSensor")) {
                try {
                    DoorStateMain main = objectMapper.readValue(objectMapper.writeValueAsString(mainNode), DoorStateMain.class);
                    component.setMain(main);
                    state.setComponent(component);
                    states.add(state);
                } catch (IOException ex) {
                    System.out.println(ex.getLocalizedMessage());
                    assert false;
                }
            } else if (mainNode.has("powerMeter")) {
                try {
                    EnergyMain main = objectMapper.readValue(objectMapper.writeValueAsString(mainNode), EnergyMain.class);
                    component.setMain(main);
                    state.setComponent(component);
                    states.add(state);
                } catch (IOException ex) {
                    System.out.println(ex.getLocalizedMessage());
                    assert false;
                }
            }            
        }
        device.setStates(states);

        try {
            System.out.println(objectMapper.writeValueAsString(device));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(SmartThingsParseTest.class.getName()).log(Level.SEVERE, null, ex);
            assert false;
        }

    }

}
