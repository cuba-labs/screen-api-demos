package com.haulmont.screenapidemos.web.order_alt;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Order;

import javax.inject.Inject;

@UiController("sad_Order.altEdit")
@UiDescriptor("order-alt-edit.xml")
@EditedEntityContainer("orderCt")
public class OrderAltEdit extends StandardEditor<Order> {

    @Inject
    private InstanceContainer<Order> orderCt;

    @Subscribe(id = "editLines")
    protected void onEditLinesClick(Button.ClickEvent event) {
        OrderLinesList orderLinesList = getScreenContext().getScreens().create(OrderLinesList.class, OpenMode.DIALOG);
        orderLinesList.setParentDataContext(getScreenData().getDataContext());
        orderLinesList.setOrder(orderCt.getItem());
        orderLinesList.show();
        orderLinesList.addAfterCloseListener(afterCloseEvent -> {
            orderLinesList.commit();
        });
    }

}