package com.haulmont.screenapidemos.web.datascreen;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

@UiController("demo-data")
@UiDescriptor("datascreen.xml")
public class DataScreen extends Screen {

    @Inject
    protected CollectionLoader<User> usersLd;
    @Inject
    protected InstanceContainer<User> userCt;
    @Inject
    protected Label<String> demoLabel;

    @Inject
    private DataManager dataManager;

    private static final Logger log = LoggerFactory.getLogger(DataScreen.class);

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent beforeShowEvent) {
        getScreenData().loadAll();
    }

    @Subscribe(target = Target.DATA_CONTAINER, id = "usersCt")
    protected void onUsersCtItemChanged(InstanceContainer.ItemChangeEvent<User> itemChangeEvent) {
        userCt.setItem(itemChangeEvent.getItem());
    }

    @Subscribe(id = "refresh")
    protected void onRefreshClick(Button.ClickEvent clickEvent) {
        usersLd.load();
    }

    @Subscribe(id = "save")
    protected void onSaveClick(Button.ClickEvent clickEvent) {
        getScreenData().getDataContext().commit();
    }

    @Install(target = Target.DATA_LOADER, to = "usersLd")
    protected List<User> loadUsers(LoadContext<User> loadContext) {
        log.info("Intercepted users loading");
        return dataManager.loadList(loadContext);
    }


    @Install(target = Target.DATA_CONTEXT)
    protected Set<Entity> commitChanges(CommitContext commitContext) {
        log.info("Intercepted screen data commit");
        return dataManager.commit(commitContext);
    }
}