package functions.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Route implements Iterable {

    private final List<Location> locations = new ArrayList<>();

    public List<Location> getLocations() {
        return locations;
    }

    public void addNewLocation(Location newLocation) {
        locations.add(newLocation);
    }

    public void addNewLocation(int index, Location newLocation) {
        locations.add(index, newLocation);
    }

    public void removeLocation(int index) {
        locations.remove(index);
    }
    public Location getFirstLocation() {
        return locations.get(0);
    }

    public Location getLastLocation() {
        return locations.get(locations.size() - 1);
    }

    @Override
    public Iterator<Location> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < locations.size() - 1;
            }

            @Override
            public Location next() {
                if (hasNext()) {
                    return locations.get(index++);
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        };
    }
}
