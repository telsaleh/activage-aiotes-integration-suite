
package eu.activage.leeds.producer.model.smartthings.device;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "items",
    "states"
})
public class SmartThingDevice {

    @JsonProperty("items")
    private ArrayList<Item> items;
    @JsonProperty("states")
    private ArrayList<State> states;

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @JsonProperty("states")
    public ArrayList<State> getStates() {
        return states;
    }

    @JsonProperty("states")
    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

}
