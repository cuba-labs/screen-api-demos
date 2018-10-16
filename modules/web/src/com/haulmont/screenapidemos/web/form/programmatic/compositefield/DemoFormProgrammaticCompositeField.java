/*
 * Copyright (c) 2008-2018 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.screenapidemos.web.form.programmatic.compositefield;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeZones;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.options.MapOptions;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.DataContextFactory;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

@UiController("demo-form-programmatic-composite-field")
public class DemoFormProgrammaticCompositeField extends Screen {

    @Inject
    private Metadata metadata;

    @Inject
    private TimeZones timeZones;

    @Inject
    private DataContextFactory dataContextFactory;

    @Inject
    private UiComponents uiComponents;

    @Subscribe
    protected void init(InitEvent event) {
        getWindow().setCaption("Form Composite Field");

        User user = metadata.create(User.class);
        InstanceContainer<User> userCt = dataContextFactory.createInstanceContainer(User.class);
        userCt.setItem(user);

        Form form = uiComponents.create(Form.NAME);
        getWindow().add(form);

        TextField<String> loginField = createLoginField(userCt);
        PasswordField passwordField = createPasswordField(userCt);
        PickerField<User> groupField = createGroupField(userCt);
        HBoxLayout zoneBox = createZoneBox(userCt);
        CheckBox activeField = createActiveField(userCt);

        form.add(loginField, passwordField, groupField, zoneBox, activeField);
    }

    private HBoxLayout createZoneBox(InstanceContainer<User> userCt) {
        HBoxLayout zoneBox = uiComponents.create(HBoxLayout.NAME);
        zoneBox.setSpacing(true);
        zoneBox.setCaption("Time Zone");
        zoneBox.setWidth("240px");

        LookupField<String> timeZoneField = initTimeZone(userCt);
        CheckBox autoField = createAutoField(userCt);
        zoneBox.add(timeZoneField, autoField);
        zoneBox.expand(timeZoneField);
        return zoneBox;
    }

    private CheckBox createAutoField(InstanceContainer<User> userCt) {
        CheckBox checkBox = uiComponents.create(CheckBox.NAME);
        checkBox.setCaption("Auto");
        checkBox.setAlignment(Component.Alignment.MIDDLE_LEFT);
        checkBox.setValueSource(new ContainerValueSource<>(userCt, "timeZoneAuto"));
        return checkBox;
    }

    private TextField<String> createLoginField(InstanceContainer<User> userCt) {
        TextField<String> textField = uiComponents.create(TextField.TYPE_STRING);
        textField.setCaption("Login");
        textField.setValueSource(new ContainerValueSource<>(userCt, "login"));
        return textField;
    }

    private PasswordField createPasswordField(InstanceContainer<User> userCt) {
        PasswordField passwordField = uiComponents.create(PasswordField.NAME);
        passwordField.setCaption("Password");
        passwordField.setValueSource(new ContainerValueSource<>(userCt, "password"));
        return passwordField;
    }

    private PickerField<User> createGroupField(InstanceContainer<User> userCt) {
        PickerField<User> pickerField = uiComponents.create(PickerField.NAME);
        pickerField.setCaption("Group");
        pickerField.setValueSource(new ContainerValueSource<>(userCt, "group"));
        pickerField.addLookupAction();
        return pickerField;
    }

    private CheckBox createActiveField(InstanceContainer<User> userCt) {
        CheckBox checkBox = uiComponents.create(CheckBox.NAME);
        checkBox.setCaption("Active");
        checkBox.setValueSource(new ContainerValueSource<>(userCt, "active"));
        return checkBox;
    }

    private LookupField<String> initTimeZone(InstanceContainer<User> userCt) {
        LookupField<String> timeZoneField = uiComponents.create(LookupField.TYPE_STRING);
        timeZoneField.setValueSource(new ContainerValueSource<>(userCt, "timeZone"));

        userCt.addItemPropertyChangeListener(e -> {
            if ("timeZoneAuto".equals(e.getProperty())) {
                timeZoneField.setEnabled(!Boolean.TRUE.equals(e.getValue()));
            }
        });

        Map<String, String> options = new TreeMap<>();
        for (String id : TimeZone.getAvailableIDs()) {
            TimeZone timeZone = TimeZone.getTimeZone(id);
            options.put(timeZones.getDisplayNameLong(timeZone), id);
        }
        BiMap<String, String> biMap = ImmutableBiMap.copyOf(options);
        timeZoneField.setOptions(new MapOptions<>(biMap));
        timeZoneField.setOptionCaptionProvider(v -> biMap.inverse().get(v));

        return timeZoneField;
    }
}
