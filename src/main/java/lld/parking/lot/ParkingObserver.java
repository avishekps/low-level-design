package lld.parking.lot;

public interface ParkingObserver {

    void notify(ParkingSlot slot, Vehicle vehicle);
}
