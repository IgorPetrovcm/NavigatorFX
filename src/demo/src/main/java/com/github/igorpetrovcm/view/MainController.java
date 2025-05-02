/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.igorpetrovcm.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.igorpetrovcm.core.navigation.NavigationRules;
import com.github.igorpetrovcm.core.navigation.context.NavigationContext;
import com.github.igorpetrovcm.core.navigation.core.RouteRepresentation;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author petrov
 */
public class MainController implements Initializable {
    private final List<String> states = List.of("Exit", "View2", "View3", "View4");

    @FXML Button btnView2;
    @FXML Button btnView3;
    @FXML Button btnView4;

    @FXML ChoiceBox<String> cbState;

    private final NavigationRules btnView2Navigator = new NavigationRules();

    public MainController() {
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbState.setItems(FXCollections.observableArrayList(states));

        NavigationRules rules = new NavigationRules();
        rules.addResolver(btnView2, () -> {
            Logger lambdaLogger = Logger.getLogger(this.getClass().getName());
            if (cbState.getValue().equals("Exit")) {
                return null;
            } else {
                lambdaLogger.log(Level.INFO, cbState.getValue());
                return new RouteRepresentation<String>(
                    cbState.getValue(),
                    NavigationContext.getInstance().getMapPoints().get("view2")
                );
            }
        });

        btnView2.setOnAction(new NavigationEventHandler(rules, btnView2));
    }


}
