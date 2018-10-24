package com.haulmont.screenapidemos.web.note;

import com.haulmont.cuba.gui.screen.EditedEntityContainer;
import com.haulmont.cuba.gui.screen.StandardEditor;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.screenapidemos.entity.airport.Note;

@UiController("sad_Note.edit")
@UiDescriptor("note-edit.xml")
@EditedEntityContainer("noteCt")
public class NoteEdit extends StandardEditor<Note> {
}