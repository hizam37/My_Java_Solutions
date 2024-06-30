package org.example;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Stations {
    private String name;
    private String line;
    private String date;
    private Double depth;
    private boolean hasConnection;

    public Stations(String name, String line, String dates, String depths, boolean hasConnection) {
        this.name = name;
        this.line = line;
        this.date = dates;
        if (depths.contains("?")) {
            this.depth = null;
        } else {
            this.depth = Double.parseDouble(depths);
        }
        this.hasConnection = hasConnection;
    }


    @Override
    public String toString() {
        return "Stations{" +
                "name='" + name + '\'' +
                ", line='" + line + '\'' +
                ", dates='" + date + '\'' +
                ", depths='" + depth + '\'' +
                ", hasConnection=" + hasConnection +
                '}';
    }


}



