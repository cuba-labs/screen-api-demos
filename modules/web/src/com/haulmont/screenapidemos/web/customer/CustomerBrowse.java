package com.haulmont.screenapidemos.web.customer;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Customer;

@UiController("sad_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("table")
public class CustomerBrowse extends MasterDetailScreen<Customer> {

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent beforeShowEvent) {
        getScreenData().loadAll();
    }
}