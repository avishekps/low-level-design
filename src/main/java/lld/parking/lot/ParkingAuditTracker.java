package lld.parking.lot;

import java.util.HashMap;
import java.util.Map;

public class ParkingAuditTracker implements ParkingObserver {

    private final Map<String, ParkingLotAudit> parkingLotAudit;

    public ParkingAuditTracker() {
        parkingLotAudit = new HashMap<>();
    }

    @Override
    public void notify(Slot slot, Vehicle vehicle) {
        ParkingLotAudit audit = new ParkingLotAudit(vehicle, slot);
        parkingLotAudit.put(vehicle.getId(), audit);
    }
}
