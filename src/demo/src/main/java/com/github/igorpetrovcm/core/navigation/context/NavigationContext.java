/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.igorpetrovcm.core.navigation.context;

import java.net.URL;
import java.util.Map;

import javafx.stage.Stage;

/**
 *
 * @author petrov
 */
public class NavigationContext {
    private static NavigationContext instance;

    private NavigationContext() {}

    public static NavigationContext getInstance() {
        NavigationContext instance = NavigationContext.instance;
        if (instance == null) {
            synchronized (NavigationContext.class) {
                instance = NavigationContext.instance;
                if (instance == null) {
                    NavigationContext.instance = instance = new NavigationContext();
                }
            }
        }

        return instance;
    }

    private Stage primaryStage;
    private Map<String, URL> mapPoints; 

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setMapPoints(Map<String, URL> mapPoints) {
        this.mapPoints = mapPoints;
    }

    public Map<String, URL> getMapPoints() {
        return mapPoints;
    }
}
