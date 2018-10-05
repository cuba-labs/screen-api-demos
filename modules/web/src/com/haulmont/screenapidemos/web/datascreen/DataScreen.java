package com.haulmont.screenapidemos.web.datascreen;

import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;

@UiController
public class DataScreen extends Screen {
    @Inject
    protected InstanceContainer<User> userCx;
    @Inject
    protected Label<String> demoLabel;

}