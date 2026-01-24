package lld.parking.lot;

import java.time.LocalDateTime;

public class ParkingLotAudit {

    private final Vehicle vehicle;

    private final ParkingSlot slot;

    private final LocalDateTime parkingTime;

    private LocalDateTime parkingEndTime;

    public ParkingLotAudit(final Vehicle vehicle, final ParkingSlot slot) {
        this.vehicle = vehicle;
        this.slot = slot;
        parkingTime = LocalDateTime.now();
    }

    public void endParking() {
        parkingEndTime = LocalDateTime.now();
    }
}
