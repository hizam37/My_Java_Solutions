import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Airport saintPetersBurg = Airport.getInstance();

        findPlanesLeavingInTheNextTwoHours(saintPetersBurg)

                .forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {



        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime twoHoursDifferences = localDateTime.plusHours(2);

        Date currentDateTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        Date dateWithTwoHoursDifferences = Date.from(twoHoursDifferences.atZone(ZoneId.systemDefault()).toInstant());

        return airport.getTerminals().stream(). //Sequencing through terminals
                flatMap((terminal) -> terminal.getFlights().stream()). //Sequencing through different elements using flatmap
                filter((flight -> flight.getDate().after(currentDateTime) && //filtering dates with two hours differences
                        flight.getDate().before(dateWithTwoHoursDifferences) &&
                        flight.getType().name().equals("DEPARTURE"))) //filtering by Departure
                .collect(Collectors.toList());
    }
}