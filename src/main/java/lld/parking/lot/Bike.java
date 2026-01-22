package lld.parking.lot;

public class Bike implements Vehicle {

    private final String id;

    public Bike(final String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }
}
