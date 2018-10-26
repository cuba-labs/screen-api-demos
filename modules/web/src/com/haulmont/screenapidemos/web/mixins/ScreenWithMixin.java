package com.haulmont.screenapidemos.web.mixins;

import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;

@UiController("screen-with-mixin")
public class ScreenWithMixin extends Screen implements LogoMixin {

    @Subscribe
    protected void onInit(InitEvent event) {
        getWindow().setCaption("Screen with mixin");
    }
}