/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.consumer.model.ngsi.message;

/*

  @author te0003
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data",
"subscriptionId"
})
public class NotifyContextRequest {

@JsonProperty("data")
private List<Object> data = null;
@JsonProperty("subscriptionId")
private String subscriptionId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<>();

@JsonProperty("data")
public List<Object> getData() {
return data;
}

@JsonProperty("data")
public void setData(List<Object> data) {
this.data = data;
}

@JsonProperty("subscriptionId")
public String getSubscriptionId() {
return subscriptionId;
}

@JsonProperty("subscriptionId")
public void setSubscriptionId(String subscriptionId) {
this.subscriptionId = subscriptionId;
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

