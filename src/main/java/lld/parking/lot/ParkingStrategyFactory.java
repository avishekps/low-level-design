package lld.parking.lot;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingStrategyFactory {

    private static final Map<ParkingStrategyType, ParkingStrategy> parkingStrategyMap;

    static {
        parkingStrategyMap = new HashMap<>();
        parkingStrategyMap.put(ParkingStrategyType.NearestSlot,
                new NearestParkingStrategy(Collections.singletonList(new ParkingAuditTracker())));
    }

    private ParkingStrategyFactory() {

    }

    public static ParkingStrategy getParkingStrategy(ParkingStrategyType parkingStrategyType) {
        return parkingStrategyMap.get(parkingStrategyType);
    }
}
