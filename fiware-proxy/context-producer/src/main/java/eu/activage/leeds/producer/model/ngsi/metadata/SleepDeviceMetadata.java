/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.model.ngsi.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.producer.model.ngsi.attribute.values.TypeValuePair;

import javax.validation.Valid;

/**
 *
 * @author te0003
 */
public class SleepDeviceMetadata extends MeasurableDeviceMetadata{
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
        "timestamp",
        "observationId",
        "quantityKind",
        "measurementUnit",
        "sleepStart",
        "sleepEnd"        
    })
    
    @JsonProperty("sleepStart")
    @Valid
    private TypeValuePair sleepStart;

    @JsonProperty("sleepEnd")
    @Valid
    private TypeValuePair sleepEnd;

    @JsonProperty("sleepStart")
    public TypeValuePair getSleepStart() {
        return sleepStart;
    }

    @JsonProperty("sleepStart")
    public void setSleepStart(TypeValuePair sleepStart) {
        this.sleepStart = sleepStart;
    }

    @JsonProperty("sleepEnd")
    public TypeValuePair getSleepEnd() {
        return sleepEnd;
    }

    @JsonProperty("sleepEnd")
    public void setSleepEnd(TypeValuePair sleepEnd) {
        this.sleepEnd = sleepEnd;
    }
    
    
    
    
}
