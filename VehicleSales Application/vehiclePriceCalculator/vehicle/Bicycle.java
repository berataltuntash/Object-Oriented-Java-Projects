package vehiclePriceCalculator.vehicle;

import vehiclePriceCalculator.vehicle.Vehicle;

public class Bicycle extends Vehicle {
	private String type;
	private String chainType;
	private String seatPost;
	private double sct; 
	private double total;
	
	public Bicycle() {
		super();
		this.chainType = "";
		this.seatPost = "";
		this.type = "Bicycle";
	}
	public Bicycle(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, String chainType, String seatPost, int VAT) {
		super(vehicleId, monthOfSale, cityOfSale, productionYear, VAT);
		if(!this.nullChecker(chainType, seatPost)) {
			this.chainType = chainType;
			this.seatPost = seatPost;
		}
		else {
			this.chainType = "";
			this.seatPost = "";
		}
		this.type = "Bicycle";
		this.calculateAndSetSct();
		this.calculateAndSetTotal();
	}
	

	public double getTotal() {
		return this.total;
	}
	public double getSct() {
		return this.sct;
	}
	public String getChainType() {
		return this.chainType;
	}
	public String getSeatPost() {
		return this.seatPost;
	}
	public String getVehicleType() {
		return this.type;
	}

	private boolean nullChecker(String chainType, String seatPost) {
		return chainType == null || seatPost == null;
	}

	public String toString() {
		return (
			"Vehicle: " + this.getVehicleType() +
			super.toString() + 
			"SCT: " + this.getSct() + "\n" +
			"The total price paid for " + this.getVehicleId() +
			" is: " + getTotal() + "TL" );
		
	}
	
    									/*Private methods for Calculation of SCT and Total Price for Bicycle*/
	private void calculateAndSetSct() {
		double month = calculateMonthSct();
		double chain = calculateChainSct();
		double seat = calculateSeatSct();
		this.sct = (chain * seat * 0.1) + month;
	}
	private void calculateAndSetTotal() {
		this.total = (10000*0.9)*(1+ getSct()) +(1+ getVAT()/100);
	}
	private double calculateMonthSct() {
		double monthSct = 0;
		switch(this.getMonthOfSale()) {
			case "January":
				monthSct = 0.3; 
				break;
			case "May":
				monthSct = 0.4;
				break;
			case "August":
				monthSct = 0.5;
				break;
			case "October":
				monthSct = 0.6;
				break;
			case "December":
				monthSct = 0.7;
				break;
			default:
				break;
		}
		return monthSct;
	}
	private double calculateChainSct() {
		double chainSct = 0;
		switch (this.chainType) {
			case "derailleur":
				chainSct = 1.1;
				break;
			case "onechain":
				chainSct = 1.2;
				break;
			case "doublechain":
				chainSct = 1.3;
				break;
			default:
				break;
		}
		return chainSct;
	}
	private double calculateSeatSct() {
		double seatSct = 0;
		switch(this.seatPost) {
			case "carbonfiber":
				seatSct = 0.8;
			break;
			case "steel":
				seatSct = 0.7;
			break;
			case "aluminum":
				seatSct = 0.9;
			break;
			case "titanium":
				seatSct = 0.6;
				break;
			default:
				break;	
		}
		return seatSct;
	}
}