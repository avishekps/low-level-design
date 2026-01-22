package lld.parking.lot;

public interface Slot {

    ParkingSize parkingSize();

    String getId();

    boolean isOccupied();
}
