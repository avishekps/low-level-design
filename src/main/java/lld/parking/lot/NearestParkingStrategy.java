package lld.parking.lot;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class NearestParkingStrategy extends ParkingStrategy {

    public NearestParkingStrategy(final List<ParkingObserver> observers) {
        super(observers);
    }

    @Override
    Optional<ParkingTicket> parkVehicle(Vehicle vehicle, ParkingLot parkingLot) {
        for (Map.Entry<String, Floor> floorMap : parkingLot.getParkingFloorMap().entrySet()) {
            Optional<Slot> availableSlot = floorMap.getValue().getSlotsMap().values().stream().filter(slot -> !slot.isOccupied()).findFirst();
            if (availableSlot.isPresent()) {
                notifyObservers(availableSlot.get(), vehicle);
                return Optional.of(new ParkingTicket(vehicle.getId(), availableSlot.get()));
            }
        }
        return Optional.empty();
    }
}
