package com.haulmont.screenapidemos.web.customer;

import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.screen.MasterDetailScreen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.screenapidemos.entity.Customer;

@UiController("sad_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("table")
public class CustomerBrowse extends MasterDetailScreen<Customer> {
}