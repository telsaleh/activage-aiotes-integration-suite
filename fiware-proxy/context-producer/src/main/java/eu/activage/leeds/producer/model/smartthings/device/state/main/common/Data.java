
package eu.activage.leeds.producer.model.smartthings.device.state.main.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "protocol",
    "hubHardwareId",
    "offlinePingable"
})
public class Data {

    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("hubHardwareId")
    private String hubHardwareId;
    @JsonProperty("offlinePingable")
    private String offlinePingable;

    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonProperty("hubHardwareId")
    public String getHubHardwareId() {
        return hubHardwareId;
    }

    @JsonProperty("hubHardwareId")
    public void setHubHardwareId(String hubHardwareId) {
        this.hubHardwareId = hubHardwareId;
    }

    @JsonProperty("offlinePingable")
    public String getOfflinePingable() {
        return offlinePingable;
    }

    @JsonProperty("offlinePingable")
    public void setOfflinePingable(String offlinePingable) {
        this.offlinePingable = offlinePingable;
    }

}
