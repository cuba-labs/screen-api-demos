package com.haulmont.screenapidemos.web.screeninit;

import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;

@UiController
public class DemoInitEvent extends Screen {
    @Subscribe
    protected void initButtons(InitEvent event) {
    }
}