package com.haulmont.screenapidemos.web.orderline;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.OrderLine;

@UiController("sad_OrderLine.edit")
@UiDescriptor("order-line-edit.xml")
@EditedEntityContainer("orderLineCt")
public class OrderLineEdit extends StandardEditor<OrderLine> {

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent beforeShowEvent) {
        getScreenData().loadAll();
    }

}