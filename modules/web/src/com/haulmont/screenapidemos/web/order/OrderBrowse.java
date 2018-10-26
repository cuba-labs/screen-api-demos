package com.haulmont.screenapidemos.web.order;

import com.haulmont.cuba.gui.EditorScreens;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Order;

import javax.inject.Inject;

@UiController("sad_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
public class OrderBrowse extends StandardLookup<Order> {

    @Inject
    private EditorScreens editorScreens;

    @Inject
    private GroupTable<Order> ordersTable;

    @Subscribe(id = "ordersTable.altEdit")
    protected void onAltEditActionPerformed(Action.ActionPerformedEvent event) {
        editorScreens.builder(ordersTable).withScreen("sad_Order.altEdit").build().show();
    }
}