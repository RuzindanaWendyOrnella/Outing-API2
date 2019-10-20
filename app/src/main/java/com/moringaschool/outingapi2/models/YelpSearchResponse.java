
package com.moringaschool.outingapi2.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YelpSearchResponse {

    @SerializedName("events")
    @Expose
    private List<Event> events = null;
    @SerializedName("total")
    @Expose
    private Integer total;

    /**
     * No args constructor for use in serialization
     * 
     */
    public YelpSearchResponse() {
    }

    /**
     * 
     * @param total
     * @param events
     */
    public YelpSearchResponse(List<Event> events, Integer total) {
        super();
        this.events = events;
        this.total = total;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
