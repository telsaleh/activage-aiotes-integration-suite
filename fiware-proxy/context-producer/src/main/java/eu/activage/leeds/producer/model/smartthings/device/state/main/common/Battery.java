
package eu.activage.leeds.producer.model.smartthings.device.state.main.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "battery"
})
public class Battery {

    @JsonProperty("battery")
    private Battery_ battery;

    @JsonProperty("battery")
    public Battery_ getBattery() {
        return battery;
    }

    @JsonProperty("battery")
    public void setBattery(Battery_ battery) {
        this.battery = battery;
    }

}
