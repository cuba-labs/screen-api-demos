package com.haulmont.screenapidemos.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "SAD_CONTRACT")
@Entity(name = "sad$Contract")
public class Contract extends StandardEntity {
    @NotNull
    @Column(name = "TITLE")
    protected String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}