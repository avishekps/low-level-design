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
        return findAndBookSlot(parkingLot, vehicle);
    }

    private synchronized Optional<ParkingTicket> findAndBookSlot(final ParkingLot parkingLot, final Vehicle vehicle) {
        Optional<ParkingSlot> availableSlot = findAvailableSlot(parkingLot, vehicle.getVehicleType());
        if (availableSlot.isEmpty()) {
            return Optional.empty();
        }
        availableSlot.get().setVehicleId(vehicle.getId());
        notifyObservers(availableSlot.get(), vehicle);
        return Optional.of(new ParkingTicket(vehicle.getId(), availableSlot.get().getId()));
    }

    private Optional<ParkingSlot> findAvailableSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        Optional<ParkingSlot> availableSlot = Optional.empty();
        for (Map.Entry<Integer, Floor> floorMap : parkingLot.getParkingFloorMap().entrySet()) {
            availableSlot = floorMap.getValue().getSlotsMap().values().stream()
                    .filter(slot -> !slot.isOccupied() && slot.canFitVehicle(vehicleType)).findFirst();
            if (availableSlot.isPresent()) {
                break;
            }
        }
        return availableSlot;
    }
}
