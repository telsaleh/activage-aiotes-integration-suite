package eu.activage.leeds.producer.model.proxy;

public class ActivityData {

    private String userId;
    private String type;
    private String timestamp;
    private Integer greenLower;
    private Integer greenUpper;
    private Integer yellowLower;
    private Integer yellowUpper;
    private Integer redLower;
    private Integer redUpper;
    private Integer value;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getGreenLower() {
        return greenLower;
    }

    public void setGreenLower(Integer greenLower) {
        this.greenLower = greenLower;
    }

    public Integer getGreenUpper() {
        return greenUpper;
    }

    public void setGreenUpper(Integer greenUpper) {
        this.greenUpper = greenUpper;
    }

    public Integer getYellowLower() {
        return yellowLower;
    }

    public void setYellowLower(Integer yellowLower) {
        this.yellowLower = yellowLower;
    }

    public Integer getYellowUpper() {
        return yellowUpper;
    }

    public void setYellowUpper(Integer yellowUpper) {
        this.yellowUpper = yellowUpper;
    }

    public Integer getRedLower() {
        return redLower;
    }

    public void setRedLower(Integer redLower) {
        this.redLower = redLower;
    }

    public Integer getRedUpper() {
        return redUpper;
    }

    public void setRedUpper(Integer redUpper) {
        this.redUpper = redUpper;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
