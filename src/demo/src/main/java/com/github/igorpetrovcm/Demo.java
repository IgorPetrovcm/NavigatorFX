/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.github.igorpetrovcm;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.igorpetrovcm.core.navigation.context.NavigationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author petrov
 */
public class Demo extends Application {
    private final Logger logger = Logger.getLogger(Demo.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        NavigationContext.getInstance().setPrimaryStage(stage);
        NavigationContext.getInstance().setMapPoints(Map.of(
            "view2", getClass().getResource("/fxml/view2.fxml")
        ));

        logger.log(Level.INFO, stage.toString());

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
