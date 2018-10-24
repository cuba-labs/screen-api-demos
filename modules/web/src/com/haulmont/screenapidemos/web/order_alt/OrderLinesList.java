package com.haulmont.screenapidemos.web.order_alt;

import com.haulmont.cuba.gui.EditorScreens;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.screenapidemos.entity.Order;
import com.haulmont.screenapidemos.entity.OrderLine;

import javax.inject.Inject;

@UiController("OrderLinesList")
@UiDescriptor("order-lines-list.xml")
public class OrderLinesList extends Screen {

    @Inject
    private DataContext dataContext;

    @Inject
    private InstanceContainer<Order> orderCt;

    @Inject
    private EditorScreens editorScreens;

    @Inject
    private Table<OrderLine> orderLinesTable;

    public void setParentDataContext(DataContext parentDataContext) {
        dataContext.setParent(parentDataContext);
    }

    public void setOrder(Order order) {
        orderCt.setItem(order);
    }

    public void commit() {
        dataContext.commit();
    }

    @Subscribe(id = "orderLinesTable.edit")
    protected void onEditActionPerformed(Action.ActionPerformedEvent event) {
        editorScreens.builder(OrderLine.class, this)
                .editEntity(orderLinesTable.getSingleSelected())
                .withListComponent(orderLinesTable)
                .withParentDataContext(getScreenData().getDataContext())
                .create()
                .show();
    }

    @Subscribe(id = "orderLinesTable.create")
    protected void onCreateActionPerformed(Action.ActionPerformedEvent event) {
        editorScreens.builder(OrderLine.class, this)
                .newEntity()
                .withListComponent(orderLinesTable)
                .withParentDataContext(getScreenData().getDataContext())
                .create()
                .show();
    }


}