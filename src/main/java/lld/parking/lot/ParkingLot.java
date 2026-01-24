package lld.parking.lot;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParkingLot {

    private final Map<Integer, Floor> parkingFloorMap;

    public ParkingLot(final List<Floor> floors) {
        this.parkingFloorMap = floors.stream().sorted(Comparator.comparing(Floor::getId))
                .collect(Collectors.toMap(Floor::getId, Function.identity(), (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<Integer, Floor> getParkingFloorMap() {
        return Collections.unmodifiableMap(parkingFloorMap);
    }

    public void addSlot(final Integer floorNumber, final ParkingSlot slot) {
        if (!parkingFloorMap.containsKey(floorNumber) || parkingFloorMap.get(floorNumber).getSlotsMap().containsKey(slot.getId())) {
            return;
        }
        Floor floor = parkingFloorMap.get(floorNumber);
        floor.addSlot(slot);
    }

    public void addFloor(final Integer floorNumber) {
        if (parkingFloorMap.containsKey(floorNumber)) {
            return;
        }
        parkingFloorMap.put(floorNumber, new Floor(floorNumber, Collections.emptySet()));
    }
}
