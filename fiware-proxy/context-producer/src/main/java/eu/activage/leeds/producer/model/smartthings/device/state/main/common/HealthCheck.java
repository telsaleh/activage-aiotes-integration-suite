
package eu.activage.leeds.producer.model.smartthings.device.state.main.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "checkInterval",
    "DeviceWatch-Enroll",
    "healthStatus",
    "DeviceWatch-DeviceStatus"
})
public class HealthCheck {

    @JsonProperty("checkInterval")
    private CheckInterval checkInterval;
    @JsonProperty("DeviceWatch-Enroll")
    private DeviceWatchEnroll deviceWatchEnroll;
    @JsonProperty("healthStatus")
    private HealthStatus healthStatus;
    @JsonProperty("DeviceWatch-DeviceStatus")
    private DeviceWatchDeviceStatus deviceWatchDeviceStatus;

    @JsonProperty("checkInterval")
    public CheckInterval getCheckInterval() {
        return checkInterval;
    }

    @JsonProperty("checkInterval")
    public void setCheckInterval(CheckInterval checkInterval) {
        this.checkInterval = checkInterval;
    }

    @JsonProperty("DeviceWatch-Enroll")
    public DeviceWatchEnroll getDeviceWatchEnroll() {
        return deviceWatchEnroll;
    }

    @JsonProperty("DeviceWatch-Enroll")
    public void setDeviceWatchEnroll(DeviceWatchEnroll deviceWatchEnroll) {
        this.deviceWatchEnroll = deviceWatchEnroll;
    }

    @JsonProperty("healthStatus")
    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    @JsonProperty("healthStatus")
    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    @JsonProperty("DeviceWatch-DeviceStatus")
    public DeviceWatchDeviceStatus getDeviceWatchDeviceStatus() {
        return deviceWatchDeviceStatus;
    }

    @JsonProperty("DeviceWatch-DeviceStatus")
    public void setDeviceWatchDeviceStatus(DeviceWatchDeviceStatus deviceWatchDeviceStatus) {
        this.deviceWatchDeviceStatus = deviceWatchDeviceStatus;
    }

}
