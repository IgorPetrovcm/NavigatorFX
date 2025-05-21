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
package com.github.igorpetrovcm.navigatorfx.util;

import java.util.function.Supplier;

import com.github.igorpetrovcm.navigatorfx.core.RouteRepresentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonBase;

public class Route {
    public static void register(
        final ButtonBase btn,
        final NavigateMode mode,
        final Supplier<RouteRepresentation> sup
    ) {
        switch (mode) {
            case NavigateMode.NAVIGATE_TO:
                btn.setOnAction(
                    new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(final ActionEvent event) {
                            try {
                                Navigator.navigate(sup.get());
                            }
                            catch (final Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                );

            break;

            case NavigateMode.PREV:
                btn.setOnAction(
                    new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                Navigator.navigatePrev(sup.get());
                            }        
                            catch (final Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                );
                
            break;
        }
    }
}
