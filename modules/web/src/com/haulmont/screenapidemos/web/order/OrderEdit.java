package com.haulmont.screenapidemos.web.order;

import com.haulmont.cuba.gui.EditorScreens;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Customer;
import com.haulmont.screenapidemos.entity.Order;
import com.haulmont.screenapidemos.entity.OrderLine;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;

@UiController("sad_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private EditorScreens editorScreens;

    @Inject
    private Table<OrderLine> orderLinesTable;

    @Inject
    private CollectionContainer<OrderLine> orderLinesDc;

    @Subscribe(id = "orderLinesTable.create")
    protected void onCreateActionPerformed(Action.ActionPerformedEvent event) {
        editorScreens.builder(orderLinesTable)
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
        if (selected == null)
            return;
        int selIndex = orderLinesDc.getItemIndex(selected);
        if (selIndex <= 0)
            return;
        OrderLine previous = orderLinesDc.getItems().get(selIndex - 1);
        selected.setNum(selected.getNum() - 1);
        previous.setNum(previous.getNum() + 1);
        // TODO add 'disableListeners' here when implemented
        orderLinesDc.getMutableItems().sort(Comparator.comparingInt(OrderLine::getNum));
    }

    @Subscribe(id = "orderLinesTable.moveDown")
    protected void onMoveDownActionPerformed(Action.ActionPerformedEvent event) {
        OrderLine selected = orderLinesTable.getSingleSelected();
        if (selected == null)
            return;
        int selIndex = orderLinesDc.getItemIndex(selected);
        if (selIndex >= orderLinesDc.getItems().size() - 1)
            return;
        OrderLine next = orderLinesDc.getItems().get(selIndex + 1);
        selected.setNum(selected.getNum() + 1);
        next.setNum(next.getNum() - 1);
        // TODO add 'disableListeners' here when implemented
        orderLinesDc.getMutableItems().sort(Comparator.comparingInt(OrderLine::getNum));
    }
}