/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.igorpetrovcm.core.navigation;

import java.net.URL;
import java.util.Objects;

import com.github.igorpetrovcm.core.navigation.context.NavigationContext;
import com.github.igorpetrovcm.core.navigation.core.RouteRepresentation;
import com.github.igorpetrovcm.core.navigation.usecase.DataLauncher;
import com.github.igorpetrovcm.core.navigation.usecase.RouteResolver;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author petrov
 */
public class Navigator {
    public static void movement(URL route) throws Exception {
        Parent root = null;
        try {
            root = FXMLLoader.load(route);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Objects.requireNonNull(root);

        Stage primary = NavigationContext.getInstance().getPrimaryStage();

        primary.setScene(new Scene(root));
    }

    public static void movement(RouteResolver resolver) {
        Parent root = null;

        RouteRepresentation representation = resolver.resolve();
        try {
            FXMLLoader loader = new FXMLLoader(representation.route);
            root = loader.load();

            Object controller = loader.getController();
            if (controller instanceof DataLauncher launcher) {
                launcher.launch(representation.commonData); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Objects.requireNonNull(root);

        NavigationContext.getInstance().getPrimaryStage()
            .setScene(new Scene(root));
    }
}
