/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.igorpetrovcm.core.navigation;

import java.util.function.Supplier;

import com.github.igorpetrovcm.core.navigation.core.RouteRepresentation;
import com.github.igorpetrovcm.core.navigation.usecase.RouteResolver;

/**
 *
 * @author petrov
 */
public class SimpleRouteResolver implements RouteResolver {
    private final Supplier<RouteRepresentation<?>> supplier; 

    public SimpleRouteResolver(Supplier<RouteRepresentation<?>> supplier) {
        this.supplier = supplier;
    }

    @Override
    public RouteRepresentation<?> resolve() {
        return supplier.get();
    }

}
