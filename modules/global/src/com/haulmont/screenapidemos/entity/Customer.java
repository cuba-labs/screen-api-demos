package com.haulmont.screenapidemos.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;

import javax.persistence.*;
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

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "ADDRESS_CITY")),
            @AttributeOverride(name = "zip", column = @Column(name = "ADDRESS_ZIP"))
    })
    protected Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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