package lld.parking.lot;

public interface ParkingObserver {

    void notify(Slot slot, Vehicle vehicle);
}
