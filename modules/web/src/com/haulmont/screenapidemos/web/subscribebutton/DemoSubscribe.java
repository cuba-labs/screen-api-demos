package com.haulmont.screenapidemos.web.subscribebutton;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("demo-subscribe")
@UiDescriptor("demo-subscribe.xml")
public class DemoSubscribe extends Screen {
    @Inject
    protected Notifications notifications;

    @Subscribe("runBtn")
    protected void run(Button.ClickEvent clickEvent) {
        notifications.create()
                .setCaption("Demo")
                .show();
    }
}