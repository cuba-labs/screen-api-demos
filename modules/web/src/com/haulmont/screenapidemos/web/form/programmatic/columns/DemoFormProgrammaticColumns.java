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

package com.haulmont.screenapidemos.web.form.programmatic.columns;

import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;

@UiController("demo-form-programmatic-columns")
public class DemoFormProgrammaticColumns extends Screen {
    @Inject
    private UiComponents uiComponents;

    @Subscribe
    protected void init(InitEvent event) {
        getWindow().setCaption("Form Basic Sample");

        Form form = uiComponents.create(Form.NAME);
        form.setColumns(2);
        getWindow().add(form);

        TextField<String> textField = uiComponents.create(TextField.TYPE_STRING);
        textField.setCaption("Text Field");
        form.add(textField);

        LookupField<String> lookupField = uiComponents.create(LookupField.TYPE_STRING);
        lookupField.setCaption("Lookup Field");
        form.add(lookupField);

        PickerField<User> pickerField = uiComponents.create(PickerField.NAME);
        pickerField.setCaption("Picker Field");
        form.add(pickerField, 1);

        CheckBox checkBox = uiComponents.create(CheckBox.NAME);
        checkBox.setCaption("Check Box");
        form.add(checkBox, 1);
    }
}
