/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.main.demo;

import eu.activage.leeds.producer.client.api.BatchUpdateOpClient;
import eu.activage.leeds.producer.formatter.HomeNgsiFormatter;
import eu.activage.leeds.producer.model.proxy.DeviceData;
import org.hashids.Hashids;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

/**
 *
 * @author te0003
 */
class VirtualSensor implements Runnable {

    private String deviceType;
    private int interval;
    private String deviceId;
    private String userId;
    private String deviceState = "";
    private final String[] doorStates = {"CLOSED", "OPEN"};
    private final String[] motionStates = {"NO-MOTION", "MOTION-DETECTED"};
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

    VirtualSensor(String deviceType, int interval, String deviceId, String userId) {
        // store parameter for later user
        this.deviceId = deviceId;
        this.interval = interval;
        this.deviceType = deviceType;
        this.userId = userId;
    }

    @Override
    public void run() {

        int periodMinRange = interval * 1000;
        int periodMaxRange = 10 * periodMinRange;

        do {

//            int interval = (int) (Math.random() * periodMaxRange + periodMinRange);
            interval = periodMinRange;

            List<DeviceData> ddle = new ArrayList<>();
            ddle.add(getDeviceData());
            HomeNgsiFormatter nf = new HomeNgsiFormatter();
            String nsgiRequest = nf.getNgsiFormat(ddle);
            System.out.println(nsgiRequest);

            BatchUpdateOpClient buoc = new BatchUpdateOpClient();
            try {
                buoc.updateEntities(nsgiRequest);

            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            try {
                // get a calendar using the default time zone and locale
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                calendar.add(Calendar.SECOND, interval / 1000);
                System.out.println(calendar.getTime());
                System.out.println("Next data collection ==> " + calendar.getTime());
//                TimeUnit.SECONDS.wait(5);
                Thread.sleep(interval);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        } while (true);

    }

    private DeviceData getDeviceData() {

        DeviceData deviceData = new DeviceData();
        deviceData.setDeviceId(this.deviceId);
        deviceData.setUserId(this.userId);
        deviceData.setTimestamp(this.dateFormat.format(new Date()));

        long timestamp = Instant.now().getEpochSecond();
        String obsInstanceId = deviceData.getDeviceId().concat("@" + timestamp);
        Hashids obsHashId = new Hashids(obsInstanceId, 10);
        String obsInstanceHash = obsHashId.encode(1L);
        deviceData.setObservationId(obsInstanceHash);
        deviceData.setObservationId(deviceId);

        boolean randomState = getRandomBoolean();

        if (this.deviceType.equalsIgnoreCase("motion")) {
            deviceData.setType("motion");
            if (randomState) {
                this.deviceState = motionStates[1];
            } else {
                this.deviceState = motionStates[0];
            }
            deviceData.setMonitoredAsset("living_room");
        } else {
            deviceData.setType("open");
            if (randomState) {
                this.deviceState = doorStates[1];
            } else {
                this.deviceState = doorStates[0];
            }
            deviceData.setMonitoredAsset("bathroom");
        }
        deviceData.setState(this.deviceState);
        return deviceData;
    }

    private static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
