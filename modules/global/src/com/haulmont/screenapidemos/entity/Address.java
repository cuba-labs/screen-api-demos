package com.haulmont.screenapidemos.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@MetaClass(name = "sad_Address")
public class Address extends EmbeddableEntity {
    @Column(name = "CITY")
    protected String city;

    @Column(name = "ZIP", length = 10)
    protected String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}