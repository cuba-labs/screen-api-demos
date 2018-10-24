package com.haulmont.screenapidemos.entity.airport;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "SAD_NOTE")
@Entity(name = "sad_Note")
public class Note extends StandardEntity {
    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MEETING_POINT_ID")
    protected MeetingPoint meetingPoint;

    public MeetingPoint getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(MeetingPoint meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}