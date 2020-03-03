
package eu.activage.leeds.producer.model.smartthings.device;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.producer.model.smartthings.device.item.Component;
import eu.activage.leeds.producer.model.smartthings.device.item.Dth;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deviceId",
    "name",
    "label",
    "locationId",
    "roomId",
    "deviceTypeId",
    "deviceTypeName",
    "deviceNetworkType",
    "components",
    "dth",
    "type"
})
public class Item {

    @JsonProperty("deviceId")
    private String deviceId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("label")
    private String label;
    @JsonProperty("locationId")
    private String locationId;
    @JsonProperty("roomId")
    private String roomId;
    @JsonProperty("deviceTypeId")
    private String deviceTypeId;
    @JsonProperty("deviceTypeName")
    private String deviceTypeName;
    @JsonProperty("deviceNetworkType")
    private String deviceNetworkType;
    @JsonProperty("components")
    private List<Component> components = null;
    @JsonProperty("dth")
    private Dth dth;
    @JsonProperty("type")
    private String type;

    @JsonProperty("deviceId")
    public String getDeviceId() {
        return deviceId;
    }

    @JsonProperty("deviceId")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("locationId")
    public String getLocationId() {
        return locationId;
    }

    @JsonProperty("locationId")
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @JsonProperty("roomId")
    public String getRoomId() {
        return roomId;
    }

    @JsonProperty("roomId")
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

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

    @JsonProperty("components")
    public List<Component> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @JsonProperty("dth")
    public Dth getDth() {
        return dth;
    }

    @JsonProperty("dth")
    public void setDth(Dth dth) {
        this.dth = dth;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

}
