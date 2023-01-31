package vehiclePriceCalculator.vehicle;

import vehiclePriceCalculator.vehicle.Vehicle;

public class PickupTruck extends Vehicle {
	private String type;
	private String cabType;
	private String truckBedType;
	private double sct; 
	private double total;
	
	public PickupTruck() {
		super();
		this.cabType = "";
		this.truckBedType = "";
		this.type = "PickupTruck";
	}
	public PickupTruck(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, String cabType, String truckBedType, int VAT) {
		super(vehicleId, monthOfSale, cityOfSale, productionYear, VAT);
		if (!this.nullChecker(cabType, truckBedType)) {
			this.cabType = cabType;
			this.truckBedType = truckBedType;
		}
		this.type = "PickupTruck";
		this.calculateAndSetSct();
		this.calculateAndSetTotal();
	
	}

	public String getCabType() {
		return this.cabType;
	}
	public String getTruckBedType() {
		return this.truckBedType;
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
	
	private boolean nullChecker(String cabType, String truckBedType) {
		return cabType == null || truckBedType == null;
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
		double bed = calculateTruckBedTypeSct();
		double cab = calculateCabTypeSct();
		double year = calculateProductionYearSct();
		this.sct = (bed * year) / cab;
	}
	private double calculateTruckBedTypeSct() {
		double bedSct = 0;
		switch(truckBedType) {
			case "regular":
				bedSct = 0.5f;
				break;
				case "tanker":
				bedSct = 0.8f;
				break;
				case "trailer":
				bedSct = 1;
				break;
				default:
				System.exit(-1);
		}
		return bedSct;
	}
	private double calculateCabTypeSct() {
		double cabSct = 0;
		switch (cabType) {
			case "regular":
				cabSct = 2.5f;
				break;
			case "extended":
				cabSct = 2.8f;
				break;
			case "crew":
				cabSct = 3;
				break;
			default:
				System.exit(-1);
		}
		return cabSct;
	}
	private void calculateAndSetTotal() {
		total = (250000) * (1 + (getSct() * 0.6)) + (1 + (getVAT() / 100));
	}
	
	

}
