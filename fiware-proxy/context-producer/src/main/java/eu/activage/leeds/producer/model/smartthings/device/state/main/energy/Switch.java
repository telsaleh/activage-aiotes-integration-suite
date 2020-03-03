
package eu.activage.leeds.producer.model.smartthings.device.state.main.energy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "switch"
})
public class Switch {

    @JsonProperty("switch")
    private Switch_ _switch;

    @JsonProperty("switch")
    public Switch_ getSwitch() {
        return _switch;
    }

    @JsonProperty("switch")
    public void setSwitch(Switch_ _switch) {
        this._switch = _switch;
    }

}
