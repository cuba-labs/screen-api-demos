package com.haulmont.screenapidemos.web.terminal;

import com.haulmont.cuba.gui.screen.EditedEntityContainer;
import com.haulmont.cuba.gui.screen.StandardEditor;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.screenapidemos.entity.airport.Terminal;

@UiController("sad_Terminal.edit")
@UiDescriptor("terminal-edit.xml")
@EditedEntityContainer("terminalCt")
public class TerminalEdit extends StandardEditor<Terminal> {
}