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
package com.github.igorpetrovcm.navigatorfx.fxml.internal;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class InfoNavigationBuilder {
    private StringBuilder info = new StringBuilder();
    private List<String> searchIn = new ArrayList<>();
    private List<String> foundFiles = new ArrayList<>();

    public InfoNavigationBuilder mainBlock(String block) {
        info.append(block);

        return this;
    }

    public InfoNavigationBuilder searchIn(String in) {
        searchIn.add(in);
        return this;
        // info.append("\t[SEARCH IN]()")
    }

    public InfoNavigationBuilder foundFiles() {
        foundFiles.clear();

        FileVisitor<Path> visitor = new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileSystem fs = FileSystems.getDefault();
                PathMatcher pm = fs.getPathMatcher("glob:**/*.fxml");
                if (pm.matches(file)) {
                    foundFiles.add(file.toString());
                }

                return FileVisitResult.CONTINUE;
            }
        };
        try {
            URI root = getClass().getResource("/").toURI();
            Files.walkFileTree(Paths.get(root), visitor);
        } catch (Exception e) {e.printStackTrace();}

        return this;
    }

    public String build() {
        info.append("\t[SEARCH IN](");

        if (!searchIn.isEmpty()) {
            info.append(interOfCollection(searchIn));
        }
        info.append(")");

        info.append("\t[FOUND FXML FILES](");
        if (!foundFiles.isEmpty()) {
            info.append(interOfCollection(foundFiles));
        }
        info.append(")");


        return info.toString();
    }

    private String interOfCollection(List<String> collection) {
        StringBuilder inter = new StringBuilder();

        inter.append(collection.getFirst());
        collection.removeFirst();

        collection.forEach(e -> inter.append("," + e));

        return inter.toString();
    }

}
