package org.example;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dates {
private String name;
private String  date;

    @Override
    public String toString() {
        return "Dates{" +
                "name:" + name + '\'' +
                ", date:" + date +
                '}';
    }
}
