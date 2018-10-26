package com.haulmont.screenapidemos.web.mixins;

import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.screen.Extensions;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;

public interface LogoMixin {
    @Subscribe
    default void initLogo(Screen.InitEvent event) {
        Window window = event.getSource().getWindow();

        BeanLocator beanLocator = Extensions.getBeanLocator(event.getSource());
        UiComponents uiComponents = beanLocator.get(UiComponents.class);

        Label<String> logoLabel = uiComponents.create(Label.NAME);
        logoLabel.setValue("<LOGO>");

        window.add(logoLabel, 0);
    }
}