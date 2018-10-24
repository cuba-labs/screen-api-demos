package com.haulmont.screenapidemos.web.meetingpoint;

import com.haulmont.cuba.gui.screen.EditedEntityContainer;
import com.haulmont.cuba.gui.screen.StandardEditor;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.screenapidemos.entity.airport.MeetingPoint;

@UiController("sad_MeetingPoint.edit")
@UiDescriptor("meeting-point-edit.xml")
@EditedEntityContainer("meetingPointCt")
public class MeetingPointEdit extends StandardEditor<MeetingPoint> {
}