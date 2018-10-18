package com.haulmont.screenapidemos.web.order;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Order;

@UiController("sad_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderCt")
public class OrderEdit extends StandardEditor<Order> {

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent beforeShowEvent) {
        getScreenData().loadAll();
    }
}