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

import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;

import com.github.igorpetrovcm.navigationfx.context.NavigationContext;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Navigator implements NavigationContext {
    private LinkedList<FXMLLoader> views = new LinkedList<>();

    public static void movement(RouteResolver resolver) {
        Parent root = null; 

        RouteRepresentation<?, ?> representation = resolver.resolve();
        try {
            FXMLLoader loader = FXMLLoader.load((URL)representation.getDestination());

            root = loader.load();
            Object controller = loader.getController();
            if (controller instanceof DataLauncher launcher) {
                launcher.launch(representation.getCommon());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Objects.requireNonNull(root);

        
    }

    @Override
    public void register(Class<?>... views) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void register(Class<?> view) {
        final NavigationPath navigationPath = view.getAnnotationsByType(NavigationPath.class)[0];
        final URL resource = navigationPath.equals(null)
            ? view.getResource(view.getName() + ".fxml")
            : view.getResource(navigationPath.path());

        views.add(new FXMLLoader(resource));
    }
}
