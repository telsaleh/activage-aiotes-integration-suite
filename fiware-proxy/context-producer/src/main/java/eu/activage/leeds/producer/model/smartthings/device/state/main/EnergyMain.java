
package eu.activage.leeds.producer.model.smartthings.device.state.main;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import eu.activage.leeds.producer.model.smartthings.device.state.main.energy.Actuator;
import eu.activage.leeds.producer.model.smartthings.device.state.main.energy.EnergyMeter;
import eu.activage.leeds.producer.model.smartthings.device.state.main.energy.PowerMeter;
import eu.activage.leeds.producer.model.smartthings.device.state.main.energy.Switch;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "powerMeter",
    "actuator",
    "configuration",
    "energyMeter",
    "healthCheck",
    "refresh",
    "sensor",
    "switch"
})
@JsonTypeName("main")
public class EnergyMain extends Main{

    @JsonProperty("powerMeter")
    private PowerMeter powerMeter;
    @JsonProperty("actuator")
    private Actuator actuator;    
    @JsonProperty("energyMeter")
    private EnergyMeter energyMeter;     
    @JsonProperty("switch")
    private Switch _switch;

    @JsonProperty("powerMeter")
    public PowerMeter getPowerMeter() {
        return powerMeter;
    }

    @JsonProperty("powerMeter")
    public void setPowerMeter(PowerMeter powerMeter) {
        this.powerMeter = powerMeter;
    }

    @JsonProperty("actuator")
    public Actuator getActuator() {
        return actuator;
    }

    @JsonProperty("actuator")
    public void setActuator(Actuator actuator) {
        this.actuator = actuator;
    }

    @JsonProperty("energyMeter")
    public EnergyMeter getEnergyMeter() {
        return energyMeter;
    }

    @JsonProperty("energyMeter")
    public void setEnergyMeter(EnergyMeter energyMeter) {
        this.energyMeter = energyMeter;
    }

    @JsonProperty("switch")
    public Switch getSwitch() {
        return _switch;
    }

    @JsonProperty("switch")
    public void setSwitch(Switch _switch) {
        this._switch = _switch;
    }

}
