package org.example;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DataCollector {


    public static void main(String[] args) throws IOException {

        List<Stations> stationsList = new ArrayList<>();

        List<Line> lines = new ArrayList<>();

        Dates dates = new Dates();

        Depths depths = new Depths();

        CsvParser csvParser = new CsvParser();

        JsonParser jsonParser = new JsonParser();

        HtmlParser htmlParser = new HtmlParser();

        //List OF NUMBER AND NAME OF LINES
        TreeMap<String, String> nameAndNumberOfLines = htmlParser.parseNameAndNumberOfLines();

        //List OF NUMBER OF LINES AND THEIR STATIONS
        Map<String, List<String>> numberOfLinesAndTheirStations = htmlParser.parseNumberOfLinesAndTheirStations();

        ///LIST OF NAME OF STATIONS AND THEIR NAME OF LINES
        List<LineStation> nameOfStationAndTheirNameOfLine = htmlParser.parseNameOfLinesAndStations();

        //LIST OF NAME OF STATIONS ALONG WITH THEIR DATES
        Map<String, String> nameAndDateOfStations = csvParser.parseDateAndNameOfStations();

        //LIST OF NAME OF STATIONS ALONG WITH THEIR DEPTHS
        Map<String, String> depthsOfStations = jsonParser.parseDepthAndNameOfstations();

        for (LineStation nameOfLinesAndStation : nameOfStationAndTheirNameOfLine) {

            for (Map.Entry<String, String> dateOfStationsEntry : nameAndDateOfStations.entrySet()) {

                for (Map.Entry<String, String> depthsOfStationsEntry : depthsOfStations.entrySet()) {

                    if (dateOfStationsEntry.getKey().equals(nameOfLinesAndStation.getStationName())
                            && depthsOfStationsEntry.getKey().equals(nameOfLinesAndStation.getStationName())) {

                        dates.setDate(dateOfStationsEntry.getValue());
                        depths.setDepth(depthsOfStationsEntry.getValue());

                        Stations stations = new Stations(nameOfLinesAndStation.getStationName(),
                                nameOfLinesAndStation.getLineName(),
                                dates.getDate(),
                                depths.getDepth(),
                                nameOfLinesAndStation.isHasConnection());

                        Gson gson = new Gson();

                        stationsList.add(stations);

                        String json = gson.toJson(stationsList);

                        try (FileWriter fileWriter = new FileWriter("src/main/resources/stations.json")) {

                            fileWriter.write("{ \"stations\": " + json + " }");

                        } catch (IOException e) {

                            e.printStackTrace();

                        }


                    }
                }
            }
        }
        for (Map.Entry<String, String> linesEntry : nameAndNumberOfLines.entrySet()) {

            String lineName = linesEntry.getKey();

            String lineNumber = linesEntry.getValue();

            lines.add(new Line(lineName, lineNumber));

            StationMap stationMap = new StationMap(numberOfLinesAndTheirStations, lines);

            Gson convert = new Gson();

            String stationMapToJsonFormat = convert.toJson(stationMap);

            try (FileWriter fileWriter = new FileWriter("src/main/resources/Mymap.json")) {

                fileWriter.write(stationMapToJsonFormat);

            } catch (
                    IOException e) {

                e.printStackTrace();

            }

        }
    }
}