package com.haulmont.screenapidemos.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Table(name = "SAD_ORDER_LINE")
@Entity(name = "sad_OrderLine")
public class OrderLine extends StandardEntity {
    @NotNull
    @Column(name = "NUM", nullable = false)
    protected Integer num;
    @Column(name = "PRODUCT")
    protected String product;
    @Column(name = "PRICE")
    protected BigDecimal price;
    @Column(name = "QUANTITY")
    protected BigDecimal quantity;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}