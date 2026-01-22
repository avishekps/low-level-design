package lld.parking.lot;

import java.util.UUID;

public class LargeParkingSlot implements Slot {

    private final String id;

    private String vehicleId;

    LargeParkingSlot() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public ParkingSize parkingSize() {
        return ParkingSize.LARGE;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isOccupied() {
        return vehicleId != null && !vehicleId.isEmpty();
    }
}
