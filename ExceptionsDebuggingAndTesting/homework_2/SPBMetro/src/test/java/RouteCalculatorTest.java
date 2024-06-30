import core.Line;
import core.Station;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RouteCalculatorTest {

    RouteCalculator routeCalculator;
    Station chernashevskaya;
    Station ploshadVastanya;
    Station mayakovskaya;
    Station dostyevskaya;
    Station vladimirskaya;

    StationIndex conectectedStations;
    Line line1;

    Line line3;
    Line line4;
    List<Station> stations;


    @Before
    public void setUp() throws Exception {

        conectectedStations = new StationIndex();

        stations = new ArrayList<>();

        line1 = new Line(1, "red");

        line3 = new Line(3, "green");

        line4 = new Line(4, "orange");

        chernashevskaya = new Station("Чернышевская", line1);

        ploshadVastanya = new Station("Площадь Восстания", line1);

        vladimirskaya = new Station("Владимирская", line1);

        mayakovskaya = new Station("Маяковская", line3);

        dostyevskaya = new Station("Достоевская", line4);

        line1.addStation(vladimirskaya);

        line1.addStation(ploshadVastanya);

        line3.addStation(mayakovskaya);

        line1.addStation(chernashevskaya);

        line4.addStation(dostyevskaya);

        conectectedStations.addLine(line1);

        conectectedStations.addLine(line3);

        conectectedStations.addLine(line4);

        stations.add(ploshadVastanya);

        stations.add(mayakovskaya);

        stations.add(vladimirskaya);

        stations.add(dostyevskaya);

        conectectedStations.addConnection(Arrays.asList(ploshadVastanya, mayakovskaya));

        conectectedStations.addConnection(Arrays.asList(vladimirskaya, dostyevskaya));

        routeCalculator = new RouteCalculator(conectectedStations);

    }


    @Test
    public void getShortestRoute() {

        List<Station> shortestRoutes = routeCalculator.getShortestRoute(chernashevskaya, vladimirskaya);

        List<Station> stations = new ArrayList<>();

        stations.add(new Station("Чернышевская", new Line(1, "red")));

        stations.add(new Station("Площадь Восстания", new Line(1, "red")));

        stations.add(new Station("Владимирская", new Line(1, "red")));

        assertEquals(stations, shortestRoutes);
    }

    @Test
    public void calculateDuration() {

        double actual = RouteCalculator.calculateDuration(stations);

        double expected = 10.5;

        assertEquals(expected, actual, 0.0);

    }

    @Test
    public void getRouteWithOneConnection() {

        List<Station> routeWithOneConnection = routeCalculator.getShortestRoute(chernashevskaya, mayakovskaya);

        List<Station> stations = new ArrayList<>();

        stations.add(new Station("Чернышевская", new Line(1, "red")));

        stations.add(new Station("Площадь Восстания", new Line(1, "red")));

        stations.add(new Station("Маяковская", new Line(3, "green")));

        assertEquals(stations, routeWithOneConnection);

    }


    @Test
    public void getRouteWithTwoConnections() {

        List<Station> routeWithTwoConnection = routeCalculator.getShortestRoute(chernashevskaya, dostyevskaya);

        List<Station> stations = new ArrayList<>();

        stations.add(new Station("Чернышевская", new Line(1, "red")));

        stations.add(new Station("Площадь Восстания", new Line(1, "red")));

        stations.add(new Station("Владимирская", new Line(1, "red")));

        stations.add(new Station("Достоевская", new Line(4, "orange")));

        assertEquals(stations, routeWithTwoConnection);
    }
}
