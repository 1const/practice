package TasksTest;

import functions.Tasks.Location;
import functions.Tasks.Route;
import functions.Tasks.Settlement;
import functions.Tasks.Waypoint;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class RouteTest {

    @Test
    public void testGetterAndAddNewLocation() {
        Route route = new Route();
        Location city = new Settlement();
        city.setName("Самара");
        Location villageOne = new Waypoint();
        villageOne.setName("Тольятти");
        Location villageTwo = new Waypoint();
        villageTwo.setName("Сызрань");
        Location villageThree = new Waypoint();
        villageThree.setName("Москва");
        Location villageFour = new Settlement();
        villageFour.setName("Питер");
        route.addNewLocation(city);
        route.addNewLocation(villageOne);
        route.addNewLocation(villageTwo);
        route.addNewLocation(villageThree);
        route.addNewLocation(1, villageFour);
        List<Location> locations = new ArrayList<>();
        locations.add(city);
        locations.add(villageFour);
        locations.add(villageOne);
        locations.add(villageTwo);
        locations.add(villageThree);
        Assert.assertEquals(route.getLocations(), locations);
    }

    @Test
    public void testRemoveLocation() {
        Route route = new Route();
        Location city = new Settlement();
        city.setName("Самара");
        Location villageOne = new Waypoint();
        villageOne.setName("Тольятти");
        Location villageTwo = new Waypoint();
        villageTwo.setName("Сызрань");
        Location villageThree = new Waypoint();
        villageThree.setName("Москва");
        Location villageFour = new Settlement();
        villageFour.setName("Питер");
        route.addNewLocation(city);
        route.addNewLocation(villageOne);
        route.addNewLocation(villageTwo);
        route.addNewLocation(villageThree);
        route.addNewLocation(1, villageFour);
        route.removeLocation(0);
        route.removeLocation(0);
        route.removeLocation(0);
        route.removeLocation(0);
        route.removeLocation(0);
        Assert.assertEquals(route.getLocations(), new ArrayList<>());
    }
    @Test
    public void testIterator() {
        Route route = new Route();
        Location city = new Settlement();
        city.setId(0);
        Location villageOne = new Waypoint();
        villageOne.setId(1);
        Location villageTwo = new Settlement();
        villageTwo.setId(2);
        route.addNewLocation(city);
        route.addNewLocation(villageOne);
        route.addNewLocation(villageTwo);
    }

    @Test
    public void testGetterFirstAndLastLocations() {
        Route route = new Route();
        Location city = new Settlement();
        city.setName("Самара");
        Location villageOne = new Waypoint();
        villageOne.setName("Тольятти");
        Location villageTwo = new Settlement();
        villageTwo.setName("Москва");
        route.addNewLocation(city);
        route.addNewLocation(villageOne);
        route.addNewLocation(villageTwo);
        Assert.assertEquals(route.getFirstLocation().getName(), "Самара");
        Assert.assertEquals(route.getLastLocation().getName(), "Москва");
    }
}

