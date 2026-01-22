package lld.parking.lot;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {

    private final String id;

    private final String vehicleId;

    private final Slot slot;

    private final LocalDateTime parkingTime;

    private LocalDateTime parkingEndTime;

    private Double parkingFees;

    public ParkingTicket(final String vehicleId, final Slot slot) {
        this.id = UUID.randomUUID().toString();
        this.vehicleId = vehicleId;
        this.slot = slot;
        parkingTime = LocalDateTime.now();
    }

    public void endParking() {
        parkingEndTime = LocalDateTime.now();
    }

    public void setParkingFees(final Double parkingFees) {
        this.parkingFees = parkingFees;
    }

    public LocalDateTime getParkingTime() {
        return this.parkingTime;
    }

    public LocalDateTime getParkingEndTime() {
        return this.parkingEndTime;
    }

    public Double getParkingFees() {
        return this.parkingFees;
    }

    public String getId() {
        return this.id;
    }
}
