package com.haulmont.screenapidemos.web.demo;

import com.haulmont.cuba.gui.screen.MessageBundle;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("demo")
@UiDescriptor("demo.xml")
public class DemoScreen extends Screen {

    @Inject
    protected MessageBundle messageBundle;
}