package com.haulmont.screenapidemos.web.order;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionContainer.UnmuteEventsMode;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Order;
import com.haulmont.screenapidemos.entity.OrderLine;

import javax.inject.Inject;
import java.util.Comparator;

@UiController("sad_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Table<OrderLine> orderLinesTable;
    @Inject
    private CollectionContainer<OrderLine> orderLinesDc;

    @Subscribe(id = "orderLinesTable.create")
    protected void onCreateActionPerformed(Action.ActionPerformedEvent event) {
        screenBuilders.editor(orderLinesTable)
                .newEntity()
                .withInitializer(orderLine -> orderLine.setNum(getMaxNum() + 1))
                .build()
                .show();
    }

    private int getMaxNum() {
        return orderLinesDc.getItems().stream()
                .map(OrderLine::getNum)
                .max(Integer::compareTo)
                .orElse(0);
    }

    @Subscribe(id = "orderLinesTable.moveUp")
    protected void onMoveUpActionPerformed(Action.ActionPerformedEvent event) {
        OrderLine selected = orderLinesTable.getSingleSelected();
        if (selected == null) {
            return;
        }
        int selIndex = orderLinesDc.getItemIndex(selected);
        if (selIndex <= 0) {
            return;
        }

        orderLinesDc.mute();

        OrderLine previous = orderLinesDc.getItems().get(selIndex - 1);
        selected.setNum(selected.getNum() - 1);
        previous.setNum(previous.getNum() + 1);

        orderLinesDc.getMutableItems()
                .sort(Comparator.comparingInt(OrderLine::getNum));

        orderLinesDc.unmute(UnmuteEventsMode.FIRE_REFRESH_EVENT);
    }

    @Subscribe(id = "orderLinesTable.moveDown")
    protected void onMoveDownActionPerformed(Action.ActionPerformedEvent event) {
        OrderLine selected = orderLinesTable.getSingleSelected();
        if (selected == null) {
            return;
        }
        int selIndex = orderLinesDc.getItemIndex(selected);
        if (selIndex >= orderLinesDc.getItems().size() - 1) {
            return;
        }

        orderLinesDc.mute();

        OrderLine next = orderLinesDc.getItems().get(selIndex + 1);
        selected.setNum(selected.getNum() + 1);
        next.setNum(next.getNum() - 1);

        orderLinesDc.getMutableItems()
                .sort(Comparator.comparingInt(OrderLine::getNum));

        orderLinesDc.unmute(UnmuteEventsMode.FIRE_REFRESH_EVENT);
    }
}