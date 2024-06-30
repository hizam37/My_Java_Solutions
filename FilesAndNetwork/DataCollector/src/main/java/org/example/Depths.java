package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Depths {
    private String station_name;
    private String depth;

    @Override
    public String toString() {
        return "Depths" +
                "{" +
                "station_name:" + station_name + '\'' +
                ", depth:" + depth +
                '}';
    }
}

