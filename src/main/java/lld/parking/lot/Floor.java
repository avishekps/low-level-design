package lld.parking.lot;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Floor {

    private final Integer id;

    private final Map<String, ParkingSlot> slotsMap;

    public Floor(final Integer id, final Set<ParkingSlot> slots) {
        this.id = id;
        this.slotsMap = slots.stream().sorted(Comparator.comparing(ParkingSlot::getId))
                .collect(Collectors.toMap(ParkingSlot::getId, Function.identity(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<String, ParkingSlot> getSlotsMap() {
        return Collections.unmodifiableMap(slotsMap);
    }

    public void addSlot(final ParkingSlot slot) {
        if (slotsMap.containsKey(slot.getId())) {
            return;
        }
        slotsMap.put(slot.getId(), slot);
    }

    public Integer getId() {
        return id;
    }
}
