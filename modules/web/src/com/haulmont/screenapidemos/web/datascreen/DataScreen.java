package com.haulmont.screenapidemos.web.datascreen;

import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;

@UiController
@UiDescriptor("datascreen.xml")
public class DataScreen extends Screen {
    @Inject
    protected InstanceContainer<User> demoCt;
    @Inject
    protected Label<String> demoLabel;

}