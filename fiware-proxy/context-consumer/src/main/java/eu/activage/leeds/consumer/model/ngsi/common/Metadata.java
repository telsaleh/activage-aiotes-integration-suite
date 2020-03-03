
package eu.activage.leeds.consumer.model.ngsi.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.Valid;

@JsonPropertyOrder({"timestamp"})
@JsonInclude(Include.NON_EMPTY)
public class Metadata {

    @JsonProperty("timestamp")
    @Valid
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
