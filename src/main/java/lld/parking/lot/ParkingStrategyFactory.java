package lld.parking.lot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingStrategyFactory {

    private Map<VehicleType, ParkingStrategy> parkingStrategyMap;

    public ParkingStrategyFactory(final List<ParkingObserver> observers) {
        parkingStrategyMap = new HashMap<>();
        parkingStrategyMap.put(VehicleType.BIKE, new BikeParkingStrategy(observers));
        parkingStrategyMap.put(VehicleType.CAR, new CarParkingStrategy(observers));
        parkingStrategyMap.put(VehicleType.TRUCK, new TruckParkingStrategy(observers));
    }

    public ParkingStrategy getParkingStrategy(VehicleType vehicleType) {
        return parkingStrategyMap.get(vehicleType);
    }
}
