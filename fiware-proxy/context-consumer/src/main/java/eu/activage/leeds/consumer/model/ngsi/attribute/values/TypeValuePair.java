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
"type",
"value"
})
public class TypeValuePair {

@JsonProperty("type")
private String type;
@JsonProperty("value")
private String value;

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("value")
public String getValue() {
return value;
}

@JsonProperty("value")
public void setValue(String value) {
this.value = value;
}

}
