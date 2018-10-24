package com.haulmont.screenapidemos.web.airport;

import com.haulmont.cuba.gui.screen.EditedEntityContainer;
import com.haulmont.cuba.gui.screen.StandardEditor;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.screenapidemos.entity.airport.Airport;

@UiController("sad_Airport.edit")
@UiDescriptor("airport-edit.xml")
@EditedEntityContainer("airportCt")
public class AirportEdit extends StandardEditor<Airport> {
}