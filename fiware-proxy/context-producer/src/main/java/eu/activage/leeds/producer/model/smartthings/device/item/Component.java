
package eu.activage.leeds.producer.model.smartthings.device.item;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "label",
    "capabilities"
})
public class Component {

    @JsonProperty("id")
    private String id;
    @JsonProperty("label")
    private String label;
    @JsonProperty("capabilities")
    private List<Capability> capabilities = null;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("capabilities")
    public List<Capability> getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

}
