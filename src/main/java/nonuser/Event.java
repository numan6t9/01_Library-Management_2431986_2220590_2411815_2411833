package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class Event implements Serializable {

    private String eventName,organizerName,eventVenue;
    private LocalDate eventSchedule;


    public Event(String eventName, LocalDate eventSchedule, String eventVenue, String organizerName) {
        this.eventName = eventName;
        this.eventSchedule = eventSchedule;
        this.eventVenue = eventVenue;
        this.organizerName = organizerName;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventSchedule() {
        return eventSchedule;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventSchedule(LocalDate eventSchedule) {
        this.eventSchedule = eventSchedule;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", organizerName='" + organizerName + '\'' +
                ", eventVenue='" + eventVenue + '\'' +
                ", eventSchedule=" + eventSchedule +
                '}';
    }

}
