/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.consumer.model.ngsi.metadata;

/**
 *
 * @author te0003
 */

import com.fasterxml.jackson.annotation.*;
import eu.activage.leeds.consumer.model.ngsi.common.Metadata;
import eu.activage.leeds.consumer.model.ngsi.metadata.activity.Field;
import eu.activage.leeds.consumer.model.ngsi.metadata.activity.Threshold;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"userId",
"timestamp",
"measurementUnit",
"green_lower",
"green_upper",
"yellow_lower",
"yellow_upper",
"red_lower",
"red_upper"
})
public class ActivityMetadata extends Metadata{

@JsonProperty("userid")
private Field userid;
@JsonProperty("measurementUnit")
private Field measurementUnit;
@JsonProperty("green_lower")
private Threshold greenLower;
@JsonProperty("green_upper")
private Threshold greenUpper;
@JsonProperty("yellow_lower")
private Threshold yellowLower;
@JsonProperty("yellow_upper")
private Threshold yellowUpper;
@JsonProperty("red_lower")
private Threshold redLower;
@JsonProperty("red_upper")
private Threshold redUpper;
@JsonIgnore
private final Map<String, Object> additionalProperties = new HashMap<>();

@JsonProperty("userId")
public Field getUserid() {
return userid;
}

@JsonProperty("userid")
public void setUserid(Field userid) {
this.userid = userid;
}

@JsonProperty("measurementUnit")
public Field getMeasurementUnit() {
return measurementUnit;
}

@JsonProperty("measurementUnit")
public void setMeasurementUnit(Field measurementUnit) {
this.measurementUnit = measurementUnit;
}

@JsonProperty("green_lower")
public Threshold getGreenLower() {
return greenLower;
}

@JsonProperty("green_lower")
public void setGreenLower(Threshold greenLower) {
this.greenLower = greenLower;
}

@JsonProperty("green_upper")
public Threshold getGreenUpper() {
return greenUpper;
}

@JsonProperty("green_upper")
public void setGreenUpper(Threshold greenUpper) {
this.greenUpper = greenUpper;
}

@JsonProperty("yellow_lower")
public Threshold getYellowLower() {
return yellowLower;
}

@JsonProperty("yellow_lower")
public void setYellowLower(Threshold yellowLower) {
this.yellowLower = yellowLower;
}

@JsonProperty("yellow_upper")
public Threshold getYellowUpper() {
return yellowUpper;
}

@JsonProperty("yellow_upper")
public void setYellowUpper(Threshold yellowUpper) {
this.yellowUpper = yellowUpper;
}

@JsonProperty("red_lower")
public Threshold getRedLower() {
return redLower;
}

@JsonProperty("red_lower")
public void setRedLower(Threshold redLower) {
this.redLower = redLower;
}

@JsonProperty("red_upper")
public Threshold getRedUpper() {
return redUpper;
}

@JsonProperty("red_upper")
public void setRedUpper(Threshold redUpper) {
this.redUpper = redUpper;
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

