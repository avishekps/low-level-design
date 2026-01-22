package lld.parking.lot;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Floor {

    private final String id;

    private final Map<String, Slot> slotsMap;

    public Floor(final String id, final Set<Slot> slots) {
        this.id = id;
        this.slotsMap = slots.stream().sorted(Comparator.comparing(Slot::getId))
                .collect(Collectors.toMap(Slot::getId, Function.identity(), (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<String, Slot> getSlotsMap() {
        return Collections.unmodifiableMap(slotsMap);
    }

    public String getId() {
        return id;
    }
}
