package lld.parking.lot;

public class Car implements Vehicle {

    private final String id;

    public Car(final String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
