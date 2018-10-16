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

package com.haulmont.screenapidemos.web.form.declarative.compositefield;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeZones;
import com.haulmont.cuba.gui.components.Form;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.data.options.MapOptions;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

@UiController("demo-form-declarative-composite-field")
@UiDescriptor("demo-form-declarative-composite-field.xml")
@EditedEntityContainer("userCt")
public class DemoFormDeclarativeCompositeField extends Screen {
    @Inject
    private InstanceContainer<User> userCt;

    @Inject
    private Form form;

    @Inject
    private LookupField<String> timeZoneField;

    @Inject
    private Metadata metadata;

    @Inject
    private TimeZones timeZones;

    @Subscribe
    protected void initCt(InitEvent event) {
        User user = metadata.create(User.class);
        userCt.setItem(user);
    }

    @Subscribe
    protected void initTimeZone(InitEvent event) {
        userCt.addItemPropertyChangeListener(e -> {
            if ("timeZoneAuto".equals(e.getProperty())) {
                // We obtain a component from a Form for testing purpose
                form.getComponentNN("timeZoneField")
                        .setEnabled(!Boolean.TRUE.equals(e.getValue()));
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
    }
}
