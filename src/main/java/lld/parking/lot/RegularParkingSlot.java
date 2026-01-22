package lld.parking.lot;

import java.util.UUID;

public class RegularParkingSlot implements Slot {

    private final String id;

    private String vehicleId;

    RegularParkingSlot() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public ParkingSize parkingSize() {
        return ParkingSize.REGULAR;
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
