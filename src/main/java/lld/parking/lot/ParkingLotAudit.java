package lld.parking.lot;

import java.time.LocalDateTime;

public class ParkingLotAudit {

    private final Vehicle vehicle;

    private final Slot slot;

    private final LocalDateTime parkingTime;

    private LocalDateTime parkingEndTime;

    public ParkingLotAudit(final Vehicle vehicle, final Slot slot) {
        this.vehicle = vehicle;
        this.slot = slot;
        parkingTime = LocalDateTime.now();
    }

    public void endParking() {
        parkingEndTime = LocalDateTime.now();
    }
}
