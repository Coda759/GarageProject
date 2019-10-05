import java.util.Random;

public class Vehicle {
	
	enum VehicleType {
		MOTORBIKE(1), SEDAN(2), TRUCK(3);
		
		private int value;
		
		private VehicleType(int value) {
			this.value = value;
		}
		
		public int getSize() {
			return value;
		}
	}
	 
	private String[] states = {
		 "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", 
		 "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI",
		 "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC",
		 "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT",
		 "VT", "VA", "WA", "WV", "WI", "WY" }; 
	private String characters = "ABCDEFGHIGKMNLOPQRSTUVWXYZ";
	private String numbers = "0123456789";
	private String licensePlateP1 = "";
	private String licensePlateP2 = "";
	private String licensePlateNum = "";
	private int charLength = 3;
	private int numLength = 4;
	private Random rand = new Random();
	private int size;
	
	public String generateLicensePlate() {
		
		char[] plate1 = new char[charLength];
		
		for(int i = 0; i < charLength; i++) {
			plate1[i] = characters.charAt(rand.nextInt(characters.length()));
		}
		
		for(int i = 0; i < plate1.length; i++) {
			licensePlateP1 += plate1[i];
		}
		
		char[] plate2 = new char[numLength];
		
		for(int i = 0; i < numLength; i++) {
			plate2[i] = numbers.charAt(rand.nextInt(numbers.length()));
		}
		
		for(int i = 0; i < plate2.length; i++) {
			licensePlateP2 += plate2[i];
		}
		
		int randomStateNum = rand.nextInt(states.length);
		String randomState = states[randomStateNum];
		
		setLicensePlate(randomState + " " + licensePlateP1 + "-" + licensePlateP2);
		
		return licensePlateNum;
		
	}

	public String getLicensePlate() {
		return licensePlateNum;
	}

	public void setLicensePlate(String licensePlateNum) {
		this.licensePlateNum = licensePlateNum;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	//Types of Vehicles:
	
	public static class Truck extends Vehicle {
		public Truck() {
			setLicensePlate(generateLicensePlate());
			setSize(VehicleType.TRUCK.getSize());
		}
	}
	
	public static class Sedan extends Vehicle {
		public Sedan() {
			setLicensePlate(generateLicensePlate());
			setSize(VehicleType.SEDAN.getSize());
		}
	}
	
	public static class Motorbike extends Vehicle {
		public Motorbike() {
			setLicensePlate(generateLicensePlate());
			setSize(VehicleType.MOTORBIKE.getSize());
		} 
	}
	
	@Override 
	public String toString() {
		return this.licensePlateNum + " " + this.getSize();
	}
} 
 