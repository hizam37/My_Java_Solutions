package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LineStation {
    private String stationName;
    private String lineName;
    boolean hasConnection;
}
