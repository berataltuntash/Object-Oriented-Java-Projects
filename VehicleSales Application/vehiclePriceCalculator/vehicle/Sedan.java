package vehiclePriceCalculator.vehicle;

import vehiclePriceCalculator.vehicle.Automobile;

public class Sedan extends Automobile {
	private String type;
	private String roofType;
	private double sct;
	private double total;
	public Sedan() {
		super();
		this.roofType = "";
		this.type = "Sedan";
	}
	public Sedan(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, String roofType, double engineVolume, int VAT) {
		super(vehicleId, monthOfSale, cityOfSale, productionYear, VAT, engineVolume);
		if(!this.nullChecker(roofType)) {
			this.roofType = roofType;
		}
		else {
			this.roofType = "";
		}
		this.type = "Sedan";
		this.calculateAndSetSct();
		this.calculateAndSetTotal();
	}
	
	public double getTotal() {
		return this.total;
	}
	public double getSct() {
		return this.sct;
	}
	public String getRoofType() {
		return this.roofType;
	}

	public String getVehicleType() {
		return type;
	}
	
	private boolean nullChecker(String _roofType) {
		return _roofType == null;
	}
	
	public String toString() {
		return (
			"Vehicle: " + this.getVehicleType() +
			super.toString() + 
			"SCT: " + this.getSct() + "\n" +
			"The total price paid for " + this.getVehicleId() +
			" is: " + getTotal() + "TL");
	}
	
											/*Private methods for Calculation of SCT and Total Price for PickUps*/
	private void calculateAndSetSct() {
		double year = calculateProductionYearSct();
		double roof = 0;
		switch(this.roofType) {
			case "sunroof":
				roof = 0.5f;
			break;
			case "moonroof":
				roof = 0.6f;
			break;
			case "regular":
				roof = 0.8f;
			break;
			default:
				System.exit(-1);
		}
		this.sct = (getEngineVolume() * 0.2 * roof) / year;
	}
	
	private void calculateAndSetTotal() {
		this.total = (200000)*(1+ getSct()*0.8) + (1+ getVAT()/100);
	}
	
}
