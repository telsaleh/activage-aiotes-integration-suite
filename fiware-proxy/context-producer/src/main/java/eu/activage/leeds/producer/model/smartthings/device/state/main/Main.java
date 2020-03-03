package eu.activage.leeds.producer.model.smartthings.device.state.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import eu.activage.leeds.producer.model.smartthings.device.state.main.common.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = Id.NONE)
@JsonSubTypes({
    @JsonSubTypes.Type(value = EnergyMain.class, name = "main")
    ,
    @JsonSubTypes.Type(value = MotionMain.class, name = "main")
    ,
    @JsonSubTypes.Type(value = DoorStateMain.class, name = "main"),})
public abstract class Main {
    
    Main(){}

    @JsonProperty("configuration")
    private Configuration configuration;
    @JsonProperty("healthCheck")
    private HealthCheck healthCheck;
    @JsonProperty("refresh")
    private Refresh refresh;
    @JsonProperty("temperatureMeasurement")
    private TemperatureMeasurement temperatureMeasurement;
    @JsonProperty("battery")
    private Battery battery;
    @JsonProperty("sensor")
    private Sensor sensor;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @JsonProperty("configuration")
    public Configuration getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @JsonProperty("healthCheck")
    public HealthCheck getHealthCheck() {
        return healthCheck;
    }

    @JsonProperty("healthCheck")
    public void setHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
    }

    @JsonProperty("refresh")
    public Refresh getRefresh() {
        return refresh;
    }

    @JsonProperty("refresh")
    public void setRefresh(Refresh refresh) {
        this.refresh = refresh;
    }

    @JsonProperty("temperatureMeasurement")
    public TemperatureMeasurement getTemperatureMeasurement() {
        return temperatureMeasurement;
    }

    @JsonProperty("temperatureMeasurement")
    public void setTemperatureMeasurement(TemperatureMeasurement temperatureMeasurement) {
        this.temperatureMeasurement = temperatureMeasurement;
    }

    @JsonProperty("battery")
    public Battery getBattery() {
        return battery;
    }

    @JsonProperty("battery")
    public void setBattery(Battery battery) {
        this.battery = battery;
    }

}
