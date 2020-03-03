package eu.activage.leeds.producer.model.ngsi.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"type", "value"})
public class Attribute {

    @JsonProperty("type")
    @JsonInclude
    private String type;
    @JsonProperty("value")
    @JsonInclude
    private Object value;
    
//    @JsonProperty("metadata")
    @JsonInclude(Include.NON_EMPTY)
    private Metadata metadata;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
