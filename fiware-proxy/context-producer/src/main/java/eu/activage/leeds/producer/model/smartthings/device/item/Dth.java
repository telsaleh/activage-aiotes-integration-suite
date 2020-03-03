
package eu.activage.leeds.producer.model.smartthings.device.item;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deviceTypeId",
    "deviceTypeName",
    "deviceNetworkType",
    "completedSetup",
    "networkSecurityLevel",
    "hubId"
})
public class Dth {

    @JsonProperty("deviceTypeId")
    private String deviceTypeId;
    @JsonProperty("deviceTypeName")
    private String deviceTypeName;
    @JsonProperty("deviceNetworkType")
    private String deviceNetworkType;
    @JsonProperty("completedSetup")
    private Boolean completedSetup;
    @JsonProperty("networkSecurityLevel")
    private String networkSecurityLevel;
    @JsonProperty("hubId")
    private String hubId;

    @JsonProperty("deviceTypeId")
    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    @JsonProperty("deviceTypeId")
    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    @JsonProperty("deviceTypeName")
    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    @JsonProperty("deviceTypeName")
    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    @JsonProperty("deviceNetworkType")
    public String getDeviceNetworkType() {
        return deviceNetworkType;
    }

    @JsonProperty("deviceNetworkType")
    public void setDeviceNetworkType(String deviceNetworkType) {
        this.deviceNetworkType = deviceNetworkType;
    }

    @JsonProperty("completedSetup")
    public Boolean getCompletedSetup() {
        return completedSetup;
    }

    @JsonProperty("completedSetup")
    public void setCompletedSetup(Boolean completedSetup) {
        this.completedSetup = completedSetup;
    }

    @JsonProperty("networkSecurityLevel")
    public String getNetworkSecurityLevel() {
        return networkSecurityLevel;
    }

    @JsonProperty("networkSecurityLevel")
    public void setNetworkSecurityLevel(String networkSecurityLevel) {
        this.networkSecurityLevel = networkSecurityLevel;
    }

    @JsonProperty("hubId")
    public String getHubId() {
        return hubId;
    }

    @JsonProperty("hubId")
    public void setHubId(String hubId) {
        this.hubId = hubId;
    }

}
