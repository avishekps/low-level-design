package lld.parking.lot;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParkingLot {

    private final Map<String, Floor> parkingFloorMap;

    public ParkingLot(final List<Floor> floors) {
        this.parkingFloorMap = floors.stream().sorted(Comparator.comparing(Floor::getId))
                .collect(Collectors.toMap(Floor::getId, Function.identity(), (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<String, Floor> getParkingFloorMap() {
        return Collections.unmodifiableMap(parkingFloorMap);
    }
}
