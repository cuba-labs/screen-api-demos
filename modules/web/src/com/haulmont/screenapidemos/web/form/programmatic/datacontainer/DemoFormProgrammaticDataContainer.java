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

package com.haulmont.screenapidemos.web.form.programmatic.datacontainer;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.DataElementsFactory;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;

@UiController("demo-form-programmatic-data-container")
public class DemoFormProgrammaticDataContainer extends Screen {

    @Inject
    private Metadata metadata;

    @Inject
    private UiComponents uiComponents;

    @Inject
    private DataElementsFactory dataElementsFactory;

    @Subscribe
    protected void init(InitEvent event) {
        getWindow().setCaption("Form Data Container");

        User user = metadata.create(User.class);
        InstanceContainer<User> userCt = dataElementsFactory.createInstanceContainer(User.class);
        userCt.setItem(user);

        Form form = uiComponents.create(Form.NAME);
        getWindow().add(form);

        TextField<String> loginField = createLoginField(userCt);
        PasswordField passwordField = createPasswordField(userCt);
        PickerField<User> groupField = createGroupField(userCt);
        CheckBox activeField = createActiveField(userCt);

        form.add(loginField, passwordField, groupField, activeField);
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
}
