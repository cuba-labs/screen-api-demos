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

package com.haulmont.screenapidemos.web.form.declarative.datacontainer;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;

@UiController("demo-form-declarative-data-container")
@UiDescriptor("demo-form-declarative-data-container.xml")
@EditedEntityContainer("userCt")
public class DemoFormDeclarativeDataContainer extends Screen {
    @Inject
    private InstanceContainer<User> userCt;

    @Inject
    private Metadata metadata;

    @Subscribe
    protected void initCt(InitEvent event) {
        User user = metadata.create(User.class);
        userCt.setItem(user);
    }
}
