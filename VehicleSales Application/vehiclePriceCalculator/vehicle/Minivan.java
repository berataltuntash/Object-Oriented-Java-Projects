package vehiclePriceCalculator.vehicle;

import vehiclePriceCalculator.vehicle.Automobile;

public class Minivan extends Automobile {
	private String type;
	private int numberOfSeats;
	private double sct;
	private double total;
	public Minivan() {
		super();
		this.numberOfSeats = 0;
		this.type = "Minivan";
	}
	public Minivan(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, int numberOfSeats, double engineVolume, int VAT) {
		super(vehicleId, monthOfSale, cityOfSale, productionYear, VAT, engineVolume);
		if(numberOfSeats <= 0) {
			this.numberOfSeats = -1;
		}
		else {			
			this.numberOfSeats = numberOfSeats;
		}
		this.type = "Minivan";
		this.calculateAndSetSct();
		this.calculateAndSetTotal();
	}
	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}
	public double getSct() {
		return this.sct;
	}
	public double getTotal() {
		return this.total;
	}
	public String getVehicleType() {
		return this.type;
	}
	
	public String toString() {
		return (
			"Vehicle: " + this.getVehicleType() +
			super.toString() + 
			"SCT: " + this.getSct() + "\n" +
			"The total price paid for " + this.getVehicleId() +
			" is: " + getTotal() + "TL");
	}
    										/*Private methods for Calculation of SCT and Total Price for Minivans*/
	private void calculateAndSetSct() {
		double year = super.calculateProductionYearSct();
		
		this.sct = (0.6 * year) / (getEngineVolume() + this.calculateNumberOfSeatsSct());
	}
	private double calculateNumberOfSeatsSct() {
		double seats = 0;
		switch(this.numberOfSeats) {
			case 4:
				seats = 0.1;
				break;
			case 5:
				seats = 0.4;
				break;
			case 6:
				seats = 0.6;
				break;
			case 7:
				seats = 0.8;
				break;
			default:
				System.exit(-1);
		}
		return seats;
	}
	private void calculateAndSetTotal() {
		this.total = (200000)*(1+ getSct()*0.8) + (1+ getVAT()/100);
	}
	
}
