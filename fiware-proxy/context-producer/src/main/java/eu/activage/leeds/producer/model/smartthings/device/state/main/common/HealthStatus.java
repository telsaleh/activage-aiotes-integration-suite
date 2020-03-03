
package eu.activage.leeds.producer.model.smartthings.device.state.main.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value"
})
public class HealthStatus {

    @JsonProperty("value")
    private Object value;
    @JsonProperty("data")
    private StatusData data;

    public StatusData getData() {
        return data;
    }

    public void setData(StatusData data) {
        this.data = data;
    }

    @JsonProperty("value")
    public Object getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Object value) {
        this.value = value;
    }

}
