
package eu.activage.leeds.producer.model.smartthings.device.state.main;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.producer.model.smartthings.device.state.main.door.AccelerationSensor;
import eu.activage.leeds.producer.model.smartthings.device.state.main.door.ContactSensor;
import eu.activage.leeds.producer.model.smartthings.device.state.main.door.ThreeAxis;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "contactSensor",
    "threeAxis",
    "configuration",
    "healthCheck",
    "refresh",
    "temperatureMeasurement",
    "sensor",
    "battery",
    "accelerationSensor"
})
public class DoorStateMain extends Main{

    @JsonProperty("contactSensor")
    private ContactSensor contactSensor;
    @JsonProperty("threeAxis")
    private ThreeAxis threeAxis;       
    @JsonProperty("accelerationSensor")
    private AccelerationSensor accelerationSensor;

    @JsonProperty("contactSensor")
    public ContactSensor getContactSensor() {
        return contactSensor;
    }

    @JsonProperty("contactSensor")
    public void setContactSensor(ContactSensor contactSensor) {
        this.contactSensor = contactSensor;
    }

    @JsonProperty("threeAxis")
    public ThreeAxis getThreeAxis() {
        return threeAxis;
    }

    @JsonProperty("threeAxis")
    public void setThreeAxis(ThreeAxis threeAxis) {
        this.threeAxis = threeAxis;
    }    

    @JsonProperty("accelerationSensor")
    public AccelerationSensor getAccelerationSensor() {
        return accelerationSensor;
    }

    @JsonProperty("accelerationSensor")
    public void setAccelerationSensor(AccelerationSensor accelerationSensor) {
        this.accelerationSensor = accelerationSensor;
    }

}
