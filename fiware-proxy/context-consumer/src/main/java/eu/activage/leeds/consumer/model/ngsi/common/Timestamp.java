/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.consumer.model.ngsi.common;

/*

  @author te0003
 */

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "type"
})
public class Timestamp {

    @JsonProperty("value")
    private String value;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    @Valid
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public Timestamp(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Timestamp() {
        
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
