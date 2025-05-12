package com.example;

import com.github.igorpetrovcm.navigationfx.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        NavigationContext context = FxmlNavigationContext.getInstance();
        context.setStageHolder(new PrimaryStageHolder(primaryStage));

        Navigator.setNavigationContext(context);
        Navigator.setViewLoader(new FxmlViewLoader());

        Navigator.register(MainController.class);
        Navigator.register(View2Controller.class);

        Navigator.navigate(MainController.class);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
