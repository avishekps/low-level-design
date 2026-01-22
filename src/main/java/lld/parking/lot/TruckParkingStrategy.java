package lld.parking.lot;

import java.util.List;
import java.util.Optional;

public class TruckParkingStrategy extends ParkingStrategy {

    public TruckParkingStrategy(final List<ParkingObserver> observers) {
        super(observers);
    }

    @Override
    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle, ParkingLot parkingLot) {

        return Optional.empty();
    }
}
