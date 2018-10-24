package com.haulmont.screenapidemos.web.contract;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.screenapidemos.entity.Contract;

@EditedEntityContainer("contractCt")
@PrimaryEditorScreen(Contract.class)
@UiDescriptor("contract-edit.xml")
@UiController("contract-edit")
public class ContractEdit extends StandardEditor<Contract> {

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent beforeShowEvent) {
        getScreenData().loadAll();
    }
}