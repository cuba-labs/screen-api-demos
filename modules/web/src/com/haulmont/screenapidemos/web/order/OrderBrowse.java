package com.haulmont.screenapidemos.web.order;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Order;
import com.haulmont.screenapidemos.web.order_alt.OrderAltEdit;

import javax.inject.Inject;

@UiController("sad_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
public class OrderBrowse extends StandardLookup<Order> {

    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private GroupTable<Order> ordersTable;

    @Subscribe(id = "ordersTable.altEdit")
    protected void onAltEditActionPerformed(Action.ActionPerformedEvent event) {
        screenBuilders.editor(ordersTable)
                .withScreenClass(OrderAltEdit.class)
                .build()
                .show();
    }
}