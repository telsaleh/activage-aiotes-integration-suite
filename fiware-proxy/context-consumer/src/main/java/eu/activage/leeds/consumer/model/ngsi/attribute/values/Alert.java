/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.consumer.model.ngsi.attribute.values;

/*

  @author te0003
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"hasConfirmation",
"hasPriority"
})
class Alert {

@JsonProperty("hasConfirmation")
private TypeValuePair hasConfirmation;
@JsonProperty("hasPriority")
private TypeValuePair hasPriority;

@JsonProperty("hasConfirmation")
public TypeValuePair getHasConfirmation() {
return hasConfirmation;
}

@JsonProperty("hasConfirmation")
public void setHasConfirmation(TypeValuePair hasConfirmation) {
this.hasConfirmation = hasConfirmation;
}

@JsonProperty("hasPriority")
public TypeValuePair getHasPriority() {
return hasPriority;
}

@JsonProperty("hasPriority")
public void setHasPriority(TypeValuePair hasPriority) {
this.hasPriority = hasPriority;
}

}
