
package eu.activage.leeds.producer.model.smartthings.device.state.main.energy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "energy"
})
public class EnergyMeter {

    @JsonProperty("energy")
    private Energy energy;

    @JsonProperty("energy")
    public Energy getEnergy() {
        return energy;
    }

    @JsonProperty("energy")
    public void setEnergy(Energy energy) {
        this.energy = energy;
    }

}
