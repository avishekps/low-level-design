package lld.parking.lot;

import java.time.Duration;
import java.time.LocalDateTime;

public class StandardParkingFeesCalculationStrategy implements ParkingFeesCalculationStrategy {

    private final Double perHourCharges;

    private final Double overtimeCharges;

    public StandardParkingFeesCalculationStrategy(final Double perHourCharges, final Double overtimeCharges) {
        this.perHourCharges = perHourCharges;
        this.overtimeCharges = overtimeCharges;
    }

    @Override
    public Double calculateParkingFees(ParkingTicket parkingTicket) {
        LocalDateTime startTime = parkingTicket.getParkingTime();
        LocalDateTime endTime = parkingTicket.getParkingEndTime();
        long totalHours = Duration.between(endTime, startTime).toHours();
        return perHourCharges + (totalHours-1) * overtimeCharges;
    }
}
