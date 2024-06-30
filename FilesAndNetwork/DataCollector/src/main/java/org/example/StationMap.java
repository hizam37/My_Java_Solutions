package org.example;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class StationMap {

    private Map<String,List<String>> stations;
    private List<Line> lines;

}

