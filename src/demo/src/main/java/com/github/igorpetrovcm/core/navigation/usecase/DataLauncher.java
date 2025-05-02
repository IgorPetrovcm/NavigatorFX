/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.github.igorpetrovcm.core.navigation.usecase;

import com.github.igorpetrovcm.core.navigation.core.RouteRepresentation;

/**
 *
 * @author petrov
 */
public interface DataLauncher<T> {
    void launch(T representation);
}
