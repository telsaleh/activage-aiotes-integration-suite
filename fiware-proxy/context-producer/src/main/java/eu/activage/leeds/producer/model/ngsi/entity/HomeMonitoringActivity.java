
package eu.activage.leeds.producer.model.ngsi.entity;

import com.fasterxml.jackson.annotation.*;
import eu.activage.leeds.producer.model.ngsi.common.Attribute;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "type",
    "dailyResult"
})
public class HomeMonitoringActivity extends DeviceEntity{

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("dailyResult")
    @Valid
    private Attribute dailyResult;
    @JsonIgnore
    @Valid
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("dailyResult")
    public Attribute getDailyResult() {
        return dailyResult;
    }

    @JsonProperty("dailyResult")
    public void setDailyResult(Attribute dailyResult) {
        this.dailyResult = dailyResult;
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
