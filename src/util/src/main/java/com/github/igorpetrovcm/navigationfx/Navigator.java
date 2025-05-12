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

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {
    private static NavigationContext context;
    private static ViewLoader viewLoader;

    private static LinkedList<RouteRepresentation<Class<?>, ?>> recentViews = new LinkedList<>();
    private static List<Class<?>> views = new ArrayList<>();


    public static void setViewLoader(ViewLoader contextViewLoader) {
        viewLoader = contextViewLoader;
    }

    public static void setNavigationContext(NavigationContext contextNavigationContext) {
        context = contextNavigationContext;
    }

    public static void register(Class<?>... views) {
        // TODO Register an array of Views 
        
    }

    /**
     * Defining a simple algorithm for registering a View using a Class. 
     * This Class must have a field annotated using the NavigationPath, otherwise the navigation mechanism may break.
     * @param view
     */
    public static void register(Class<?> view) {
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

        final var root = viewLoader.load(correspond);
        updateRecent(new RouteRepresentation<>(correspond, null));

        final Stage stage = context.getStageHolder().getPrimaryStage();
        
        stage.setScene(new Scene(
                root   
        ));
    }

    /**
     * Laconic way to navigate with the ability to transfer some data
     * @param route Route representation
     * @throws ViewIsNotRegisteredException
     * @throws IOException
     */
    public static void navigate(RouteRepresentation<Class<?>, ?> route) throws ViewIsNotRegisteredException, IOException {
        isRegistered(route.getDestination());

        final var root = viewLoader.load(route);
        updateRecent(route);

        final Stage stage = context.getStageHolder().getPrimaryStage();

        stage.setScene(new Scene(root));
    }

    /**
     * Loads the previous View from the recent list
     * @param route Representation without specifying the Destination, and having Some data
     * @throws IOException
     */
    public static void navigatePrev(RouteRepresentation<Class<?>, ?> route) throws IOException {
        recentViews.removeLast();
        var prevRoute = recentViews.peekLast();

        final Parent root = viewLoader.load(
            new RouteRepresentation<>(prevRoute.getDestination(), route.getSome())
        );

        final Stage stage = context.getStageHolder()
                .getPrimaryStage();

        stage.setScene(new Scene(root));
    }

    /**
     * If no Views have been uploaded before, then the most recently uploaded Ones will have the first one.
     * @param representation
     */
    private static void updateRecent(RouteRepresentation<Class<?>, ?> representation) {
        if (recentViews.isEmpty()) {
            recentViews.addFirst(representation);
        } else {
            recentViews.add(representation);
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
}
