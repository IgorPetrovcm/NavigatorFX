package com.example;

import com.github.igorpetrovcm.navigationfx.Navigator;
import com.github.igorpetrovcm.navigationfx.RouteRepresentation;
import com.github.igorpetrovcm.navigationfx.RulesHolder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NavigationPrevEventHandler implements EventHandler<ActionEvent> {
    private final RulesHolder rulesHolder;
    private final Object name;

    public NavigationPrevEventHandler(RulesHolder rulesHolder, Object name) {
        this.rulesHolder = rulesHolder;
        this.name = name;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Navigator.navigatePrev((RouteRepresentation<Class<?>, ?>) rulesHolder.getResolver(name).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
