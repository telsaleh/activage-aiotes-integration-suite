/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.formatter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.activage.leeds.producer.model.ngsi.attribute.values.TypeValuePair;
import eu.activage.leeds.producer.model.ngsi.common.Attribute;
import eu.activage.leeds.producer.model.ngsi.common.Timestamp;
import eu.activage.leeds.producer.model.ngsi.entity.AssociatedDeviceEntity;
import eu.activage.leeds.producer.model.ngsi.entity.DeviceEntity;
import eu.activage.leeds.producer.model.ngsi.message.BatchUpdateOperation;
import eu.activage.leeds.producer.model.ngsi.metadata.DeviceMetadata;
import eu.activage.leeds.producer.model.ngsi.metadata.MeasurableDeviceMetadata;
import eu.activage.leeds.producer.model.proxy.DeviceData;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te0003
 */
public class HomeNgsiFormatter extends NgsiFormatter {

    public String getNgsiFormat(List<DeviceData> ddle) {

        List<AssociatedDeviceEntity> dsdList = new ArrayList<>();
        List<DeviceEntity> mdList = new ArrayList<>();
        List<AssociatedDeviceEntity> edList = new ArrayList<>();

        for (DeviceData dd : ddle) {

            String deviceType = dd.getType();
            switch (deviceType) {

                case "open":
                    AssociatedDeviceEntity doorStateDevice;
                    doorStateDevice = getNgsiDoorState(dd);
                    dsdList.add(doorStateDevice);
                    break;
                case "motion":
                    AssociatedDeviceEntity motionDevice;
                    motionDevice = getNgsiMotionPresence(dd);
                    mdList.add(motionDevice);
                    break;
                case "energy":
                    AssociatedDeviceEntity energyDevice;
                    energyDevice = getNgsiEnergy(dd);
                    edList.add(energyDevice);
                    break;
                default:
            }
        }

        BatchUpdateOperation buo = new BatchUpdateOperation();

        for (AssociatedDeviceEntity doorStateDevice : dsdList) {
            buo.getEntities().add(doorStateDevice);
        }
        for (DeviceEntity motionDevice : mdList) {
            buo.getEntities().add(motionDevice);
        }
        for (AssociatedDeviceEntity energyDevice : edList) {
            buo.getEntities().add(energyDevice);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String result = "";
        try {
            result = mapper.writeValueAsString(buo);
//            System.out.println(result);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(HomeNgsiFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private AssociatedDeviceEntity getNgsiDoorState(DeviceData dd) {

        //Timestamp metadata
        Timestamp ts = new Timestamp();
        ts.setType("DateTime");
        ts.setValue(dd.getTimestamp());

        TypeValuePair observationId = new TypeValuePair();
        observationId.setType("String");
        observationId.setValue(dd.getObservationId());

        TypeValuePair quantityKind = new TypeValuePair();
        quantityKind.setType("String");
        quantityKind.setValue("doorState");

        DeviceMetadata metadata = new DeviceMetadata();
        metadata.setTimestamp(ts);
        metadata.setObservationId(observationId);
        metadata.setQuantityKind(quantityKind);

        Attribute observation = new Attribute();
        observation.setMetadata(metadata);
        observation.setType("String");
        String deviceState = dd.getState();
        observation.setValue(deviceState.toUpperCase());

        Attribute monitoredAsset = new Attribute();
        monitoredAsset.setType("String");
        monitoredAsset.setValue(dd.getMonitoredAsset());
//        monitoredAsset.setMetadata(metadata); //test

        AssociatedDeviceEntity doorStateSensor = new AssociatedDeviceEntity();
        doorStateSensor.setMonitoredAsset(monitoredAsset);
        doorStateSensor.setObservation(observation);
        doorStateSensor.setType("DoorStateSensor");
        doorStateSensor.setId(dd.getDeviceId());

        return doorStateSensor;

    }

    private AssociatedDeviceEntity getNgsiMotionPresence(DeviceData dd) {

        Timestamp ts = new Timestamp();
        ts.setType("DateTime");
        ts.setValue(dd.getTimestamp());

        TypeValuePair observationId = new TypeValuePair();
        observationId.setType("String");
        observationId.setValue(dd.getObservationId());

        TypeValuePair quantityKind = new TypeValuePair();
        quantityKind.setType("String");
        quantityKind.setValue("motion");

        DeviceMetadata metadata = new DeviceMetadata();
        metadata.setTimestamp(ts);
        metadata.setObservationId(observationId);
        metadata.setQuantityKind(quantityKind);

        Attribute observation = new Attribute();
        observation.setMetadata(metadata);
        observation.setType("String");
        String motionStateValue = dd.getState();
        observation.setValue(motionStateValue.toUpperCase());
        
        Attribute monitoredAsset = new Attribute();
        monitoredAsset.setType("String");
        monitoredAsset.setValue(dd.getMonitoredAsset());

        AssociatedDeviceEntity motionDetector = new AssociatedDeviceEntity();
        motionDetector.setObservation(observation);
        motionDetector.setType("MotionDetector");
        motionDetector.setId(dd.getDeviceId());
        motionDetector.setMonitoredAsset(monitoredAsset);

        return motionDetector;

    }

    private AssociatedDeviceEntity getNgsiEnergy(DeviceData dd) {

        Timestamp ts = new Timestamp();
        ts.setType("DateTime");
        ts.setValue(dd.getTimestamp());

        TypeValuePair observationId = new TypeValuePair();
        observationId.setType("String");
        observationId.setValue(dd.getObservationId());

        TypeValuePair quantityKind = new TypeValuePair();
        quantityKind.setType("String");
        quantityKind.setValue("Power");

        TypeValuePair measurementUnit = new TypeValuePair();
        measurementUnit.setType("String");
        measurementUnit.setValue("WAT");

        MeasurableDeviceMetadata metadata = new MeasurableDeviceMetadata();
        metadata.setTimestamp(ts);
        metadata.setObservationId(observationId);
        metadata.setQuantityKind(quantityKind);
        metadata.setMeasurementUnit(measurementUnit);

        Attribute observation = new Attribute();
        observation.setMetadata(metadata);
        observation.setType("Number");
        observation.setValue(Float.parseFloat(dd.getValue()));

        Attribute monitoredAsset = new Attribute();
        monitoredAsset.setType("String");
        monitoredAsset.setValue(dd.getMonitoredAsset());

        AssociatedDeviceEntity energyMeter = new AssociatedDeviceEntity();
        energyMeter.setMonitoredAsset(monitoredAsset);
        energyMeter.setObservation(observation);
        energyMeter.setType("EnergyMeter");
        energyMeter.setId(dd.getDeviceId());

        return energyMeter;

    }

}
