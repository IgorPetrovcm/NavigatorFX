/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.igorpetrovcm.view;

import com.github.igorpetrovcm.navigationfx.NavigationRules;
import com.github.igorpetrovcm.navigationfx.Navigator;
import com.github.igorpetrovcm.navigationfx.RouteRepresentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author petrov
 */
public class NavigationEventHandler implements EventHandler<ActionEvent> {
    private final NavigationRules rules;
    private final Object stateObj;

    public NavigationEventHandler(NavigationRules rules, Object stateObj) {
        this.rules = rules;
        this.stateObj = stateObj;
    }

    @Override
    public void handle(ActionEvent t) {
        try {
            Navigator.navigate((RouteRepresentation<?, ?>)rules.getResolver(stateObj).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
