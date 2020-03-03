
package eu.activage.leeds.producer.model.smartthings.device.state;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.producer.model.smartthings.device.state.main.Main;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "main"
})
public class StateComponent {
    
    public StateComponent(){}

    @JsonProperty("main")
    private Main main;

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

}
