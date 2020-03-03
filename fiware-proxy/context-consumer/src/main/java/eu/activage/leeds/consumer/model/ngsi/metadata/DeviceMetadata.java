
package eu.activage.leeds.consumer.model.ngsi.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import eu.activage.leeds.consumer.model.ngsi.attribute.values.TypeValuePair;
import eu.activage.leeds.consumer.model.ngsi.common.Metadata;

import javax.validation.Valid;

@JsonPropertyOrder({
    "timestamp",
    "observationId",
    "quantityKind"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceMetadata extends Metadata{
    
    @JsonProperty("observationId")
    @Valid
    private TypeValuePair observationId;
    @JsonProperty("quantityKind")
    @Valid
    private TypeValuePair quantityKind;    

    public TypeValuePair getObservationId() {
        return observationId;
    }

    public void setObservationId(TypeValuePair observationId) {
        this.observationId = observationId;
    }

    public TypeValuePair getQuantityKind() {
        return quantityKind;
    }

    public void setQuantityKind(TypeValuePair quantityKind) {
        this.quantityKind = quantityKind;
    }
}
