package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class HtmlParser {

    public TreeMap<String,String> parseNameAndNumberOfLines() throws IOException {

        TreeMap<String, String> nameAndNumberOfLines = new TreeMap<>();

        Document doc = Jsoup.connect("https://skillbox-java.github.io").get();

        Elements linesAndNamesOfmetroStations = doc.select("div[id=metrodata]");

        for (Element div : linesAndNamesOfmetroStations) {

            Elements nameOfLine = div.select("span.js-metro-line");

            for (Element stations : nameOfLine) {

                String lineName = stations.text();

                String lineNumber = stations.attr("data-line");

                nameAndNumberOfLines.put(lineNumber, lineName);

            }

        }

        return nameAndNumberOfLines;

    }


    public List<LineStation> parseNameOfLinesAndStations() throws IOException {

        Map<String, String> lineNameByLineNumber = new HashMap<>();

        List<LineStation> stationNamesByLineName = new ArrayList();

        Document doc = Jsoup.connect("https://skillbox-java.github.io").get();

        Elements allLinesAndAllStations = doc.getElementsByAttribute("data-line");

        for (Element lineAndStations : allLinesAndAllStations) {

            if (lineAndStations.className().contains("metro-line")) {

                String lineName = lineAndStations.text();

                String lineNumber = lineAndStations.attr("data-line");

                lineNameByLineNumber.put(lineNumber, lineName);

            }
        }

        for (Element lineAndStations : allLinesAndAllStations) {
            if (lineAndStations.className().contains("metro-stations")) {
                String lineNumber = lineAndStations.attr("data-line");
                Elements children = lineAndStations.children();
                for (Element station : children) {
                    String stationName = station.getElementsByClass("name").text();
                    String lineName = lineNameByLineNumber.get(lineNumber);
                    Elements hasConnections = station.getElementsByAttribute("title");
                    stationNamesByLineName.add(new LineStation(stationName, lineName, hasConnections.size() > 0));
                }
            }

        }
        return stationNamesByLineName;
    }




    public TreeMap<String, List<String>> parseNumberOfLinesAndTheirStations() throws IOException {

        List<String> line = new ArrayList<>();

        List<String> nameOfStation = new ArrayList<>();

        TreeMap<String, List<String>> numberOfLinesAndTheirStations = new TreeMap<>();

        Document doc = Jsoup.connect("https://skillbox-java.github.io").get();

        Elements linesAndNamesOfmetroStationss = doc.select("div[id=metrodata]");

        for (Element div : linesAndNamesOfmetroStationss) {

            Elements namesStation = div.getElementsByClass("name");

            Elements numberOfLines = div.select("span.js-metro-line");

            for (Element stations : numberOfLines) {

                for (Element station : namesStation) {


                    String nameStation = station.text().trim();
                    nameOfStation.add(nameStation);
                }

                String lineNumber = stations.attr("data-line");

                line.add(lineNumber);

            }

            int[] amountOfStationPerLine = {26, 50, 72, 85, 97, 121, 144, 164, 189, 212, 218, 221, 228, 259, 270, 295, 330};

            for (int i = 0; i < amountOfStationPerLine.length; i++) {

                int start = i > 0 ? amountOfStationPerLine[i - 1] : 0;

                int end = amountOfStationPerLine[i];

                numberOfLinesAndTheirStations.put(line.get(i), nameOfStation.subList(start, end));

            }

        }

        return numberOfLinesAndTheirStations;

    }

}



