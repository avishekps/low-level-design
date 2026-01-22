package lld.parking.lot;

public class Truck implements Vehicle {

    private final String id;

    public Truck(final String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TRUCK;
    }
}
