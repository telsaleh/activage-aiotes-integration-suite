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
public class MeasurableDeviceMetadata extends DeviceMetadata {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
        "timestamp",
        "observationId",
        "quantityKind",
        "measurementUnit"
    })
    
    @JsonProperty("measurementUnit")
    @Valid
    private TypeValuePair measurementUnit;

    @JsonProperty("measurementUnit")
    public TypeValuePair getMeasurementUnit() {
        return measurementUnit;
    }

    @JsonProperty("measurementUnit")
    public void setMeasurementUnit(TypeValuePair measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

}
