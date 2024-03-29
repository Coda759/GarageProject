/**
 * @author Nicholas Smiriagine
 */
package application;
public class ParkingSpot implements Comparable<ParkingSpot> {
	
	enum ParkingSpotType {
		MOTORBIKEspot(1), TRUCKspot(3), SEDANspot(2);
		
		private int value;
		
		private ParkingSpotType(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	private boolean available = true;
	private Vehicle vehicle;
	private ParkingSpotType type;
	protected String num;
	
	public int getParkingSpotValue() {
		if(vehicle.getSize() == ParkingSpotType.MOTORBIKEspot.getValue()) {
			return 1;
		} else if(vehicle.getSize() == ParkingSpotType.SEDANspot.getValue()) {
			return 2;
		} else if(vehicle.getSize() == ParkingSpotType.TRUCKspot.getValue()) {
			return 3;
		} else {
			return 0;
		}
	}
	
	@Override
	public int compareTo(ParkingSpot spot) {
		if(spot.isOccupied() == true) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public boolean isOccupied() { 
		if(this.available == true) {
			return false;
		} else {
			return true;
		}
	}
	
	public ParkingSpot() {
		
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return available = false;
	}
	
	public boolean removeVehicle() {
		this.vehicle = null;
		return available = true;
	}
	
	public void setValue(ParkingSpotType value) {
		this.type = value;
	}
	
	public static class MotorbikeSpot extends ParkingSpot {
		public MotorbikeSpot(String num) {
			setValue(ParkingSpot.ParkingSpotType.MOTORBIKEspot);
			this.num = num;
			
		}
	}
	
	public static class SedanSpot extends ParkingSpot {
		public SedanSpot(String num) {
			setValue(ParkingSpot.ParkingSpotType.SEDANspot);
			this.num = num;
		}
	}
	
	public static class TruckSpot extends ParkingSpot {
		public TruckSpot(String num) {
			setValue(ParkingSpot.ParkingSpotType.TRUCKspot);
			this.num = num;
		}
	}
	
	@Override
	public String toString() {
		return num + " occupied: " + isOccupied() + ", vehicle: " + this.vehicle;
	}
}

