package com.example;

import com.github.igorpetrovcm.navigationfx.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

@NavigationPath(path = "/fxml/view2.fxml")
public class View2Controller implements Initializable, DataLauncher<String> {
    private RulesHolder rulesHolder;

    @FXML private Label lData;
    @FXML private Button btnBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rulesHolder = new RulesHolder();
        rulesHolder.addResolver(btnBack, () -> new RouteRepresentation<>(null, lData.getText() + "[From View2]"));

        btnBack.setOnAction(new NavigationPrevEventHandler(rulesHolder, btnBack));
    }

    @Override
    public void launch(String s) {
        lData.setText(s);
    }
}
