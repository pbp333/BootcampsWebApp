package org.academiadecodigo.bootcamp.model;

import java.util.Date;

public class Bootcamp {

    private Integer id;

    private String location;
    private Date start;
    private Date end;

    public Bootcamp() {
    }

    public Bootcamp(Integer id, String location, Date start, Date end) {
        this.id = id;
        this.location = location;
        this.start = start;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
