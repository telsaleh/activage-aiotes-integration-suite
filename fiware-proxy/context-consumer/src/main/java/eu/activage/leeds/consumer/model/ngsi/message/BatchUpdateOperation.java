/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.consumer.model.ngsi.message;

/*

  @author te0003
 */

import com.fasterxml.jackson.annotation.*;
import eu.activage.leeds.consumer.model.ngsi.entity.DeviceEntity;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"actionType",
"entities"
})
public class BatchUpdateOperation {

@JsonProperty("actionType")
private String actionType;
@JsonProperty("entities")
@Valid
private List<DeviceEntity> entities;
@JsonIgnore
@Valid
private final Map<String, Object> additionalProperties = new HashMap<>();

    public BatchUpdateOperation() {
        
        this.actionType = "append";
        this.entities = new ArrayList<>();
    }



@JsonProperty("actionType")
public String getActionType() {
return actionType;
}

@JsonProperty("actionType")
public void setActionType(String actionType) {
this.actionType = actionType;
}

@JsonProperty("entities")
public List<DeviceEntity> getEntities() {
return entities;
}

@JsonProperty("entities")
public void setEntities(List<DeviceEntity> entities) {
this.entities = entities;
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

