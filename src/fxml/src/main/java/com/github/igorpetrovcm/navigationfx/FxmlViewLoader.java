/*
 * Copyright 2025 IgorPetrovcm
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.igorpetrovcm.navigationfx;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class FxmlViewLoader implements ViewLoader {

    @Override
    public Parent load(Class<?> view) {
        Parent root = null;

        var loader = uploadResource(view);

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            root = new Pane(new Label(e.getMessage()));
            // TODO Handle please
        }

        return root;
    }

    @Override
    public Parent load(RouteRepresentation<Class<?>, ?> representation) {
        Parent root = null;

        var loader = uploadResource(representation.getDestination());
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            root = new Pane(new Label(e.getMessage()));
            // TODO Handle please
        }

        var controller = loader.getController();
        if (controller instanceof DataLauncher launcher) {
            launcher.launch(representation.getSome());
        }

        return root;
    }


    private FXMLLoader uploadResource(Class<?> view) {
        FXMLLoader loader = null;
        NavigationPath[] navigationAnnotations = view.getAnnotationsByType(NavigationPath.class);

        try {
            if (navigationAnnotations == null) {
                loader = new FXMLLoader(view.getResource(view.getName() + ".fxml"));
            } else {
                loader = new FXMLLoader(view.getResource(navigationAnnotations[0].path()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Objects.requireNonNull(loader, "Something went wrong when loading the view resource");
        return loader;
    }
    
}
