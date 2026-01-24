package lld.parking.lot;

import java.util.List;
import java.util.Optional;

public abstract class ParkingStrategy {

    private final List<ParkingObserver> observerList;

    ParkingStrategy(List<ParkingObserver> observerList) {
        this.observerList = observerList;
    }

    void notifyObservers(ParkingSlot slot, Vehicle vehicle) {
        for (ParkingObserver parkingObserver : observerList) {
            parkingObserver.notify(slot, vehicle);
        }
    }

    abstract Optional<ParkingTicket> parkVehicle(Vehicle vehicle, ParkingLot parkingLot);
}