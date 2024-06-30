package org.example;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvParser {

    private final FileSearcher fileSearcher = new FileSearcher();
    Map<String,String> parseDateAndNameOfStations(){

    Map<String, String> dateAndNamesOfStations =  new HashMap<>();

        try {

            List<Path> parseDateAndNameOfStationsList = fileSearcher.getCsvInfo();

            for (Path path : parseDateAndNameOfStationsList) {

                List<String> lines = Files.readAllLines(path);

                for (String line : lines) {

                    String[] columns = line.split(",");

                    for (int i = 1; i < columns.length; i++) {

                        dateAndNamesOfStations.put(columns[i - 1],columns[i]);

                    }
                }
            }

        }catch (Exception e)

        {

            e.printStackTrace();

        }

        return dateAndNamesOfStations;
    }
}
