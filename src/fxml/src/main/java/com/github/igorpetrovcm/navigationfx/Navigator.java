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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.github.igorpetrovcm.navigationfx.exception.ViewIsNotRegisteredException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {
    private static LinkedList<FXMLLoader> recentViews = new LinkedList<>();
    private static List<Class<?>> views = new ArrayList<>();

    public static void register(Class<?>... views) {
        // TODO Auto-generated method stub
        
    }

    /**
     * Defining a simple algorithm for registering a View using a Class. 
     * This Class must have a field annotated using the NavigationPath, otherwise the navigation mechanism may break.
     * @param view
     */
    public static void register(Class<?> view) {
        // final NavigationPath navigationPath = view.getAnnotationsByType(NavigationPath.class)[0];
        // final URL resource = navigationPath.equals(null)
            // ? view.getResource(view.getName() + ".fxml")
            // : view.getResource(navigationPath.path());
        Objects.requireNonNull(view);
        views.add(view);
    }

    
    /** 
     * Navigation to a specific View
     * @param view View class that you need to navigate to
     * @throws ViewIsNotRegisteredException
     * @throws IOException
     */
    public static void navigate(Class<?> view) throws ViewIsNotRegisteredException, IOException {
        final Class<?> correspond = isRegistered(view);

        final FXMLLoader loader = loadViewLoader(correspond);
        updateRecent(loader);

        final Stage stage = FxmlNavigationContext.getInstance().getStageHolder()
                    .getPrimaryStage();
        
        stage.setScene(new Scene(
            loader.<Parent>load()
        ));
    }

    /**
     * Laconic way to navigate with the ability to transfer some data
     * @param route Route representation
     * @throws ViewIsNotRegisteredException
     * @throws IOException
     */
    public static void navigate(RouteRepresentation<? extends Class<?>, ?> route) throws ViewIsNotRegisteredException, IOException {
        final Class<?> correspond = isRegistered(route.getDestination());

        final FXMLLoader loader = loadViewLoader(correspond);
        updateRecent(loader);

        final Parent root = loader.load();

        Object controller = loader.getController();
        if (controller instanceof DataLauncher launcher) {
            launcher.launch(route.getSome());
        }

        final Stage stage = FxmlNavigationContext.getInstance().getStageHolder()
                .getPrimaryStage();

        stage.setScene(new Scene(root));
    }

    /**
     * Loads the previous View from the recent list
     * @param route
     * @throws IOException
     */
    public static void navigatePrev(RouteRepresentation<? extends Class<?>, ?> route) throws IOException {
        final FXMLLoader loader = recentViews.pollLast();

        final Parent root = loader.load();

        Object controller = loader.getController();
        if (controller instanceof DataLauncher launcher) {
            launcher.launch(route.getSome());
        }

        final Stage stage = FxmlNavigationContext.getInstance().getStageHolder()
                .getPrimaryStage();

        stage.setScene(new Scene(root));
    }

    /**
     * If no Views have been uploaded before, then the most recently uploaded Ones will have the first one.
     * @param loader
     */
    private static void updateRecent(FXMLLoader loader) {
        if (recentViews.isEmpty()) {
            recentViews.addFirst(loader);
        } else {
            recentViews.add(loader);
        }
    }

    private static Class<?> isRegistered(Class<?> view) throws ViewIsNotRegisteredException {
        return views.stream()
            .filter(view::equals)
            .findFirst()
            .orElseThrow(
                ViewIsNotRegisteredException::new
            );
    }

    /**
     * Attempt to load fxml from a specific View
     * @param view
     * @return
     */
    private static FXMLLoader loadViewLoader(Class<?> view) {
        NavigationPath[] navigationAnnotations = view.getAnnotationsByType(NavigationPath.class);
        FXMLLoader loader = null;

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
