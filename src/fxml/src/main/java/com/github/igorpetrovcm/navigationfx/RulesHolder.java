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

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Supplier;

public class RulesHolder implements NavigationRules<Object>{
    private Map<Integer, Supplier<RouteRepresentation<?, ?>>> resolvers = new Hashtable<>(); 

    @Override
    public void addResolver(Object name, Supplier<RouteRepresentation<?, ?>> representation) {
         resolvers.put(name.hashCode(), representation);
    }

    @Override
    public Supplier getResolver(Object name) {
        return resolvers.get(name.hashCode());
    }
     
}
