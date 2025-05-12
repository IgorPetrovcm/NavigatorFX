package com.example;

import com.github.igorpetrovcm.navigationfx.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

@NavigationPath(path = "/fxml/main.fxml")
public class MainController implements Initializable, DataLauncher<String> {
    private RulesHolder rulesHolder;

    @FXML private Label lHello;
    @FXML private Button btnGoto;

    @Override
    public void launch(String s) {
        lHello.setText(s);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rulesHolder = new RulesHolder();
        rulesHolder.addResolver(btnGoto, () -> new RouteRepresentation<>(View2Controller.class, lHello.getText()));

        btnGoto.setOnAction(new NavigationEventHandler(rulesHolder, btnGoto));
    }
}
