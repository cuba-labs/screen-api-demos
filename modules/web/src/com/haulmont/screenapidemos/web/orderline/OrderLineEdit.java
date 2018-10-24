package com.haulmont.screenapidemos.web.orderline;

import com.haulmont.cuba.gui.screen.EditedEntityContainer;
import com.haulmont.cuba.gui.screen.StandardEditor;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.screenapidemos.entity.OrderLine;

@UiController("sad_OrderLine.edit")
@UiDescriptor("order-line-edit.xml")
@EditedEntityContainer("orderLineCt")
public class OrderLineEdit extends StandardEditor<OrderLine> {
}