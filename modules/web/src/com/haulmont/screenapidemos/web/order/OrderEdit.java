package com.haulmont.screenapidemos.web.order;

import com.haulmont.cuba.gui.screen.EditedEntityContainer;
import com.haulmont.cuba.gui.screen.StandardEditor;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.screenapidemos.entity.Order;

@UiController("sad_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderCt")
public class OrderEdit extends StandardEditor<Order> {
}