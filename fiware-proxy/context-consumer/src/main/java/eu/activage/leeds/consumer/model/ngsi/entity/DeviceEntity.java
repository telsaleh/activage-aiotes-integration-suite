/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.consumer.model.ngsi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.consumer.model.ngsi.common.Attribute;
import eu.activage.leeds.consumer.model.ngsi.common.Entity;

/**
 *
 * @author te0003
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"id", "type", "observation"})
public class DeviceEntity extends Entity {

    @JsonProperty("observation")
    private Attribute observation;

    public Attribute getObservation() {
        return observation;
    }

    public void setObservation(Attribute doorState) {
        this.observation = doorState;
    }

}
