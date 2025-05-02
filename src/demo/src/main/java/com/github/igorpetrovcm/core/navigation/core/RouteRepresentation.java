/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.igorpetrovcm.core.navigation.core;

import java.net.URL;

/**
 *
 * @author petrov
 */
public class RouteRepresentation<T> {
    public URL route;
    public T commonData;

    public RouteRepresentation(T commonData, URL route) {
        this.commonData = commonData;
        this.route = route;
    }
}
