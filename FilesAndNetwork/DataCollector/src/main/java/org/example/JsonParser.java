package org.example;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParser  {

    private final FileSearcher fileSearcher = new FileSearcher();
    Map<String, String> parseDepthAndNameOfstations() {

        Map<String, String> JsonInfo = new HashMap<>();

        try {

            List<Path> result = fileSearcher.getJsonInfo();

            for (Path path : result) {

                String json = new String(Files.readAllBytes(path));

                JSONParser parser = new JSONParser();

                JSONArray jsonArray = (JSONArray) parser.parse(json);

                for (Object o : jsonArray) {

                    JSONObject person = (JSONObject) o;

                    String name = (String) person.get("station_name");

                    String depth =  person.get("depth").toString().replace(",",".");

                    JsonInfo.put(name,depth);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonInfo;
    }

}
