package com.github.igorpetrovcm;

import com.github.igorpetrovcm.navigationfx.FxmlNavigationContext;
import com.github.igorpetrovcm.navigationfx.Navigator;
import com.github.igorpetrovcm.navigationfx.PrimaryStageHolder;
import com.github.igorpetrovcm.view.MainController;
import com.github.igorpetrovcm.view.View2Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class GUI extends Application {
    private final Logger logger = Logger.getLogger(Demo.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FxmlNavigationContext.getInstance().setStageHolder(new PrimaryStageHolder(stage));

        Navigator.register(MainController.class);
        Navigator.register(View2Controller.class);

        Navigator.navigate(MainController.class);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

}
