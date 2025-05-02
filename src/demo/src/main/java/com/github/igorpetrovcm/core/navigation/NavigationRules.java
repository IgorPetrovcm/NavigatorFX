/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.igorpetrovcm.core.navigation;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Supplier;

import com.github.igorpetrovcm.core.navigation.core.RouteRepresentation;

/**
 *
 * @author petrov
 */
public class NavigationRules {
    private Map<Integer, Supplier<RouteRepresentation<?>>> resolvers = new Hashtable<>();

    public void addResolver(Object ruleName, Supplier<RouteRepresentation<?>> resolver) {
        resolvers.put(ruleName.hashCode(), resolver);
    }

    public Supplier<RouteRepresentation<?>> getResolver(Object ruleName) {
        return resolvers.get(ruleName.hashCode());
    }

}
