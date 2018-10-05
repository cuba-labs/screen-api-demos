package com.haulmont.screenapidemos.web.contract;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Contract;

@UiDescriptor("contract-list.xml")
@UiController("contract-list")
@PrimaryLookupScreen(Contract.class)
@LookupComponent("contractsTable")
public class ContractList extends StandardLookup<Contract> {

}