package com.haulmont.screenapidemos.web.screeninstall;

import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("demo-install")
@UiDescriptor("demo-install.xml")
public class DemoInstallFormatter extends Screen {
    @Inject
    protected Label<Integer> demoLabel;

    @Subscribe
    protected void init(Screen.InitEvent event) {
        demoLabel.setValue(10);
    }

    @Install(subject = "formatter", to = "demoLabel")
    protected String format(Integer value) {
        return ">" + value;
    }
}