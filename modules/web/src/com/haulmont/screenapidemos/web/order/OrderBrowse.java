package com.haulmont.screenapidemos.web.order;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Order;

@UiController("sad_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
public class OrderBrowse extends StandardLookup<Order> {

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent beforeShowEvent) {
        getScreenData().loadAll();
    }

}