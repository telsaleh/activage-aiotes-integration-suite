
package eu.activage.leeds.producer.model.smartthings.device.state.main.motion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "motion"
})
public class MotionSensor {

    @JsonProperty("motion")
    private Motion motion;

    @JsonProperty("motion")
    public Motion getMotion() {
        return motion;
    }

    @JsonProperty("motion")
    public void setMotion(Motion motion) {
        this.motion = motion;
    }

}
