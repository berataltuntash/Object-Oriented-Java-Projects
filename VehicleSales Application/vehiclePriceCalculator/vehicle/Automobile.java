package vehiclePriceCalculator.vehicle;

import vehiclePriceCalculator.vehicle.Vehicle;

public class Automobile extends Vehicle {
	private double engineVolume;
	private double sct;
	private double total;
	public Automobile() {
		super();
		this.engineVolume = 0;
	}
	public Automobile(String vehicleId, String monthOfSale, String cityOfSale, int productionYear, int VAT, double engineVolume) {
		super(vehicleId, monthOfSale, cityOfSale, productionYear, VAT);
		this.engineVolume = engineVolume;
		
	}
	public double getEngineVolume() {
		return this.engineVolume;
	}


	protected double calculateProductionYearSct() {
		return super.calculateProductionYearSct();
	}


	public String toString() {
		return super.toString();
	}

}
