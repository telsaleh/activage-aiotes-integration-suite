
package eu.activage.leeds.producer.model.smartthings.device;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.producer.model.smartthings.device.state.StateComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "components"
})
public class State {

    @JsonProperty("components")
    private StateComponent components;

    @JsonProperty("components")
    public StateComponent getComponent() {
        return components;
    }

    @JsonProperty("components")
    public void setComponent(StateComponent components) {
        this.components = components;
    }

}
