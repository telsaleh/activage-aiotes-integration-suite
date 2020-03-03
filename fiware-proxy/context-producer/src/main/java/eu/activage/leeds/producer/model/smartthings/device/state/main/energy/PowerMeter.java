
package eu.activage.leeds.producer.model.smartthings.device.state.main.energy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "power"
})
public class PowerMeter {

    @JsonProperty("power")
    private Power power;

    @JsonProperty("power")
    public Power getPower() {
        return power;
    }

    @JsonProperty("power")
    public void setPower(Power power) {
        this.power = power;
    }

}
