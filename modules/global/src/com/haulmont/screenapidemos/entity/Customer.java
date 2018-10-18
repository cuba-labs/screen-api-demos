package com.haulmont.screenapidemos.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "SAD_CUSTOMER")
@Entity(name = "sad_Customer")
public class Customer extends StandardEntity {
    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;
    @Column(name = "EMAIL", length = 100)
    protected String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}