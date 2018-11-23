package com.haulmont.screenapidemos.web.customer;

import com.haulmont.cuba.gui.EditorScreens;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Customer;

import javax.inject.Inject;

@UiController("sad_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("table")
public class CustomerBrowse extends MasterDetailScreen<Customer> {

    @Inject
    private EditorScreens editorScreens;

    @Inject
    private GroupTable<Customer> table;

    @Subscribe("table.editExt")
    protected void onTableEditExtActionPerformed(Action.ActionPerformedEvent event) {
        editorScreens.builder(table)
                .withScreen(CustomerEdit.class)
                .build()
                .show();
    }
}