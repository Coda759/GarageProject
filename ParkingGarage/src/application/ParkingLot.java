package application;
import java.util.PriorityQueue;

public class ParkingLot {
	
	private PriorityQueue<ParkingSpot.MotorbikeSpot> motoLot = new PriorityQueue<ParkingSpot.MotorbikeSpot>();
	private PriorityQueue<ParkingSpot.SedanSpot> sedanLot = new PriorityQueue<ParkingSpot.SedanSpot>();
	private PriorityQueue<ParkingSpot.TruckSpot> truckLot = new PriorityQueue<ParkingSpot.TruckSpot>();
	private ParkingSpot.MotorbikeSpot motoSpot;
	private ParkingSpot.SedanSpot sedanSpot;
	private ParkingSpot.TruckSpot truckSpot;
	private int motoCount = 0;
	private int sedanCount = 0;
	private int truckCount = 0;
	private final int maxMotorbikeSpots = 15;
	private final int maxSedanSpots = 70;
	private final int maxTruckSpots = 15;
	
	public String showLot() {
		return motoLot + "\n" + sedanLot + "\n" + truckLot;
	}
	
	//Optional: show lots separately
	public String showMotoLot() {
		return "Vehicles parked in motorbike lot: " + motoLot;
	}
	
	public String showSedanLot() {
		return "Vehicles parked in sedan lot: " + sedanLot;
	}
	
	public String showTruckLot() {
		return "Vehicles parked in truck lot: " + truckLot;
	}
	
	public void parkVehicle(Vehicle vehicle) {		
		switch(vehicle.getSize()) {
			case 1: if(motoCount < maxMotorbikeSpots) {
						motoSpot = new ParkingSpot.MotorbikeSpot("M-" + (motoCount++ +1));
						motoSpot.addVehicle(vehicle);
						motoLot.add(motoSpot);
					} else {
						System.out.println("No more morbike spots available");
					}
					break;
			case 2: if(sedanCount < maxSedanSpots) {
						sedanSpot = new ParkingSpot.SedanSpot("S-" + (sedanCount++ +1));
						sedanSpot.addVehicle(vehicle);
						sedanLot.add(sedanSpot);
					} else {
						System.out.println("No more sedan spots available");
					}
					break;
			case 3: if(truckCount < maxTruckSpots) {
						truckSpot = new ParkingSpot.TruckSpot("T-" + (truckCount++ +1));
						truckSpot.addVehicle(vehicle);
						truckLot.add(truckSpot);
					} else {
						System.out.println("No more truck spots available");
					}
					break;
					default: System.out.println("Error, this type of car is not accepted");
		}
	}
	
}
