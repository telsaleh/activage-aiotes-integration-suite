
package eu.activage.leeds.producer.model.smartthings.device.state.main.door;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "threeAxis"
})
public class ThreeAxis {

    @JsonProperty("threeAxis")
    private ThreeAxis_ threeAxis;

    @JsonProperty("threeAxis")
    public ThreeAxis_ getThreeAxis() {
        return threeAxis;
    }

    @JsonProperty("threeAxis")
    public void setThreeAxis(ThreeAxis_ threeAxis) {
        this.threeAxis = threeAxis;
    }

}
