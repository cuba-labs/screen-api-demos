package com.haulmont.screenapidemos.web.airport;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.airport.Airport;

@UiController("sad_Airport.browse")
@UiDescriptor("airport-browse.xml")
@LookupComponent("airportsTable")
public class AirportBrowse extends StandardLookup<Airport> {
}