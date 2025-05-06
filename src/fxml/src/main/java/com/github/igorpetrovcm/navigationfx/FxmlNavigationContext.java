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

import com.github.igorpetrovcm.navigationfx.context.NavigationContext;
import com.github.igorpetrovcm.navigationfx.context.StageHolder;

public class FxmlNavigationContext implements NavigationContext {
    private static FxmlNavigationContext instance;

    private FxmlNavigationContext() {}

    public static FxmlNavigationContext getInstance() {
        if (instance == null) {
            synchronized (FxmlNavigationContext.class) {
                if (instance == null) {
                    instance = new FxmlNavigationContext();
                }
            }
        }
        return instance;
    }

    private StageHolder stageHolder;

    public StageHolder getStageHolder() {
        return stageHolder;
    }

    public void setStageHolder(StageHolder stageHolder) {
        this.stageHolder = stageHolder;
    }
}
