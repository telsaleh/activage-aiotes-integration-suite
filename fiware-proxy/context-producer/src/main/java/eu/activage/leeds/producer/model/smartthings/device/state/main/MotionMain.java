
package eu.activage.leeds.producer.model.smartthings.device.state.main;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.producer.model.smartthings.device.state.main.motion.MotionSensor;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
    "configuration",
    "healthCheck",
    "refresh",
    "temperatureMeasurement",
    "sensor",
    "motionSensor",
    "battery"
})
public class MotionMain extends Main{
    
    @JsonProperty("motionSensor")
    private MotionSensor motionSensor;
    
    @JsonProperty("motionSensor")
    public MotionSensor getMotionSensor() {
        return motionSensor;
    }

    @JsonProperty("motionSensor")
    public void setMotionSensor(MotionSensor motionSensor) {
        this.motionSensor = motionSensor;
    }

}
