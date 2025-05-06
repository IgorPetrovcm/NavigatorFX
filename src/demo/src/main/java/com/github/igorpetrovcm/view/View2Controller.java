/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.igorpetrovcm.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.github.igorpetrovcm.navigationfx.DataLauncher;
import com.github.igorpetrovcm.navigationfx.NavigationPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author petrov
 */
@NavigationPath(path = "/fxml/view2.fxml")
public class View2Controller implements Initializable, DataLauncher<String> {
    private String data;

    @FXML Label lData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void launch(String data) {
        this.data = data;
        lData.setText(data);
    }
}
