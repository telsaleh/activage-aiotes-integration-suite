
package eu.activage.leeds.producer.model.smartthings.device.state.main.door;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acceleration"
})
public class AccelerationSensor {

    @JsonProperty("acceleration")
    private Acceleration acceleration;

    @JsonProperty("acceleration")
    public Acceleration getAcceleration() {
        return acceleration;
    }

    @JsonProperty("acceleration")
    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }

}
