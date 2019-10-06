package application;

public class VehicleChecking {

    public String vehicleCheckIn(String attendantId, String vehiclePlate, String vehicleState, String vehicleType){
        parkVehicle(vehiclePlate, vehicleState, vehicleType);
        return "parked";
    }



    private void parkVehicle(String vehiclePlate, String vehicleState, String vehicleType){

    }
}
