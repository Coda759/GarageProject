package application;

/**
 * GarageRates class contains the cost rates for parking different kinds of vehicles;
 * @author Jonathon Shea
 * @version 1.0
 */
public class GarageRates {

    private double carRate;
    private double motorcycleRate;
    private double truckRate;

    /**
     * No-arg constructor sets all rates to default values.
     * Cars = 10.0
     * Motorcycles = 8.0
     * Trucks = 18.0
     */
    public GarageRates(){
        this.carRate = 10;
        this.motorcycleRate = 8;
        this.truckRate = 18;

    }

    /**
     * Constructor that sets rates to input values.
     * @param carRate
     * @param motorcycleRate
     * @param truckRate
     */
    public GarageRates(double carRate, double motorcycleRate, double truckRate) {
        this.carRate = carRate;
        this.motorcycleRate = motorcycleRate;
        this.truckRate = truckRate;
    }

    public double getCarRate() {
        return carRate;
    }

    public double getMotorcycleRate() {
        return motorcycleRate;
    }

    public double getTruckRate() {
        return truckRate;
    }
}
