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

package com.haulmont.screenapidemos.web.form.programmatic.captionpos;

import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;

@UiController("demo-form-programmatic-caption-position")
public class DemoFormProgrammaticCaptionPosition extends Screen {

    @Inject
    private UiComponents uiComponents;

    @Subscribe
    protected void init(InitEvent event) {
        getWindow().setCaption("Form Caption Position");

        HBoxLayout box = uiComponents.create(HBoxLayout.NAME);
        box.setSpacing(true);

        box.add(createForm("Caption Position: TOP", Form.CaptionAlignment.TOP),
                createForm("Caption Position: LEFT", Form.CaptionAlignment.LEFT));

        getWindow().add(box);
    }

    private Form createForm(String caption, Form.CaptionAlignment captionPosition) {
        Form form = uiComponents.create(Form.NAME);
        form.setCaption(caption);
        form.setCaptionAlignment(captionPosition);

        TextField<String> textField = uiComponents.create(TextField.TYPE_STRING);
        textField.setCaption("Text Field");

        LookupField<String> lookupField = uiComponents.create(LookupField.TYPE_STRING);
        lookupField.setCaption("Lookup Field");

        PickerField<User> pickerField = uiComponents.create(PickerField.NAME);
        pickerField.setCaption("Picker Field");

        CheckBox checkBox = uiComponents.create(CheckBox.NAME);
        checkBox.setCaption("Check Box");

        form.add(textField, lookupField, pickerField, checkBox);

        return form;
    }
}
