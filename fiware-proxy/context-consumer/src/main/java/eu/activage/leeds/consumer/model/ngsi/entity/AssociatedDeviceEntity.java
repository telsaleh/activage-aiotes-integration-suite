package eu.activage.leeds.consumer.model.ngsi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.consumer.model.ngsi.common.Attribute;

@JsonPropertyOrder({"id", "type", "observation", "monitoredAsset"})
public class AssociatedDeviceEntity extends DeviceEntity {

    @JsonProperty("monitoredAsset")
    private Attribute monitoredAsset;

    public Attribute getMonitoredAsset() {
        return monitoredAsset;
    }

    public void setMonitoredAsset(Attribute monitoredAsset) {
        this.monitoredAsset = monitoredAsset;
    }

}
