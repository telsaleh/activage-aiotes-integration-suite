/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.activage.leeds.producer.model.ngsi.attribute.values.TypeValuePair;
import eu.activage.leeds.producer.model.ngsi.common.Attribute;
import eu.activage.leeds.producer.model.ngsi.common.Timestamp;
import eu.activage.leeds.producer.model.ngsi.entity.DeviceEntity;
import eu.activage.leeds.producer.model.ngsi.message.BatchUpdateOperation;
import eu.activage.leeds.producer.model.ngsi.metadata.MeasurableDeviceMetadata;
import eu.activage.leeds.producer.model.ngsi.metadata.SleepDeviceMetadata;
import eu.activage.leeds.producer.model.proxy.DeviceData;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te0003
 */
public class WearableNgsiFormatter extends NgsiFormatter{
   
    public String getNgsiFormat(List<DeviceData> wearableDeviceList) {

        List<DeviceEntity> hrdList = new ArrayList<>();
        List<DeviceEntity> pdList = new ArrayList<>();
        List<DeviceEntity> sdList = new ArrayList<>();
       
        for (DeviceData dd : wearableDeviceList) {

            String deviceType = dd.getType();
            switch (deviceType) {

                case "hrm":
                    DeviceEntity heartRateDevice = new DeviceEntity();
                    heartRateDevice = getNgsiHeartRate(dd);
                    hrdList.add(heartRateDevice);
                    break;
                case "dailyStepTrend":
                    DeviceEntity pedometerDevice = new DeviceEntity();
                    if (dd.getValueLabel().equalsIgnoreCase("count")) {
                        pedometerDevice = getNgsiPedometer(dd);
                        pdList.add(pedometerDevice);
                    }
                    break;
                case "sleep":
                    DeviceEntity sleepDevice = new DeviceEntity();
                    sleepDevice = getNgsiSleep(dd);
                    sdList.add(sleepDevice);
                    break;
                default:
            }
        }

        BatchUpdateOperation buo = new BatchUpdateOperation();

        for (DeviceEntity hrd : hrdList) {
            buo.getEntities().add(hrd);
        }
        for (DeviceEntity pd : pdList) {
            buo.getEntities().add(pd);
        }
        for (DeviceEntity sd : sdList) {
            buo.getEntities().add(sd);
        }
       
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String result = "";
        try {
            result = mapper.writeValueAsString(buo);
//            System.out.println(result);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(WearableNgsiFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }    

    private DeviceEntity getNgsiHeartRate(DeviceData dd) {

        Timestamp ts = new Timestamp();
        ts.setType("DateTime");
        ts.setValue(dd.getTimestamp());
        
        TypeValuePair observationId = new TypeValuePair();
        observationId.setType("String");
        observationId.setValue(dd.getObservationId());
        
        TypeValuePair quantityKind = new TypeValuePair();
        quantityKind.setType("String");
        quantityKind.setValue("heartRate");
        
        TypeValuePair measurementUnit = new TypeValuePair();
        measurementUnit.setType("String");
        measurementUnit.setValue("bpm"); 

        MeasurableDeviceMetadata metadata = new MeasurableDeviceMetadata();
        metadata.setTimestamp(ts);

        Attribute observation = new Attribute();
        observation.setMetadata(metadata);
        observation.setType("Number");
        observation.setValue(Integer.parseInt(dd.getValue()));

        DeviceEntity hrde = new DeviceEntity();
        hrde.setObservation(observation);
        hrde.setType("HeartBeatSensor");
        hrde.setId(dd.getDeviceId());

        return hrde;
    }

    private DeviceEntity getNgsiPedometer(DeviceData dd) {

        Timestamp ts = new Timestamp();
        ts.setType("DateTime");
        ts.setValue(dd.getTimestamp());

        TypeValuePair observationId = new TypeValuePair();
        observationId.setType("String");
        observationId.setValue(dd.getObservationId());
        
        TypeValuePair quantityKind = new TypeValuePair();
        quantityKind.setType("String");
        quantityKind.setValue("stepCount");
        
        TypeValuePair measurementUnit = new TypeValuePair();
        measurementUnit.setType("String");
        measurementUnit.setValue("StepPerDay"); 

        MeasurableDeviceMetadata metadata = new MeasurableDeviceMetadata();
        metadata.setTimestamp(ts);

        Attribute observation = new Attribute();
        observation.setMetadata(metadata);
        observation.setType("Number");
        try {
            observation.setValue(Integer.parseInt(dd.getValue()));
        } catch (NumberFormatException nfe) {
            return null;
        }
//        System.out.println(hr.getValue());

        DeviceEntity pedometer = new DeviceEntity();
        pedometer.setObservation(observation);
        pedometer.setType("Pedometer");
        pedometer.setId(dd.getDeviceId());

        return pedometer;
    }

    private DeviceEntity getNgsiSleep(DeviceData dd) {

        Timestamp ts = new Timestamp();
        ts.setType("DateTime");
        ts.setValue(dd.getTimestamp());

        TypeValuePair observationId = new TypeValuePair();
        observationId.setType("String");
        observationId.setValue(dd.getObservationId());
        
        TypeValuePair quantityKind = new TypeValuePair();
        quantityKind.setType("String");
        quantityKind.setValue("SleepRate");
        
        TypeValuePair measurementUnit = new TypeValuePair();
        measurementUnit.setType("String");
        measurementUnit.setValue("Hours"); 
        
        TypeValuePair sleepStart = new TypeValuePair();
        sleepStart.setType("DateTime");
        sleepStart.setValue("TODO"); //TODO
        
        TypeValuePair sleepEnd = new TypeValuePair();
        sleepEnd.setType("DateTime");
        sleepEnd.setValue("TODO"); //TODO

        SleepDeviceMetadata metadata = new SleepDeviceMetadata();
        metadata.setTimestamp(ts);

        Attribute observation = new Attribute();
        observation.setMetadata(metadata);
        observation.setType("seconds");
        observation.setValue(Integer.parseInt(dd.getValue()));
//        System.out.println(hr.getValue());

        DeviceEntity sleepDetector = new DeviceEntity();
        sleepDetector.setObservation(observation);
        sleepDetector.setType("SleepDetector");
        sleepDetector.setId(dd.getDeviceId());

        return sleepDetector;

    }

}
