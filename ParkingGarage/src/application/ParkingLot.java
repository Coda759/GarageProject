package application;
import java.util.PriorityQueue;

public class ParkingLot {
	
	private PriorityQueue<ParkingSpot.MotorbikeSpot> motoLot = new PriorityQueue<ParkingSpot.MotorbikeSpot>();
	private PriorityQueue<ParkingSpot.SedanSpot> sedanLot = new PriorityQueue<ParkingSpot.SedanSpot>();
	private PriorityQueue<ParkingSpot.TruckSpot> truckLot = new PriorityQueue<ParkingSpot.TruckSpot>();
	private final int motoLotSize = 16;
	private final int truckLotSize = 16;
	private final int sedanLotSize = 71;
	private ParkingSpot spot;
	
	public void createLot() {
		for(int i = 1; i < motoLotSize; i++) {
			ParkingSpot.MotorbikeSpot motoSpot = new ParkingSpot.MotorbikeSpot("M-"+i);
			motoLot.add(motoSpot);
		}
		for(int i = 1; i < truckLotSize; i++) {
			ParkingSpot.TruckSpot truckSpot = new ParkingSpot.TruckSpot("T-"+i);
			truckLot.add(truckSpot);
		}
		for(int i = 1; i < sedanLotSize; i++) {
			ParkingSpot.SedanSpot sedanSpot = new ParkingSpot.SedanSpot("S-"+i);
			sedanLot.add(sedanSpot);
		}
	}
	
	public String showLot() {
		return motoLot + "\n" + sedanLot + "\n" + truckLot;
	}
	
	public void parkVehicle(Vehicle vehicle) {
		switch(spot.getParkingSpotValue()) {
		
		}
	}
	
	//TODO: Add parkVehicle, FreeSpot and generate ticket methods
	
}
