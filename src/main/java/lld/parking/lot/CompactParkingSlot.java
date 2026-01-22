package lld.parking.lot;

import java.util.UUID;

public class CompactParkingSlot implements Slot {

    private final String id;

    private String vehicleId;

    CompactParkingSlot() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public ParkingSize parkingSize() {
        return ParkingSize.COMPACT;
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
