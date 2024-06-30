package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class FileSearcher {

    public List<Path> getJsonInfo() throws IOException {

        Path path = Paths.get("data");

        List<Path> result;

        try (Stream<Path> walk = Files.walk(path)) {

            result = walk

                    .filter(Files::isRegularFile)

                    .filter(pathToJson -> pathToJson.getFileName().toString().endsWith(".json"))

                    .collect(Collectors.toList());

        }

        return result;
    }

    public List<Path> getCsvInfo() throws IOException {

        Path path = Paths.get("data");

        List<Path> result;

        try (Stream<Path> walk = Files.walk(path)) {

            result = walk

                    .filter(Files::isRegularFile)

                    .filter(pathToCsv -> pathToCsv.getFileName().toString().endsWith(".csv"))

                    .collect(Collectors.toList());

        }

        return result;
    }
}

