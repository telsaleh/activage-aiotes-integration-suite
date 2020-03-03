
package eu.activage.leeds.producer.model.smartthings.device.state.main.door;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "unit"
})
public class ThreeAxis_ {

    @JsonProperty("value")
    private List<Integer> value = null;
    @JsonProperty("unit")
    private String unit;

    @JsonProperty("value")
    public List<Integer> getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(List<Integer> value) {
        this.value = value;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
