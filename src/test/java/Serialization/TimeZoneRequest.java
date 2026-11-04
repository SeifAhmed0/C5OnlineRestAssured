package Serialization;

//POJO Class
public class TimeZoneRequest {
    private String fromTimeZone;
    private String dateTime;
    private String toTimeZone;
    private String dstAmbiguity;

    public void setFromTimeZone(String fromTimeZone) {
        this.fromTimeZone = fromTimeZone;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setToTimeZone(String toTimeZone) {
        this.toTimeZone = toTimeZone;
    }

    public void setDstAmbiguity(String dstAmbiguity) {
        this.dstAmbiguity = dstAmbiguity;
    }
}
