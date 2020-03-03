/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.model.proxy;

/**
 *
 * @author te0003
 */

public class DeviceData {

    private String userId;
    private String deviceId;
    private String observationId;    
    private String type;
    private String value;
    private String timestamp;
    private String valueLabel;    
    private String state;
    private String monitoredAsset;    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
    public String getObservationId() {
        return observationId;
    }

    public void setObservationId(String observationId) {
        this.observationId = observationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setValueLabel(String valueLabel) {
        this.valueLabel = valueLabel;
    }
    
    public String getValueLabel() {
        return this.valueLabel;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }    
    
    public String getMonitoredAsset() {
        return monitoredAsset;
    }

    public void setMonitoredAsset(String monitoredAsset) {
        this.monitoredAsset = monitoredAsset;
    }

}
