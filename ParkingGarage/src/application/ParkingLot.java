/**
 * @author Nicholas Smiriagine
 */

package application;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

public class ParkingLot {
	
	private PriorityQueue<ParkingSpot.MotorbikeSpot> motoLot = new PriorityQueue<ParkingSpot.MotorbikeSpot>(new lotComparator());
	private PriorityQueue<ParkingSpot.SedanSpot> sedanLot = new PriorityQueue<ParkingSpot.SedanSpot>(new lotComparator());
	private PriorityQueue<ParkingSpot.TruckSpot> truckLot = new PriorityQueue<ParkingSpot.TruckSpot>(new lotComparator());
	private ParkingSpot.MotorbikeSpot motoSpot;
	private ParkingSpot.SedanSpot sedanSpot;
	private ParkingSpot.TruckSpot truckSpot;
	private ParkingSpot spot;
	private final int maxMotorbikeSpots = 15;
	private final int maxSedanSpots = 7;
	private final int maxTruckSpots = 15;
	private String licensePlate;
	private HashMap<String, ParkingSpot> parkedVehicles = new HashMap<String, ParkingSpot>();
	
	public ParkingLot() {
		for(int i = 0; i < maxMotorbikeSpots; i++) {
			ParkingSpot.MotorbikeSpot motoSpot = new ParkingSpot.MotorbikeSpot("M-" + (i + 1));
			motoLot.add(motoSpot);
		}
		for(int i = 0; i < maxTruckSpots; i++) {
			ParkingSpot.TruckSpot truckSpot = new ParkingSpot.TruckSpot("T-" + (i + 1));
			truckLot.add(truckSpot);
		}
		for(int i = 0; i < maxSedanSpots; i++) {
			ParkingSpot.SedanSpot sedanSpot = new ParkingSpot.SedanSpot("S-"+ (i + 1));
			sedanLot.add(sedanSpot);
		}
	}
	
	public String showLot() {
		return motoLot + "\n" + sedanLot + "\n" + truckLot + "\n" + "Parked vehicles: " + parkedVehicles;
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
	
	public String parkVehicle(Vehicle vehicle) {
		switch(vehicle.getSize()) {
		case 1: motoSpot = motoLot.poll();
				motoSpot.addVehicle(vehicle);
				parkedVehicles.put(vehicle.getLicensePlate(), motoSpot);
				return motoSpot.num;
		case 2: sedanSpot = sedanLot.poll();
				sedanSpot.addVehicle(vehicle);
				parkedVehicles.put(vehicle.getLicensePlate(), sedanSpot);
				return sedanSpot.num;
		case 3: truckSpot = truckLot.poll();
				truckSpot.addVehicle(vehicle);
				parkedVehicles.put(vehicle.getLicensePlate(), truckSpot);
				return truckSpot.num;
		default: return "Spot not found";
		}
	}
	
	public void retrieveVehicle(String licensePlate) {
		ParkingSpot spot = parkedVehicles.remove(licensePlate);
		this.licensePlate = licensePlate;
		spot.removeVehicle();
		if(spot instanceof ParkingSpot.SedanSpot) {
			sedanLot.add((ParkingSpot.SedanSpot) spot);
		} else if(spot instanceof ParkingSpot.MotorbikeSpot) {
			motoLot.add((ParkingSpot.MotorbikeSpot) spot);
		} else {
			truckLot.add((ParkingSpot.TruckSpot) spot);
		}
	}
	
	public class lotComparator implements Comparator<ParkingSpot> {
	@Override
	public int compare(ParkingSpot spot, ParkingSpot other) {
		int spotNum = Integer.parseInt(spot.num.substring(2));
		int spotNum2 = Integer.parseInt(other.num.substring(2));
		if(spotNum < spotNum2) {
			return -1;
		} else if(spotNum > spotNum2) {
			return 1;
		} else {
			return 0;
		}
	}
	}
}
