package com.haulmont.screenapidemos.web.actiondemo;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("demo-action")
@UiDescriptor("demo-action.xml")
public class DemoActionScreen extends Screen {
    @Inject
    protected Notifications notifications;

    @Subscribe("demo")
    protected void onExport(Action.ActionPerformedEvent event) {
        notifications.create()
                .withCaption("Demo")
                .show();
    }
}